package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicIDPage extends BasePage{
    public DynamicIDPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }
    final String selector = "//button[@class='btn btn-primary']";
    @FindBy(xpath = selector)
    WebElement btnDynamicID;

    public boolean clickAndValidateBtnDynamicID(){
      // String selector = "//button[@class='btn btn-primary']";
      btnDynamicID.click();
        return selector.contains("id");
    }

    public boolean validateIdBtn(){
      //  String selector = "//button[@class='btn btn-primary']";
        btnDynamicID.click();
      String idBefore = btnDynamicID.getAttribute("id");
      driver.navigate().refresh();
        String idAfter = btnDynamicID.getAttribute("id");
        return idBefore.equals(idAfter);
    }
}
