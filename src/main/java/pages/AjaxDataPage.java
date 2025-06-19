package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxDataPage extends BasePage{

    public AjaxDataPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }

    @FindBy(id = "ajaxButton")
    WebElement ajaxBtnTrigger;

    @FindBy (id = "spinner")
    WebElement loadingSpinner;
    @FindBy(id = "content")
    WebElement contentLabel;

    public AjaxDataPage clickAjaxBtnTrigger(){
        ajaxBtnTrigger.click();
        return this;
    }

    public boolean validateLoadingSpinner(){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOf(loadingSpinner));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    public boolean validateAttributeContains(){
        return new WebDriverWait(driver,Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeContains(loadingSpinner,"style","display: none;"));
    }

    public boolean validateLabelText(){
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.textToBePresentInElement(
                        contentLabel,"Data loaded with AJAX get request."));
    }

}
