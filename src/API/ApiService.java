package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class ApiService
{
    private String JSON ;
    private String api_key;
    private String base_url;
    private HttpClient client;

    public ApiService() {
        this.base_url = "https://v6.exchangerate-api.com/v6/";
        this.client = HttpClient.newBuilder()
                .build();
    }

    //getters

    public String getApi_key() {
        return api_key;
    }

    public String getBase_url() {
        return base_url;
    }
        //setters

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }



//metodos

    public void insiraApi(String apikey) {
    if( apikey == null) {
        System.err.println("\uD83D\uDEB7 Sua API ainda esta vazia!");
    }
        else {
            System.out.println("\uD83D\uDD11 Chave inserida com sucesso!");
         this.api_key = apikey;
        }
        return;
    }


    public String obterTaxa (String origem, String destino) {
        if (this.api_key == null) {
            System.err.println("\uD83D\uDEB7 Sua API esta vazia!");
            return null;
        }
        String endereco = this.base_url + this.api_key +"/pair/" + origem + "/" + destino;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("\uD83D\uDEAB Erro na requisição: " + e.getMessage());
        }

        return null;
    }

    public double obterTaxaDeConversao(String json) {

        try {
            JsonElement elemento = JsonParser.parseString(json);
            JsonObject obj = elemento.getAsJsonObject();
            double taxa = obj.get("conversion_rate").getAsDouble();
            return taxa;
        } catch (Exception e) {
            System.err.println("⛔ Erro ao parsear JSON: " + e.getMessage());
        }
        return -1.0;
    }

}


