package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCities extends BasePage {

    private By logOutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By nameField = By.xpath("//*[@id=\"name\"]");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By saveMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By editBtn = By.xpath("//*[@id=\"edit\"]/span");
    private By editField = By.xpath("//*[@id=\"name\"]");
    private By firstRow = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By searchField = By.xpath("//*[@id=\"search\"]");
    private By deleteBtn = By.xpath("//*[@id=\"delete\"]");
    private By finalDeleteBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]");

    public AdminCities(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogOutBtn() {
        return getDriver().findElement(logOutBtn);
    }

    public WebElement getNewItemBtn() {
        return getDriver().findElement(newItemBtn);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public WebElement getEditBtn() {
        return getDriver().findElement(editBtn);
    }

    public WebElement getEditField() {
        return getDriver().findElement(editField);
    }

    public WebElement getFirstRow() {
        return getDriver().findElement(firstRow);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public WebElement getDeleteBtn() {
        return getDriver().findElement(deleteBtn);
    }

    public WebElement getFinalDeleteBtn() {
        return getDriver().findElement(finalDeleteBtn);
    }

    public void createNewItem(String name) {
        getNewItemBtn().click();
        getNameField().sendKeys(name);
        getSaveBtn().click();
    }
}
