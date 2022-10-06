package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class TestSignUp extends BaseTestPage {

    @Test
    public void visabilityOfSignUpInUrl(){
        getHomePage().goToSignUp();
        String expectedResult = "/signup";
        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void inputType(){
        String expectedResult1 = "email";
        String expectedResult2 = "password";
        String expectedResult3 = "password";

        getHomePage().goToSignUp();

        String actualResult1 = getSignUpPage().getEmailField().getAttribute("type").toString();
        Assert.assertEquals(expectedResult1,actualResult1);
        String actualResult2 = getSignUpPage().getPasswordField().getAttribute("type").toString();
        Assert.assertEquals(expectedResult2,actualResult2);
        String actualResult3 = getSignUpPage().getConfirmPassField().getAttribute("type").toString();
        Assert.assertEquals(expectedResult3,actualResult3);

    }

    @Test
    public void userAlreadyExist(){
        String expectedResult1 = "E-mail already exists";
        getHomePage().goToSignUp();
        getSignUpPage().signUpWithAlreadyExistEmail("Test Test","admin@admin.com","12345","12345");
        String actualResult1 = getSignUpPage().getErrorMessage().getText();
        Assert.assertEquals(expectedResult1,actualResult1);

        String expectedResult2 = "/signup";
        String actualResult2 = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

    @Test
    public void validData() throws InterruptedException {
        String expectedResult = "IMPORTANT: Verify your account";
        getHomePage().goToSignUp();
        getSignUpPage().signUpValidData("Aleksandra Zujovic","111000","111000");
        Thread.sleep(2000);
        String actualResult = getSignUpPage().getImportantMessage().getText();
        Assert.assertEquals(expectedResult,actualResult);
    }


}
