import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;
import java.time.Duration;

public class DynamicWaitTest {
    static WebDriver driver;


    @BeforeClass
    void setUp(){
        DriverUtils.setChromePath();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();

    }

    @Test  (priority = 1)
    void testExample1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.cssSelector(".example a[href='/dynamic_loading/1'")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".example button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("div #finish")));
        WebElement helloWorld = driver.findElement(By.cssSelector("div #finish"));
        Assert.assertTrue(helloWorld.getText().contains("Hello World!"));
    }

    @Test (priority = 2)
    void testExample2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.cssSelector(".example a[href='/dynamic_loading/2")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".example button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("div #finish")));
        WebElement helloWorld = driver.findElement(By.cssSelector("div #finish"));
        Assert.assertTrue(helloWorld.getText().contains("Hello World!"));

    }

    @AfterClass
    void wrapUp() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }

}
