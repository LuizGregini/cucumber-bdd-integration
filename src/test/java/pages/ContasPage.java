package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContasPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By menuContas = By.xpath("//a[@href='/' and @role='button' and contains(normalize-space(),'Contas')]");
    private final By adicionarConta = By.xpath("//a[@href='/addConta' and contains(text(), 'Adicionar')]");
    private final By nomeDaConta = By.id("nome");
    private final By salvaConta = By.xpath("//button[@class='btn btn-primary' and contains(text(), 'Salvar')]");
    private final By messagemValidaContaCriada = By.xpath("//div[@class='alert alert-success' and @role='alert' and contains(text(), 'Conta adicionada com sucesso!')]");
    private final By messagemInvalidaContaCriada = By.xpath("//div[@class='alert alert-danger' and @role='alert' and contains(text(),'Informe o nome da conta')]");
    private final By messagemRegistroDuplicado = By.xpath("//div[@class='alert alert-danger' and @role='alert' and normalize-space(.)='Já existe uma conta com esse nome!']");
    public ContasPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(61));
    }

    public void acessarMenuContas(){
        driver.findElement(menuContas).click();
    }

    public void clicarEmAdicionar(){
        driver.findElement(adicionarConta).click();
    }

    public void informaNomeDaConta(String name){
        driver.findElement(nomeDaConta).sendKeys(name);
    }

    public void clicaEmSalvarConta(){
        driver.findElement(salvaConta).click();
    }

    public void validaMensagemDeContaInseridaComSucesso(){
        driver.findElement(messagemValidaContaCriada);
    }

    public void validaMensagemDeContaNaoInserida(){
        driver.findElement(messagemInvalidaContaCriada);
    }

    public void validaMensagemRegistroDuplicado(){
        driver.findElement(messagemRegistroDuplicado);
    }

    public String getMessagemValidaContaCriada(){
        return driver.findElement(messagemValidaContaCriada).getText();
    }


}
