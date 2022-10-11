package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAuthRoutes extends BaseTest {

    @Test
    public void visitsToHome(){
        String expectedResult = "/login";

        getDriver().get("https://vue-demo.daniel-avellaneda.com/home");

        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test
    public void  visitsToProfile(){
        String expectedResult = "/login";

        getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");

        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test
    public void visitsToAdminCities(){
        String expectedResult = "/login";

        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test
    public void visitsToAdminUsers(){
        String expectedResult = "/login";

        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");

        String actualResult = getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }



}
