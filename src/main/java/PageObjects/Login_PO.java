package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_PO {

    WebDriver driver;

    public void setUsername(String username){
        driver.findElement(By.cssSelector("#userName")).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(By.cssSelector("#login")).click();
    }

    public Login_PO(WebDriver driver){
        this.driver = driver;
    }
}
