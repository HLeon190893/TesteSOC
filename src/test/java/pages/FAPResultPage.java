package pages;

public class FAPResultPage extends BasePage {

    public boolean ValidarEstimouFap() {
        return encontrarElementoPorXPath("//*[@id=\"page\"]/section/div/header/h1").isDisplayed();
    }
}
