import com.google.gson.Gson;

import java.awt.desktop.AboutEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    PairConversionModel pairConversionModel = new PairConversionModel();

    public PairConversionModel convertirMonedasPorPares(String origen, String destino, double monto) {

        String direccionBase = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "09a3a0c0c6a789f2322ba3f0/pair/";

        try {

            Gson gson = new Gson();
            URI direccion = URI.create(direccionBase+apiKey+origen+"/"+destino+"/"+monto);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var resultado = gson.fromJson(response.body(), PairConversionModel.class);

            //pairConversionModel.fecha_registro
            return resultado;

        } catch (Exception e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }

    }
}
