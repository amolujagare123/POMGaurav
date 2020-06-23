package regression.clients.GauravCode;
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

    // LANGUAGE ->>>>>>> cause of drop down
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
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();// 'normalize-space' is used to remove the spaces in the inspect element code
    }

    // COUNTRY ->>>>>>> cause of drop down
    @FindBy (xpath="//span[@id='select2-client_country-container']") WebElement containerCountry;// to click dropdown of country
    @FindBy (xpath="//input[@type='search']") WebElement txtSearch; // to click search the country in the text field
    public void setContainerCountry(String country) //clicks on country tab and then searches the country
    {
        containerCountry.click();
        txtSearch.sendKeys(country);
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();//to find in the name of country use concatination operator "+country+" country is a variable as it will keep changing
    }

    // GENDER ->>>>>>> cause of drop down
    @FindBy (xpath="//span[@id='select2-client_gender-container']") WebElement containerGender;
    public void setGender (String gender)
    {
        containerGender.click();
        txtSearch.sendKeys(gender);
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }

    // BIRTHDAY ->>>>>>>>
    @FindBy (id="client_birthdate") WebElement txtBirthDate;
    public void setTxtBirthDate(String myDate) throws ParseException {
        //-> For SETTING MONTH
        txtBirthDate.click();
        String setDateStr = myDate;
        SimpleDateFormat sdSetDate = new SimpleDateFormat("dd/MM/yyyy"); // to convert the string into date format
        Date setDate = sdSetDate.parse(setDateStr);          //parse the string to convert in date format

        //-> MMMM yyyy for CURRENT DATE from the date picker
        String currtdateStr = driver.findElement(By.className("datepicker-switch")).getText();//gets date on text format
        System.out.println(currtdateStr);
        //-> now convert the currdate text in respective format
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currtdateStr);

        //-> NOW to FIND DIFFERENCE between the above DATES set - current date and download the jar file for it to work ( https://jar-download.com/artifacts/joda-time/joda-time/2.9.4/source-code )
        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();//diff between 1st day of the months
        System.out.println(monthDiff);

        //-> Now to click on the arrow left or right
        boolean monthDiffStatus = false ;              //take a flag to check month diff is positive or not, flag is just variable,by deafault keep it as false
        if (monthDiff > 0)                        // if month diff is greater than 0  the flag is true or positive
            monthDiffStatus = true;
        for (int i = 0; i < monthDiff; i++)
        {
            if (monthDiffStatus)
                driver.findElement(By.name("//th[@class='next']")).click();   //if true then click on next button
            else
                driver.findElement(By.name("//th[@class='prev']")).click();    //if false the click previous button
        }

        //-> FOR SETTING DATE
        String setDaystr = new SimpleDateFormat("dd").format(setDate);     //convert date to string
        System.out.println(setDateStr);

        //-> Cause for single digit dates like "2" it will take "02" hence convert "02" in integer like "2"
        int setDatInt = Integer.parseInt(setDateStr);                             //convert in integer using wrapper class
        System.out.println(setDatInt);

        driver.findElement(By.xpath("//td[text() = '"+setDatInt+"' and @class = 'day']")).click();
        //in calender there can me multiple same dates hence class name should be checked like day and new day for date 2 so use and operator in path
    }

    @FindBy (xpath="//input[@id='client_name']") WebElement txtClientName;
    @FindBy (xpath="//input[@id='client_surname']") WebElement txtClientSurname;
    @FindBy (xpath="//input[@id='client_address_1']") WebElement txtAddress1;
    @FindBy (xpath="//input[@id='client_address_2']") WebElement txtAddress2;
    @FindBy (xpath="//input[@id='client_city']") WebElement txtCity;
    @FindBy (xpath="//input[@id='client_state']") WebElement txtState;
    @FindBy (xpath="//input[@id='client_zip']") WebElement txtZipCode;
    @FindBy (xpath="//input[@id='client_phone']") WebElement txtPhoneNumber;
    @FindBy (xpath="//input[@id='client_fax']") WebElement txtFaxNumber;
    @FindBy (xpath="//input[@id='client_mobile']") WebElement txtMobileNumber;
    @FindBy (xpath="//input[@id='client_email']") WebElement txtEmail;
    @FindBy (xpath="//input[@id='client_web']") WebElement txtWeb;
    @FindBy (xpath="//input[@id='client_vat_id']") WebElement txtVatId;
    @FindBy (xpath="//input[@id='client_tax_code']") WebElement txtTaxCode;
    //@FindBy (xpath="//span[@id='select2-client_gender-container']") WebElement txtCalender;
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
    public void setSave ()
    {
        Save.click();
    }
    public void setCancel(){ Cancel.click(); }
}

