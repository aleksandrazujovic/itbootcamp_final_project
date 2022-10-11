package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage extends BasePage {

    private By goToLogin = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By LogOutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    private By signUpBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesBtn = By.className("btnAdminCities");
    private By header = By.xpath("//*[@id=\"app\"]/div/div/header/div");


    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getGoToLogin() {
        return getDriver().findElement(goToLogin);
    }

    public WebElement getLogOutBtn() {
        return getDriver().findElement(LogOutBtn);
    }

    public WebElement getCitiesBtn() {
        return getDriver().findElement(citiesBtn);
    }

    public List<WebElement> getHeader() {
        return getDriver().findElements(header);
    }

    public void goToLogInPage() {
        getGoToLogin().click();
    }


    public void logOut() {
        getLogOutBtn().click();
    }

    public WebElement getSignUpBtn() {
        return getDriver().findElement(signUpBtn);
    }

    public void goToSignUp() {
        getSignUpBtn().click();
    }

    public void goToCities() throws InterruptedException {
        getAdminBtn().click();
        Thread.sleep(2000);
        getCitiesBtn().click();

    }


}
