package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbstractPage;

public class EmailPage extends AbstractPage {
    private final WebDriver driver;

    private final Selecteur  INPUT_FOR_MAIL = new Selecteur("L'input pour rentrer son mail afin d'obtenir ses résultats'", By.id("email"));
    private final Selecteur  OK_BUTTON = new Selecteur("Le bouton pour valider l'envoit du résultat au mail indiqué", By.id("submitMail"));

    public EmailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ResultsPage sendByEmail() {
        findAndFill(INPUT_FOR_MAIL, "laetitia.autier@yopmail.com");
        clickElement(OK_BUTTON);
        return new ResultsPage(driver);
    }

}
