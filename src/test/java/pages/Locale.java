package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Locale extends BasePage{

    private By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By esBtn = By.xpath("/html/body/div/div[3]/div/div[2]");
    private By esText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public Locale(WebDriver driver) {
        super(driver);
    }

    public WebElement getEsBtn(){
        return getDriver().findElement(esBtn);
    }

    public WebElement getLanguageBtn(){
        return getDriver().findElement(languageBtn);
    }
    public WebElement getEsText(){
        return getDriver().findElement(esText);
    }

    public void setES() throws InterruptedException {
        getLanguageBtn().click();
        Thread.sleep(1000);
        getEsBtn().click();
    }


}
