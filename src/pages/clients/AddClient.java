package pages.clients;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClient
{
    WebDriver driver;// no value is assigned here hence to assign value from test the from below constructor "public AddClient(WebDriver driver)" we need to add a statement below
    @FindBy (xpath="//input[@id='client_name']") WebElement txtClientName;
    @FindBy (xpath="//input[@id='client_surname']") WebElement txtClientSurname;

    //FOR LANGUAGE ->>>>>>> cause of drop down
    //below commented code in language is also a way to execute the operation
   /* @FindBy (xpath="//select[@id='client_language']") WebElement selectlanguage ;*/
    @FindBy (xpath="//span[@id='select2-client_language-container']") WebElement selectlanguage;
    @FindBy (xpath="//input[@type='search']") WebElement containerLanguage; //
    public void setlanguage(String language)
    {
        /*Select sellangauge = new Select(selectlanguage);
        sellangauge.selectByValue(language);*/
        selectlanguage.click();
        containerLanguage.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();// normalize space is used to remove the spaces in the inspect element code

    }

    @FindBy (xpath="//input[@id='client_address_1']") WebElement txtAddress1;
    @FindBy (xpath="//input[@id='client_address_2']") WebElement txtAddress2;
    @FindBy (xpath="//input[@id='client_city']") WebElement txtCity;
    @FindBy (xpath="//input[@id='client_state']") WebElement txtState;
    @FindBy (xpath="//input[@id='client_zip']") WebElement txtZipCode;

    //FOR COUNTRY ->>>>>>> cause of drop down
    @FindBy (xpath="//span[@id='select2-client_country-container']") WebElement containerCountry;// to click dropdown of country
    @FindBy (xpath="//input[@type='search']")
    WebElement txtSearch; // to click search the country in the text field
    public void setContainerCountry(String country) //clicks on country tab and then searches the country
    {
        containerCountry.click();
        txtSearch.sendKeys(country);
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();//to find in the name of country use concatination operator "+country+" country is a variable as it will keep changing
    }

    @FindBy (xpath="//input[@id='client_phone']") WebElement txtPhoneNumber;
    @FindBy (xpath="//input[@id='client_fax']") WebElement txtFaxNumber;
    @FindBy (xpath="//input[@id='client_mobile']") WebElement txtMobileNumber;
    @FindBy (xpath="//input[@id='client_email']") WebElement txtEmail;
    @FindBy (xpath="//input[@id='client_web']") WebElement txtWeb;
    @FindBy (xpath="//input[@id='client_vat_id']") WebElement txtVatId;
    @FindBy (xpath="//input[@id='client_tax_code']") WebElement txtTaxCode;


    @FindBy (xpath="//input[@id='client_birthdate']")
    WebElement txtBirthDate ;


    public void setDate(String mydate) throws ParseException {
// TODO Auto-generated method stub

        txtBirthDate.click();
//PSD



        String setDateStr = mydate;
        SimpleDateFormat setdatesd = new SimpleDateFormat("dd/MM/yyyy");
        Date setDate = setdatesd.parse(setDateStr);

        Date currentDate = new Date();
        String currentDatestr = driver.findElement(By.className("datepicker-switch")).getText();
        SimpleDateFormat currentDatesd =new SimpleDateFormat("MMMM yyyy");
        currentDate = currentDatesd.parse(currentDatestr);


        int monthDiff= Months.monthsBetween(new DateTime(currentDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture;
        if(monthDiff>0)
            isFuture=true;
        else {
            isFuture = false;
            monthDiff= (-1) * monthDiff;
        }

        for(int i=0; i<monthDiff;i++)
        {

            if(isFuture)
                driver.findElement(By.className("next")).click();
            else
                driver.findElement(By.className("prev")).click();
        }

        SimpleDateFormat sdDay = new SimpleDateFormat("dd");

        String dayStr = sdDay.format(setDate);

        int dayInt = Integer.parseInt(dayStr);

        driver.findElement(By.xpath("//td[text()='"+dayInt+"' and @class='day']")).click();



    }

    //FOR GENDER ->>>>>>> cause of drop down
    @FindBy (xpath="//span[@id='select2-client_gender-container']")
    WebElement containerGender;

    @FindBy (id="client_gender")
    WebElement drpGender;

    public void setGender (String gender)
    {
        Select selGender = new Select(drpGender);

        selGender.selectByVisibleText(gender);
       /* containerGender.click();
        txtSearch.sendKeys(gender);
        driver.findElement(By.xpath("//li[contains(text(),'"+gender+"')]")).click();*/
    }

    @FindBy (xpath="//span[@id='select2-client_gender-container']") WebElement txtCalender;
    @FindBy (xpath="//button[@id='btn-submit']") WebElement Save;
    @FindBy (xpath="//button[@id='btn-cancel']") WebElement Cancel;

 //NOW write the constructors for the above WebElements
    public AddClient(WebDriver driver)// to initialise PageFactory
    {
        this.driver = driver;
        //the above driver is assigned to current driver
        // here the value of a driver that will come from test will be assigned to the driver object of this class
        PageFactory.initElements(driver,this);
    }
    //Now set all the elements
    public void setTxtClientName(String clientName)
    {
        txtClientName.sendKeys(clientName);
    }
    public void setTxtClientSurname(String surname)  { txtClientSurname.sendKeys(surname); }
    public void setTxtAddress1(String address1){
        txtAddress1.sendKeys(address1);
    }
    public void setTxtAddress2 (String address2){
        txtAddress2.sendKeys(address2);
    }
    public void setTxtCity (String city){
        txtCity.sendKeys(city);
    }
    public void setTxtState(String state) {
        txtState.sendKeys(state);
    }
    public void setTxtZipCode (String zipCode){
        txtZipCode.sendKeys(zipCode);
    }
    public void setTxtPhoneNumber(String phoneNumber){
        txtPhoneNumber.sendKeys(phoneNumber);
    }
    public void setTxtFaxNumber(String faxNumber){
        txtFaxNumber.sendKeys(faxNumber);
    }
    public void setTxtMobileNumber(String mobileNumber){
        txtMobileNumber.sendKeys(mobileNumber);
    }
    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtWeb(String web){
        txtWeb.sendKeys(web);
    }
    public void setTxtVatId(String vatId){
        txtVatId.sendKeys(vatId);
    }
    public void setTxtTaxCode(String taxcode){
        txtTaxCode.sendKeys(taxcode);
    }
    public void setTxtCalender(String calender){
        txtCalender.sendKeys(calender);
    }
    public void setSave ()
    {
        Save.click();
    }
    public void setCancel(){ Cancel.click(); }
}

