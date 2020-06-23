package utilities;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.Login;
import uilities.Drivers;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static uilities.Drivers.getDriver;

// since we are using the annotations related to tests we are putting this class in
// testsrc
public class DoLogin {


    protected WebDriver driver = getDriver(Drivers.DriverTypes.CHROME);

    @BeforeClass
    public void doLogin()
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
