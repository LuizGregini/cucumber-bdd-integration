package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.enums.UnidadeTempo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class AprenderCucumberSteps {

    String telefoneValido = "";
    String regexTelefone = "\\(\\d{2}\\)9\\d{4,5}-\\d{4}";
    private int contador = 0;
    String telefoneInvalido = "";
    String regexTelefoneInvalido = "\\(\\d{2}\\)[0-8]\\d{4,5}-\\d{4}";
    private LocalDate dataPrazo;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate novaDataComAtraso;

    @Given("que eu criei o arquivo corretamente")
    public void queEuCrieiOArquivoCorretamente() {
    }

    @When("executa-ló")
    public void executaLo() {
    }

    @Then("a especificação deve finalizar com sucesso")
    public void aEspecificaçãoDeveFinalizarComSucesso() {
    }


    @Given("^que o valor do contador é (\\d+)$")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = int1;
    }

    @When("eu incrementar em três {int}")
    public void euIncrementarEmTrês(Integer int1) {
        contador = contador + int1;
    }

    @Then("o valor do contador será {int}")
    public void oValorDoContadorSerá(Integer int1) {
        assertEquals((int) int1, contador);
    }


    @Given("que o usuário digitou o seguinte telefone {string}")
    public void queOUsuárioDigitouOSeguinteTelefone(String telefoneValidoDigitado) {
        this.telefoneValido = telefoneValidoDigitado;
    }

    @When("o usuário clicar em salvar telefone")
    public void oUsuárioClicarEmSalvarTelefone() {
    }

    @Then("o sistema deve validar o telefone como válido")
    public void oSistemaDeveValidarOTelefoneComoVálido() {
        assertTrue(telefoneValido.matches(regexTelefone), "Telefone inválido: " + telefoneValido);
    }


    @Given("que o usuário digitou o seguinte telefone inválido {string}")
    public void queOUsuárioDigitouOSeguinteTelefoneInválido(String telefoneInvalidoDigitado) {
        this.telefoneInvalido = telefoneInvalidoDigitado;
    }

    @When("o usuário clicar em salvar o telefone inválido")
    public void oUsuárioClicarEmSalvarOTelefoneInválido() {
    }

    @Then("o sistema não deve cadastrar o telefone")
    public void oSistemaNãoDeveCadastrarOTelefone() {
        assertTrue(telefoneInvalido.matches(regexTelefoneInvalido), "opss, Telefone válido");
    }


    @Given("que o prazo é dia (\\d{2}/\\d{2}/\\d{4})$")
    public void queOPrazoÉDia(String dataParametroInicial) {
        this.dataPrazo = LocalDate.parse(dataParametroInicial, formatter);
    }


    @When("a entrega atrasar em (\\d+) (dia|mes|ano)$")
    public void aEntregaAtrasarEm(Integer quantidadeDeDiaOuMesOuAno, String unidadeDeTempo) {
        UnidadeTempo unidade = UnidadeTempo.valueOf(unidadeDeTempo.toUpperCase());
        switch(unidade){
            case DIA:
                novaDataComAtraso = dataPrazo.plusDays(quantidadeDeDiaOuMesOuAno);
                break;
            case MES:
                novaDataComAtraso = dataPrazo.plusMonths(quantidadeDeDiaOuMesOuAno);
                break;
            case ANO:
                novaDataComAtraso = dataPrazo.plusYears(quantidadeDeDiaOuMesOuAno);
                break;
        }
    }

    @Then("a nova data será dia (\\d{2}/\\d{2}/\\d{4})$")
    public void aNovaDataSeráDia(String dataFinal) {
        LocalDate novaDataFinal = LocalDate.parse(dataFinal, formatter);
        assertEquals(novaDataComAtraso, novaDataFinal);
    }

    @Given("^que o ticket( especial)? é (A[A-Za-z]\\d{3})$")
    //(A[A-Za-z]\d{3})$
    public void queOTicketÉ(String especial,  String ticket) {
    }

    @Given("^que o valor da passagem é R\\$ ([0-9]{1,6}[,][0-9]{2})$")
    public void queOValorDaPassagemÉR$(double valorDaPassagem) {
    }

    @Given("^que o nome do passageiro é ([\\p{L} ]{3,20})$")
    public void queONomeDoPassageiroE(String nomePassageiro) {
    }

    @Given("^que o telefone do passageiro é (9\\d{3,4}[-]\\d{4})$")
    public void queOTelefoneDoPassageiroE(String numertoTelefonePassageiro) {
    }

    @When("criar os steps")
    public void criarOsSteps() {
    }

    @Then("o teste vai funcionar")
    public void oTesteVaiFuncionar() {
    }
}