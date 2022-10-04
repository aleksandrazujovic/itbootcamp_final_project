package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePage extends BasePage {

    private By goToLogin = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");



    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getGoToLogin(){
        return getDriver().findElement(goToLogin);
    }

    public void goToLogInPage(){
        getGoToLogin().click();
    }

}
