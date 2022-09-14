import PageObjects.Assignment8Page;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DriverUtils;
import utils.ExcelUtils;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Assignment_8_Bofa {
    WebDriver driver;
    Assignment8Page asgmnt8Page;
    static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + "/resources/test_data/Mock_Data.xlsx";

    @BeforeMethod
    void setUp() throws InterruptedException {
        DriverUtils.setChromePath();
        asgmnt8Page = new Assignment8Page();
        driver = DriverUtils.getWebDriver();
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get(asgmnt8Page.pageUrl);
        Thread.sleep(3000);
    }
    @DataProvider(name = "loadFormData")
    public static Object[][] dataLoad() throws Exception {
        return ExcelUtils.getTableArray(EXCEL_FILE_PATH, "Small Data Set");
    }

    @Test(dataProvider = "loadFormData")
    void creditCardForm(double id, String fName, String lName, String gender, String dob, String ssn, String phone, String email) throws Exception {

        driver.findElement(asgmnt8Page.applyBtn).click();
        DriverUtils.scroll(driver, asgmnt8Page.fName);
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.fName).sendKeys(fName);
        driver.findElement(asgmnt8Page.lastname).sendKeys(lName);
        Faker f = new Faker(new Locale("en-US"));
        driver.findElement(asgmnt8Page.address).sendKeys(f.address().streetAddress());
        driver.findElement(asgmnt8Page.city).sendKeys(f.address().city());
        List<WebElement> states = driver.findElements(asgmnt8Page.state);
        Random rnd = new Random();
        int i = rnd.nextInt(states.size()-11);
        //getting the value of Attribute to get state abbreviation in order to match the zipcode with the selected state
        String state = states.get(i).getAttribute("value");
        states.get(i).click();
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.zip).sendKeys(f.address().zipCodeByState(state));
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.phoneNumber).sendKeys(phone);
        DriverUtils.setTimeout(driver, 10000);
        DriverUtils.scrollToElementAndClick(driver,asgmnt8Page.mobRadio);
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.email).sendKeys(email);
        driver.findElement(asgmnt8Page.saveAndCont).click();

        DriverUtils.scrollToElementAndClick(driver, asgmnt8Page.radioCitizen);
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.ssn).sendKeys(ssn);
        DriverUtils.scrollToElementAndClick(driver, asgmnt8Page.radioDualCitizen);
        driver.findElement(asgmnt8Page.countryOfResidence).sendKeys("United States");
        Thread.sleep(2000);
        driver.findElement(asgmnt8Page.dob).sendKeys(dob);
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.saveAndCont).click();

        driver.findElement(asgmnt8Page.employmentStatus).sendKeys("Unemployed");
        driver.findElement(asgmnt8Page.annualIncome).sendKeys("25000");
        driver.findElement(asgmnt8Page.incomeSource).sendKeys("Unemployed / Other Income");
        driver.findElement(asgmnt8Page.monthlyCost).sendKeys("1000");
        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.saveAndCont).click();

        DriverUtils.setTimeout(driver, 10000);
        driver.findElement(asgmnt8Page.checkboxTerms).click();
        driver.findElement(asgmnt8Page.saveAndCont).click();

        Assert.assertTrue(driver.findElement(asgmnt8Page.header).getText().contains("Review your information"));
        DriverUtils.setTimeout(driver, 10000);

    }
    @AfterMethod
    void wrapUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
