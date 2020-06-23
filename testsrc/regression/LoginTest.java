package regression;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Login;
import uilities.Drivers;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static uilities.Drivers.getDriver;

public class LoginTest {

    WebDriver driver = getDriver(Drivers.DriverTypes.CHROME);
    @Test
    public void loginTest()
    {
        String myUrl ="";

        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");

        myUrl= rb.getString("url");

        driver.get(myUrl);

        Login login = new Login(driver);

        login.setTxtUser("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickBtnLogin();

        driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
    }



}
