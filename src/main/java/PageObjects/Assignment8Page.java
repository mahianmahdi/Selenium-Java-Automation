package PageObjects;

import org.openqa.selenium.By;

public class Assignment8Page {
    public By applyBtn = new By.ByXPath("//a[contains(@id,'home_4060812')]");
    public By fName = new By.ByCssSelector("#customerFirstName");
    public By lastname = new By.ByCssSelector("#customerLastName");
    public By address = new By.ByCssSelector("#customerResidentialAddressOne");
    public By city = new By.ByCssSelector("#customerAddressCity");
    public By state = new By.ByCssSelector("#customerAddressState option");
    public By zip = new By.ByCssSelector("#customerAddressInput");
    public By phoneNumber = new By.ByCssSelector("#customerPrimaryPhoneNumber");
    public By mobRadio = new By.ByXPath("//label[contains(@for,'Mobile')]");
    public By email = new By.ByCssSelector("#customerEmailAddress");
    public By saveAndCont = new By.ByCssSelector("#icaiContinueButton");
    public By radioCitizen = new By.ByCssSelector("#customerUsCitizenYes");
    public By ssn = new By.ByCssSelector("#customerSocialSecurityNumber");
    public By radioDualCitizen = new By.ByCssSelector("#customerDualCitizenshipNo");
    public By countryOfResidence = new By.ByCssSelector("#customerCountryOfResidence");
    public By dob = new By.ByCssSelector("#customerBirthDate");


    public By employmentStatus = new By.ByCssSelector("#employmentStatus");
    public By annualIncome = new By.ByCssSelector("#annualSalary");
    public By incomeSource = new By.ByCssSelector("#incomeSource");
    public By monthlyCost = new By.ByCssSelector("#monthlyHousingPayment");


    public By checkboxTerms = new By.ByCssSelector("#termsAndConditionsCheckBox");



    public By header = new By.ByCssSelector(".section-heading");
    public String pageUrl = "https://www.bankofamerica.com/credit-cards/#filter";

}
