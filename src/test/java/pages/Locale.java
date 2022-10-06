package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locale extends BasePage{

    private By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");


    public Locale(WebDriver driver) {
        super(driver);
    }


}
