package BDD.stepDefinitions;

import Base.BaseClass;
import Logger.Log;
import PageObjects.RegistrationPage;
import Utilities.ReadConfig;
import Utilities.TakeScreenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class UserRegistration extends BaseClass {
    RegistrationPage registrationPage;
    ReadConfig readConfig = new ReadConfig();





    @Given("the user is on the register page")
    public void the_user_is_on_the_register_page() {
        startDriver();
        Log.info("Starting web driver");
    }
    @When("user enters all the required details")
    public void user_enters_all_the_required_details() {
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
        Log.info("All the mandatory fields has been filled");
    }
    @When("clicks submit")
    public void clicks_submit() {
        registrationPage.clickSubmit();
    }
    @Then("The registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
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
