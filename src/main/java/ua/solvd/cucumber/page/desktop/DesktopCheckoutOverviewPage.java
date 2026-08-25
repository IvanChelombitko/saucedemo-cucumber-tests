package ua.solvd.cucumber.page.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.cucumber.page.CheckoutOverviewPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutOverviewPageBase.class)
public class DesktopCheckoutOverviewPage extends CheckoutOverviewPageBase {
    public DesktopCheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
}