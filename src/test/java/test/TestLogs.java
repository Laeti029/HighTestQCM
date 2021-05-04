package test;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ChoiceQcmPage;
import pages.EmailPage;
import pages.QcmPage;

public class TestLogs extends BaseTests {

    @Test
    public void testLogs() {
        homePage.clickOnglet();
        ChoiceQcmPage choiceQcmPage = homePage.clickOnglet();
        QcmPage qcmPage = choiceQcmPage.selectIstqbFoundation();
        qcmPage.responsesQcm();
        EmailPage emailPage = qcmPage.clickFormValidation();
    }
}
