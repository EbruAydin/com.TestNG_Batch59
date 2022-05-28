package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {

    /*
       Bugune kadar TestBase classina extends ederek kullandigimiz
       driver yerine bundan sonra Driver class'indan kullanacagimiz getDriver static
       method'unu kullanacagiz

       Driver.getDriver() ---->IN
       driver----------->OUT
        */

    @Test
    public void test01(){
        Driver.getDriver().get("http://wwww.amazon.com");
        Driver.getDriver().get("http://www.bestbuy.com");
        Driver.getDriver().get("http://www.facebook.com");

        Driver.closeDriver();

    }
}
