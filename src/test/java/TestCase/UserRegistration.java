package TestCase;

import Base.BaseClass;
import Logger.Log;
import PageObjects.RegistrationPage;
import Utilities.ReadConfig;
import Utilities.TakeScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class UserRegistration extends BaseClass {

    WebDriver tdriver;
    ReadConfig readConfig = new ReadConfig();
    RegistrationPage registrationPage;

    @Test
    public void userRegTest() throws IOException {

        ReadConfig readConfig = new ReadConfig();
        //Started the login test
        Log.info("Started userRegTest");
        //Create an object for LoginPage
        Log.info("Attempting to register a user ");
        registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName(readConfig.setFirstname());
        registrationPage.enterLastName(readConfig.setLastName());
//        registrationPage.enterAddress(readConfig.setAddress());
        registrationPage.enterEmail(readConfig.setEmailAddress());
        registrationPage.enterPhoneNumber(readConfig.setPhoneNumber());
        registrationPage.chooseGender();
        registrationPage.selectHobby();
//        registrationPage.selectLanguage(readConfig.getLanguage()); //UnexpectedTagNameException: Element should have been "select" but was "div"
        registrationPage.selectSkills(readConfig.getSkills());
        registrationPage.country();
//        registrationPage.selectCountry(readConfig.getCountry()); //UnexpectedTagNameException: Element should have been "select" but was "span"
        registrationPage.selectDOB();
        registrationPage.enterPassword_and_confirmPassword(readConfig.setPassword());
//        registrationPage.uploadImage(readConfig.getImagePath());
        registrationPage.clickSubmit();

        SoftAssert softassert = new SoftAssert();
        if (driver.getCurrentUrl().equals("https://demo.automationtesting.in/Dashboard.html")) {
            softassert.assertTrue(true);
            Log.info("Test Passed! Registration Successful!");
        } else {
            softassert.assertFalse(false);
            Log.info("Test Failed! Registration failed!");
            TakeScreenshot.captureScreenShot(driver, "userRegistrationTest");
        }
        softassert.assertAll();
        Log.info("Completed UserRegistrationTest");

    }
}
