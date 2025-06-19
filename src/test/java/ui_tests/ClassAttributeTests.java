package ui_tests;

import enums.HomePageMenuItem;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClassAttributePage;
import pages.HomePage;

public class ClassAttributeTests extends AppManager {
    @Test
    public void classAttributeBtnTest(){
        ClassAttributePage classAttributePage = new HomePage(getDriver())
                .chooseHomePageMenuItem(HomePageMenuItem.CLASS_ATTRIBUTE);
      Assert.assertTrue(classAttributePage.validateSuccessAlert());
    }
}
