package ui_tests;

import enums.HomePageMenuItem;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AjaxDataPage;
import pages.HomePage;

public class AjaxDataTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void ajaxDataSpinnerTest(){
        AjaxDataPage ajaxDataPage = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.AJAX_DATA);
        ajaxDataPage.clickAjaxBtnTrigger();
       softAssert.assertTrue(ajaxDataPage.validateLoadingSpinner());
       softAssert.assertTrue(ajaxDataPage.validateAttributeContains());
       softAssert.assertAll();
    }

    @Test
    public void ajaxDataLabelTest(){
        AjaxDataPage ajaxDataPage = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.AJAX_DATA);
        ajaxDataPage.clickAjaxBtnTrigger();
       Assert.assertTrue(ajaxDataPage.validateLabelText());
    }


}
