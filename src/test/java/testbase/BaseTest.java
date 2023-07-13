package testbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import propertyreader.PropertyReader;
import utilities.Utility;

public class BaseTest extends Utility {

    String browser= PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }
    @AfterMethod
    public void tearDown(){
        //closeBrowser();
    }
}