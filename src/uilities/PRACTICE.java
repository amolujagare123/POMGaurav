//8june
package uilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;

public class PRACTICE {
        @Test (dataProvider = "getData")
        public void loginTest(String name, String contact,String email,String city) throws InterruptedException
        {
            System.out.println(name);
            System.out.println(contact);
            System.out.println(email);
            System.out.println(city);


           /* WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://scriptinglogic.org/request-call-demo-class-online/");
            WebElement name1 = driver.findElement(By.xpath("//input[@placeholder='Name']"));
            name1.sendKeys(name);
            WebElement email1 = driver.findElement(By.xpath("//input[@placeholder='Email']"));
            email1.sendKeys(email);
            WebElement contact1 = driver.findElement(By.xpath("//input[@placeholder='Contact no./ Whatsapp No.']"));
            contact1.sendKeys(contact);
            WebElement city1= driver.findElement(By.xpath("//input[@placeholder='City']"));
            city1.sendKeys(city);
            Thread.sleep(3000);
            driver.close();*/
        }

        @DataProvider
        public Object[][] getData() throws IOException
        {
            //reading the file (getting the file object)
            FileInputStream fileinputstream = new FileInputStream("data\\Scriptingdata.xls");
            HSSFWorkbook work = new HSSFWorkbook(fileinputstream);
            HSSFSheet sheet = work.getSheet("Sheet1");
            int rowCount = sheet.getPhysicalNumberOfRows();
            Object[][] data = new Object[rowCount][4];
            for (int i=1; i<rowCount; i++)
            {
                //getting row object
                HSSFRow row = sheet.getRow(i);

                //name
                HSSFCell name = row.getCell(0);
                if (name==null)                          //to deal with null or blank cell issues
                    data[i][0] = "";
                else {
                    name.setCellType(CellType.STRING); // to handle cell which are not string
                    data[i][0] = name.getStringCellValue(); //will read the string and store the value in array
                }

                //email
                HSSFCell email = row.getCell(1);
                if (email==null)
                    data[i][1] = "" ;
                else {
                    email.setCellType(CellType.STRING);
                    data[i][1] = email.getStringCellValue();
                }

                //contact
                HSSFCell contact = row.getCell(2);
                if (contact==null)
                    data[i][2]="";
                else {
                    contact.setCellType(CellType.STRING);
                    data[i][2] = contact.getStringCellValue();
                }

                //city
                HSSFCell city = row.getCell(3);
                if (city==null)
                    data[i][3]="";
                else {
                    city.setCellType(CellType.STRING);
                    data[i][3] = city.getStringCellValue();
                }
            }
            return data;
            }
        }


