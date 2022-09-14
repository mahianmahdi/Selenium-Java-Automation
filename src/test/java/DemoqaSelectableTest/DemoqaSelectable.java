package DemoqaSelectableTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverUtils;

public class DemoqaSelectable {
    static WebDriver driver;

    @BeforeClass
    void setUp(){
        DriverUtils.setChromePath();
        driver = WebDriverManager.chromedriver().create();
        DriverUtils.setTimeout(driver,10000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/selectable");
        //selectable = ".element-group:nth-child(5) #item-1
        driver.findElement(By.cssSelector("#demo-tab-grid")).click();

    }

    @Test
    void testAsignGrid(){
        testGrid("#row1 li:nth-child(1)");
        testGrid("#row1 li:nth-child(2)");
        testGrid("#row1 li:nth-child(3)");

        testGrid("#row2 li:nth-child(1)");
        testGrid("#row2 li:nth-child(2)");
        testGrid("#row2 li:nth-child(3)");

        testGrid("#row3 li:nth-child(1)");
        testGrid("#row3 li:nth-child(2)");
        testGrid("#row3 li:nth-child(3)");
    }
    void testGrid(String selector){
        WebElement grid = driver.findElement(By.cssSelector(selector));
        grid.click();
        Assert.assertTrue(grid.getAttribute("class").contains("active"));
        grid.click();
        Assert.assertFalse(grid.getAttribute("class").contains("active"));
    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();

    }

}

    /*@Test
    void selectGrid(){
        WebElement gridOne = driver.findElement(By.cssSelector("#row1 li:nth-child(1)"));
        gridOne.click();
        Assert.assertTrue(gridOne.getAttribute("class").contains("active"));
        gridOne.click();
        Assert.assertFalse(gridOne.getAttribute("class").contains("active"));

        WebElement gridTwo = driver.findElement(By.cssSelector("#row1 li:nth-child(2)"));
        gridTwo.click();
        WebElement gridThree = driver.findElement(By.cssSelector("#row1 li:nth-child(3)"));
        gridThree.click();


        WebElement gridFour = driver.findElement(By.cssSelector("#row2 li:nth-child(1)"));
        gridFour.click();
        WebElement gridFive = driver.findElement(By.cssSelector("#row2 li:nth-child(2)"));
        gridFive.click();
        WebElement gridSix = driver.findElement(By.cssSelector("#row2 li:nth-child(3)"));
        gridSix.click();

        WebElement gridSeven = driver.findElement(By.cssSelector("#row3 li:nth-child(1)"));
        gridSeven.click();
        WebElement gridEight = driver.findElement(By.cssSelector("#row3 li:nth-child(2)"));
        gridEight.click();
        WebElement gridNine = driver.findElement(By.cssSelector("#row3 li:nth-child(3)"));
        gridNine.click();
    }*/


