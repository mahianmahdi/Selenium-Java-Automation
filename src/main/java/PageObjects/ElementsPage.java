package PageObjects;

import org.openqa.selenium.By;

public class ElementsPage extends BasePage{

    public By textBox_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(1)");
    public By checkbox_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(2)");
    public By radioBtn_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(3)");
    public By webTables_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(4)");
    public By buttons_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(5)");
    public By links_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(6)");
    public By brokenLinkImages = new By.ByCssSelector(".element-group:first-child li:nth-child(7)");
    public By uploadAndDownload = new By.ByCssSelector(".element-group:first-child li:nth-child(8)");
    public By dynamicProperties = new By.ByCssSelector(".element-group:first-child li:nth-child(9)");
    public static String pageUrl = "https://demoqa.com/elements";

}
