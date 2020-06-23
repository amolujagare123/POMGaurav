package uilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

    public static Properties getPropertyObject() throws IOException {
        // 1. read the file (.properties)
        FileInputStream fp  = new FileInputStream("Resources\\InvoicePlane.properties");

        //2. create object of properties class
        Properties prop = new Properties();

        // 3. load the file
        prop.load(fp);

        return prop;
    }

   /*
    public String getMyUrl() throws IOException {

        return  getPropertyObject().getProperty("url");

    }
    */


    public static String getMyUrl() throws IOException {

        Properties prp =  getPropertyObject();

        String myurl  =  prp.getProperty("url");

        return  myurl;

    }

    public static String getuserName() throws IOException {
        Properties prp =  getPropertyObject();

        String myurl  =  prp.getProperty("username");

        return  myurl;
    }

}
