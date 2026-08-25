package ua.solvd.cucumber.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPageBase extends BasePage {

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

    public CheckoutOverviewPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/checkout-step-two.html");
    }

    public CheckoutCompletePageBase finishCheckout() {
        finishButton.click();
        return initPage(getDriver(), CheckoutCompletePageBase.class);
    }
}