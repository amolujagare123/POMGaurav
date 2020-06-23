package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(linkText = "Dashboard")
    WebElement lnkDashBoard;

    @FindBy (xpath = "//span[contains(text(),'Clients')]")
    WebElement lnkClients;

    // @FindBy (locator = value)   WebElement elementName ;

    @FindBy (xpath="//a[contains(text(),'Add Client')]")
    WebElement lnkAddClinent;

    @FindBy (xpath="//a[contains(text(),'View Client')]")
    WebElement lnkViewClinent;

    public Menu(WebDriver driver) // constructor
    {
        PageFactory.initElements(driver,this);
    }



    public void clickLnkDahboard()
    {
        lnkDashBoard.click();
    }

    public void clickAddClient()
    {
        lnkClients.click();
        lnkAddClinent.click();
    }

    public void clickViewClient()
    {
        lnkClients.click();
        lnkViewClinent.click();
    }

}
