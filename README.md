## **📚 DOCUMENTAÇÃO COMPLETA - ACADÊMICA + JAVADOC**

***

## **📄 1. README.md (Completo e Acadêmico):**

```markdown
# 💱 Conversor de Moedas - Projeto Acadêmico

> Sistema de conversão de moedas em tempo real utilizando ExchangeRate-API

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura](#arquitetura)
- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Usar](#como-usar)
- [Moedas Suportadas](#moedas-suportadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tratamento de Erros](#tratamento-de-erros)
- [API Reference](#api-reference)
- [Autor](#autor)
- [Licença](#licença)

---

## 📖 Sobre o Projeto

Este projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos** e tem como objetivo demonstrar o consumo de APIs REST, manipulação de JSON, tratamento de exceções e boas práticas de programação Java.

O sistema permite a conversão entre 11 moedas diferentes utilizando taxas de câmbio atualizadas em tempo real através da ExchangeRate-API.

### Objetivos de Aprendizagem

- Consumo de APIs REST com HttpClient
- Parsing JSON com biblioteca Gson
- Tratamento robusto de exceções
- Separação de responsabilidades (SRP)
- Interface de usuário interativa no console
- Validação de entrada de dados

---

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Gson 2.10.1** - Biblioteca para parsing JSON
- **HttpClient** - Cliente HTTP nativo do Java (java.net.http)
- **ExchangeRate-API** - API de taxas de câmbio

---

## 🏗️ Arquitetura

O projeto segue o padrão de **separação de responsabilidades** com três componentes principais:

```
┌─────────────────┐
│   Main.java     │  Interface do usuário (UI)
│   (Console)     │
└────────┬────────┘
│
▼
┌─────────────────────────┐
│  ConversorDeMoedas.java │  Lógica de negócio
│  (Business Logic)       │
└────────┬────────────────┘
│
▼
┌─────────────────┐
│ ApiService.java │  Comunicação com API
│ (Data Access)   │
└─────────────────┘
```

### Componentes

1. **Main.java**: Interface de usuário no console, menu interativo
2. **ConversorDeMoedas.java**: Orquestra a conversão e validações
3. **ApiService.java**: Gerencia requisições HTTP e parsing JSON
4. **Moeda.java**: Enum com as moedas suportadas

---

## ⚙️ Funcionalidades

### Principais Recursos

- ✅ **9 Pares Pré-configurados**: Conversões mais comuns (USD→EUR, BRL→USD, etc)
- ✅ **Conversão Personalizada**: Escolha qualquer par entre 11 moedas
- ✅ **Taxas em Tempo Real**: Dados atualizados da ExchangeRate-API
- ✅ **Validação de Entrada**: Try-catch para entradas inválidas
- ✅ **Confirmação de Continuação**: Sistema S/N após cada conversão
- ✅ **Menu Organizado**: Categorias (Principais, Brasil, América Latina)
- ✅ **Formatação Profissional**: Valores com 2 casas decimais

### Fluxo de Uso

```
1. Usuário insere API key
2. Menu de opções é exibido
3. Usuário escolhe par de moedas
4. Sistema solicita valor
5. Conversão é processada e exibida
6. Sistema pergunta: "Nova conversão? S/N"
7. Loop continua ou encerra
```

---

## 📋 Pré-requisitos

- **Java JDK 17** ou superior
- **Gson 2.10.1** (jar na pasta `/lib`)
- **Conexão com internet** (para acessar API)
- **API Key gratuita** da ExchangeRate-API

### Obter API Key

1. Acesse: https://www.exchangerate-api.com/
2. Crie uma conta gratuita
3. Copie sua chave de API
4. Cole no programa quando solicitado

**Plano Free:**
- 1.500 requisições/mês
- Suficiente para o projeto

---

## 🚀 Instalação e Configuração

### 1. Clone o repositório

```
git clone https://github.com/seu-usuario/conversor-moedas.git
cd conversor-moedas
```

### 2. Adicione a biblioteca Gson

Coloque o arquivo `gson-2.10.1.jar` na pasta `/lib`

### 3. Compile o projeto

**Usando IntelliJ IDEA:**
- File → Project Structure → Libraries → Add Gson JAR
- Build → Build Project

**Linha de comando:**
```
javac -cp "lib/gson-2.10.1.jar" -d out Main.java API/*.java
```

### 4. Execute

**IntelliJ:**
- Run → Main

**Linha de comando:**
```
java -cp "out:lib/gson-2.10.1.jar" Main
```

---

## 📱 Como Usar

### Passo 1: Inserir API Key

```
🔑 Coloque sua chave API: [sua-chave-aqui]
```

### Passo 2: Escolher Conversão

```
╔════════════════════════════════════════════╗
║       💱 CONVERSOR DE MOEDAS 💱           ║
╠════════════════════════════════════════════╣
║ 1  │ USD → EUR  (Dólar → Euro)           ║
║ 2  │ USD → GBP  (Dólar → Libra)          ║
[...]
```

### Passo 3: Digitar Valor

```
💰 Digite o valor em USD: 100
```

### Passo 4: Resultado

```
✅ 100,00 USD = 94,12 EUR
```

### Passo 5: Continuar ou Sair

```
🔄 Deseja fazer outra conversão? (S/N): N
👋 Obrigado por usar o conversor de moedas!
```

---

## 💰 Moedas Suportadas

| Código | Nome | Região |
|--------|------|--------|
| **USD** | Dólar Americano | Estados Unidos |
| **EUR** | Euro | União Europeia |
| **GBP** | Libra Esterlina | Reino Unido |
| **JPY** | Iene Japonês | Japão |
| **BRL** | Real Brasileiro | Brasil |
| **CAD** | Dólar Canadense | Canadá |
| **CHF** | Franco Suíço | Suíça |
| **ARS** | Peso Argentino | Argentina |
| **BOB** | Boliviano | Bolívia |
| **CLP** | Peso Chileno | Chile |
| **COP** | Peso Colombiano | Colômbia |

---

## 📁 Estrutura do Projeto

```
conversor-moedas/
│
├── src/
│   ├── Main.java                    # Interface console
│   └── API/
│       ├── ApiService.java          # Comunicação HTTP
│       ├── ConversorDeMoedas.java   # Lógica conversão
│       └── Moeda.java               # Enum moedas
│
├── lib/
│   └── gson-2.10.1.jar              # Biblioteca JSON
│
├── out/                             # Classes compiladas
│
└── README.md                        # Este arquivo
```

---

## 🛡️ Tratamento de Erros

### Exceções Tratadas

1. **InputMismatchException**
   - Entrada não numérica no menu
   - Entrada não numérica no valor

2. **IOException / InterruptedException**
   - Falha na requisição HTTP
   - Timeout de conexão

3. **JsonSyntaxException**
   - JSON malformado da API

### Mensagens ao Usuário

- ❌ `"Entrada inválida! Digite apenas números"`
- ❌ `"Valor inválido! Digite um número"`
- ❌ `"Erro ao obter dados da API!"`
- ❌ `"Erro ao processar taxa!"`

---

## 🔗 API Reference

### ExchangeRate-API

**Endpoint usado:**
```
https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{FROM}/{TO}
```

**Exemplo de resposta:**
```
{
"result": "success",
"base_code": "USD",
"target_code": "BRL",
"conversion_rate": 5.43
}
```

**Documentação oficial:**  
https://www.exchangerate-api.com/docs

---

## 👨‍💻 Autor

**Seu Nome**  
Estudante de Análise e Desenvolvimento de Sistemas  
Instituição: [Nome da Instituição]

- GitHub: [@seu-usuario](https://github.com/seu-usuario)
- LinkedIn: [Seu Nome](https://linkedin.com/in/seu-perfil)

---

## 📝 Licença

Este projeto foi desenvolvido para fins educacionais.

---

## 🙏 Agradecimentos

- ExchangeRate-API pela API gratuita
- Comunidade Java
- Professor [Nome do Professor]

---

**Última atualização:** Dezembro 2025  
**Versão:** 1.0.0
```

***

## **📝 2. JAVADOC PARA AS CLASSES:**

### **ApiService.java:**

```java
package API;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Serviço responsável pela comunicação com a ExchangeRate-API.
 * 
 * <p>Esta classe gerencia requisições HTTP, parsing de JSON e extração
 * de taxas de conversão da API externa. Utiliza HttpClient nativo do Java
 * e a biblioteca Gson para manipulação JSON.</p>
 * 
 * <h2>Funcionalidades principais:</h2>
 * <ul>
 *   <li>Configuração de API key</li>
 *   <li>Requisições HTTP GET para obter taxas</li>
 *   <li>Parsing JSON da resposta</li>
 *   <li>Extração do campo conversion_rate</li>
 * </ul>
 * 
 * <h2>Exemplo de uso:</h2>
 * <pre>
 * ApiService api = new ApiService();
 * api.insiraApi("sua-chave-aqui");
 * String json = api.obterTaxa("USD", "BRL");
 * double taxa = api.obterTaxaDeConversao(json);
 * </pre>
 * 
 * @author Seu Nome
 * @version 1.0
 * @since 2025-12-09
 */
public class ApiService {
    
    /** Chave de autenticação da API */
    private String api_key;
    
    /** URL base da ExchangeRate-API (v6) */
    private String base_url;
    
    /** Cliente HTTP reutilizável para requisições */
    private HttpClient client;
    
    /**
     * Construtor padrão da classe ApiService.
     * 
     * <p>Inicializa a URL base da API e cria uma instância do HttpClient
     * que será reutilizada em todas as requisições.</p>
     */
    public ApiService() {
        this.base_url = "https://v6.exchangerate-api.com/v6/";
        this.client = HttpClient.newBuilder().build();
    }
    
    // Getters
    
    /**
     * Retorna a chave de API configurada.
     * 
     * @return String contendo a API key ou null se não configurada
     */
    public String getApi_key() {
        return api_key;
    }
    
    /**
     * Retorna a URL base da API.
     * 
     * @return String com a URL base (sem a chave)
     */
    public String getBase_url() {
        return base_url;
    }
    
    // Métodos principais
    
    /**
     * Configura a chave de autenticação da API.
     * 
     * <p>Valida se a chave fornecida não é nula ou vazia antes de
     * armazená-la. Exibe mensagem de sucesso ou erro ao usuário.</p>
     * 
     * @param apikey String contendo a chave de API fornecida pelo usuário
     * @throws IllegalArgumentException se apikey for null ou vazia (implícito)
     */
    public void insiraApi(String apikey) {
        if (apikey == null || apikey.isEmpty()) {
            System.err.println("🚷 Sua API esta vazia!");
            return;
        }
        this.api_key = apikey;
        System.out.println("🔑 Chave inserida com sucesso!");
    }
    
    /**
     * Realiza requisição HTTP para obter taxa de conversão entre duas moedas.
     * 
     * <p>Monta a URL completa com API key e códigos das moedas, realiza
     * requisição GET síncrona e retorna o corpo da resposta em formato JSON.</p>
     * 
     * <h3>Formato da URL:</h3>
     * <code>https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{origem}/{destino}</code>
     * 
     * @param origem Código da moeda de origem (ex: "USD")
     * @param destino Código da moeda de destino (ex: "BRL")
     * @return String contendo JSON da resposta ou null em caso de erro
     * @see #obterTaxaDeConversao(String)
     */
    public String obterTaxa(String origem, String destino) {
        if (this.api_key == null) {
            System.err.println("🚷 Sua API esta vazia!");
            return null;
        }
        
        String endereco = this.base_url + this.api_key + "/pair/" + origem + "/" + destino;
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.err.println("🚫 Erro na requisição: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Extrai a taxa de conversão de um JSON retornado pela API.
     * 
     * <p>Utiliza Gson para parsear o JSON e extrair o valor do campo
     * "conversion_rate". Trata exceções de parsing retornando -1.0.</p>
     * 
     * <h3>Estrutura JSON esperada:</h3>
     * <pre>
     * {
     *   "result": "success",
     *   "conversion_rate": 5.43,
     *   ...
     * }
     * </pre>
     * 
     * @param json String contendo JSON válido da API
     * @return double com a taxa de conversão ou -1.0 em caso de erro
     */
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
```

***

### **ConversorDeMoedas.java:**

```java
package API;

/**
 * Classe responsável pela lógica de conversão de moedas.
 * 
 * <p>Orquestra a obtenção de taxas através do ApiService e realiza
 * o cálculo da conversão monetária. Implementa validações de entrada
 * e tratamento de erros.</p>
 * 
 * <h2>Padrão de Design:</h2>
 * Utiliza <b>Dependency Injection</b> para receber ApiService, facilitando
 * testes e manutenção.
 * 
 * <h2>Exemplo de uso:</h2>
 * <pre>
 * ApiService api = new ApiService();
 * api.insiraApi("chave-api");
 * 
 * ConversorDeMoedas conversor = new ConversorDeMoedas(api);
 * double resultado = conversor.converter(100, "USD", "BRL");
 * 
 * if (resultado != -1.0) {
 *     System.out.println("Convertido: " + resultado);
 * }
 * </pre>
 * 
 * @author Seu Nome
 * @version 1.0
 * @since 2025-12-09
 */
public class ConversorDeMoedas {
    
    /** Serviço de API injetado para comunicação externa */
    private ApiService apiService;
    
    /**
     * Construtor com injeção de dependência.
     * 
     * @param apiService Instância configurada de ApiService
     */
    public ConversorDeMoedas(ApiService apiService) {
        this.apiService = apiService;
    }
    
    /**
     * Converte um valor de uma moeda para outra.
     * 
     * <p>Realiza o processo completo de conversão:
     * <ol>
     *   <li>Valida se valor é positivo</li>
     *   <li>Obtém JSON da API com taxa</li>
     *   <li>Extrai taxa do JSON</li>
     *   <li>Calcula valor convertido</li>
     *   <li>Retorna resultado</li>
     * </ol>
     * </p>
     * 
     * <h3>Fórmula de conversão:</h3>
     * <code>valorConvertido = valorOriginal × taxaDeConversão</code>
     * 
     * @param valor Valor a ser convertido (deve ser positivo)
     * @param moedaOrigem Código da moeda de origem (ex: "USD")
     * @param moedaDestino Código da moeda de destino (ex: "EUR")
     * @return double com valor convertido ou -1.0 em caso de erro
     */
    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        // Validar valor
        if (valor <= 0) {
            System.err.println("⚠️ Valor deve ser positivo!");
            return -1.0;
        }
        
        // Obter JSON
        String json = apiService.obterTaxa(moedaOrigem, moedaDestino);
        if (json == null) {
            System.err.println("⚠️ Erro ao obter dados da API!");
            return -1.0;
        }
        
        // Obter taxa
        double taxa = apiService.obterTaxaDeConversao(json);
        
        // Validar taxa
        if (taxa == -1.0) {
            System.err.println("⚠️ Erro ao processar taxa!");
            return -1.0;
        }
        
        // Calcular e retornar
        double valorConvertido = valor * taxa;
        return valorConvertido;
    }
}
```

***

### **Moeda.java (Enum):**

```java
package API;

/**
 * Enumeração das moedas suportadas pelo sistema.
 * 
 * <p>Define os códigos ISO 4217 das 11 moedas disponíveis para
 * conversão. Inclui moedas globais e da América Latina.</p>
 * 
 * <h2>Categorias:</h2>
 * <ul>
 *   <li><b>Principais Globais:</b> USD, EUR, GBP, JPY, CHF</li>
 *   <li><b>América do Norte:</b> USD, CAD</li>
 *   <li><b>América Latina:</b> BRL, ARS, BOB, CLP, COP</li>
 * </ul>
 * 
 * @author Seu Nome
 * @version 1.0
 * @since 2025-12-09
 */
public enum Moeda {
    /** Dólar Americano - Moeda de reserva global */
    USD,
    
    /** Real Brasileiro - Moeda nacional */
    BRL,
    
    /** Peso Argentino - Argentina */
    ARS,
    
    /** Boliviano - Bolívia */
    BOB,
    
    /** Peso Chileno - Chile */
    CLP,
    
    /** Peso Colombiano - Colômbia */
    COP,
    
    /** Euro - União Europeia */
    EUR,
    
    /** Libra Esterlina - Reino Unido */
    GBP,
    
    /** Iene Japonês - Japão */
    JPY,
    
    /** Dólar Canadense - Canadá */
    CAD,
    
    /** Franco Suíço - Suíça */
    CHF
}
```

