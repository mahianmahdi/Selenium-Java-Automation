package PageObjects;

import org.openqa.selenium.By;

public class Widget_ToolTipPage extends BasePage{
    public String pageUrl = "https://demoqa.com/tool-tips";
    public By hoverOverButton = new By.ByCssSelector("#toolTipButton");
    public By toolTip = new By.ByCssSelector(".tooltip-inner");
    public By textBoxField = new By.ByCssSelector("#toolTipTextField");

    public By contraryField = new By.ByXPath("//a[text()='Contrary']");

    public By mainHeader = new By.ByCssSelector(".main-header");
    public By lastToolTip = new By.ByXPath("//a[text()='1.10.32']");
}
