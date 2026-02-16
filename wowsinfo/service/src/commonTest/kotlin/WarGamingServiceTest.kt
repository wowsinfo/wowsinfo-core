import io.github.henryquan.model.WarGamingLanguage
import io.github.henryquan.model.WarGamingRegion
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