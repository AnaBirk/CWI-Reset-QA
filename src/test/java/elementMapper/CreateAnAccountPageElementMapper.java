package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPageElementMapper {

    @FindBy(className = "page-subheading")
    public WebElement pageSubHeading;

    //YOUR PERSONAL INFORMATION

    @FindBy(id="id_gender1")
    public WebElement mrTitle;

    @FindBy(name="customer_firstname")
    public WebElement fristName;

    @FindBy(id="customer_lastname")
    public WebElement lastName;

    @FindBy(name="email")
    public WebElement email;

    @FindBy(id="passwd")
    public WebElement password;

    @FindBy(name="days")
    public WebElement birthDay;

    @FindBy(xpath = "//*[@id=\"days\"]/option[32]")
    public WebElement selectedBirthDay;

    @FindBy (name="months")
    public WebElement birthMonth;

    @FindBy (xpath = "//*[@id=\"months\"]/option[6]")
    public WebElement selectedBirthMonth;

    @FindBy(name="years")
    public WebElement birthYear;

    @FindBy(xpath = "//*[@id=\"years\"]/option[25]")
    public WebElement getSelectedBirthYear;

    @FindBy(id="newsletter")
    public WebElement newsletter;

    @FindBy(id="optin")
    public WebElement SpecialOffers;

    @FindBy(id="firstname")
    public WebElement fristNameAddress;

    @FindBy(id="lastname")
    public WebElement lastNameAddress;

    @FindBy(id="company")
    public WebElement company;

    @FindBy(id="address1")
    public WebElement address;

    @FindBy(id="address2")
    public WebElement addressLine2;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="id_country")
    public WebElement country;

    @FindBy(xpath = "//*[@id=\"id_country\"]/option[2]")
    public WebElement countrySelect;

    @FindBy(id="id_state")
    public WebElement state;

    @FindBy(xpath = "//*[@id=\"id_state\"]/option[34]")
    public WebElement stateSelect;

    @FindBy(name="postcode")
    public WebElement postalCode;

    @FindBy(id="other")
    public WebElement additionalInformation;

    @FindBy(id="phone")
    public WebElement homePhone;

    @FindBy(id="phone_mobile")
    public WebElement mobilePhone;

    @FindBy(id="submitAccount")
    public WebElement btnRegister;




















}
