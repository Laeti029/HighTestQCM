package utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;

import static java.lang.Thread.sleep;

public class AbstractTest {

    private WebDriver driver;

    protected int timeOut = 5;

    public AbstractTest(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By by) {
        //logger.info("Clic sur l'élément '" + getPathFromBy(by) + "'");
        assertElementPresent(by);
        driver.findElement(by).click();
    }

    protected String getPathFromBy(By by){
        return by.toString().split(": ")[1];
    }

    public void assertElementPresent(By by) {
        if(!isElementPresent(by)){
            //logger.error("ERREUR : '" + getPathFromBy(by) + "' n'a pas été trouvé(e) sur la page.", Exception ex);
        }
        Assert.assertTrue(isElementPresent(by));
    }

    public boolean isElementPresent(By by) {
        boolean isElementPresent = false;
        int time = 0;
        while (!isElementPresent && time < timeOut) {
            isElementPresent = isElementPresentNow(by);
        }
        return isElementPresent;
    }

    public boolean isElementPresentNow(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean isElementPresent = (driver.findElements(by).size() != 0);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.MILLISECONDS);
        return isElementPresent;
    }

    public static int findIndex(int arr[], int t)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);

        return list.indexOf(t);
    }

}
