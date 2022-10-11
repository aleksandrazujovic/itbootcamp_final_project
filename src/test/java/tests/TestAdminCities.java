package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAdminCities extends BaseTest {

    @Test (priority = 1)
    public void visitAdminCities()  throws InterruptedException  {
        String expectedResult1 = "/admin/cities";
        String expectedResult2 = "LOGOUT";

        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getHomePage().goToCities();

        String actualResult1 = getDriver().getCurrentUrl();
        String actualResult2 = getAdminCities().getLogOutBtn().getText();
        Assert.assertTrue(actualResult1.contains(expectedResult1));
        Assert.assertEquals(expectedResult2,actualResult2);
        getHomePage().logOut();
}
    @Test (priority = 2)
    public void createNewCity() throws InterruptedException {
        String expectedResult = "Saved successfully";

        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getHomePage().goToCities();
        getAdminCities().createNewItem("Novi Sad");

        String actualResult = getAdminCities().getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        getHomePage().logOut();

    }
    @Test (priority = 3)
    public void editCity() throws InterruptedException {
        String expectedResult = "Saved successfully";

        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getHomePage().goToCities();
        getAdminCities().getEditBtn().click();
        getAdminCities().getEditField().sendKeys(" - edited");
        getAdminCities().getSaveBtn().click();

        String actualResult = getAdminCities().getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        getHomePage().logOut();

    }
    @Test (priority = 4)
    public void searchCity() throws InterruptedException {
        String expectedResult = "Novi Sad - edited";

        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getHomePage().goToCities();

        String actualResult = getAdminCities().getFirstRow().getText();
        Assert.assertEquals(expectedResult,actualResult);
        getHomePage().logOut();

    }
    @Test (priority = 5)
    public void deleteCity() throws InterruptedException {
        String expectedResult = "Deleted successfully";
        String expectedResult1 = "Novi Sad - edited";

        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getHomePage().goToCities();
        getAdminCities().getDeleteBtn().click();

        String actualResult1 = getAdminCities().getFirstRow().getText();
        Assert.assertEquals(expectedResult1,actualResult1);

        Thread.sleep(1000);
        getAdminCities().getFinalDeleteBtn().click();
        Thread.sleep(1000);

        String actualResult = getAdminCities().getSaveMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        getHomePage().logOut();


    }
}
