package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends  BasePage{

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPassField = By.id("confirmPassword");

    private By signUpBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");

    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul");
    private By importantMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public WebElement getImportantMessage(){
        return getDriver().findElement(importantMessage);
    }

    public WebElement getErrorMessage(){
        return getDriver().findElement(errorMessage);
    }

    public WebElement getSignUpBtn(){
        return getDriver().findElement(signUpBtn);
    }

    public WebElement getNameField(){
        return  getDriver().findElement(nameField);
    }

    public WebElement getEmailField(){
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField(){
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPassField(){
        return getDriver().findElement(confirmPassField);
    }

    public void signUpWithAlreadyExistEmail(String name, String email, String password, String confirmPass){
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPassField().sendKeys(confirmPass);
        getSignUpBtn().click();
    }

    public void signUpValidData(String name, String password, String confirmPass){
        getNameField().sendKeys(name);
        getEmailField().sendKeys(getFaker().internet().emailAddress());
        getPasswordField().sendKeys(password);
        getConfirmPassField().sendKeys(confirmPass);
        getSignUpBtn().click();
    }
}
