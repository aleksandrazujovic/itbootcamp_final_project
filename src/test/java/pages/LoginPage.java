package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  extends BasePage{


    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By messageUserDoesNotExist = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul");
    private By messageWrongPass = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailField(){
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField(){
        return  getDriver().findElement(passwordField);
    }

    public WebElement getLoginBtn(){
        return  getDriver().findElement(loginBtn);
    }

    public WebElement getMessageUserDoesNotExist(){
        return getDriver().findElement(messageUserDoesNotExist);
    }
    public WebElement getMessageWrongPass(){
        return getDriver().findElement(messageWrongPass);
    }

    public void logInWithFaker(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }
    public void logInWithValidEmailInvalidPass(String email){
        Faker faker = new Faker();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(faker.internet().password());
        getLoginBtn().click();

    }

    public void logInHappyFlow(String emailField, String password){
        getEmailField().sendKeys(emailField);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();

    }

}
