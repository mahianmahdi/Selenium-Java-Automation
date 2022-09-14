
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

import java.util.Locale;

public class DemoqaHomePage {
    static WebDriver driver;

    @BeforeClass
     void setup(){
        DriverUtils.setChromePath();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test (priority = 1)
     void testTitle(){
        Assert.assertEquals(driver.getTitle(),"ToolsQA");

    }

    @Test (priority = 2)
    void logoVisibilityVarification(){
        WebElement logo = driver.findElement(By.cssSelector("header img"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test (priority = 3)
    void footerValidation(){
        WebElement footer = driver.findElement(By.cssSelector("footer span"));
        String footerText = footer.getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("TOOLSQA.COM"));
    }

    @Test (priority = 4)
    void fakeUse() throws InterruptedException {
        Faker faker = new Faker(new Locale("en-US"));
        WebElement userName = driver.findElement(By.cssSelector("#userName"));
        userName.sendKeys(faker.name().fullName());

        WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
        String email = faker.name().username() + faker.number().randomDigit() + "@gmail.com";
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);

        WebElement currentAddress = driver.findElement(By.cssSelector("#currentAddress"));
        String address = faker.address().fullAddress();
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(address);

        WebElement permanentAddress = driver.findElement(By.cssSelector("#permanentAddress"));
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(address);

    }

    @Test (priority = 5)
    void submitButton (){

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        String textCheck = driver.findElement(By.cssSelector("#output > div")).getText();
        Assert.assertFalse(textCheck.isEmpty());
        Assert.assertTrue(textCheck.contains("Name"));
    }

    @AfterClass
     void wrapUp() throws InterruptedException {

        Thread.sleep(10000);
        driver.quit();
    }


}
