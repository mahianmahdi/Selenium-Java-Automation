package PageObjects;

import org.openqa.selenium.By;

public class RadioButtonPage extends BasePage{
    public By yesRadiBtn = new By.ByXPath("//label[text()='Yes']");
    public By successMessage = new By.ByCssSelector(".text-success");
    public By noRadio = new By.ByXPath("//label[@for='noRadio']");
}
