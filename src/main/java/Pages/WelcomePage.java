package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WelcomePage extends BaseFlight{
    @FindBy(name="fromPort")
    WebElement departure;

    @FindBy(name="toPort")
    WebElement destination;

    @FindBy(xpath="//input[@type='submit']")
    WebElement findFlightsButton;

//here all able are initialized with driver, internally these webelements will be converted into driver.findElements
    public WelcomePage(){
        PageFactory.initElements(driver,this);
    }

    Select dropdown;
    //Actions
    public String validateWelcomePageTitle(){
        return driver.getTitle();
    }

    public void selectDepartureCity(String fromCity){
        dropdown=new Select(departure);
        List<WebElement> options=dropdown.getOptions();
        dropdown.selectByVisibleText(fromCity);
        //dropdown.selectByIndex(3);
    }

    public void selectDestinationCity(String toCity){
        dropdown=new Select(destination);
        List<WebElement> options=dropdown.getOptions();
        dropdown.selectByVisibleText(toCity);
       // dropdown.selectByIndex(3);
    }
    public void clickFindFlights(){
        findFlightsButton.click();
    }
    public AllFlightsPage selectFromAndTo(){
        //username.click();
        return new AllFlightsPage();
    }
}
