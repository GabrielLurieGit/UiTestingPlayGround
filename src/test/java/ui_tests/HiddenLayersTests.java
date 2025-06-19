package ui_tests;

import enums.HomePageMenuItem;
import manager.AppManager;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HiddenLayersPage;
import pages.HomePage;

public class HiddenLayersTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void hiddenLayersTest(){
        HiddenLayersPage hiddenLayersPage = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.HIDDEN_LAYERS);
        softAssert.assertTrue(hiddenLayersPage.validateBtnCanNotBeHitTwice());
        softAssert.assertTrue(hiddenLayersPage.validateButtonsLayers());
        softAssert.assertAll();
    }
}
