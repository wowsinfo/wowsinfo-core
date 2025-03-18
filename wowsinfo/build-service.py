"""
See https://github.com/wowsinfo/wowsinfo-core/issues/3#issuecomment-2395750182
Patch the JS output of wowsinfo-service to temporarily fix the opeque response
"""

import subprocess

TEMPLATE = r"""
// this is a temp solution for Apple
try {
require('react-native');
// need to convert response to buffer, then pass it to channelFromStream as a ReadableStream in ByteArray
const myBody = new ReadableStream({
    start(controller) {
        response.arrayBuffer().then(buffer => {
            controller.enqueue(new Uint8Array(buffer));
            controller.close();
        }).catch(error => {
            controller.error(error);
        });
    }
});
return channelFromStream(|PARAM1|, myBody);
} catch (error) {
    throw error;
}

"""

def patch_service(path: str):
    with open(path, 'r') as f:
        all = f.read()

    # locate function readBodyBrowser
    func_start = all.find('function readBodyBrowser')
    func_end = all.find('{', func_start)
    
    # grab the first parameter
    param_start = all.find('(', func_start)
    param_end = all.find(',', param_start)

    parameter1 = all[param_start+1:param_end].strip()
    print(f'Found function readBodyBrowser({parameter1})')

    # add a new line below the function
    with open(path, 'w') as f:
        f.write(all[:func_end+1])
        f.write(TEMPLATE.replace('|PARAM1|', parameter1))
        f.write(all[func_end+1:])
    
    print(f'Patched {path}')

if __name__ == '__main__':
    import sys
    import shutil
    # run gradlew :service:jsProductionRun and patch
    print('Running gradlew :service:jsProductionRun')
    gradlew = r'.\gradlew.bat' if sys.platform == 'win32' else r'./gradlew'

    yarn_update = subprocess.run([gradlew, 'kotlinUpgradeYarnLock'], capture_output=True)
    gradlew_task = subprocess.run([gradlew, ':service:jsProductionRun'], capture_output=True)
    gradlew_task.check_returncode()
    patch_service('build/js/packages/wowsinfo-service/kotlin/ktor-ktor-client-core.mjs')

    print('Moving to react-native-app')
    react_native_path = '../../react-native-app/res/3rd/wowsinfo-service'
    # clear the existing folder
    shutil.rmtree(react_native_path, ignore_errors=True)
    shutil.move('build/js/packages/wowsinfo-service', react_native_path)
