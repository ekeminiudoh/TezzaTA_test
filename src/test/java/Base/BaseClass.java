package Base;

import Utilities.ReadConfig;
import Utilities.TakeScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Logger.Log;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    /*
     * Initialise Webdriver, properties, xls ,creating db connection, generating
     * selenium.log
     */

    public static WebDriver driver;



    @BeforeSuite
    public static void startDriver(){
        ReadConfig readConfig = new ReadConfig();
        if (readConfig.getbrowser().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.setDriverPath());
            driver = new ChromeDriver();
            Log.info("chrome browser launched");
        } else if (readConfig.getbrowser().equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "src/test/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (readConfig.getbrowser().equals("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "src/test/resources/Drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        // navigate to app url
        driver.get(readConfig.setApplicationURL());
        driver.manage().window().maximize();

        // Global implicit Wait
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        // load excel file
        // excel = new Xls_Reader(
        // System.getProperty("user.dir") + "\\src\\test\\java\\busyqa\\properties\\testdata.xlsx");
        // app_logs.debug("loading the excel file");

    }

    @AfterSuite
    public  void  tearDown() {
        driver.close();
        Log.info("Test Completed Successfully");

        driver.quit();

    }


    @AfterMethod
    public void screenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screen Shot.....");
            TakeScreenshot.captureScreenShot(driver, testResult.getMethod().getMethodName());
        }
    }

}
