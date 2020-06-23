package regression.clients.GauravCode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;
import utilities.DoLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
public class AddClientTest extends DoLogin
{
    @Test (dataProvider = "getData")
    public void addClienttest(String clientname,String surname, String language,String add1,
                              String add2,String city,String state,String zipcode,String country,
                              String gender,String myDate,String phoneno,String faxno,String mobileno,
                              String email,String web,String vat,String taxcode,String expected, String xpathActual) throws ParseException  //Excel sheet sequence and parameter in addClienttest sequence should be same
    //Excel sheet sequence and parameter in addClienttest sequence should be same
    {
        //to click on menu button and click on addclient
        Menu menu = new Menu(driver); //driver is inherited from DoLogin which is extends
        menu.clickAddClient();

        AddClient addclient = new AddClient(driver);
        addclient.setTxtClientName(clientname); // we are directly using variables hear mentioned in the parameters above
        addclient.setTxtClientSurname(surname);
        addclient.setlanguage(language);
        addclient.setTxtAddress1(add1);
        addclient.setTxtAddress2(add2);
        addclient.setTxtCity(city);
        addclient.setTxtState(state);
        addclient.setTxtZipCode(zipcode);
        addclient.setContainerCountry(country);
        addclient.setGender(gender);
        addclient.setDate(myDate);
        addclient.setTxtPhoneNumber(phoneno);
        addclient.setTxtFaxNumber(faxno);
        addclient.setTxtMobileNumber(mobileno);
        addclient.setTxtEmail(email);
        addclient.setTxtWeb(web);
        addclient.setTxtVatId(vat);
        addclient.setTxtTaxCode(taxcode);
        addclient.setSave();

        /*AddClient addclient = new AddClient(driver);  // when not using excel sheet enter values here
        addclient.setTxtClientName("Gaurav");
        addclient.setTxtClientSurname("Vinod");
        addclient.setlanguage("Dutch");
        addclient.setTxtAddress1("Dapodi");
        addclient.setTxtAddress2("hadapsar");
        addclient.setTxtCity("Pune");
        addclient.setTxtState("Maharashtra");
        addclient.setTxtZipCode("411012");
        addclient.setContainerCountry("India");
        addclient.setTxtPhoneNumber("123456789");
        addclient.setTxtFaxNumber("456789");
        addclient.setTxtMobileNumber("987654321");
        addclient.setTxtEmail("abc@gmail.com");
        addclient.setTxtWeb("www.google.com");
        addclient.setTxtVatId("63937");
        addclient.setTxtTaxCode("000123");
        addclient.setGender("Female");
        addclient.setTxtBirthDate("23/12/2004");
        addclient.setSave();*/

        String actual = driver.findElement(By.xpath(xpathActual)).getText(); // to find text of actual result
        Assert.assertEquals(actual,expected, "This test has FAILED"); // Used to compair the actual and expected result
    }

    @DataProvider //used for excel sheet
    public Object[][] getData() throws IOException
    {
        //reading the file (getting the file object)
        FileInputStream fin = new FileInputStream("data\\myData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fin);
        HSSFSheet sheet = workbook.getSheet("Addclient");
        HSSFRow row;
        int rowCount = sheet.getPhysicalNumberOfRows();
        Object data[][]  = new Object[rowCount - 1][20]; // row count is -1 cause to not conclude Header in the excel file

        for (int i=0; i<rowCount-1; i++) // For ROWS
        {
            row = sheet.getRow(i+1); //i+1 to skip header in excel sheet

            for (int j=0; j<20; j++) // for loop for the 18 fields for COLUMNS in the excel sheet
            {
                HSSFCell element = row.getCell(j);
                element.setCellType(CellType.STRING);//to convert the data in String
                data[i][j] = element.getStringCellValue(); //enter data from data folder in element
            }
        }
    return data; //
    }
}
