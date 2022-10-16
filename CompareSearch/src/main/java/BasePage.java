//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement find(By locator) {
        WebDriverWait w = new WebDriverWait(this.driver, Duration.ofMillis(5000));
        w.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
    public void type(By locator, String text) {
        this.find(locator).sendKeys(new CharSequence[]{text});
    }
    public List<WebElement> findAll(By locator) {
        return this.driver.findElements(locator);
    }
    public void click(By locator) {
        this.find(locator).click();
    }
}
