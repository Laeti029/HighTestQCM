package test;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ChoiceQcmPage;
import pages.EmailPage;
import pages.QcmPage;
import pages.ResultsPage;

public class QcmTests extends BaseTests {

    @Test
    public void qcmTests() {
        homePage.clickTab();
        ChoiceQcmPage choiceQcmPage = homePage.clickTab();
        QcmPage qcmPage = choiceQcmPage.selectIstqbFoundation();
        qcmPage.responsesQcm();
        EmailPage emailPage = qcmPage.clickFormValidation();
        ResultsPage resultsPage = emailPage.sendByEmail();
        resultsPage.verifyPicture();
    }
}
