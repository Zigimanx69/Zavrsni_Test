package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {

    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUp() {
        WebElement popUp = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'error')]")));
    }

    public String getElementTextMessage() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();

    }

    public String getVerifyAccount() {

        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]")).getText();
    }

    public void getDeleteDialogtobeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));
    }

    public WebElement getCloseButtonPopUp() {
        return driver.findElement(By.className("btnClose"));
    }

    public String getTextSaveSucssesful() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")).getText();
    }


    public WebElement getDialogDeleteBUtton() {
        return driver.findElement(By.xpath("//button[contains(@class,'text--lighten3')]"));
    }


    public String getDeleteSuccsefull() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")).getText();
    }

    public void waitPopUpforLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div")));
    }
    public String getTextEmailExixst(){
       return driver.findElement(By.xpath("//div[contains(@class,'error')]")).getText();
    }
    public WebElement getMyProfileEmailCOnfirmation(){
        return driver.findElement(By.id("email"));
    }

    public String getTextSavedProfile(){
        return driver.findElement(By.xpath("//*[contains(@class,'v-snack__content')]")).getText();
    }
}
