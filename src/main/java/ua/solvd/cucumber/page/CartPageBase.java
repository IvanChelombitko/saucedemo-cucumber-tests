package ua.solvd.cucumber.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPageBase extends BasePage {

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;

    public CartPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/cart.html");
    }

    public CheckoutInfoPageBase proceedToCheckout() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutInfoPageBase.class);
    }
}