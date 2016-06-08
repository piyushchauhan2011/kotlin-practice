/**
 * Created by piyushchauhan on 8/06/2016.
 */
public final class ThermoConverter {

    private ThermoConverter() {
        // hidden
    }

    public static ThermoModel getTemperature(float celsius) {
        float fahr = celsius * 9 / 5 + 32f;
        float kel = celsius + 273.15f;
        return new ThermoModel(celsius, kel, fahr);
    }

}
