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

1. Acesse: [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/)
2. Crie uma conta gratuita
3. Copie sua chave de API
4. Cole no programa quando solicitado

**Plano Free:**
- 1.500 requisições/mês
- Suficiente para o projeto

---

## 🚀 Instalação e Configuração

### 1. Clone o repositório

```bash
git clone https://github.com/Victoredbr21/conversor-moedas.git
cd conversor-moedas
```

### 2. Adicione a biblioteca Gson

Coloque o arquivo `gson-2.10.1.jar` na pasta `/lib`

### 3. Compile o projeto

**Usando IntelliJ IDEA:**
- File → Project Structure → Libraries → Add Gson JAR
- Build → Build Project

**Linha de comando:**
```bash
javac -cp "lib/gson-2.10.1.jar" -d out Main.java API/*.java
```

### 4. Execute

**IntelliJ:**
- Run → Main

**Linha de comando:**
```bash
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
```json
{
  "result": "success",
  "base_code": "USD",
  "target_code": "BRL",
  "conversion_rate": 5.43
}
```

**Documentação oficial:**  
[https://www.exchangerate-api.com/docs](https://www.exchangerate-api.com/docs)

---

## 👨‍💻 Autor

**Victor Américo**  
Estudante de Análise e Desenvolvimento de Sistemas  
Instituição: Celso Lisboa (Rio de Janeiro)

- GitHub: [@Victoredbr21](https://github.com/Victoredbr21)
- LinkedIn: [Victor Américo](https://linkedin.com/in/seu-perfil)

---

## 📝 Licença

Este projeto foi desenvolvido para fins educacionais.

---

## 🙏 Agradecimentos

- ExchangeRate-API pela API gratuita
- Comunidade Java
- Professores do curso de ADS

---

**Última atualização:** Dezembro 2025  
**Versão:** 1.0.0