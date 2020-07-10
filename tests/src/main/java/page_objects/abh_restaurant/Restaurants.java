package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class Restaurants extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurants\\d*";
    final static private String BRIMSTONE_CSS = "#main > div > div[class = 'row'] > div > div > div > a[href='/restaurant/52'] > div";
    final static private String RESERVATION_PERSON_PICKER_CSS = "#reservation > form:nth-child(1)";
    final static private String RESERVATION_DATE_PICKER_CSS = "#reservation > form:nth-child(2)";
    final static private String RESERVATION_TIME_PICKER_CSS = "#reservation > form:nth-child(3)";

    public Restaurants(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = BRIMSTONE_CSS)
    private WebElement restaurantHeading;

    @FindBy(css = RESERVATION_DATE_PICKER_CSS)
    private WebElement reservationDatePicker;

    public WebElement getRestaurantHeading(){
        return restaurantHeading;
    }

    public WebElement getReservationDatePicker() { return reservationDatePicker; }

    public void openSpecificRestaurant(){ getRestaurantHeading().click(); }
}
