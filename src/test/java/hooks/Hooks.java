package hooks;

import context.ScenarioContext;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {

    @BeforeAll()
    public static void resetaBanco(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Começou o reseta banco");
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("seleniumwithcucumber@gmail.com");
        driver.findElement(By.name("senha")).sendKeys("5545");
        driver.findElement(By.tagName("button")).click();
        wait.withMessage("Mensagem de boas-vindas não apareceu")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success') and contains(.,'Bem vindo')]")));
        driver.findElement(By.xpath("//a[@href='/reset' and contains(text(), 'reset')]")).click();
        System.out.println("Finalizou reset de Banco");
        driver.quit();
    }

    private final ScenarioContext context;

    public Hooks(ScenarioContext context) {
        this.context = context;
    }

    @After
    public void imprimirFilme() {
        if (context.getFilme() != null) {
            System.out.println("Resultado do cenário:");
            System.out.println(context.getFilme());
        }
    }

    public static WebDriver driver;

    @Before(value = "@participate")
    public void abrirBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(61));
    }

    @After(order = 1, value = "@participate")
    public void screenshot(Scenario scenario){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshots/"+scenario.getName()+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After(order = 0, value = "@participate")
    public void fecharBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}
