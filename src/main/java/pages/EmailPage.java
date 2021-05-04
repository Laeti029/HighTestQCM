package pages;

import org.openqa.selenium.WebDriver;
import utils.AbstractTest;

public class EmailPage extends AbstractTest{
    private WebDriver driver;

    public EmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

 /*   public String setEmail() {
        return driver.findElemenbt(By.id("contentForm:email")).sendKeys("laetitia.autier@yopmail.com");
    }
  */
}
