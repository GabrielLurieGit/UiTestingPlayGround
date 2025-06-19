package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HiddenLayersPage extends BasePage{
    public HiddenLayersPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }

    @FindBy(id = "greenButton")
    WebElement greenButton;
    @FindBy(xpath = "//div[contains(@class, 'spa-view') and contains(@style, 'z-index: 1;')]")
    WebElement greenLayer;
    @FindBy(xpath = "//div[contains(@class, 'spa-view') and contains(@style, 'z-index: 2;')]")
    WebElement blueLayer;


    public boolean validateBtnCanNotBeHitTwice(){
        greenButton.click();
        try {
            greenButton.click();
            return false;
        }catch (ElementClickInterceptedException e){
           // System.out.println(e.getMessage());
            return true;
        }
    }

    public boolean validateButtonsLayers(){
       String green = greenLayer.getCssValue("z-index");
        System.out.println(green);
        String blue = blueLayer.getCssValue("z-index");
        System.out.println(blue);
        return Integer.parseInt(green) < Integer.parseInt(blue);
    }
}
