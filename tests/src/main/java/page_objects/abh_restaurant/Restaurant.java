package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class Restaurant extends PageBase {

    final static private String PAGE_URL_REGEX = "\\/d*\\d*";
    final static private String RESERVATION_PERSON_PICKER_CSS = "#reservation form select:nth-child(1)";
    final static private String RESERVATION_DATE_PICKER_CSS = "#reservation form input:nth-child(2)";
    final static private String RESERVATION_TIME_PICKER_CSS = "#reservation form input:nth-child(3)";
    final static private String RESERVATION_SUBMIT_BUTTON_CSS ="#reservation form button";
    final static private String AVAILABLE_RESERVATION_CSS = ".restaurant-reservation-times > span:nth-child(1)";

    public Restaurant(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = RESERVATION_PERSON_PICKER_CSS)
    private WebElement reservationPersonPicker;

    @FindBy(css = RESERVATION_DATE_PICKER_CSS)
    private WebElement reservationDatePicker;

    @FindBy(css = RESERVATION_TIME_PICKER_CSS)
    private WebElement reservationTimePicker;

    @FindBy(css = RESERVATION_SUBMIT_BUTTON_CSS)
    private WebElement reservationSubmitButton;

    @FindBy(css = AVAILABLE_RESERVATION_CSS)
    private WebElement availableReservation;



    public WebElement getReservationPersonPicker() { return reservationPersonPicker; }

    public WebElement getReservationDatePicker() { return reservationDatePicker; }

    public WebElement getReservationTimePicker() { return reservationTimePicker; }

    public WebElement getReservationSubmitButton() { return reservationSubmitButton; }

    public WebElement getAvailableReservation() { return availableReservation; }

}