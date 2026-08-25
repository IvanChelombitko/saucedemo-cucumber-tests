package ua.solvd.cucumber.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ua.solvd.cucumber.model.User;

public class CheckoutInfoPageBase extends BasePage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "postal-code")
    private ExtendedWebElement postalCodeInput;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    public CheckoutInfoPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/checkout-step-one.html");
    }

    public CheckoutOverviewPageBase fillInformationAndContinue(User user) {
        firstNameInput.type(user.getFirstName());
        lastNameInput.type(user.getLastName());
        postalCodeInput.type(user.getZipCode());
        continueButton.click();
        return initPage(getDriver(), CheckoutOverviewPageBase.class);
    }
}