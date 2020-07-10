package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class ReservationDetails extends  PageBase {
    final static private String PAGE_URL_REGEX = "\\/reservation-details/\\d*";
    final static private String COMPLETE_RESERVATION_BTN_CSS = ".confirm-reservation-button";

    public ReservationDetails(WebDriver driver){
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = COMPLETE_RESERVATION_BTN_CSS)
    private WebElement completeReservationBtn;

    public WebElement getCompleteReservationBtn() { return completeReservationBtn; }

}