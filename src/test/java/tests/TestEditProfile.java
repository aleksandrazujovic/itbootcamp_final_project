package tests;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEditProfile extends BaseTestPage{


    @Test
    public void editProfile(){
        String expectedResult = "Profile saved successfuly";
        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getEditProfile().editProfile();
        String actualResult = getEditProfile().getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
