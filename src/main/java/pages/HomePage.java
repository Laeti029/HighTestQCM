package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbstractTest;

public class HomePage extends AbstractTest {

    private WebDriver driver;

    private final By BTN_ONGLET_TOOLBOX = By.xpath("(//a[contains(@href, '/boite-outils')])");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ChoiceQcmPage clickOnglet() {
        clickElement(BTN_ONGLET_TOOLBOX);
        return new ChoiceQcmPage(driver);
    }
}
