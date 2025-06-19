package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadDelayPage extends BasePage{
    public LoadDelayPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }

    @FindBy(xpath = "//button[text()='Button Appearing After Delay']")
    WebElement btnAfterDelay;

    public LoadDelayPage clickBtnAfterDelay(){
        clickWait(btnAfterDelay);
         System.out.println(btnAfterDelay.getText());
        return this;
    }

    public boolean validateUrl(){
     return new WebDriverWait(driver, Duration.ofSeconds(10))
             .until(ExpectedConditions.urlContains("loaddelay"));
    }
}
