package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverFactory;

public class BasePage {

    WebDriver driver;

    public BasePage() {
        driver = DriverFactory.getDriver();
    }

    public WebElement encontrarElementoPorClasse(String classe) {
        return driver.findElement(By.className(classe));
    }

    public WebElement encontrarElementoPorXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement encontrarElementoPorNome(String nome){
        return driver.findElement(By.name(nome));
    }

}
