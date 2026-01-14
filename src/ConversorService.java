import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {
    public PairConversionModel convertirMonedasPorPares(String origen, String destino, double monto) {

        String Base = "https://v6.exchangerate-api.com/v6/09a3a0c0c6a789f2322ba3f0/pair/usd/dop/10";
        String direccionBase = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "09a3a0c0c6a789f2322ba3f0/pair/";




        URI direccion = URI.create(direccionBase+apiKey+origen+"/"+destino+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), PairConversionModel.class);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
