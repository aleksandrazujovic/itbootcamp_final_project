package tests;

import org.testng.annotations.Test;

public class TestAdminCities extends BaseTestPage{

    @Test
    public void visitAdminCities(){
        getHomePage().goToLogInPage();
        getLoginPage().logInHappyFlow("admin@admin.com","12345");
        getHomePage().goToCities();
}
}
