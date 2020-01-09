package pages;

import org.openqa.selenium.support.ui.Select;

public class FAPPage extends BasePage {
    public void preencherCampoNomeDaEmpresa(String nome) {
        encontrarElementoPorNome("nomeEmpresa").sendKeys(nome);
    }

    public void preencherCampoFAP(Double valor) {
        String aux = valor.toString();
        encontrarElementoPorNome("fap").sendKeys(aux);
    }

    public void preencherCampoRAT(Integer opt){
         switch (opt){
             case 1:
                 encontrarElementoPorXPath("//*[@id=\"frmcalculadora\"]/div[2]/div[3]/span/div/div[3]/div/ul/li[2]").click();
                 break;
             case 2:
                 encontrarElementoPorXPath("//*[@id=\"frmcalculadora\"]/div[2]/div[3]/span/div/div[3]/div/ul/li[3]").click();
                 break;
             case 3:
                 encontrarElementoPorXPath("//*[@id=\"frmcalculadora\"]/div[2]/div[3]/span/div/div[3]/div/ul/li[4]").click();
                 break;
         }
    }

    public void preencherCampoProjecaoDeMassaSalarial(Double valor) {
        String aux = valor.toString();
        encontrarElementoPorNome("projecao").sendKeys(aux);
    }

    public void clicarNoBotaoEstimarFAP(){
        encontrarElementoPorXPath("//*[@id=\"estimar\"]").click();
    }

    public void clicarNoBotaoLimparFormulario(){
        encontrarElementoPorXPath("//*[@id=\"frmcalculadora\"]/div[2]/div[5]/a").click();
    }
}
