package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.AbstractPage;

public class ResultsPage extends AbstractPage {
    private final WebDriver driver;

    private final Selecteur PICTURE_TESTEUM = new Selecteur("Bouton de validation du QCM", By.xpath("(//img[contains(@src, 'logo-testeum.png')])"));

    public ResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyPicture() {
        Assert.assertTrue(isElementPresent(PICTURE_TESTEUM));
    }

}
