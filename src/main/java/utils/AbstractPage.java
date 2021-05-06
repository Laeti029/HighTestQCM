package utils;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AbstractPage {
    private final WebDriver driver;
    protected int timeOut = 5;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(Selecteur selecteur) {
        assertElementPresent(selecteur);
        driver.findElement(selecteur.getChemin()).click();
    }

    protected void findAndFill(Selecteur selecteur, String string) {
        driver.findElement(selecteur.getChemin()).sendKeys(string);
    }

    protected List<WebElement> findList(Selecteur selecteur) {
        return driver.findElements(selecteur.getChemin());
    }

    public void assertElementPresent(Selecteur selecteur) {
        isElementPresent(selecteur);
        Assert.assertTrue(isElementPresent(selecteur));
    }

    public boolean isElementPresent(Selecteur selecteur) {
        boolean isElementPresent = false;
        int time = 0;
        while (!isElementPresent && time < timeOut) {
            isElementPresent = isElementPresentNow(selecteur);
        }
        return isElementPresent;
    }

    public boolean isElementPresentNow(Selecteur selecteur) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean isElementPresent = (driver.findElements(selecteur.getChemin()).size() != 0);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.MILLISECONDS);
        return isElementPresent;
    }

    public static class Selecteur {
        public String nom;
        public By chemin;

        public Selecteur(String nom, By chemin){
            this.nom = nom;
            this.chemin = chemin;
        }

        public String getNom(){
            return nom;
        }

        public By getChemin(){
            return chemin;
        }
    }

}
