package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;
import java.util.List;

public abstract class BaseTest {


    private WebDriver driver;
    private LoginPage loginPage;
    private TestLogin testLogin;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private AdminCities adminCities;
    private Locale locale;
    private EditProfile editProfile;
    protected Faker faker;
    private WebDriverWait driverWait;


    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public AdminCities getAdminCities() {
        return adminCities;
    }

    public Locale getLocale() {
        return locale;
    }

    public EditProfile getEditProfile() {
        return editProfile;
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\bootcamp\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        adminCities = new AdminCities(driver, driverWait);
        locale = new Locale(driver, driverWait);
        editProfile = new EditProfile(driver, driverWait);
        faker = new Faker();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    private String baseUrl() {
        return "https://vue-demo.daniel-avellaneda.com";
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl());
    }

    @AfterClass
    public void afterClass() {
       // driver.quit();
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }


}