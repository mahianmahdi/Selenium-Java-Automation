import PageObjects.Assignment_7Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Assignment_7 {
        WebDriver driver;
        Assignment_7Page asgmtPage;

    @BeforeClass
    void setUp() throws InterruptedException {
        DriverUtils.setChromePath();
        asgmtPage = new Assignment_7Page();
        //driver = DriverUtils.getWebDriver();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();
        //DriverUtils.zoomOutToPercentage(driver, 50);
        driver.get(asgmtPage.regUrl);
        Thread.sleep(10000);
    }

    @Test (priority = 1)
    void testRegister() throws InterruptedException {
        driver.findElement(asgmtPage.regButton).click();
        WebElement border1 = driver.findElement(asgmtPage.firstName);
        Assert.assertTrue(border1.getAttribute("class").contains("is-invalid"));
        driver.findElement(asgmtPage.regButton).click();
        WebElement border2 = driver.findElement(asgmtPage.lastName);
        Assert.assertTrue(border2.getAttribute("class").contains("is-invalid"));
        driver.findElement(asgmtPage.regButton).click();
        WebElement border3 = driver.findElement(asgmtPage.userName);
        Assert.assertTrue(border3.getAttribute("class").contains("is-invalid"));
        driver.findElement(asgmtPage.regButton).click();
        WebElement border4 = driver.findElement(asgmtPage.password);
        Assert.assertTrue(border4.getAttribute("class").contains("is-invalid"));
    }

    @Test (priority = 2)
    void testRegAndLogin() throws InterruptedException {
        driver.get(asgmtPage.loginUrl);
        Thread.sleep(10000);
        String username = DriverUtils.initializeProperties().getProperty("username");
        String password = DriverUtils.initializeProperties().getProperty("password");
        driver.findElement(asgmtPage.userName).sendKeys(username);
        driver.findElement(asgmtPage.password).sendKeys(password);
        driver.findElement(asgmtPage.loginButton).click();
        Thread.sleep(5000);

        String actualUrl = "https://demoqa.com/profile";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        Thread.sleep(2000);

        DriverUtils.scrollToElementAndClick(driver, asgmtPage.bookStore);

        List<WebElement> books = driver.findElements(By.cssSelector(".mr-2"));
        System.out.println(books.size());
        Random rnd = new Random();
        int i = rnd.nextInt(books.size()-1);

        String randBook = books.get(i).getText();
        books.get(i).click();
        driver.findElement(asgmtPage.addToCollection).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.get("https://demoqa.com/profile");
        System.out.println(randBook);
        Assert.assertTrue(driver.findElement(By.cssSelector(".rt-tbody")).getText().contains(randBook));
        driver.findElement(By.xpath("//button[text() = 'Log out']")).click();

    }
    @Test (priority = 3)
    void extraPointTest() throws InterruptedException {
        driver.get(asgmtPage.loginUrl);
        Thread.sleep(2000);
        String username = DriverUtils.initializeProperties().getProperty("username");
        String password = DriverUtils.initializeProperties().getProperty("password");
        driver.findElement(asgmtPage.userName).sendKeys(username);
        driver.findElement(asgmtPage.password).sendKeys(password);
        driver.findElement(asgmtPage.loginButton).click();
        Thread.sleep(5000);
        DriverUtils.scrollToElementAndClick(driver, asgmtPage.bookStore);
        Thread.sleep(5000);
        List<WebElement> bookList = driver.findElements(asgmtPage.lastBook);
        DriverUtils.scrollToTheEnd(driver);
        String lastBookName = bookList.get(bookList.size()-1).getText();
        bookList.get(bookList.size()-1).click();
        driver.findElement(asgmtPage.addToCollection).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        driver.get("https://demoqa.com/profile");
        Assert.assertTrue(driver.findElement(By.cssSelector(".rt-tbody")).getText().contains(lastBookName));
    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
