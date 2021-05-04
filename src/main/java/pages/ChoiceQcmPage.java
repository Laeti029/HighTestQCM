package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbstractTest;

public class ChoiceQcmPage extends AbstractTest {

    private WebDriver driver;
    private final By BTN_ISTQB_FOUNDATION = By.xpath("(//a[contains(@href, 'http://www.hightest.nc/ressources/test-istqb.php')])");

    public ChoiceQcmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public QcmPage selectIstqbFoundation() {
        clickElement(BTN_ISTQB_FOUNDATION);
        return new QcmPage(driver);
    }


}
