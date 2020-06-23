package regression.clients.GauravCode;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import uilities.Drivers;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static uilities.Drivers.getDriver;
import static uilities.GetProperties.getMyUrl;

public class LoginTest {

    WebDriver driver = getDriver(Drivers.DriverTypes.CHROME); //find the source in utilities Drivers
     @Test (dataProvider = "getData")
    public void loginValidationTest(String txtUser ,String txtPassword,String expected, String xpathActual) throws IOException {
        driver.get(getMyUrl());
        Login loginDetails = new Login(driver);
        loginDetails.setTxtUser(txtUser);
        loginDetails.setTxtPassword(txtPassword);
        loginDetails.clickBtnLogin();

        String actual = driver.findElement(By.xpath(xpathActual)).getText(); // to find text of actual result
        Assert.assertEquals(actual,expected, "This test has FAILED");
    }

    @DataProvider //used for excel sheet
    public Object[][] getData() throws IOException
    {
        //reading the file (getting the file object)
        FileInputStream fin = new FileInputStream("data\\myData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fin);
        HSSFSheet sheet = workbook.getSheet("userid");
        HSSFRow row;
        int rowCount = sheet.getPhysicalNumberOfRows();
        Object data[][]  = new Object[rowCount - 1][4]; // row count is -1 cause to not conclude Header in the excel file

        for (int i=0; i<rowCount-1; i++) // For ROWS
        {
            row = sheet.getRow(i+1); //i+1 to skip header in excel sheet

            for (int j=0; j<4; j++) // for loop for the 4 fields for COLUMNS in the excel sheet
            {
                HSSFCell element = row.getCell(j);
                element.setCellType(CellType.STRING);//to convert the data in String
                data[i][j] = element.getStringCellValue(); //enter data from data folder in element
            }
        }
        return data;
    }
}
