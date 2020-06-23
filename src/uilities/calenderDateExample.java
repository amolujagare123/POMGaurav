package uilities;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static uilities.Drivers.getDriver;

public class calenderDateExample {

    public static void main(String[] args) throws ParseException {
        WebDriver driver = getDriver(Drivers.DriverTypes.CHROME);

        driver.get("https://jqueryui.com/datepicker/");

        WebElement iframe = driver.findElement(By.className("demo-frame"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.id("datepicker")).click();

        String setDateStr = "01/12/2020";

        SimpleDateFormat sdSetDate = new SimpleDateFormat("dd/MM/yyyy");

        Date setDate  = sdSetDate.parse(setDateStr);

        // MMMM yyyy
        String currdateStr = driver.findElement(By.className("ui-datepicker-title")).getText();
        System.out.println(currdateStr);

        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currdateStr);

  // joda date jar      https://jar-download.com/artifacts/joda-time/joda-time/2.9.4/source-code

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();

        System.out.println(monthDiff);

        boolean monthDiffStatus=false;

        if(monthDiff>0)
            monthDiffStatus=true;

        for(int i=0 ;i<monthDiff;i++)
        {
            if (monthDiffStatus)
                driver.findElement(By.xpath("//span[text()='Next']")).click();
            else
                driver.findElement(By.xpath("//span[text()='Prev']")).click();
        }
//a[text()='1']

        String setDaystr = new SimpleDateFormat("dd").format(setDate);
        System.out.println(setDaystr);

        int setDayInt  = Integer.parseInt(setDaystr);
        System.out.println(setDayInt);


        driver.findElement(By.xpath("//a[text()='"+setDayInt+"']")).click();

    }
}
