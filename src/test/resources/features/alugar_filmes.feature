@DEUS-6
Feature: Alugar filmes
  Como um usuário
  Eu quero cadastrar alugueis de filmes
  Para controlar preços e data de entrega

@DEUS-5
Scenario: Deve alugar um filme com sucesso
  Given um filme
  | estoque |2|
  |  preco  |3|
  When alugar
  Then o preço do aluguel será de R$ 3.00
  And a data de entrega será de 1 dia
  And o estoque do filme será de 1 unidade

@DEUS-5
Scenario: Não deve alugar filme sem estoque
  Given um filme com estoque de 0 unidades
  When alugar
  Then não será possível por falta de estoque
  And o estoque do filme será de 0 unidade

@DEUS-5
Scenario: Deve dar condições especiais para categoria extendida
  Given um filme com estoque de 2 unidades
  And que o preço do aluguel seja de R$ 4.00
  And que o Tipo de aluguel seja extendido
  When alugar
  Then o preço do aluguel será de R$ 8.00
  And a data de entrega será de 3 dias
  And e a pontuação será de 2 pontos

@DEUS-5
Scenario: Deve alugar para categoria comum
  Given um filme com estoque de 2 unidades
  And que o preço do aluguel seja de R$ 4.00
  And que o Tipo de aluguel seja comum
  When alugar
  Then o preço do aluguel será de R$ 4.00
  And a data de entrega será de 1 dia
  And e a pontuação será de 1 ponto

Scenario Outline: Deve dar condições conforme tipo de aluguel
  Given um filme com estoque de 2 unidades
  And que o preço do aluguel seja de R$ <preco>
  And que o Tipo de aluguel seja <tipo>
  When alugar
  Then o preço do aluguel será de R$ <valorFinal>
  And a data de entrega será de <qtdeDias> dias
  And e a pontuação será de <pontuacao> pontos

  Examples:
    | preco |    tipo       | valorFinal | qtdeDias | pontuacao |
    |   4   |  extendido    |       8    |     3     |     4    |
    |   4   |  comum        |       4    |     1     |     1    |
    |   3   |  sem_vinculo  |       3    |     1     |     1    |
