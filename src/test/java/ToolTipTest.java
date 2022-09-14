import PageObjects.Widget_ToolTipPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;
import java.time.Duration;

public class ToolTipTest {
    WebDriver driver;
    Widget_ToolTipPage toolTipPage;

    @BeforeClass
    void setUp() throws InterruptedException {
        DriverUtils.setChromePath();
        driver = DriverUtils.getWebDriver();
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();
        toolTipPage = new Widget_ToolTipPage();
        driver.get(toolTipPage.pageUrl);
    }

    @Test(priority = 1)
    void testTooltip() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(toolTipPage.hoverOverButton));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipPage.toolTip));

        Assert.assertEquals(element.getText(),"You hovered over the Button");

        driver.findElement(By.cssSelector(".main-header")).click();
    }

    @Test(priority = 2)
    void testToolTipText() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(toolTipPage.textBoxField));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipPage.toolTip));

        Assert.assertEquals(element.getText(),"You hovered over the text field");
        driver.findElement(By.cssSelector(".main-header")).click();
    }

    @Test(priority = 3)
    void contraryToolTip() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(toolTipPage.contraryField));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipPage.toolTip));

        Assert.assertEquals(element.getText(),"You hovered over the Contrary");
        driver.findElement(By.cssSelector(".main-header")).click();
    }

    @Test(priority = 4)
    void lastToolTip() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(toolTipPage.lastToolTip));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(toolTipPage.toolTip));

        Assert.assertEquals(element.getText(),"You hovered over the 1.10.32");

    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
