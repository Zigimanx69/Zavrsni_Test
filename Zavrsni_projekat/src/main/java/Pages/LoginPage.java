package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFieldForEmail() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getFieldForPassword() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getButtonSubbmitLogin() {
        return driver.findElement(By.xpath("//*[@type = 'submit']"));
    }

    public WebElement getTypeofFiledName(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getTypeOfFieldCity(){
        return driver.findElement(By.id("city"));
    }

    public WebElement getTypeOfFiledCountry(){
        return driver.findElement(By.id("country"));
    }

    public WebElement getUrlTwiter(){
        return driver.findElement(By.id("urlTwitter"));
    }

    public WebElement getGitHubb(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public WebElement getPhone(){
        return driver.findElement(By.id("phone"));
    }
    public String getDisable(){
        return driver.findElement(By.id("email")).getText();
    }

    public WebElement getSave(){
        return driver.findElement(By.xpath("//*[contains(@type,'submit')]"));
    }
}
