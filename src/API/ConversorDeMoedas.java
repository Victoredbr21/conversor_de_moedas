package API;


public class ConversorDeMoedas {
    private ApiService apiService;

    //construtor

    public ConversorDeMoedas(ApiService apiService) {
        this.apiService = apiService;
    }

    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        if (valor <= 0) {
            throw new IllegalArgumentException("⚠️ Valor deve ser positivo!");
        }

        String json = apiService.obterTaxa(moedaOrigem, moedaDestino);
        if (json == null) {
            throw new RuntimeException("⚠️ Erro ao obter dados da API!");
        }

        double taxa = apiService.obterTaxaDeConversao(json);
        if (taxa == -1.0) {
            throw new RuntimeException("⚠️ Erro ao processar taxa!");
        }

        double resultado = taxa * valor;
        return resultado;
    }
    
}// fecha chave
