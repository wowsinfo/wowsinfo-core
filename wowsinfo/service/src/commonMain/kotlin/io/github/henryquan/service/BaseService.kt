import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlin.js.json

expect fun getEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig>

abstract class BaseService {
    abstract val baseUrl: String

    val client = HttpClient(getEngineFactory()) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend inline fun <reified T> getObject(
        path: String,
        params: Map<String, String> = emptyMap()
    ): T {
        return client.get("$baseUrl$path") {
            params.forEach { (key, value) ->
                parameter(key, value)
            }
        }.body()
    }
}
