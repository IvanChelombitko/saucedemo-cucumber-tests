package ua.solvd.cucumber.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePageBase extends BasePage {

    @FindBy(className = "complete-header")
    private ExtendedWebElement completeHeader;

    public CheckoutCompletePageBase(WebDriver driver) {
        super(driver);
        setPageURL("/checkout-complete.html");
    }

    public boolean isOrderSuccessful() {
        return completeHeader.isElementPresent() && 
               completeHeader.getText().equalsIgnoreCase("Thank you for your order!");
    }
}