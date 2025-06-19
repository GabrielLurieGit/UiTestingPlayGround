package pages;

import enums.HomePageMenuItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public <T extends BasePage> T chooseHomePageMenuItem(HomePageMenuItem homePageMenuItem) {

        WebElement element = driver.findElement(
                By.xpath("//a[text()='" + homePageMenuItem.getLocator() + "']"));
        element.click();
        switch (homePageMenuItem) {
            case DYNAMIC_ID -> {
                return (T) new DynamicIDPage(driver);
            }
            case LOAD_DELAY -> {
                return (T) new LoadDelayPage(driver);
            }
            case HIDDEN_LAYERS -> {
                return (T) new HiddenLayersPage(driver);
            }
            case CLASS_ATTRIBUTE -> {
                return (T) new ClassAttributePage(driver);
            }
            default -> throw new IllegalArgumentException("wrong parameter");
        }
    }


    public void pause(int time) {
        try {
            Thread.sleep(time / 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWait(WebElement element){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }catch (RuntimeException e){
            System.out.println("something went wrong, exception!");
        }
    }
}
