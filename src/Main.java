import API.ApiService;
import API.ConversorDeMoedas;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ApiService api = new ApiService();
        System.out.print("\uD83D\uDD11 Coloque sua chave API: ");
        String chaveAPI = sc.nextLine();

        api.insiraApi(chaveAPI);

        ConversorDeMoedas conversor = new ConversorDeMoedas(api);




    }

    private static void exibirMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       💱 CONVERSOR DE MOEDAS 💱           ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║          🌎 PRINCIPAIS PARES              ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 1  │ USD → EUR  (Dólar → Euro)           ║");
        System.out.println("║ 2  │ USD → GBP  (Dólar → Libra)          ║");
        System.out.println("║ 3  │ USD → JPY  (Dólar → Iene)           ║");
        System.out.println("║ 4  │ USD → BRL  (Dólar → Real)           ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║          🇧🇷 BRASIL (BRL)                  ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 5  │ BRL → USD  (Real → Dólar)           ║");
        System.out.println("║ 6  │ BRL → EUR  (Real → Euro)            ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║          🌎 AMÉRICA LATINA                ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 7  │ USD → ARS  (Dólar → Peso ARG)       ║");
        System.out.println("║ 8  │ USD → COP  (Dólar → Peso COL)       ║");
        System.out.println("║ 9  │ BRL → ARS  (Real → Peso ARG)        ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 10 │ ⚙️  Conversão personalizada         ║");
        System.out.println("║ 0  │ 🚪 Sair                             ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.print("👉 Escolha uma opção: ");
    }

}