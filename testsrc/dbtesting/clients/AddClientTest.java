package dbtesting.clients;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class AddClientTest extends DoLogin {


    @Test(dataProvider = "getData")
    public void addClienttest(String clinetName,String surname,String language,String add1,
                              String add2,String city,String state,String zipcode,String country,
                              String gender ,String bdate,String phoneno,String faxno,
                              String mobile,String email,String web,String vat,
                              String taxcode) throws ParseException, ClassNotFoundException, SQLException {

        ArrayList<String> expected = new ArrayList<>();

        expected.add(clinetName);
        expected.add(surname);
        expected.add(language);
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zipcode);
        expected.add(country);
       // expected.add(gender);
        expected.add(bdate);
        expected.add(phoneno);
        expected.add(faxno);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(taxcode);




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
        //addclient.setGender(gender);
        addclient.setSave();


        Class.forName("com.mysql.cj.jdbc.Driver");

        String url ="jdbc:mysql://localhost:3306/inoiveplane";
        String username ="root";
        String password ="root";

        Connection con = DriverManager.getConnection(url,username,password);

        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+clinetName+"'";

        ResultSet rs = st.executeQuery(sql);


        ArrayList<String> actual = new ArrayList<>();


        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            actual.add(rs.getString("client_country"));
          //  actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }


        Assert.assertEquals(actual,expected);

    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fin=new FileInputStream("data\\Scriptingdata.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fin);
        HSSFSheet sheet=workbook.getSheet("dbTesting");
        HSSFRow row;
        int rowCount =sheet.getPhysicalNumberOfRows();
        Object data[][]=new Object[rowCount-1][18];


        for(int i=0; i<rowCount-1;i++)
        {

            row = sheet.getRow(i+1);

            for(int j=0;j<18;j++)
            {
                HSSFCell element = row.getCell(j);
                element.setCellType(CellType.STRING);
                data[i][j] = element.getStringCellValue();

            }

        }

        return  data;
    }


}
