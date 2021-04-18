package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage extends BaseFlight {
    @FindBy(xpath="//td[text()='Id']//following-sibling::td")
    WebElement purchaseID;

    @FindBy(xpath="//td[text()='Status']//following-sibling::td")
    WebElement status;

    @FindBy(name="")
    WebElement username2;

    //here all able are initialized with driver, internally these webelements will be converted into driver.findElements
    public FlightConfirmationPage(){
        PageFactory.initElements(driver,this);
    }
    //Actions
    public String validateWelcomePageTitle(){
        return driver.getTitle();
    }
    public String getPurchaseID(){
        String pid=purchaseID.getText();
        return pid;
    }
}
