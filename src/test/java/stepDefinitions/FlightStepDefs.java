package stepDefinitions;

import Pages.*;
import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class FlightStepDefs extends BaseFlight{
    Scenario scenario;
    @Inject
    WelcomePage welcomePage;
    @Inject
    AllFlightsPage allFlightsPage;
    @Inject
    UserDetailsPage userDetailsPage;
    @Inject
    FlightConfirmationPage flightConfirmationPage;
    @Before
    public void setUp(){
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver= new ChromeDriver();
            log.info("chrome browser opened");
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/firefoxdriver.exe");
            driver= new FirefoxDriver();
            log.info("firefox browser opened");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scn){
        if(scn.isFailed()){
            TakesScreenshot scnShot=(TakesScreenshot)driver;
            byte[] data=scnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/JPEG","failedScn");
        }
        driver.quit();
    }
    @Given("User navigates to flight booking application")
    public void user_navigates_to_flight_booking_application() {
        String title= welcomePage.validateWelcomePageTitle();
        Assert.assertEquals("valid page title","BlazeDemo",title);
    }

    @When("user selects {string} and {string} city and click on Find Flights button")
    public void userFromAndToCity(String departure, String destination) {
        System.out.println("depp=="+departure+"desss=="+destination);
        welcomePage.selectDepartureCity(departure);
        welcomePage.selectDestinationCity(destination);
        welcomePage.clickFindFlights();
    }

    @And("user choose flight to reserve ticket")
    public void userChooseFlightToReserveTicket() {
        allFlightsPage.clickChooseThisFlightButton();
    }

    @And("user enters all passenger details and clicks on Purchase Flight button")
    public void userEntersAllPassengerDetailsAndClicksOnPurchaseFlightButton() {
        userDetailsPage.enterFirstName("Adamshafi");
        userDetailsPage.enterAddress("123 street");
        userDetailsPage.enterCity("Bangalore");
        userDetailsPage.enterCCNumber("12345");
        userDetailsPage.enterCCMonth("12");
        userDetailsPage.enterCCYear("2021");
        userDetailsPage.enterZipCode("12344");
        userDetailsPage.enterNameOnCard("Shafi");
        userDetailsPage.enterState("Karnataka");
        userDetailsPage.clickPurchaseFlight();
    }

    @Then("user validates purchase details")
    public void userValidatesPurchaseDetails() {
        String pid=flightConfirmationPage.getPurchaseID();
        Assert.assertTrue("purchase ID generated= "+pid,pid!=null);
    }
}