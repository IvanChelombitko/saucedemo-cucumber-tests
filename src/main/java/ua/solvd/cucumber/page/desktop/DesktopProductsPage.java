package ua.solvd.cucumber.page.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import ua.solvd.cucumber.page.ProductsPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductsPageBase.class)
public class DesktopProductsPage extends ProductsPageBase {
    public DesktopProductsPage(WebDriver driver) {
        super(driver);
    }
}