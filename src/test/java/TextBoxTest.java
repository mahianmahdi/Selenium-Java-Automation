import PageObjects.BasePage;
import PageObjects.TextBoxPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

public class TextBoxTest {
    WebDriver driver;
    TextBoxPage textBoxPage;

    @BeforeClass
    void setUp() {
        DriverUtils.setChromePath();
        driver = new ChromeDriver(DriverUtils.enableChromeIncognito());
        DriverUtils.setTimeout(driver, 5000);
        driver.manage().window().maximize();
        textBoxPage = new TextBoxPage();
        driver.get(textBoxPage.pageUrl);
    }

    @Test
    void testTitle(){
        Assert.assertEquals(driver.getTitle(),"ToolsQA");
    }

    @Test
    void logoVisibilityVerification(){
        //Assert.assertTrue(textBoxPage.logo;

    }
}
