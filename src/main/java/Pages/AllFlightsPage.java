package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllFlightsPage  extends BaseFlight{
    @FindBy(xpath="//input[@type='submit']")
    WebElement chooseThisFlight;

    @FindBy(name="")
    WebElement username1;

    @FindBy(name="")
    WebElement username2;

    @FindBy(name="")
    WebElement username3;
    //here all able are initialized with driver, internally these webelements will be converted into driver.findElements
    public AllFlightsPage(){
        PageFactory.initElements(driver,this);
    }
    //Actions
    public String validateWelcomePageTitle(){
        return driver.getTitle();
    }
    public AllFlightsPage selectFromAndTo(){
        return new AllFlightsPage();
    }

    public void clickChooseThisFlightButton(){
        chooseThisFlight.click();
    }
}
