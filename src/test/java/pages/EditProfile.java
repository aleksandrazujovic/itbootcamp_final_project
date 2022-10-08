package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Factory;

public class EditProfile extends BasePage{

    private By myProfileBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By name = By.id("name");
    private By phone = By.id("phone");
    private By city = By.id("city");
    private By country = By.id("country");
    private By twitter = By.name("urlTwitter");
    private By github = By.name("urlGitHub");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By saveMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    private By ny = By.xpath("//*[@id=\"list-item-473-15\"]/div/div");
    public EditProfile(WebDriver driver) {
        super(driver);
    }

    public WebElement getMyProfileBtn(){
        return getDriver().findElement(myProfileBtn);
    }

    public WebElement getName(){
        return getDriver().findElement(name);
    }
    public WebElement getPhone(){
        return getDriver().findElement(phone);
    }
    public WebElement getCity(){
        return getDriver().findElement(city);
    }
    public WebElement getCountry(){
        return getDriver().findElement(country);
    }
    public WebElement getTwitter(){
        return getDriver().findElement(twitter);
    }
    public WebElement getGitHub(){
        return getDriver().findElement(github);
    }
    public WebElement getSaveBtn(){
        return getDriver().findElement(saveBtn);
    }
    public WebElement getSaveMessage(){
        return getDriver().findElement(saveMessage);
    }
    public WebElement getNy(){
        return getDriver().findElement(ny);
    }
    public void editProfile(){
        Faker faker = new Faker();
        getMyProfileBtn().click();

        getName().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getName().sendKeys(faker.name().firstName());

        getPhone().click();
        getPhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhone().sendKeys(faker.phoneNumber().phoneNumber());

        getCity().click();
        getCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCity().sendKeys(faker.address().city());

        getCountry().click();
        getCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountry().sendKeys(faker.country().name());

        getTwitter().click();
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitter().sendKeys("http://" + faker.name().firstName() + ".com");

        getGitHub().click();
        getGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHub().sendKeys("http://" + faker.name().firstName() + ".name");

        getSaveBtn().click();

    }

}
