package br.upf.ConstruContract;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteSistema {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        try {
            login(driver);
            cadastrarContrato(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

    private static void login(WebDriver driver) {
        driver.navigate().to("http://localhost:3000/");

        WebElement botaoLogin = driver.findElement(By.cssSelector("[type^='Button']"));
        botaoLogin.click();

        WebElement input = driver.findElement(By.id("email"));
        input.sendKeys("teste4");
        WebElement input2 = driver.findElement(By.id("senha"));
        input2.sendKeys("Teste3");

        botaoLogin = driver.findElement(By.cssSelector("[type^='Button']"));
        botaoLogin.click();

    }

    private static void cadastrarContrato(WebDriver driver) {
        WebElement contratos = driver.findElement(By.id("Contratos"));
        contratos.click();

        WebElement cadastrar = driver.findElement(By.id("cadastrar"));
        cadastrar.click();

        WebElement selContratante = driver.findElement(By.id("contratanteselect"));
        selContratante.click();

        WebElement optionContratante = driver.findElement(By.cssSelector("[aria-labelledby='contratante']"));
        optionContratante.findElement(By.cssSelector("[role='option']")).click();

        WebElement selVend = driver.findElement(By.id("vendedorselect"));
        selVend.click();

        WebElement optionVend = driver.findElement(By.cssSelector("[aria-labelledby='vendedor']"));
        optionVend.findElement(By.cssSelector("[role='option']")).click();

        WebElement addProjeto = driver.findElement(By.id("addProjeto"));
        addProjeto.click();

        WebElement selProj = driver.findElement(By.id("projeto0select"));
        selProj.click();

        WebElement optionProj = driver.findElement(By.cssSelector("[aria-labelledby='projeto0']"));
        optionProj.findElement(By.cssSelector("[role='option']")).click();

        WebElement salvar = driver.findElement(By.id("salvar"));
        salvar.click();

    }

}
