package my.webapp.temperatura;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TemperaturaServlet", urlPatterns = {"/TemperaturaServlet"})
public class TemperaturaServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos enviados desde el formulario
        String temperaturaTexto =
                request.getParameter("temperatura");

        String tipoConversion =
                request.getParameter("conversion");

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            try {

                // Convertir el dato recibido a número
                double temperatura =
                        Double.parseDouble(temperaturaTexto);

                // Crear objeto de la clase auxiliar
                ConversorTemperatura conversor =
                        new ConversorTemperatura();

                // Realizar la conversión
                double resultado =
                        conversor.convertir(
                                temperatura,
                                tipoConversion
                        );

                // Obtener el nombre de la conversión
                String conversionRealizada = "";

                String unidadInicial = "";
                String unidadFinal = "";

                switch (tipoConversion) {

                    case "celsiusFahrenheit":

                        conversionRealizada =
                                "Celsius to Fahrenheit";

                        unidadInicial = "°C";
                        unidadFinal = "°F";

                        break;


                    case "fahrenheitCelsius":

                        conversionRealizada =
                                "Fahrenheit to Celsius";

                        unidadInicial = "°F";
                        unidadFinal = "°C";

                        break;


                    case "celsiusKelvin":

                        conversionRealizada =
                                "Celsius to Kelvin";

                        unidadInicial = "°C";
                        unidadFinal = "K";

                        break;


                    case "kelvinCelsius":

                        conversionRealizada =
                                "Kelvin to Celsius";

                        unidadInicial = "K";
                        unidadFinal = "°C";

                        break;
                }


                // Mostrar máximo 2 decimales
                DecimalFormat df =
                        new DecimalFormat("0.00");


                // Crear página de resultado
                out.println("<!DOCTYPE html>");

                out.println("<html lang='en'>");

                out.println("<head>");

                out.println(
                        "<meta charset='UTF-8'>"
                );

                out.println(
                        "<meta name='viewport' "
                        + "content='width=device-width, "
                        + "initial-scale=1.0'>"
                );

                out.println(
                        "<title>Temperature Result</title>"
                );


                // CSS
                out.println("<style>");

                out.println("* {");
                out.println("box-sizing: border-box;");
                out.println("}");

                out.println("body {");
                out.println("margin: 0;");
                out.println("min-height: 100vh;");
                out.println("display: flex;");
                out.println("justify-content: center;");
                out.println("align-items: center;");
                out.println(
                        "font-family: Arial, "
                        + "Helvetica, sans-serif;"
                );
                out.println(
                        "background-color: #f0f2f5;"
                );
                out.println("}");

                out.println(".container {");

                out.println("width: 100%;");
                out.println("max-width: 500px;");
                out.println("background-color: white;");
                out.println("padding: 35px;");
                out.println("border-radius: 12px;");

                out.println(
                        "box-shadow: "
                        + "0 4px 15px "
                        + "rgba(0,0,0,0.15);"
                );

                out.println("}");

                out.println("h1 {");
                out.println("text-align: center;");
                out.println("color: #007bff;");
                out.println("}");

                out.println(".data {");
                out.println("margin-top: 25px;");
                out.println("}");

                out.println(".data p {");

                out.println("padding: 14px;");

                out.println(
                        "background-color: #f8f9fa;"
                );

                out.println("border-radius: 6px;");
                out.println("margin-bottom: 12px;");

                out.println("}");

                out.println(".label {");
                out.println("font-weight: bold;");
                out.println("}");

                out.println(".result {");

                out.println(
                        "background-color: #e8f5e9 "
                        + "!important;"
                );

                out.println("font-size: 20px;");
                out.println("text-align: center;");
                out.println("}");

                out.println(".button {");

                out.println("display: block;");
                out.println("margin-top: 25px;");
                out.println("padding: 12px;");
                out.println("text-align: center;");
                out.println("text-decoration: none;");
                out.println("background-color: #007bff;");
                out.println("color: white;");
                out.println("border-radius: 6px;");

                out.println("}");

                out.println(".button:hover {");
                out.println(
                        "background-color: #0056b3;"
                );
                out.println("}");

                out.println("</style>");

                out.println("</head>");


                out.println("<body>");

                out.println(
                        "<div class='container'>"
                );

                out.println(
                        "<h1>Temperature Result</h1>"
                );

                out.println("<div class='data'>");


                out.println(
                        "<p>"
                        + "<span class='label'>"
                        + "Original Temperature:"
                        + "</span> "
                        + df.format(temperatura)
                        + " "
                        + unidadInicial
                        + "</p>"
                );


                out.println(
                        "<p>"
                        + "<span class='label'>"
                        + "Conversion:"
                        + "</span> "
                        + conversionRealizada
                        + "</p>"
                );


                out.println(
                        "<p class='result'>"
                        + "<span class='label'>"
                        + "Result:"
                        + "</span><br><br>"
                        + df.format(resultado)
                        + " "
                        + unidadFinal
                        + "</p>"
                );


                out.println("</div>");


                out.println(
                        "<a class='button' "
                        + "href='index.html'>"
                        + "Convert Another Temperature"
                        + "</a>"
                );


                out.println("</div>");

                out.println("</body>");

                out.println("</html>");


            } catch (NumberFormatException e) {

                out.println("<!DOCTYPE html>");

                out.println("<html>");

                out.println("<head>");

                out.println(
                        "<title>Error</title>"
                );

                out.println("</head>");

                out.println("<body>");

                out.println(
                        "<h1>Invalid temperature</h1>"
                );

                out.println(
                        "<p>Please enter a valid number.</p>"
                );

                out.println(
                        "<a href='index.html'>"
                        + "Go Back"
                        + "</a>"
                );

                out.println("</body>");

                out.println("</html>");
            }
        }
    }
}