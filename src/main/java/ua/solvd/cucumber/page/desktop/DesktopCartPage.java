package ua.solvd.cucumber.page.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.cucumber.page.CartPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class DesktopCartPage extends CartPageBase {
    public DesktopCartPage(WebDriver driver) {
        super(driver);
    }
}