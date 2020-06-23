package utilities;
import org.testng.annotations.BeforeClass;
import pages.Login;

import java.util.concurrent.TimeUnit;

//since we are using the annotations related to tests we are putting this class in test src
public class DoLogin extends BaseOpenUrl// how to create for firefox ????????????????????
{
       @BeforeClass // this forces doLogin to run before every class
    public void doLogin()
    {
           Login login = new Login(driver);

        login.setTxtUser("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickBtnLogin();

        driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
    }
}
