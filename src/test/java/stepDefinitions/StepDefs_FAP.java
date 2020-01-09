package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BlogPage;
import pages.FAPPage;
import pages.FAPResultPage;
import utilities.DriverFactory;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class StepDefs_FAP {

    BlogPage bpage;
    FAPPage fpage;
    FAPResultPage frpage;
    WebDriverWait wait;


    @Given("Que eu esteja no site do SOC")
    public void que_eu_esteja_no_site_do_SOC() {
        bpage = new BlogPage();
        fpage = new FAPPage();
        frpage = new FAPResultPage();
        wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        DriverFactory.getDriver().get("https://ww2.soc.com.br/blog/");
    }

    @When("eu acessar a tela do FAP")
    public void eu_acessar_a_tela_do_FAP() {
        bpage.acessarFAP();
    }

    @And("Preencher os campos necessarios")
    public void preencher_os_campos_necessarios() {
        fpage.preencherCampoNomeDaEmpresa("Empresa TA");
        fpage.preencherCampoFAP(10.10);
        DriverFactory.getDriver().findElement(By.className("selectric")).click();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        fpage.preencherCampoRAT(1);
        fpage.preencherCampoProjecaoDeMassaSalarial(1000.0);
    }

    @Then("Eu clico no botao Simular FAP e recebo as informacoes")
    public void eu_clico_no_botao_Simular_FAP_e_recebo_as_informacoes() {
        fpage.clicarNoBotaoEstimarFAP();
        Assert.assertEquals(true, frpage.ValidarEstimouFap());
    }

    @When("Preecher os campos exceto FAP")
    public void preecher_os_campos_exceto_FAP() {
        fpage.preencherCampoNomeDaEmpresa("Empresa TA");
//        fpage.preencherCampoFAP(10.10);
        DriverFactory.getDriver().findElement(By.className("selectric")).click();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        fpage.preencherCampoRAT(1);
        fpage.preencherCampoProjecaoDeMassaSalarial(1000.0);
    }

    @Then("Eu clico no botao Simular FAP e recebo uma mensagem avisando que o campo FAP é obrigatorio")
    public void eu_clico_no_botao_Simular_FAP_e_recebo_uma_mensagem_avisando_que_o_campo_FAP_é_obrigatorio() {
        fpage.clicarNoBotaoEstimarFAP();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page\"]/div/div/div/div[2]/p")));
        Assert.assertEquals("POR FAVOR, INFORME O FAP", DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"page\"]/div/div/div/div[2]/p")).getText());
    }

    @When("Preecher os campos exceto RAT")
    public void preecher_os_campos_exceto_RAT() {
        fpage.preencherCampoNomeDaEmpresa("Empresa TA");
        fpage.preencherCampoFAP(10.10);
//        DriverFactory.getDriver().findElement(By.className("selectric")).click();
//        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        fpage.preencherCampoRAT(1);
        fpage.preencherCampoProjecaoDeMassaSalarial(1000.0);
    }

    @Then("Eu clico no botao Simular FAP e recebo uma mensagem avisando que o campo RAT é obrigatorio")
    public void eu_clico_no_botao_Simular_FAP_e_recebo_uma_mensagem_avisando_que_o_campo_RAT_é_obrigatorio() {
        fpage.clicarNoBotaoEstimarFAP();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page\"]/div/div/div/div[2]/p")));
        Assert.assertEquals("POR FAVOR, INFORME O RAT", DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"page\"]/div/div/div/div[2]/p")).getText());
    }

    @When("Preecher os campos exceto Projecao de Massa Salarial")
    public void preecher_os_campos_exceto_Projecao_de_Massa_Salarial() {
        fpage.preencherCampoNomeDaEmpresa("Empresa TA");
        fpage.preencherCampoFAP(10.10);
        DriverFactory.getDriver().findElement(By.className("selectric")).click();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        fpage.preencherCampoRAT(1);
//        fpage.preencherCampoProjecaoDeMassaSalarial(1000.0);
    }

    @Then("Eu clico no botao Simular FAP e recebo uma mensagem avisando que o campo Projecao de Massa Salarial é obrigatorio")
    public void eu_clico_no_botao_Simular_FAP_e_recebo_uma_mensagem_avisando_que_o_campo_Projecao_de_Massa_Salarial_é_obrigatorio() {
        fpage.clicarNoBotaoEstimarFAP();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page\"]/div/div/div/div[2]/p")));
        Assert.assertEquals("POR FAVOR, INFORME O PROJEÇÃO DE MASSA SALARIAL", DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"page\"]/div/div/div/div[2]/p")).getText());
    }

    @Then("Eu clico no botao Limpar Formulario e os Campos devem ficar vazios")
    public void Eu_clico_no_botao_Limpar_Formulario_e_os_Campos_devem_ficar_vazios(){
        fpage.preencherCampoNomeDaEmpresa("Empresa TA");
        fpage.preencherCampoFAP(10.10);
        DriverFactory.getDriver().findElement(By.className("selectric")).click();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        fpage.preencherCampoRAT(1);
        fpage.preencherCampoProjecaoDeMassaSalarial(1000.0);
        fpage.clicarNoBotaoLimparFormulario();
        Assert.assertEquals("", DriverFactory.getDriver().findElement(By.name("nomeEmpresa")).getText());
        Assert.assertEquals("", DriverFactory.getDriver().findElement(By.name("fap")).getText());

    }
}

