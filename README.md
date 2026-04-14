# 📱 Cucumber BDD Integration Framework

Este é um projeto de automação de testes utilizando **Java + Cucumber + BDD**, estruturado com foco em boas práticas de automação, legibilidade e escalabilidade.

---

## 🎯 Objetivo

Este projeto surgiu com Objetivo de alavancar o conhecimento no que se diz o BDD.

Este projeto tem como objetivo demonstrar a implementação de testes automatizados utilizando **Behavior Driven Development (BDD)** com Cucumber.
A proposta é escrever testes em linguagem natural (Gherkin), facilitando a comunicação entre QA, desenvolvedores e stakeholders, além de manter uma arquitetura organizada, reutilizável e escalável.
Por fim pensando em uma futura melhoria na parte de CI/CD resolvi fazer a integração direta dos teste utilizando o Jira com o Xray.

---

## 🧠 BDD (Behavior Driven Development)

BDD é uma abordagem que descreve o comportamento da aplicação através de cenários escritos em linguagem natural.

### Exemplo de cenário:

```gherkin
Feature: Login

Scenario: Usuário realiza login com sucesso
  Given que o usuário está na tela de login
  When informa credenciais válidas
  Then deve ser autenticado com sucesso
```

Essa abordagem melhora o entendimento do comportamento da aplicação e aproxima o teste da linguagem de negócio.

---

## 🧰 Tecnologias utilizadas

* Java
* Cucumber
* Gherkin
* Maven
* JUnit
* Selenium WebDriver
* Page Object Model (POM)

---

## 🏗️ Estrutura do projeto

O projeto segue uma arquitetura organizada em camadas:

```
src/test/java
 ├── runners        # Execução dos testes Cucumber
 ├── steps          # Definição dos Steps (Given / When / Then)
 ├── pages          # Page Objects (interação com elementos da UI)
 ├── hooks          # Setup e teardown dos testes
 ├── base           # Configuração do driver
 ├── utils          # Classes utilitárias e helpers
```

---

## 🔹 Runner

Responsável por:

* Executar os testes do Cucumber
* Definir features e glue (steps)
* Configurar plugins de relatório

---

## 🔹 Step Definitions

Camada responsável por:

* Traduzir cenários Gherkin em código Java
* Reutilizar ações das Pages
* Manter os testes legíveis e organizados

---

## 🔹 Page Object Model (POM)

As classes de Page encapsulam as interações com a interface da aplicação.

### Benefícios:

* Reutilização de métodos
* Redução de duplicação de código
* Facilidade de manutenção
* Separação entre lógica de teste e UI

---

## 🔹 Hooks

Responsável por:

* Inicializar o driver antes dos testes
* Finalizar a sessão após execução
* Controlar pré e pós-condições dos cenários

---

## 🚀 Como executar o projeto

Execute os testes via Maven:

```bash
mvn clean test
```

Ou execute diretamente pela classe Runner na IDE.

---

## 📊 Boas práticas aplicadas

* Estrutura baseada em BDD com Cucumber
* Separação clara de responsabilidades (Steps / Pages / Base)
* Uso de Page Object Model (POM)
* Reutilização de código
* Driver centralizado e compartilhado
* Estrutura escalável para projetos reais de automação

---

## 📌 Observação

Este projeto 
Este projeto foi desenvolvido com foco em aprendizado e evolução em automação de testes. Anteriormente já tinha conhecimento com Cypress 

---

## 🚀 Diferencial

* Estrutura profissional de framework
* Código organizado e escalável
* Base pronta para CI/CD
* Foco em boas práticas de mercado em automação

---

Algumas considerações ao finalizar o Curso:

O BDD tem como objetivo ser uma documentação verdadeira, ou seja, tudo o que está descrito nele deve ser considerado como verdade do sistema. Uma de suas principais características é ser uma documentação viva, acessível a todos os envolvidos no projeto, como suporte, equipe de implantação, stakeholders, vendas, desenvolvedores e QA.

Por outro lado, um dos seus principais desafios é justamente manter essa documentação sempre atualizada. Qualquer nova feature deve ser adicionada, funcionalidades removidas devem ser refletidas quando necessário e alterações de regra de negócio precisam ser devidamente ajustadas. Caso contrário, a documentação perde sua confiabilidade e um dos princípios do BDD é comprometido.

Neste projeto, optei por utilizar o Selenium junto com o BDD para a automação dos testes.

Durante o desenvolvimento, me deparei com uma postagem do Papito, na qual ele discute se o uso de BDD com Selenium é uma abordagem boa ou ruim. Essa reflexão me fez reconsiderar, ao final do projeto, se realmente vale a pena utilizar essa combinação dessa forma, principalmente ao observar que algumas empresas adotam esse modelo.

---

## 👨‍💻 Autor

**Luiz Gustavo**

---
