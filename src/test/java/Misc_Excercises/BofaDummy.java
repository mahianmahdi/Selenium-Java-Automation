package Misc_Excercises;

import PageObjects.Assignment_7Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

import java.time.Duration;

public class BofaDummy {
    WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {
        DriverUtils.setChromePath();
        //driver = DriverUtils.getWebDriver();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();
        driver.get("https://www.bankofamerica.com/credit-cards/#filter");
        //Thread.sleep(1000);
    }

    @Test
    void BOA() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@id,'home_4060812')]")).click();

    }
}
