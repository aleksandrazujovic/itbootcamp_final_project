package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class TestLogin extends BaseTestPage{

    @Test
    public void visabilityOfLoginInUrl(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        getHomePage().goToLogInPage();
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void inputType(){
        String expectedResult1 = "email";
        String expectedResult2 = "password";
        getHomePage().goToLogInPage();
        String actualResult1 = getLoginPage().getEmailField().getAttribute("type").toString();
        Assert.assertEquals(expectedResult1,actualResult1);
        String actualResult2 = getLoginPage().getPasswordField().getAttribute("type").toString();
        Assert.assertEquals(expectedResult2,actualResult2);
    }

    @Test
    public void errorsWhenUserDoesNotExist() throws InterruptedException {
        String expectedResult = "User does not exists";
        getHomePage().goToLogInPage();
        getLoginPage().logInWithFaker();
        String actualResult = getLoginPage().getMessage().getText();
        Assert.assertEquals(actualResult,expectedResult);
    }





}
