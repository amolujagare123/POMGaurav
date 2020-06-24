package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import uilities.Drivers;

import java.util.ResourceBundle;

import static uilities.Drivers.getDriver;

public class BaseOpenUrl {

    protected WebDriver driver = getDriver(Drivers.DriverTypes.CHROME); //find the source in utilities Drivers, driver is a datamember
    //driver was a default member which cannot be accessed publicly in AddClient hence you make it public or protected to access in other flies

    @BeforeClass // this forces doLogin to run before every class
    public void openUrl() {
        String myUrl = "";

        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane"); //use resource bundle
        myUrl = rb.getString("url");

        driver.get(myUrl);
    }
}
