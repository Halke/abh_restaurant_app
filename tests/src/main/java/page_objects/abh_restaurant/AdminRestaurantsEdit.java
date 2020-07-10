package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;
import java.util.List;

public class AdminRestaurantsEdit extends PageBase {

    final static private String PAGE_URL_REGEX = "\\/admin/restaurants/edit\\d*";
    final static private String EDIT_RESTAURANT_NAVBAR_CSS = ".nav-tabs li > a";
    final static private String ADD_TABLE_BTN_CSS = ".admin-from-new-button";
    final static private String TABLE_INPUT_LIST_CSS = ".admin-form div > div label input";

    public AdminRestaurantsEdit(WebDriver driver){
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = EDIT_RESTAURANT_NAVBAR_CSS)
    private List<WebElement> editRestaurantNav;

    @FindBy(css = ADD_TABLE_BTN_CSS)
    private WebElement addTableBtn;

    @FindBy(css = TABLE_INPUT_LIST_CSS)
    private List<WebElement> listOfTables;

    public List<WebElement> getEditRestaurantNav() { return editRestaurantNav; }

    public WebElement getAddTableBtn() { return addTableBtn; }

    public List<WebElement> getListOfTables() { return listOfTables; }

    public void openTablesView(int index){
        getEditRestaurantNav().get(index).click();
    }

    public void clickAddNewTableBtn() {
        getAddTableBtn().click();
    }

    public void populateNewTable(String people){
        WebElement newTable = getListOfTables().get(getListOfTables().size()-1);
        newTable.sendKeys(people);
    }
}