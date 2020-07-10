package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class AdminRestaurants extends PageBase {

    final static private String PAGE_URL_REGEX = "\\/admin/restaurants\\d*";
    final static private String EDIT_RESTAURANT_BTN_CSS = ".admin-form-object-list li a[href='/admin/restaurants/edit/52']";

    public AdminRestaurants(WebDriver driver){
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = EDIT_RESTAURANT_BTN_CSS)
    private WebElement editRestaurantBtn;

    public WebElement getEditRestaurantBtn() { return editRestaurantBtn; }
}