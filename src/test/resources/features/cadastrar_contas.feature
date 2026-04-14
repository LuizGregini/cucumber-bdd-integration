@participate
Feature: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Background:
  Given que estou acessando a aplicação
  When informo o usuário "seleniumwithcucumber@gmail.com"
  And a senha "5545"
  And seleciono entrar
  Then visualizo a página inicial
  When seleciono Contas
  And seleciono Adicionar

@smoke
Scenario: Deve inserir uma conta com sucesso
  And informo a conta "Conta de Teste"
  And seleciono Salvar
  Then a conta é inserida com sucesso

@smoke
Scenario: Não deve inserir uma conta sem nome
  And seleciono Salvar
  Then sou notificado que o nome da conta é obrigatório

@smoke
Scenario: Não deve inserir uma conta com nome já existente
  And informo a conta "Conta mesmo nome"
  And seleciono Salvar
  Then sou notificado que já existe uma conta com esse nome