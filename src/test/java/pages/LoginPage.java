package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By email = By.id("email");
    private final By password = By.name("senha");
    private final By buttonToEnter = By.xpath("//button[@type='submit' and @class='btn btn-primary' and contains(text(), 'Entrar')]");
    private final By messageLoginSucess = By.xpath("//div[contains(@class,'alert-success') and contains(.,'Bem vindo, Nikinha!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acessarAplicacao() {
        driver.get("https://seubarriga.wcaquino.me/");
    }

    public void informarEmail(String emailUsuario){
        driver.findElement(email).sendKeys(emailUsuario);
    }

    public void informarSenha(String senha){
        driver.findElement(password).sendKeys(senha);
    }

    public void clicarEmEntrar(){
        driver.findElement(buttonToEnter).click();
    }

    public void validarMensagemLoginComSucesso(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageLoginSucess));
    }

    public String getStringMessageLoginSucess(){
        return driver.findElement(messageLoginSucess).getText();
    }
}
