package regression.clients;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class AddClientTest extends DoLogin {



    @Test (dataProvider = "getData")
    public void addClienttest(String clinetName,String surname,String language,String add1,
                              String add2,String city,String state,String zipcode,String country,
                              String gender ,String bdate,String phoneno,String faxno,
                              String mobile,String email,String web,String vat,
                              String taxcode,String expected,String xpathActual) throws ParseException {
        Menu menu =new Menu (driver); //driver is inhertied from DoLogin which is extened
        menu.clickAddClient();

        AddClient addclient = new AddClient(driver);
        addclient.setTxtClientName(clinetName);
        addclient.setTxtClientSurname(surname);
        addclient.setlanguage(language); ////////
        addclient.setTxtAddress1(add1);
        addclient.setTxtAddress2(add2);
        addclient.setTxtCity(city);
        addclient.setDate(bdate);
        addclient.setTxtState(state);
        addclient.setTxtZipCode(zipcode);
        addclient.setContainerCountry(country);
        addclient.setTxtPhoneNumber(phoneno);
        addclient.setTxtFaxNumber(faxno);
        addclient.setTxtMobileNumber(mobile);
        addclient.setTxtEmail(email);
        addclient.setTxtWeb(web);
        addclient.setTxtVatId(vat);
        addclient.setTxtTaxCode(taxcode);
        addclient.setGender(gender);
        addclient.setSave();


        String actual = driver.findElement(By.xpath(xpathActual)).getText();

        Assert.assertEquals(actual,expected,"this test is failed");
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fin=new FileInputStream("data\\Scriptingdata.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fin);
        HSSFSheet sheet=workbook.getSheet("addClient");
        HSSFRow row;
        int rowCount =sheet.getPhysicalNumberOfRows();
        Object data[][]=new Object[rowCount-1][20];


        for(int i=0; i<rowCount-1;i++)
        {

             row = sheet.getRow(i+1);

             for(int j=0;j<20;j++)
             {
                 HSSFCell element = row.getCell(j);
                 element.setCellType(CellType.STRING);
                 data[i][j] = element.getStringCellValue();

             }

        }

        return  data;
    }
}
