package PageObjects;

import org.openqa.selenium.By;

public class TextBoxPage extends ElementsPage{
    public By fullName = new By.ByCssSelector("#userName");
    public By email= new By.ByCssSelector("#userEmail");
    public By currentAddress = new By.ByCssSelector("#currentAddress");
    public By permanentAddress = new By.ByCssSelector("#permanentAddress");
    public By submitBtn = new By.ByCssSelector("#submit");
    public String pageUrl = "https://demoqa.com/text-box";
}
