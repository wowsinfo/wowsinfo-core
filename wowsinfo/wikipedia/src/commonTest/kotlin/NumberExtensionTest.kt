import utility.asPercentString
import utility.toDisplayString
import utility.toFixedDigits
import utility.toPercentString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NumberExtensionTest {
    @Test
    fun testNumberExtension() {
        assertTrue(1.2345.toFixedDigits(2) == "1.23")
        assertTrue(1.toFixedDigits(2) == "1.00")
        assertTrue(1.2.toFixedDigits(5) == "1.20000")
        assertTrue(1.546.toDisplayString() == "1.55")
        assertTrue(null.toFixedDigits(0) == "-")
        assertTrue(1.2345.toDisplayString() == "1.23")
        assertEquals(54.31245.toDisplayString(), 54.31245.toFixedDigits(2))
        assertTrue(1.asPercentString() == "1.00%")
        assertTrue(1.toPercentString() == "100.00%")
        assertTrue(null.asPercentString() == "-")
        assertTrue(null.toPercentString() == "-")
    }
}
