package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.ContasPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class CadastrarContasSteps {

    LoginPage loginPage;
    ContasPage contasPage;

    public CadastrarContasSteps() {
        this.loginPage = new LoginPage(Hooks.driver);
        this.contasPage = new ContasPage(Hooks.driver);
    }

    @Given("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        loginPage.acessarAplicacao();
    }

    @When("informo o usuário {string}")
    public void informo_o_usuário(String email) {
        loginPage.informarEmail(email);
    }

    @And("a senha {string}")
    public void a_senha(String senha) {
        loginPage.informarSenha(senha);
    }

    @And("seleciono entrar")
    public void seleciono_entrar() {
        loginPage.clicarEmEntrar();
    }

    @Then("visualizo a página inicial")
    public void visualizo_a_página_inicial() {
        loginPage.validarMensagemLoginComSucesso();
        System.out.println(loginPage.getStringMessageLoginSucess());
        assertEquals("Bem vindo, Nikinha!", loginPage.getStringMessageLoginSucess());
    }

    @When("seleciono Contas")
    public void seleciono_contas() {
        contasPage.acessarMenuContas();
    }

    @And("seleciono Adicionar")
    public void seleciono_adicionar() {
        contasPage.clicarEmAdicionar();
    }

    @And("informo a conta {string}")
    public void informo_a_conta(String setNomeDaConta) {
        contasPage.informaNomeDaConta(setNomeDaConta);
    }

    @And("seleciono Salvar")
    public void seleciono_salvar() {
        contasPage.clicaEmSalvarConta();
    }

    @Then("a conta é inserida com sucesso")
    public void a_conta_é_inserida_com_sucesso() {
        contasPage.validaMensagemDeContaInseridaComSucesso();
        assertEquals("Conta adicionada com sucesso!", contasPage.getMessagemValidaContaCriada());
    }

    @Then("sou notificado que o nome da conta é obrigatório")
    public void souNotificadoQueONomeDaContaÉObrigatório() {
        contasPage.validaMensagemDeContaNaoInserida();
    }

    @Then("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        contasPage.validaMensagemRegistroDuplicado();
    }
}
