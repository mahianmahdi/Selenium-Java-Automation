package DemoQARadio;

import PageObjects.RadioButtonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

public class DemoQaRadioPage extends RadioButtonPage {
    static WebDriver driver;


    @BeforeClass
    void setup() {
        DriverUtils.setChromePath();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector("div div:nth-child(3)")));
        driver.findElement(By.cssSelector("div div:nth-child(3)")).click();

    }

    @Test (priority = 1)
    void clickRadioButton() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class='element-list collapse show'] li[id='item-2']")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    void wrapUp() throws InterruptedException {

        Thread.sleep(10000);
        driver.quit();
    }
}
