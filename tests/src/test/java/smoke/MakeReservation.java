package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.*;
import testUtils.TestBase;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

public class MakeReservation extends TestBase {

    private static final String FIRST_NAME = "Alice";
    private static final String LAST_NAME = "Lopez";
    private static final String EMAIL = "bambooch5@live.com";
    private static final String PHONE_NUMBER = "12345";
    private static final String ADDRESS = "Pijacna 118";
    private static final String PASSWORD = "1234";
    private static final String HEADER_TEXT = "Make a free reservation";

    //Persons array has an offset set for PERSONS[0] so it is more intuitive to change the number of persons for the reservation. PERSONS[3] would be for three persons.
    private static final String[] PERSONS = {"offSet","1 Person", "2 People", "3 People", "4 People", "5 People", "6 People", "7 People", "8 People"};

    private static final String RESERVATION_PERSONS = PERSONS[3];
    private static final String RESERVATION_DATE = "2020-07-11";
    private static final String RESERVATION_TIME = "17:00";
    private static String NEWACC_MAIL;

    @Test(priority = 0)
    public void openRestaurantsHomePage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 1)
    public void openRegistrationPage() {
        new LoginPage(driver)
                .clickRegisterButton();
    }

    @Test(priority = 2)
    public void populateRegistrationForm() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmm");
        Date date = new Date();
        NEWACC_MAIL = formatter.format(date)+EMAIL;//this is to avoid logging in with the wrong email if a minute or more has passed after account creation
        new Registration(driver)
                .makeRegistration(FIRST_NAME, LAST_NAME, NEWACC_MAIL, PHONE_NUMBER, ADDRESS, PASSWORD, PASSWORD);
    }

    @Test(priority = 3)
    public void checkUserIsRegistered(){
        Assert.assertTrue(new HomePage(driver)
        .checkMainText(HEADER_TEXT));
    }

    @Test(priority = 4)
    public void openUserDetails() {
        new HomePage(driver)
                .clickUserDetails(2);
    }

    @Test(priority = 5)
    public void logOut() {
        new UserDetails(driver)
                .clickLogoutButton();
    }

    @Test(priority = 6)
    public void openHomePage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 7)
    public void loginToRestaurantsPage() {
        new LoginPage(driver)
                .loginToRestaurants(NEWACC_MAIL, PASSWORD);
    }
    @Test(priority = 8)
    public void checkUserLoginIsSuccessful(){
        Assert.assertTrue(new HomePage(driver)
                .checkMainText(HEADER_TEXT));
    }

    @Test(priority = 9)
    public void openRestaurantsPage() {
        new HomePage(driver)
                .openRestaurantsPage(1);
    }
    //this should continue to try and make a reservation
    @Test(priority = 10)
    public void openBrimstoneRestaurant() throws InterruptedException {
        new Restaurants(driver).openSpecificRestaurant();
    }

    @Test(priority = 11)
    public void fillReservationData() throws InterruptedException{
        //initialization
        Select dropDownValue = new Select(new Restaurant(driver).getReservationPersonPicker());
        WebElement datePicker = new Restaurant(driver).getReservationDatePicker();
        WebElement timePicker = new Restaurant(driver).getReservationTimePicker();

        //data population
        dropDownValue.selectByVisibleText(RESERVATION_PERSONS);
        datePicker.sendKeys(RESERVATION_DATE);
        timePicker.sendKeys(RESERVATION_TIME);
    }

    @Test(priority = 12)
    public void makeReservation() {
        new Restaurant(driver).getReservationSubmitButton().click();
        WebElement availableReservationBtn = new Restaurant(driver).getAvailableReservation();
        try
        {
            availableReservationBtn.click();
            new ReservationDetails(driver).getCompleteReservationBtn().click();
        }
        catch(Exception e)
        {
            //It waits too long to catch this error, if the availableReservationBtn isn't displayed it should throw immediately...
            Assert.fail("No free tables in restaurant...");
        }


    }

}
