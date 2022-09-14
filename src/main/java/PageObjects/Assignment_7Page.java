package PageObjects;

import org.openqa.selenium.By;

public class Assignment_7Page extends BasePage{
    public By firstName = new By.ByCssSelector("#firstname");
    public By lastName = new By.ByCssSelector("#lastname");
    public By userName = new By.ByCssSelector("#userName");
    public By password = new By.ByCssSelector("#password");
    public By captcha = new By.ByCssSelector(".recaptcha-checkbox-border");
    public By regButton = new By.ByCssSelector("#register");
    public By loginButton = new By.ByCssSelector("#login");
    public By bookStore = new By.ByXPath("//span[text() = 'Book Store']");
    public By addToCollection = new By.ByCssSelector(".text-right #addNewRecordButton");
    public By lastBook = new By.ByCssSelector(".mr-2");
    public String regUrl = "https://demoqa.com/register";
    public String loginUrl = "https://demoqa.com/login";
}
