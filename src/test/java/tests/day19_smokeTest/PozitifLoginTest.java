package tests.day19_smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    HotelMyCampPage obj=new HotelMyCampPage();
    @Test
    public void test01(){

        /*
        Driver obj=new Driver();
        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        Driver constructor'i private yaptigimiz icin buna artik gerek kalmadi
        cunku hata verir. obje uretilemez zaten ki amacimiz bu, yani obje uretimini engellemek
         */



            //https://www.hotelmycamp.com adresine gidin
            Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

            Actions action=new Actions(Driver.getDriver());

            //login butonuna basin
            action
                    .click(obj.loginTusuElementi)
                    .perform();

            //test data userName:manager
            //test data password:Manager1!

            action
                    .click(obj.userName)
                    .sendKeys(ConfigReader.getProperty("htTrueUsername"))
                    .sendKeys(Keys.TAB)
                    .sendKeys(ConfigReader.getProperty("htTruePassword"))
                    .sendKeys(Keys.ENTER)
                    .perform();

            //degerler girildiginde sayfaya basarili bir sekilde girildigini test edin.

            action.
                    moveToElement(obj.userNameAferLogin)
                    .perform();

            Assert.assertTrue(obj.logOutElementi.isDisplayed());

            Driver.closeDriver();
        }
    }


