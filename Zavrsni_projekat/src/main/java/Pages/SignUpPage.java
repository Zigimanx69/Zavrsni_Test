package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFieldForName() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getFieldForEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getFieldForPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getFieldForValidation() {
        return driver.findElement(By.id("confirmPassword"));
    }

}
