package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    // WebElement txtUser = driver.findElement(By.xpath("//input[@type='email']"));

    @FindBy (xpath = "//input[@type='email']")
    WebElement txtUser; // using page factory

    @FindBy (xpath = "//input[@type='password']")
    WebElement txtPassword;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy (xpath = "//a[contains(text(),'I forgot my password')]")
    WebElement lnkForgotPass;

    public Login(WebDriver driver)  // Login ob = new Login(drv)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtUser(String user)
    {
        txtUser.sendKeys(user);
    }
    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickBtnLogin()
    {
        btnLogin.click();
    }

    public  void clickForgotPassword()
    {
        lnkForgotPass.click();
    }





}
