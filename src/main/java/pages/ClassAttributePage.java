package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClassAttributePage extends BasePage{
    public ClassAttributePage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }
    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    WebElement dynamicButton;

    public boolean validateSuccessAlert(){
        dynamicButton.click();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        String message = "Primary button pressed";
        String alertCurrentText = alert.getText();
        return alertCurrentText.contains(message);
    }




}
