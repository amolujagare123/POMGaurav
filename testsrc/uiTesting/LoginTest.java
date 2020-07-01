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


    @Test
    void txtUserNameEnability()
    {
        boolean expected = true;

        boolean actual=true;
        try {
            actual = login.txtUser.isEnabled();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual,expected,"Element is not enabled");
    }

    @Test
    public void loginHeadersize()
    {
        String expected = "h1";
        String actual="";
        try {
            actual = login.loginHeading.getTagName();
        }
        catch (Exception e)
        {
            actual="" ;
        }
        Assert.assertEquals(actual,expected,"Login text do not have required size");
    }


    @Test
    void txtusernameWatermark()
    {
       String expected ="Email";
        String actual="";
       try {
            actual = login.txtUser.getAttribute("placeholder");
       }
       catch (Exception e)
       {
           actual="" ;
       }

        Assert.assertEquals(actual,expected,"incorrect watermark");
    }



    @Test
    public void lblEmailFontFamilycheck()
    {

        String expected="-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";

        String actual="";
        try {
            actual = login.lblEmail.getCssValue("font-family");
        }
        catch (Exception e)
        {
            actual="" ;
        }

        Assert.assertEquals(actual,expected,"incorrect font-family");
    }


    // check whether the font of the Email label has a family san serif or not

    @Test
    public void lblEmailFontcheck()
    {

        String font="sans-serif";

        boolean expected =true;
        boolean actual=false;
        try {
            actual = login.lblEmail.getCssValue("font-family").contains(font);
        }
        catch (Exception e)
        {
            actual=false;
        }

        Assert.assertEquals(actual,expected,"incorrect font (sans-serif is not in family)");
    }
}
