package tests;

import jdk.internal.dynalink.linker.LinkerServices;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;
import java.util.List;

public abstract class BaseTestPage {


    private WebDriver driver;
    private LoginPage loginPage;
    private TestLogin testLogin;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private AdminCities adminCities;
    private Locale locale;
    private EditProfile editProfile;


    public WebDriver getDriver(){
        return  driver;
    }

    public HomePage getHomePage(){
        return homePage;
    }
    public LoginPage getLoginPage(){
        return loginPage;
    }
    public SignUpPage getSignUpPage(){
        return signUpPage;
    }
    public AdminCities getAdminCities(){
        return adminCities;
    }
    public Locale getLocale(){return locale;}
    public EditProfile getEditProfile(){
        return editProfile;
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\bootcamp\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        adminCities = new AdminCities(driver);
        locale = new Locale(driver);
        editProfile = new EditProfile(driver);
    }

    public void baseUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
    }
   // @AfterMethod
   // public void afterMethod(){
       // List<WebElement> header = getHomePage().getHeader();
       // for (int i = 0; i < header.size(); i++){
           // if( header.get(i).getText().equals("LOGOUT")) {
             //   getAdminCities().getLogOutBtn().click();
           // }
       // }

   // }
    @AfterClass
    public void afterClass(){
     //   driver.quit();
    }



}