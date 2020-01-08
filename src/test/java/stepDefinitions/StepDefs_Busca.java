package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class StepDefs_Busca {

    WebDriver driver;

    @Given("Que eu abra o navegador e o site")
    public void que_eu_abra_o_navegador_e_o_site() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ww2.soc.com.br/blog/");
    }

    @When("Eu preencher o campo e pesquisar")
    public void eu_preencher_o_campo_e_pesquisar() {
        driver.findElement(By.name("s")).sendKeys("Analista de QA");
        driver.findElement(By.className("lupa-form")).click();
    }

    @Then("Devo ser encaminhado para pagina com o resultado da pesquisa")
    public void devo_ser_encaminhado_para_pagina_com_o_resultado_da_pesquisa() {
        boolean status = driver.findElement(By.xpath("//*[@id=\"post-14473\"]/div/h2/a")).isDisplayed();
        Assert.assertEquals(true, status);
        driver.quit();
    }

    @When("Eu preencher o campo com valores nao existentes na base")
    public void eu_preencher_o_campo_com_valores_nao_existentes_na_base() {
        driver.findElement(By.name("s")).sendKeys("Lorem Ipsum");
        driver.findElement(By.className("lupa-form")).click();
    }

    @Then("Devo ser encaminhado para pagina dizendo que a busca nao trouxe resultados")
    public void devo_ser_encaminhado_para_pagina_dizendo_que_a_busca_nao_trouxe_resultados() {
        String mensagemErro = driver.findElement(By.xpath("//*[@id=\"blog\"]/div/div[2]/div/div/div/p")).getText();
        Assert.assertEquals("Nenhum post encontrado. Tente uma busca diferente", mensagemErro);
        driver.quit();
    }
}
