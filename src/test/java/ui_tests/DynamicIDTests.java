package ui_tests;

import enums.HomePageMenuItem;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicIDPage;
import pages.HomePage;

public class DynamicIDTests extends AppManager {
    @Test
    public void dynamicIdBtnTest(){
        DynamicIDPage page = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.DYNAMIC_ID);
       Assert.assertFalse(page.clickAndValidateBtnDynamicID());
    }

    @Test
    public void dynamicIdChangesTest(){
        DynamicIDPage page = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.DYNAMIC_ID);
       Assert.assertFalse(page.validateIdBtn());
    }

}
