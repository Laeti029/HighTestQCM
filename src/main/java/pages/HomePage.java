package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbstractPage;

public class HomePage extends AbstractPage {
    private final WebDriver driver;

    private final Selecteur BTN_TAB_TOOLBOX = new Selecteur("Onglet Toolbox", By.xpath("(//a[contains(@href, '/boite-outils')])"));

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ChoiceQcmPage clickTab() {
        clickElement(BTN_TAB_TOOLBOX);
        return new ChoiceQcmPage(driver);
    }
}
