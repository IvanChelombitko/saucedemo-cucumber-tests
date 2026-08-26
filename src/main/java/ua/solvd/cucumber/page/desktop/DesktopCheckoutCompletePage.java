package ua.solvd.cucumber.page.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.cucumber.page.CheckoutCompletePageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutCompletePageBase.class)
public class DesktopCheckoutCompletePage extends CheckoutCompletePageBase {
    public DesktopCheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
}