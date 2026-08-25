package ua.solvd.cucumber.page.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.cucumber.page.LoginPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class DesktopLoginPage extends LoginPageBase {
    public DesktopLoginPage(WebDriver driver) {
        super(driver);
    }
}