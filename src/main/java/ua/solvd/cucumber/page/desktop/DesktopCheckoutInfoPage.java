package ua.solvd.cucumber.page.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.cucumber.page.CheckoutInfoPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutInfoPageBase.class)
public class DesktopCheckoutInfoPage extends CheckoutInfoPageBase {
    public DesktopCheckoutInfoPage(WebDriver driver) {
        super(driver);
    }
}