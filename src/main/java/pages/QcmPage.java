package pages;

import org.openqa.selenium.*;
import utils.AbstractPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QcmPage extends AbstractPage {
    private final WebDriver driver;

    private final Selecteur BTN_VALIDATION = new Selecteur("Bouton de validation du QCM", By.xpath("(//input[@id='submit'])"));
    private final Selecteur NBR_QUESTIONS = new Selecteur("Récupère les questions du QCM", By.xpath("(//p//b)"));

    public QcmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

   public void responsesQcm() {
       ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
       driver.switchTo().window(tabs2.get(1));

       List<WebElement> questions = findList(NBR_QUESTIONS);
       int nbrQuestions = questions.size();
       List<Integer> responses = Arrays.asList(1, 2, 1, 2, 2, 3, 2, 4, 1, 3, 4, 2, 3, 2, 4, 3, 3, 1, 2, 2);

       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       for (int i = 0; i < nbrQuestions; i++) {
           WebElement element = driver.findElement(By.xpath("//input[@name=" + i + " and @value=" + responses.get(i) + "]"));
           ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
           element.click();
       }
    }

    public EmailPage clickFormValidation() {
        clickElement(BTN_VALIDATION);
        return new EmailPage(driver);
    }

}
