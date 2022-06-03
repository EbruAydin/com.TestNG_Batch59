package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    AmazonPage amazonPage;



    @Test
    public void test01() {

        //amazon anasayfaya gidin
        amazonPage = new AmazonPage();
        //nutella icin arama yapalim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim

        String expectedKelime = "Nutella";
        String aramaSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(aramaSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object [][] arananKelimeArrayi={{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};

        return arananKelimeArrayi;
    }
    @Test(dataProvider = "AranacakKelimeler")//burasi bir liste
    public void dataProviderTest(String arananKelime) {//bu da listeden alinacak kelimeler
        //amazon anasayfaya gidin
        amazonPage = new AmazonPage();
        //nutella icin arama yapalim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        //sonuclarin aradigimiz kelimeleri icerdigini test edelim
        String expectedKelime = arananKelime;
        String aramaSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(aramaSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();
    }

}
