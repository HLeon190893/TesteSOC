package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ArtigoPage;
import pages.BlogPage;
import utilities.DriverFactory;

import java.sql.Driver;


public class StepDefs_Busca {

    BlogPage bpage;
    ArtigoPage apage;

    @Before
    public void iniciarDriver(){
        DriverFactory.initDriver();
        bpage = new BlogPage();
        apage = new ArtigoPage();
    }

    @Given("Que eu abra o navegador e o site")
    public void que_eu_abra_o_navegador_e_o_site() {
        DriverFactory.getDriver().get("https://ww2.soc.com.br/blog");
    }

    @When("Eu preencher o campo e pesquisar")
    public void eu_preencher_o_campo_e_pesquisar() {
        bpage.preencherCampoPesquisa("Analista de QA");
        bpage.clicarBotaoPesquisa();
    }

    @Then("Devo ser encaminhado para pagina com o resultado da pesquisa")
    public void devo_ser_encaminhado_para_pagina_com_o_resultado_da_pesquisa() {
        Assert.assertEquals(true, apage.encontrarTituloArtigo());
    }

    @When("Eu preencher o campo com valores nao existentes na base")
    public void eu_preencher_o_campo_com_valores_nao_existentes_na_base() {
        bpage.preencherCampoPesquisa("Lorem Ipsum");
        bpage.clicarBotaoPesquisa();
    }

    @Then("Devo ser encaminhado para pagina dizendo que a busca nao trouxe resultados")
    public void devo_ser_encaminhado_para_pagina_dizendo_que_a_busca_nao_trouxe_resultados() {
        String mensagemErro = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"blog\"]/div/div[2]/div/div/div/p")).getText();
        Assert.assertEquals("Nenhum post encontrado. Tente uma busca diferente", mensagemErro);
    }

    @When("Eu preencher o campo e clicar no botão Limpar")
    public void eu_preencher_o_campo_e_clicar_no_botão_Limpar() {
        bpage.preencherCampoPesquisa("Teste Limpeza de Campo");
        bpage.clicarBotaoLimpar();
    }

    @Then("O campo deve ficar vazio")
    public void o_campo_deve_ficar_vazio() {
        Assert.assertEquals("", DriverFactory.getDriver().findElement(By.name("s")).getText());
    }


    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
