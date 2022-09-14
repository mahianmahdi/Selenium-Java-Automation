import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

public class SelectableListTest {
    static WebDriver driver;


    @BeforeClass
    void setUp() {
        DriverUtils.setChromePath();
        driver = WebDriverManager.chromedriver().create();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/selectable");
    }

    @Test
    void testAsignLIst (){
        testList(".mt-2:nth-child(1)");
        testList(".mt-2:nth-child(2)");
        testList(".mt-2:nth-child(3)");
        testList(".mt-2:nth-child(4)");
    }

    void testList(String cssSelector){
        WebElement list = driver.findElement(By.cssSelector(cssSelector));
        list.click();
        Assert.assertTrue(list.getAttribute("class").contains("active"));
        list.click();
        Assert.assertFalse(list.getAttribute("class").contains("active"));
    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();

    }
}
