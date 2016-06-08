/**
 * Created by piyushchauhan on 8/06/2016.
 */
public class ThermoModel {
    private final float celsius, kelvin, fahrenheit;

    public ThermoModel(float celsius, float kelvin, float fahrenheit) {
        this.celsius = celsius;
        this.kelvin = kelvin;
        this.fahrenheit = fahrenheit;
    }

    public float getCelsius() {
        return celsius;
    }

    public float getKelvin() {
        return kelvin;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }
}
