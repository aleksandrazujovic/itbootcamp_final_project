package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSignUp extends BaseTest {

    @Test(priority = 1)
    public void visabilityOfSignUpInUrl() {
        String expectedResult = "/signup";

        getHomePage().goToSignUp();

        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 2)
    public void inputType() {
        String expectedResult1 = "email";
        String expectedResult2 = "password";
        String expectedResult3 = "password";

        getHomePage().goToSignUp();

        String actualResult1 = getSignUpPage().getEmailField().getAttribute("type");
        Assert.assertEquals(expectedResult1, actualResult1);
        String actualResult2 = getSignUpPage().getPasswordField().getAttribute("type");
        Assert.assertEquals(expectedResult2, actualResult2);
        String actualResult3 = getSignUpPage().getConfirmPassField().getAttribute("type");
        Assert.assertEquals(expectedResult3, actualResult3);

    }

    @Test(priority = 3)
    public void userAlreadyExist() {
        String expectedResult1 = "E-mail already exists";
        getHomePage().goToSignUp();
        getSignUpPage().signUpWithAlreadyExistEmail("Test Test", "admin@admin.com", "12345", "12345");
        String actualResult1 = getSignUpPage().getErrorMessage().getText();
        Assert.assertEquals(expectedResult1, actualResult1);

        String expectedResult2 = "/signup";
        String actualResult2 = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

    @Test(priority = 4)
    public void validData() throws InterruptedException {
        String expectedResult = "IMPORTANT: Verify your account";

        getHomePage().goToSignUp();
        getSignUpPage().signUpValidData("Aleksandra Zujovic", "111000", "111000");
        Thread.sleep(2000);

        String actualResult = getSignUpPage().getImportantMessage().getText();
        Assert.assertEquals(expectedResult, actualResult);

    }


}
