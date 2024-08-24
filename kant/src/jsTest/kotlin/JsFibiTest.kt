import kotlin.test.Test
import kotlin.test.assertEquals

class JsFibiTest {

    @Test
    fun test3dElement() {
        assertEquals(7, fibi.take(3).last())
    }
}