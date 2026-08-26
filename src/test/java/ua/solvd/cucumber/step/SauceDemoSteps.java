package ua.solvd.cucumber.step;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import ua.solvd.cucumber.dao.IUserMapper;
import ua.solvd.cucumber.dao.IUserOrderMapper;
import ua.solvd.cucumber.model.UserOrder;
import ua.solvd.cucumber.page.*;
import ua.solvd.cucumber.model.User;
import ua.solvd.cucumber.util.ConnectionFactory;

import java.util.List;

public class SauceDemoSteps implements IDriverPool, ICustomTypePageFactory {
    private User currentUser;
    private List<UserOrder> userOrders;

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheSauceDemoLoginPage() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.open();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page is not opened.");
    }

    @When("I login as {string} using credentials from the database")
    public void iLoginUsingCredentialsFromTheDatabase(String username) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession()) {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            IUserOrderMapper orderMapper = session.getMapper(IUserOrderMapper.class);
            currentUser = userMapper.getUserByUsername(username);
            Assert.assertNotNull(currentUser, "User " + username + " was not found in the database.");
            userOrders = orderMapper.getOrdersByUserId(currentUser.getId());
            Assert.assertFalse(userOrders.isEmpty(), "No orders found for user: " + username);
        }
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        ProductsPageBase productsPageBase = loginPageBase.login(currentUser.getUsername(), currentUser.getPassword());
        Assert.assertTrue(productsPageBase.isPageOpened(), "Products page is not opened after login.");
    }

    @When("I add all my stored orders to the cart")
    public void iAddAllMyStoredOrdersToTheCart() {
        ProductsPageBase productsPageBase = initPage(getDriver(), ProductsPageBase.class);
        userOrders.stream()
                .map(UserOrder::getItemName)
                .forEach(productsPageBase::addItemToCart);
    }

    @When("I proceed to checkout using my profile details")
    public void iProceedToCheckoutUsingMyProfileDetails() {
        ProductsPageBase productsPageBase = initPage(getDriver(), ProductsPageBase.class);
        CartPageBase cartPageBase = productsPageBase.openCart();
        Assert.assertTrue(cartPageBase.isPageOpened(), "Cart page is not opened.");
        CheckoutInfoPageBase checkoutInfoPageBase = cartPageBase.proceedToCheckout();
        Assert.assertTrue(checkoutInfoPageBase.isPageOpened(), "Checkout Information page is not opened.");
        CheckoutOverviewPageBase checkoutOverviewPageBase = checkoutInfoPageBase.fillInformationAndContinue(currentUser);
        Assert.assertTrue(checkoutOverviewPageBase.isPageOpened(), "Checkout Overview page is not opened.");
        checkoutOverviewPageBase.finishCheckout();
    }

    @Then("I should see the successful order completion message")
    public void iShouldSeeTheSuccessfulOrderCompletionMessage() {
        CheckoutCompletePageBase checkoutCompletePageBase = initPage(getDriver(), CheckoutCompletePageBase.class);
        Assert.assertTrue(checkoutCompletePageBase.isPageOpened(), "Checkout Complete page is not opened.");
        Assert.assertTrue(checkoutCompletePageBase.isOrderSuccessful(), "Order was not successful.");
    }
}