package tests;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEditProfile extends BaseTest {


    @Test
    public void editProfile(){
        String expectedResult = "Profile saved successfuly";

        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getEditProfile().getMyProfileBtn().click();

        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String city = "Bucaramanga";
        String country = faker.country().name();
        String twitter = "http://" + faker.internet().domainName();
        String github = "http://" + faker.internet().domainName();

        getEditProfile().editProfile(name,phone,city,country,twitter,github);

        String actualName = getEditProfile().getName().getAttribute("value");
        String actualPhone = getEditProfile().getPhone().getAttribute("value");
        String actualCity = getEditProfile().getCity().getAttribute("value");
        String actualCountry = getEditProfile().getCountry().getAttribute("value");
        String actualTwitter = getEditProfile().getTwitter().getAttribute("value");
        String actualGithub = getEditProfile().getGitHub().getAttribute("value");

        Assert.assertEquals(name,actualName);
        Assert.assertEquals(phone,actualPhone);
        Assert.assertEquals(city, actualCity);
        Assert.assertEquals(country,actualCountry);
        Assert.assertEquals(twitter,actualTwitter);
        Assert.assertEquals(github,actualGithub);

        String actualResult = getEditProfile().getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));




    }

}
