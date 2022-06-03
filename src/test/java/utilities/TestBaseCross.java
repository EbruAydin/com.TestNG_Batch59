package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {

    protected WebDriver driver;

    @Parameters("browser")//burasi browseri getirecek optional da BeforeMethod'a gecirmis olacak getirileni

    @BeforeMethod
    public void setUp(@Optional String browser){//parameters notasyonu calisabilmesi icin optional'i buraya eklemeliyi

        driver= DriverCross.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown(){
       DriverCross.closeDriver();
    }
}
