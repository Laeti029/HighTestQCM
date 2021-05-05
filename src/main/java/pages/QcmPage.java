package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.AbstractTest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QcmPage extends AbstractTest {

    private WebDriver driver;
    private final By FIRST_PAGE = By.xpath("(//p[text()='Bienvenue dans ce test blanc ISTQB Foundation.'])");

    private final By BTN_VALIDATION = By.xpath("(//input[@id='submit'])");

    private final By TITLE_PAGE = By.xpath("(//*[text()='Test ISTQB Foundation en ligne'])");

    private final By BTN_ISTQB_FOUNDATION = By.xpath("(//a[contains(@href, 'http://www.hightest.nc/ressources/test-istqb.php')])");


    public QcmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


   public void responsesQcm() {
       ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
       driver.switchTo().window(tabs2.get(1));

       int nbrQuestions = 20;
       List<Integer> responses = Arrays.asList(1, 2, 1, 2, 2, 3, 2, 4, 1, 3, 4, 2, 3, 2, 4, 3, 3, 1, 2, 2);

       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       for (int i = 0; i < nbrQuestions; i++) {
           System.out.println(responses.get(i));

           WebElement element =driver.findElement(By.xpath("//input[@name=" + i + " and @value=" + responses.get(i) + "]"));
           ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
           element.click();
       }
    }


    public EmailPage clickFormValidation() {
        clickElement(BTN_VALIDATION);
        return new EmailPage(driver);
    }

}
