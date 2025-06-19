package ui_tests;

import enums.HomePageMenuItem;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoadDelayPage;

public class LoadDelayTests extends AppManager {
    @Test
    public void loadDelayTest(){
        LoadDelayPage loadDelayPage = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.LOAD_DELAY);
        loadDelayPage.clickBtnAfterDelay();
        Assert.assertTrue(loadDelayPage.validateUrl());
    }
}
