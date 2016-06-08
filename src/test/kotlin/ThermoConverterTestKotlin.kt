import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by piyushchauhan on 8/06/2016.
 */
class ThermoConverterTestKotlin {
    private val ALLOWED_DELTA = 0.01f

    @Test
    fun thermoTest() {
        val celsiusVal = 232.778f
        val thermoModel = ThermoConverter.getTemperature(celsiusVal)
        assertEquals(celsiusVal, thermoModel.celsius, ALLOWED_DELTA.toString())
        assertEquals(451.0004f, thermoModel.fahrenheit, ALLOWED_DELTA.toString())
    }
}