package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbstractPage;

public class ChoiceQcmPage extends AbstractPage {
    private final WebDriver driver;

    private final Selecteur  BTN_ISTQB_FOUNDATION = new Selecteur("Le bouton pour ouvrir le test ISTQB Foundation", By.xpath("(//a[contains(@href, 'http://www.hightest.nc/ressources/test-istqb.php')])"));

    public ChoiceQcmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public QcmPage selectIstqbFoundation() {
        clickElement(BTN_ISTQB_FOUNDATION);
        return new QcmPage(driver);
    }

}
