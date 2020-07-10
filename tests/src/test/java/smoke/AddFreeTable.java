package smoke;

import testUtils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import java.util.concurrent.TimeUnit;

public class AddFreeTable extends TestBase {

    private final static String ADMIN_EMAIL = "admin@example.com";
    private final static String ADMIN_PASS = "admin";
    private static final String HOME_HEADER_TEXT = "Make a free reservation";

    @Test(priority = 0)
    public void openRestaurantsHomePage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 1)
    public void loginToAdmin() {
        WebElement email = new LoginPage(driver)
                .getEmailInputField();
        WebElement password = new LoginPage(driver)
                .getPasswordInputField();
        WebElement loginBtn = new LoginPage(driver)
                .getLoginButton();

        email.sendKeys(ADMIN_EMAIL);
        password.sendKeys(ADMIN_PASS);
        loginBtn.click();
    }

    //if I omit this test(2), the clickAdminDashboard below does not work at all but the build is a success and no tests fail..I wonder why
    @Test(priority = 2)
    public void checkAdminIsLoggedIn(){
        Assert.assertTrue(new HomePage(driver)
                .checkMainText(HOME_HEADER_TEXT));
    }

    //This should be refactored and split into more tests
    @Test(priority = 3)
    public void navigateToAddTablesPage() throws InterruptedException{
        new HomePage(driver).openAdminDashboard(2);
        new Admin(driver).openAdminRestaurants(1);
        WebElement editRestaurantBtn = new AdminRestaurants(driver).getEditRestaurantBtn();
        Actions action = new Actions(driver);
        action.moveToElement(editRestaurantBtn).perform();
        editRestaurantBtn.click();
        AdminRestaurantsEdit are = new AdminRestaurantsEdit(driver);
        are.openTablesView(2);
        are.clickAddNewTableBtn();
        are.populateNewTable("3");
        Thread.sleep(5000);
    }

}