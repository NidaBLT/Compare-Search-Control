//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePageTest {
    WebDriver driver;
    String driverType = "chrome";

    public BasePageTest() {
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(new String[]{"--incognito"});
        chromeOptions.addArguments(new String[]{"--disable-site-isolation-trials"});
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {

        this.driver.quit();
    }
}
