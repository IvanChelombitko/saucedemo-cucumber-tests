package ua.solvd.cucumber.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPageBase extends BasePage {

    @FindBy(xpath = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button")
    private ExtendedWebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private ExtendedWebElement cartIcon;

    public ProductsPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    public void addItemToCart(String itemName) {
        addToCartButton.format(itemName).click();
    }

    public CartPageBase openCart() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}