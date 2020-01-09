package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.DriverFactory;

public class BlogPage extends BasePage {

    WebDriver driver;

    public void preencherCampoPesquisa(String texto){
        encontrarElementoPorNome("s").sendKeys(texto);
    }

    public void clicarBotaoPesquisa(){
        encontrarElementoPorClasse("lupa-form").click();
    }

    public void clicarBotaoLimpar(){
        encontrarElementoPorClasse("limpar-busca").click();
    }

    public void acessarFAP() {
        encontrarElementoPorClasse("mostra-submenu").click();
        encontrarElementoPorXPath("//*[@id=\"navegacao-superior\"]/ul/li[3]/div/div[2]/ul/li[4]/a/abbr").click();
    }
}
