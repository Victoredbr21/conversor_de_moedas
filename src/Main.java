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
            sc.nextLine();  // limpa buffer

            boolean opcaoValida = false;  // ← FLAG AQUI

            switch (opcao) {
                case 1:  // USD → EUR
                    realizarConversao(conversor, sc, "USD", "EUR");
                    opcaoValida = true;  // ← MARCA QUE CONVERTEU
                    break;

                case 2:  // USD → GBP
                    realizarConversao(conversor, sc, "USD", "GBP");
                    opcaoValida = true;
                    break;

                case 3:  // USD → JPY
                    realizarConversao(conversor, sc, "USD", "JPY");
                    opcaoValida = true;
                    break;

                case 4:  // USD → BRL
                    realizarConversao(conversor, sc, "USD", "BRL");
                    opcaoValida = true;
                    break;

                case 5:  // BRL → USD
                    realizarConversao(conversor, sc, "BRL", "USD");
                    opcaoValida = true;
                    break;

                case 6:  // BRL → EUR
                    realizarConversao(conversor, sc, "BRL", "EUR");
                    opcaoValida = true;
                    break;

                case 7:  // USD → ARS
                    realizarConversao(conversor, sc, "USD", "ARS");
                    opcaoValida = true;
                    break;

                case 8:  // USD → COP
                    realizarConversao(conversor, sc, "USD", "COP");
                    opcaoValida = true;
                    break;

                case 9:  // BRL → ARS
                    realizarConversao(conversor, sc, "BRL", "ARS");
                    opcaoValida = true;
                    break;

                case 10:  // Personalizada
                    conversaoPersonalizada(conversor, sc);
                    opcaoValida = true;
                    break;

                case 0:  // Sair
                    System.out.println("👋 Obrigado por usar o conversor!");
                    continuar = false;
                    opcaoValida = false;  //
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
                    opcaoValida = false;  //
            }


            if (opcaoValida) {  // ← Só pergunta se converteu algo
                System.out.print("\n🔄 Deseja fazer outra conversão? (S/N): ");
                String resposta = sc.nextLine().toUpperCase().trim();

                if (resposta.equals("N") || resposta.equals("NAO") || resposta.equals("NÃO")) {
                    System.out.println("👋 Obrigado por usar o conversor de moedas!");
                    continuar = false;  // ← Para o loop
                }
                else if (resposta.equals("S") || resposta.equals("SIM")) {
                    // Continua (não faz nada, loop vai reiniciar)
                    System.out.println("");
                }
                else {
                    System.out.println("⚠️ Resposta não reconhecida. Retornando ao menu...");

                }
            }
        }

        sc.close();



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
        System.out.printf("✅ %.2f %s = %.2f %s\n", // print format é melhor para parsear numeros decimais
                valor, origem, resultado, destino);
    }
}

}