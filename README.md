# Projeto de Automação de Testes - McDonald's

Este é um projeto de automação de testes desenvolvido para validar funcionalidades da página de lançamentos do site do McDonald's. A automação utiliza **Selenium** e **Cucumber** integrados com **JUnit**, seguindo a abordagem de desenvolvimento guiado por comportamento (**BDD**).

## Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

```bash
mcdonalds/
│
├── .settings/             # Configurações do projeto (Eclipse)
├── evidencias/            # Evidências e screenshots dos testes
│   └── screen.png         # Captura de tela dos testes automatizados
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   └── steps/
│       │       └── LancamentosTest.java  # Classe de testes automatizados
│       └── resources/
│           └── features/
│               └── lancamentos.feature   # Arquivo de feature com cenários de teste
├── target/                # Diretório de build do Maven
├── .classpath             # Arquivo de configuração do Eclipse
├── .project               # Arquivo de configuração do Eclipse
├── pom.xml                # Arquivo Maven para gerenciamento de dependências
└── README.md              # Descrição e informações sobre o projeto
```

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal para os testes.
- **Selenium**: Framework de automação para simulação de interação com o navegador.
- **Cucumber**: Framework para desenvolvimento guiado por comportamento (**BDD**), que permite a escrita de cenários em formato Gherkin.
- **JUnit**: Framework de testes para execução dos testes automatizados.
- **Maven**: Gerenciador de dependências e build do projeto.

## Estrutura dos Testes

- **LancamentosTest.java**: Classe que contém os passos que implementam os cenários definidos no arquivo de feature. Ela utiliza Selenium para navegar e interagir com a página de lançamentos do McDonald's.
- **lancamentos.feature**: Arquivo Gherkin que descreve os cenários de teste. Exemplo de cenário:

```gherkin
Feature: Testar a seção de lançamentos do site McDonald's

  Scenario: Verificar os lançamentos no cardápio
    Given que estou na página de lançamentos do McDonald's
    When eu visualizo os produtos de lançamento
    Then os produtos devem ser exibidos corretamente
```

## Como Executar o Projeto

### Pré-requisitos

- **Java 11** ou superior.
- **Maven** instalado e configurado no PATH do sistema.
- Um navegador (exemplo: Chrome) e o WebDriver correspondente instalado.

### Passos para Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/mcdonalds-automation.git
```

2. Navegue até o diretório do projeto:

```bash
cd mcdonalds-automation
```

3. Execute os testes usando Maven:

```bash
mvn clean test
```

Após a execução, evidências dos testes (como capturas de tela) estarão disponíveis no diretório **evidencias/**.

## Gerenciamento de Dependências

As dependências são gerenciadas pelo Maven através do arquivo `pom.xml`. As principais bibliotecas utilizadas são:

```xml
<dependencies>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.19.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.19.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.25.0</version>
    </dependency>
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.17.0</version>
    </dependency>
</dependencies>
```

## Relatórios e Evidências

Ao final da execução dos testes, as evidências serão armazenadas no diretório **evidencias/**. As capturas de tela dos testes são salvas para análise posterior.

## Contribuições

Este projeto é aberto para contribuições. Se você deseja colaborar, faça um fork do repositório, crie um branch com suas alterações e envie um pull request.

## Licença

Este projeto é para fins educacionais e de portfólio. Sinta-se à vontade para utilizá-lo e modificá-lo conforme necessário.
