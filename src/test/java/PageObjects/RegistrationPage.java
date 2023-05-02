package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Base.BaseClass.driver;

public class RegistrationPage extends BasePage {

    WebDriver tdriver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        tdriver = driver;
        PageFactory.initElements(driver, this);

    }


    public void enterFirstName(String firstname){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.clear();
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.clear();
        lastName.sendKeys(lastname);
    }

    public void enterAddress(String address) {
//        Address.clear();
        address_field.sendKeys(address);
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void enterPhoneNumber(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(phoneNumber));
        phoneNumber.clear();
        phoneNumber.sendKeys(phone);
    }

    public void chooseGender() {gender_Male.click();}
    public boolean confirmMaleGenderBtn(){gender_Male.isEnabled();
        return true;
    }
    public boolean confirmFemaleGenderBtn(){gender_Female.isEnabled();
        return true;
    }
    public boolean selectHobby(){hobbies_Movies.isSelected(); return true;}

    public void selectLanguage(String text) {
        Select dropLang = new Select(select_language);
        dropLang.selectByValue(text);
    }

    public void selectSkills(String text) {
        Select dropSkills = new Select(Skills_dropdown);
        dropSkills.selectByVisibleText(text);
    }

    public boolean country() {country.isEnabled(); return true;}

    public void selectCountry(String text){
        Select country = new Select(select_country);
        country.selectByVisibleText(text);
    }

    public void selectDOB() {
        Select year = new Select(DOB_year);
        Select month = new Select(DOB_month);
        Select day = new Select(DOB_day);
        year.selectByVisibleText("1984");
        month.selectByVisibleText("September");
        day.selectByVisibleText("17");
    }

    public void enterPassword_and_confirmPassword(String password){
        Password.clear();
        Password.sendKeys(password);
        confirm_password.clear();
        confirm_password.sendKeys(password);
    }

    public void uploadImage(String file){
        upload_Image.sendKeys(file);
    }

    public void clickSubmit() {
        submit_btn.click();
    }




    @FindBy(xpath = "//input[@placeholder='First Name']")
    @CacheLookup
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    @CacheLookup
    WebElement lastName;

    @FindBy(css = ".form-control.ng-pristine.ng-valid.ng-touched")
    @CacheLookup
    WebElement address_field;

    @FindBy(xpath = "//input[@type='email']")
    @CacheLookup
    WebElement emailAddress;

    @FindBy(xpath = "//input[@type='tel']")
    @CacheLookup
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@value='Male']")
    @CacheLookup
    WebElement gender_Male;

    @FindBy(xpath = "//input[@value='FeMale']")
    @CacheLookup
    WebElement gender_Female;

    @FindBy(xpath = "//input[@id='checkbox2']")
    @CacheLookup
    WebElement hobbies_Movies;

    @FindBy(id= "msdd")
    @CacheLookup
    WebElement select_language;

    @FindBy(xpath = "//select[@id='Skills']")
    @CacheLookup
    WebElement Skills_dropdown;

    @FindBy(xpath = "//select[@id='countries']")
    @CacheLookup
    WebElement country;

    @FindBy(xpath = "//span[@role='combobox']")
    @CacheLookup
    WebElement select_country;

    @FindBy(xpath = "//select[@id='yearbox']")
    @CacheLookup
    WebElement DOB_year;

    @FindBy(xpath = "//select[@placeholder='Month']")
    @CacheLookup
    WebElement DOB_month;

    @FindBy(xpath = "//select[@id='daybox']")
    @CacheLookup
    WebElement DOB_day;

    @FindBy(xpath = "//input[@id='firstpassword']")
    @CacheLookup
    WebElement Password;

    @FindBy(xpath = "//input[@id='secondpassword']")
    @CacheLookup
    WebElement confirm_password;

    @FindBy(xpath = "//button[@id='submitbtn']")
    @CacheLookup
    WebElement submit_btn;

    @FindBy(xpath = "//button[@id='Button1']")
    @CacheLookup
    WebElement refresh_btn;

    @FindBy(id = "imagesrc")
    @CacheLookup
    WebElement upload_Image;

}
