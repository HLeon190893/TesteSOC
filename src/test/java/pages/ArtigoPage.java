package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtigoPage extends BasePage {

    WebDriver driver;

    public boolean encontrarTituloArtigo(){
        return encontrarElementoPorXPath("//*[@id=\"post-14473\"]/div/h2/a").isDisplayed();
    }
}
