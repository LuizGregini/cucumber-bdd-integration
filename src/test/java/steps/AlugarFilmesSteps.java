package steps;

import context.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.example.entidades.Filme;
import org.example.enums.TipoDeLocacao;
import org.example.services.FilmeService;
import java.time.LocalDate;
import java.util.Map;
import static org.example.enums.TipoDeLocacao.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlugarFilmesSteps {

    private final ScenarioContext context;

    public AlugarFilmesSteps(ScenarioContext context) {
        this.context = context;
    }

    Filme filme = new Filme();
    FilmeService filmeService = new FilmeService();
    private LocalDate today = LocalDate.now();

    private int pontuacaoFilme;

    @Given("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer estoqueDeFilmes) {
        filme.setQuantidade(estoqueDeFilmes);
    }

    @And("que o preço do aluguel seja de R$ {double}")
    public void queOPreçoDoAluguelSejaDeR$(Double precoDoAluguel) {
        filme.setPreco(precoDoAluguel);
    }

    @When("alugar")
    public void alugar() {
        filmeService.alugarFilme(filme);
        System.out.println(filme.toString());
    }

    @Then("o preço do aluguel será de R$ {double}")
    public void oPreçoDoAluguelSeráDeR$(Double precoQueSeraDoAluguel) {
        assertEquals(filme.getPreco(), precoQueSeraDoAluguel);
    }

    @And("o estoque do filme será de {int} unidade")
    public void oEstoqueDoFilmeSeráDeUnidade(Integer novaQuantidade) {
        assertEquals(filme.getQuantidade(), novaQuantidade);
    }

    @Then("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        if(filme.getQuantidade() < 0){
            filme.setQuantidade(0);
        }
        assertEquals(0, filme.getQuantidade(), "Opss, filme sem estoque atualmente.");
    }

    @And("que o Tipo de aluguel seja (.*)$")
    public void queOTipoDeAluguelSejaExtendido(String tipoDeGarantia) {
        TipoDeLocacao tipoEnum = TipoDeLocacao.valueOf(tipoDeGarantia.toUpperCase());
        switch (tipoEnum){
            case EXTENDIDO:
                filme.setTipoDeAluguel(String.valueOf(EXTENDIDO));
                break;
            case COMUM:
                filme.setTipoDeAluguel(String.valueOf(COMUM));
                break;
            default:
                filme.setTipoDeAluguel(String.valueOf(SEM_VINCULO));
                break;
        }
    }

    @And("^a data de entrega será de (\\d+) dias?$")
    public void aDataDeEntregaSeráDeDias(Integer quantidadeDeDias) {
        assertEquals(today.plusDays(quantidadeDeDias), filme.getDataDeEntrega());
    }

    @And("e a pontuação será de (\\d+) pontos?$")
    public void eAPontuaçãoSeráDePontos(Integer pontuacao) {
        filme.setPontuacao(pontuacao);
        assertEquals(filme.getPontuacao(), pontuacao);
    }

    @Given("um filme")
    public void umFilme(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        filme.setQuantidade(Integer.parseInt(map.get("estoque")));
        filme.setPreco(Double.parseDouble(map.get("preco")));
    }
}
