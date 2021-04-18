package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage extends BaseFlight {
    @FindBy(name="inputName")
    WebElement firstName;

    @FindBy(id="address")
    WebElement address;

    @FindBy(name="city")
    WebElement city;

    @FindBy(name="state")
    WebElement state;

    @FindBy(name="zipCode")
    WebElement zipCode;

    @FindBy(name="creditCardNumber")
    WebElement creditCardNumber;

    @FindBy(name="creditCardMonth")
    WebElement creditCardMonth;

    @FindBy(name="creditCardYear")
    WebElement creditCardYear;

    @FindBy(name="nameOnCard")
    WebElement nameOnCard;

    @FindBy(xpath="//input[@type='submit']")
    WebElement purchaseFlight;

    //here all able are initialized with driver, internally these webelements will be converted into driver.findElements
    public UserDetailsPage(){
        PageFactory.initElements(driver,this);
    }
    //Actions
    public String validateWelcomePageTitle(){
        return driver.getTitle();
    }
    public AllFlightsPage selectFromAndTo(){
        //username.click();
        return new AllFlightsPage();
    }

    public void enterFirstName(String fName){
        firstName.sendKeys(fName);
    }

    public void enterAddress(String addr){
        address.sendKeys(addr);
    }

    public void enterCity(String City){
        city.sendKeys(City);
    }

    public void enterState(String State){
        state.sendKeys(State);
    }

    public void enterZipCode(String ZipCode){
        zipCode.sendKeys(ZipCode);
    }

    public void enterCCNumber(String CCNumber){
        creditCardNumber.sendKeys(CCNumber);
    }

    public void enterCCMonth(String CCMonth){
        creditCardMonth.clear();
        creditCardMonth.sendKeys(CCMonth);
    }

    public void enterCCYear(String CCYear){
        creditCardYear.clear();
        creditCardYear.sendKeys(CCYear);
    }
    public void enterNameOnCard(String NameOnCard){
        nameOnCard.sendKeys(NameOnCard);
    }

    public void clickPurchaseFlight(){
        purchaseFlight.click();
    }
}
