package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locale extends BasePage {

    private By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By esBtn = By.className("btnES");
    private By esText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    private By enBtn = By.className("btnEN");
    private By enText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    private By frBtn = By.className("btnFR");
    private By frText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public Locale(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEsBtn() {
        return getDriver().findElement(esBtn);
    }

    public WebElement getLanguageBtn() {
        return getDriver().findElement(languageBtn);
    }

    public WebElement getEsText() {
        return getDriver().findElement(esText);
    }

    public WebElement getEnBtn() {
        return getDriver().findElement(enBtn);
    }

    public WebElement getEnText() {
        return getDriver().findElement(enText);
    }

    public WebElement getFrBtn() {
        return getDriver().findElement(frBtn);
    }

    public WebElement getFrText() {
        return getDriver().findElement(frText);
    }

    public void setES() throws InterruptedException {
        getLanguageBtn().click();
        Thread.sleep(1000);
        getEsBtn().click();
    }

    public void setEN() throws InterruptedException {
        getLanguageBtn().click();
        Thread.sleep(1000);
        getEnBtn().click();
    }

    public void setFR() throws InterruptedException {
        getLanguageBtn().click();
        Thread.sleep(1000);
        getFrBtn().click();
    }


}
