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
        String actualResult = getLoginPage().getMessageUserDoesNotExist().getText();
        Assert.assertEquals(actualResult,expectedResult);

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult1 = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult1,expectedResult1);
    }

    @Test
    public void errorsWithValidEmailInvalidPass(){
        String expectedResult = "Wrong password";
        getHomePage().goToLogInPage();
        getLoginPage().logInWithValidEmailInvalidPass("admin@admin.com");
        String actualResult = getLoginPage().getMessageWrongPass().getText();
        Assert.assertEquals(actualResult,expectedResult);

        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult1 = getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult1,expectedResult1);
    }

    @Test
    public void loginWithValidData() throws InterruptedException {
        String expectedResult = "/home";
        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        Thread.sleep(1000);
        String actualResult = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
        getHomePage().logOut();
    }


    @Test
    public void logOut(){
        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        boolean expectedResult1 = true;
        boolean actualResult1 = getHomePage().getLogOutBtn().isDisplayed();
        Assert.assertEquals(expectedResult1,actualResult1);

        getHomePage().logOut();

        String expectedResult2 = "/login";
        String actualResult2 = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains(expectedResult2));

        getDriver().get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult3 = "/login";
        String actualResult3 = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult3.contains(expectedResult3));

    }




}
