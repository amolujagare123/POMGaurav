package uiTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utilities.BaseOpenUrl;

public class LoginTest extends BaseOpenUrl {

    Login login;

    @BeforeClass
    public void setLoginObject()
    {
        login = new Login(driver);
    }

    @Test
    public void txtUserNameaVailability()
    {
         boolean expected = true;
        boolean actual=true;
         try {
            actual = login.txtUser.isDisplayed();
         }
         catch (Exception e)
         {
             actual =false;
         }
        Assert.assertEquals(actual,expected,"Element is not there");
    }
}
