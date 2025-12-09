import API.ApiService;
import API.ConversorDeMoedas;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ApiService api = new ApiService();
        System.out.print("\uD83D\uDD11 Coloque sua chave API: ");
        String chaveAPI = sc.nextLine();
        if (chaveAPI == null || chaveAPI.isEmpty()) {
            throw new IllegalArgumentException("❌ Chave API não pode ser vazia ou null");
        }

        api.insiraApi(chaveAPI);

        ConversorDeMoedas conversor = new ConversorDeMoedas(api);


        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:  // USD → EUR
                    realizarConversao(conversor, sc, "USD", "EUR");
                    break;

                case 2:  // USD → GBP
                    realizarConversao(conversor, sc, "USD", "GBP");
                    break;

                case 3:  // USD → JPY
                    realizarConversao(conversor, sc, "USD", "JPY");
                    break;

                case 4:  // USD → BRL
                    realizarConversao(conversor, sc, "USD", "BRL");
                    break;

                case 5:  // BRL → USD
                    realizarConversao(conversor, sc, "BRL", "USD");
                    break;

                case 6:  // BRL → EUR
                    realizarConversao(conversor, sc, "BRL", "EUR");
                    break;

                case 7:  // USD → ARS
                    realizarConversao(conversor, sc, "USD", "ARS");
                    break;

                case 8:  // USD → COP
                    realizarConversao(conversor, sc, "USD", "COP");
                    break;

                case 9:  // BRL → ARS
                    realizarConversao(conversor, sc, "BRL", "ARS");
                    break;

                case 10:  // Personalizada
                    conversaoPersonalizada(conversor, sc);
                    break;

                case 0:  // Sair
                    System.out.println("👋 Obrigado por usar o conversor!");
                    continuar = false;  // ← para o loop
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        }


    } // fecha static main

    public static void exibirMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       💱 CONVERSOR DE MOEDAS 💱              ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║          🌎 PRINCIPAIS PARES                 ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 1  │ USD → EUR  (Dólar → Euro)               ║");
        System.out.println("║ 2  │ USD → GBP  (Dólar → Libra)              ║");
        System.out.println("║ 3  │ USD → JPY  (Dólar → Iene)               ║");
        System.out.println("║ 4  │ USD → BRL  (Dólar → Real)               ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║          🇧🇷 BRASIL (BRL)                      ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 5  │ BRL → USD  (Real → Dólar)               ║");
        System.out.println("║ 6  │ BRL → EUR  (Real → Euro)                ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║          🌎 AMÉRICA LATINA                   ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 7  │ USD → ARS  (Dólar → Peso ARG)           ║");
        System.out.println("║ 8  │ USD → COP  (Dólar → Peso COL)           ║");
        System.out.println("║ 9  │ BRL → ARS  (Real → Peso ARG)            ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║ 10 │ ⚙️  Conversão personalizada             ║");
        System.out.println("║ 0  │ 🚪 Sair                                 ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("👉 Escolha uma opção: ");
    }

public static void realizarConversao(ConversorDeMoedas conversor,
                                      Scanner sc,
                                      String origem,
                                      String destino) {
    System.out.print("💰 Digite o valor em " + origem + ": ");
    double valor = sc.nextDouble();
    sc.nextLine();  // line para nao bugar o scanner

    double resultado = conversor.converter(valor, origem, destino);

    if (resultado != -1.0) {
        System.out.printf("✅ %.2f %s = %.2f %s\n",
                valor, origem, resultado, destino);
    }
}

private static void conversaoPersonalizada(ConversorDeMoedas conversor, Scanner sc) {
    System.out.println("\n💱 CONVERSÃO PERSONALIZADA");
    System.out.println("Moedas disponíveis: USD, EUR, GBP, JPY, BRL, CAD, CHF, ARS, BOB, CLP, COP");

    System.out.print("Moeda de origem (ex: USD): ");
    String origem = sc.nextLine().toUpperCase();

    System.out.print("Moeda de destino (ex: BRL): ");
    String destino = sc.nextLine().toUpperCase();

    System.out.print("Valor: ");
    double valor = sc.nextDouble();
    sc.nextLine();  // limpa buffer

    double resultado = conversor.converter(valor, origem, destino);

    if (resultado != -1.0) {
        System.out.printf("✅ %.2f %s = %.2f %s\n",
                valor, origem, resultado, destino);
    }
}

}