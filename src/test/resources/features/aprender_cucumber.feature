Feature: Aprender Cucumber
  Como um aluno
  Eu quero aprender Cucumber
  Para que eu possa automatizar critérios de aceitação

Scenario: Deve executar especificação
  Given que eu criei o arquivo corretamente
  When executa-ló
  Then a especificação deve finalizar com sucesso

Scenario: Deve incrementar contador
  Given que o valor do contador é 15
  When eu incrementar em três 3
  Then o valor do contador será 18

Scenario: Deve cadastrar um telefone celular válido
  Given que o usuário digitou o seguinte telefone "(45)99917-8702"
  When o usuário clicar em salvar telefone
  Then o sistema deve validar o telefone como válido

Scenario: Não deve cadastrar um telefone celular inválido
  Given que o usuário digitou o seguinte telefone inválido "(45)19922-5566"
  When o usuário clicar em salvar o telefone inválido
  Then o sistema não deve cadastrar o telefone

Scenario: Calcular atraso em dias no prazo de entrega
  Given que o prazo é dia 17/12/2025
  When a entrega atrasar em 3 dia
  Then a nova data será dia 20/12/2025

Scenario: Calcular atraso em meses no prazo de entrega
  Given que o prazo é dia 17/12/2025
  When a entrega atrasar em 3 mes
  Then a nova data será dia 17/03/2026

Scenario: Calcular atraso em anos no prazo de entrega
  Given que o prazo é dia 16/12/2025
  When a entrega atrasar em 1 ano
  Then a nova data será dia 16/12/2026

Scenario: Deve criar steps genéricos para estes passos
  Given que o ticket é AF345
  Given que o valor da passagem é R$ 230,45
  Given que o nome do passageiro é Fulano da Silva
  Given que o telefone do passageiro é 9999-9999
  When criar os steps
  Then o teste vai funcionar

Scenario: Deve reaproveitar os steps Dado do cenário anterior
    Given que o ticket é AB167
    Given que o ticket especial é AB167
    Given que o valor da passagem é R$ 1120,23
    Given que o nome do passageiro é Cicrano de Oliveira
    Given que o telefone do passageiro é 9888-8888

@ignore
Scenario: Deve negar todos os steps Dado dos cenários anteriores
    Given que o ticket é CD123
    Given que o ticket é AG1234
    Given que o valor da passagem é R$ 1.1345,56
    Given que o nome do passageiro é Beltrano Souza Matos de Alcântara Azevedo
    Given que o telefone do passageiro é 1234-5678
    Given que o telefone do passageiro é 999-2223

