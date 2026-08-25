package ua.solvd.cucumber.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPageBase extends BasePage {

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public ProductsPageBase login(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductsPageBase.class);
    }
}