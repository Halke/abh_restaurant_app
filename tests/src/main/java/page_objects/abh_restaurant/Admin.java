package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

import java.util.List;

public class Admin extends PageBase{

    final static private String PAGE_URL_REGEX = "\\/admin\\d*";
    final static private String DASHBOARD_NAVBAR_CSS = ".user-page-bar-navigation > li > a";

    public Admin(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = DASHBOARD_NAVBAR_CSS)
    private List<WebElement> dashboardNav;

    public List<WebElement> getDashboardNav() { return dashboardNav; }

    public AdminRestaurants openAdminRestaurants(int index) {
        getDashboardNav().get(index).click();
        return new AdminRestaurants(getDriver());
    }

}