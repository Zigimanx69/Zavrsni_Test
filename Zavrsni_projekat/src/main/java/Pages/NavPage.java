package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("btnLogin"));
    }

    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//*[@aria-current= 'page']"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnAbout')]"));
    }

    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnProfile')]"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]"));

    }

    public WebElement getCitiesLink() {
        return driver.findElement(By.linkText("Cities"));

    }

    public WebElement getAdminUsers() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnAdminUsers')]"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnLogout')]"));
    }

    public WebElement getButttonForLanguage() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnLocaleActivation')]"));
    }

    public WebElement getEnButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnEN')]"));
    }

    public WebElement getEsButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnES')]"));

    }

    public WebElement getFrButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnFR')]"));

    }

    public WebElement getCnButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnCN')]"));

    }

    public WebElement getHeaderFromChangedLanguage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'container')]/div/div/h1"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//a[contains(@href, '/signup')]"));
    }

    public WebElement getSignUpAfterInput(){
        return driver.findElement(By.xpath("//button[@type = 'submit']"));
    }
}
