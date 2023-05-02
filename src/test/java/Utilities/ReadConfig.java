package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    // Properties Class
    Properties pro;
    private final String filePath= "src/test/resources/Configuration/Config.properties";



    // Constructor
    public ReadConfig()
    {
        // Creating File object
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            pro = new Properties();
            try {
                pro.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + filePath);
        }
    }
    // Methods to read data from config.properties

    public String setDriverPath(){
        String driverPath = pro.getProperty("chromePath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }


    public String setApplicationURL() { // ok - add new url in config.properties

        String url=pro.getProperty("baseUrl"); // Value from config.properties stored in url variable
        return url;
    }

    public String setFirstname() {
        String firstName=pro.getProperty("firstName");
        return firstName;
    }

    public String setLastName() {
        String lastName = pro.getProperty("lastName");
        return lastName;
    }

    public String setAddress() {
        String address =pro.getProperty("address");
        return address;
    }

    public String setEmailAddress() {
        String emailAddress = pro.getProperty("emailAddress");
        return emailAddress;
    }

    public String setPhoneNumber() {
        String phoneNumber = pro.getProperty("phoneNumber");
        return phoneNumber;
    }

    public String setPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getbrowser() {
        String browser = pro.getProperty("browser");
        return browser;
    }

    public String getImagePath() {
        String imagePath = pro.getProperty("imagePath");
        return imagePath;

    }

    public String getLanguage() {
        String language = pro.getProperty("language");
        return language;
    }

    public String getSkills() {
        String skills = pro.getProperty("skills");
        return skills;
    }

    public String getCountry() {
        String selectCountry = pro.getProperty("selectCountry");
        return selectCountry;
    }

    public String getYear() {
        String year = pro.getProperty("year");
        return year;
    }

    public String getMonth() {
        String month = pro.getProperty("month");
        return month;
    }

    public String getDay() {
        String day = pro.getProperty("day");
        return day;
    }

}
