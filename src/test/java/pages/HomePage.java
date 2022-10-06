package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage {

    private By goToLogin = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By LogOutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    private By signUpBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");



    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getAdminBtn(){
        return getDriver().findElement(adminBtn);
    }
    public WebElement getGoToLogin(){
        return getDriver().findElement(goToLogin);
    }

    public void goToLogInPage(){
        getGoToLogin().click();
    }
    public WebElement getLogOutBtn(){
        return getDriver().findElement(LogOutBtn);
    }

    public void logOut(){
        getLogOutBtn().click();
    }
    public WebElement getSignUpBtn(){
        return getDriver().findElement(signUpBtn);
    }

    public void goToSignUp(){
        getSignUpBtn().click();
    }

    public void goToCities(){
        getAdminBtn().click();
        Select drpCities = new Select(getAdminBtn());
        String cities = getDriver().findElement(By.xpath("//*[@id=\"list-item-155\"]")).getText();
        drpCities.selectByVisibleText(cities);
    }



}
