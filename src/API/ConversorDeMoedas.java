package API;

import com.google.gson.JsonObject;

public class ConversorDeMoedas {
    private ApiService apiService;

    //construtor

    public ConversorDeMoedas(ApiService apiService) {
        this.apiService = apiService;
    }
    public double converter(double valor, String moedaOrigem, String moedaDestino) {
    String json = apiService.obterTaxa(moedaOrigem, moedaDestino);
        if (json == null) {
            System.err.println("⚠️ Erro ao obter dados da API!");
            return -1.0;
        }
        double taxa = apiService.obterTaxaDeConversao(json);
        if (taxa != -1.0) {
            return taxa;
        }
        double valorConvertido = valor * taxa;
        return valorConvertido;
    }
}// fecha chave
