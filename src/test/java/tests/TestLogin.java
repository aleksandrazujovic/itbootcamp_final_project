package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void visabilityOfLoginInUrl(){
        String expectedResult = "/login";
        getHomePage().goToLogInPage();
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void inputType(){
        String expectedResult1 = "email";
        String expectedResult2 = "password";

        getHomePage().goToLogInPage();

        String actualResult1 = getLoginPage().getEmailField().getAttribute("type");
        Assert.assertEquals(expectedResult1,actualResult1);
        String actualResult2 = getLoginPage().getPasswordField().getAttribute("type");
        Assert.assertEquals(expectedResult2,actualResult2);
    }

    @Test
    public void errorsWhenUserDoesNotExist() throws InterruptedException {
        String expectedResult = "User does not exists";
        String expectedResult1 = "/login";

        getHomePage().goToLogInPage();
        getLoginPage().logInWithFaker();

        String actualResult = getLoginPage().getMessageUserDoesNotExist().getText();
        Assert.assertEquals(actualResult,expectedResult);

        String actualResult1 = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
    }

    @Test
    public void errorsWithValidEmailInvalidPass(){
        String expectedResult = "Wrong password";
        String expectedResult1 = "/login";

        getHomePage().goToLogInPage();
        getLoginPage().logInWithValidEmailInvalidPass("admin@admin.com");

        String actualResult = getLoginPage().getMessageWrongPass().getText();
        Assert.assertEquals(actualResult,expectedResult);

        String actualResult1 = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
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
