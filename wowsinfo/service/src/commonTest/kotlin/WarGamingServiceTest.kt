import io.github.henryquan.service.WarGamingLanguage
import io.github.henryquan.service.WarGamingRegion
import io.github.henryquan.service.WarGamingService
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class WarGamingServiceTest {

    @Test
    fun testGetPlayerList() {
        val service = WarGamingService(
            WarGamingRegion.ASIA,
            WarGamingLanguage.EN,
            "demo"
        )
        runTest {
            val result = service.getPlayerList("henryqu")
            println(result)
            assertEquals(result.isOk, true) }
    }
}