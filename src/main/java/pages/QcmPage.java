package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AbstractTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QcmPage extends AbstractTest {

    private WebDriver driver;
    private final By BTN_VALIDATION = By.xpath("(//a[contains(@href, 'http://www.hightest.nc/ressources/test-istqb.php')])");

    public QcmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

   public void responsesQcm() {
        int nbrQuestions = 20;
        int[] responses = {1, 2, 1, 2, 2, 3, 2, 4, 1, 3, 4, 2, 3, 2, 4, 3, 3, 1, 2, 2};

        System.out.println(Arrays.toString(responses));

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        int Size = radioButtons.size();

/*
        for(WebElement radioButton : radioButtons) {

        }

 */

       for (WebElement radioButton : radioButtons) {
           String val = radioButton.getAttribute("name");
           System.out.println(val);

           int num = Integer.parseInt(val);
           int index = findIndex(responses, num);

           if (index == num) {
           }

            /*
            for(int i=0; i < nbrQuestions; i++){
                driver.findElement(By.tagName("div"));
                driver.findElement(By.)

                Questions.get(i).click;

                driver.findElement(By.name(responses)).click;
            }
            */
       }






       /*
        ArrayList<Integer> values = new ArrayList<>();
        Integer[] array = {1, 2, 1, 2, 2, 3, 2, 4, 1, 3, 4, 2, 3, 2, 4, 3, 3, 1, 2, 2};

        Collections.addAll(values, array);

        for(int value : values) {
            driver.findElement(By.xpath("//input[@value="+value+"]")).click();
        }

        */

    }


    public EmailPage clickFormValidation() {
        clickElement(BTN_VALIDATION);
        return new EmailPage(driver);
    }

}
