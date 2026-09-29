package my.webapp.temperatura;

public class ConversorTemperatura {

    public double convertir(double temperatura, String tipoConversion) {

        double resultado = 0;

        switch (tipoConversion) {

            case "celsiusFahrenheit":

                resultado = (temperatura * 9 / 5) + 32;

                break;


            case "fahrenheitCelsius":

                resultado = (temperatura - 32) * 5 / 9;

                break;


            case "celsiusKelvin":

                resultado = temperatura + 273.15;

                break;


            case "kelvinCelsius":

                resultado = temperatura - 273.15;

                break;


            default:

                resultado = 0;

                break;
        }

        return resultado;
    }
}