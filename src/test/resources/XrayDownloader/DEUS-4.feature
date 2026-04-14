@DEUS-4
Feature: Default

	
	@DEUS-1
	Scenario: Deus Type Test
		Given um filme com estoque de 2 unidades
		And que o preço do aluguel seja de R$ 3.00
		When alugar
		Then o preço do aluguel será de R$ 3.00
		And a data de entrega será de 1 dia
		And o estoque do filme será de 1 unidade	

	
	@DEUS-2
	Scenario: Deus Type Test
		Given um filme com estoque de 0 unidades
		When alugar
		Then não será possível por falta de estoque
		And o estoque do filme será de 0 unidade	


	@DEUS-3
	Scenario: Deus Type Test
		Given um filme com estoque de 2 unidades
		And que o preço do aluguel seja de R$ 4.00
		And que o Tipo de aluguel seja teste de tipo de locação inválido para falhar
		When alugar
		Then o preço do aluguel será de R$ 8.00
		And a data de entrega será de 3 dias
		And e a pontuação será de 2 pontos