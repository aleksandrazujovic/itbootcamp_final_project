package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTestPage {


    private WebDriver driver;
    private LoginPage loginPage;
    private TestLogin testLogin;
    private HomePage homePage;


    public WebDriver getDriver(){
        return  driver;
    }

    public HomePage getHomePage(){
        return homePage;
    }
    public LoginPage getLoginPage(){
        return loginPage;
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\bootcamp\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);


    }

    public void baseUrl() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @AfterClass
    public void afterClass(){
     //   driver.quit();
    }



}