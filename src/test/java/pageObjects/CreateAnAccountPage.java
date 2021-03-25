package pageObjects;

import elementMapper.CreateAnAccountPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.utils;

public class CreateAnAccountPage extends CreateAnAccountPageElementMapper {
    public CreateAnAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextpageSubHeading(){
        return pageSubHeading.getText();
    }

    //YOUR PERSONAL INFORMATION
    public void fillFristName(){
      fristName.sendKeys("Ana Caroline");
    }

    public void fillLastName(){
        lastName.sendKeys("Birk");
    }

    public void selectMrTitle(){
        mrTitle.click();
    }

    public String getEmailAccountValue(){
       return email.getAttribute("value");
    }

    public void fillPassword(){
        password.sendKeys("cwiresetQA");
    }

    public void dateOfBirth(){
        //Dia
        birthDay.click();
        selectedBirthDay.click();
        //Mês
        birthMonth.click();
        selectedBirthMonth.click();
        //Ano
        birthYear.click();
        getSelectedBirthYear.click();
    }

    public void checkbox(){
        newsletter.click();
        SpecialOffers.click();
    }

    //YOUR ADDRESS

    public String getFirstNameAddressValue(){
        return fristNameAddress.getAttribute("value");
    }

    public String getLastNameAddressValue(){
        return lastNameAddress.getAttribute("value");
    }


    public void fillCompany(){
        company.sendKeys("CWI");
    }

    public void fillAddress(){
        address.sendKeys("lorem ipsum, 321, PO");
        addressLine2.sendKeys("Apartment 1002");
    }

    public void fillCity(){
        city.sendKeys("New York");
    }

    public void countrySelected(){
        country.click();
        countrySelect.click();
    }

    public void stateSelected(){
        state.click();
        stateSelect.click();
    }

    public void fillPostalCode(){
        postalCode.sendKeys("12345");
    }

    public void fillAdditionalInformation(){
        additionalInformation.sendKeys("Hello world =D");
    }

    public void fillAllPhones(){
        mobilePhone.sendKeys("977665544");
        homePhone.sendKeys(("944556677"));
    }

    public void clickSubmitBtnRegister(){
        btnRegister.click();
    }

    public void personalInformation(){
        selectMrTitle();
        fillFristName();
        fillLastName();
        fillPassword();
        dateOfBirth();
        checkbox();
    }

    public void address(){
        fillCompany();
        fillAddress();
        fillCity();
        stateSelected();
        fillPostalCode();
        countrySelected();
        fillAdditionalInformation();
        fillAllPhones();
    }
}
