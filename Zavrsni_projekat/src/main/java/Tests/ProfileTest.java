package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class ProfileTest extends BasicTest{

    @Test(priority = 1)
    public void  visitsTheProfilePage(){
        navPage.getLoginButton().click();
        loginPage.getFieldForEmail().sendKeys("admin@admin.com");
        loginPage.getFieldForPassword().sendKeys("12345");
        loginPage.getButtonSubbmitLogin().click();
        navPage.getMyProfileLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"),"Url page do not contain /profile");
        String searchEmail = messagePopUpPage.getMyProfileEmailCOnfirmation().getAttribute("value");
        if (searchEmail.equals("admin@admin.com")) {
            System.out.println("Type of field contains admin@admin.com");
        } else {
            System.out.println("Type of field is not containg type");
        }
        navPage.getLogoutButton().click();

    }

    @Test(priority = 2)
    public void checksInputTypes(){
        navPage.getLoginButton().click();
        loginPage.getFieldForEmail().sendKeys("admin@admin.com");
        loginPage.getFieldForPassword().sendKeys("12345");
        loginPage.getButtonSubbmitLogin().click();
        navPage.getMyProfileLink().click();
        String searchEmail = messagePopUpPage.getMyProfileEmailCOnfirmation().getAttribute("type");
        if (searchEmail.equals("email")) {
            System.out.println("Type of field contains email");
        } else {
            System.out.println("Type of field is not containg type");
        }

       // Assert.assertTrue(loginPage.getDisable().contains("disabled"),"Field is not contain disabled");
        String searchText = loginPage.getTypeofFiledName().getAttribute("type");
        if (searchText.equals("text")) {
            System.out.println("Type of field contains text");
        } else {
            System.out.println("Type of field is not containg type");
        }
        String searchCity = loginPage.getTypeOfFieldCity().getAttribute("type");
        if (searchCity.equals("text")) {
            System.out.println("Type of field contains text");
        } else {
            System.out.println("Type of field is not containg type");
        }
        String searchCountry = loginPage.getTypeOfFiledCountry().getAttribute("type");
        if (searchCountry.equals("text")) {
            System.out.println("Type of field contains text");
        } else {
            System.out.println("Type of field is not containg type");
        }
        String searchurlTwitter = loginPage.getUrlTwiter().getAttribute("type");
        if (searchurlTwitter.equals("url")) {
            System.out.println("Type of field contains url");
        } else {
            System.out.println("Type of field is not containg type");
        }
        String searchurlGitHub = loginPage.getGitHubb().getAttribute("type");
        if (searchurlGitHub.equals("url")) {
            System.out.println("Type of field contains url");
        } else {
            System.out.println("Type of field is not containg type");
        }
        String searchPhone = loginPage.getPhone().getAttribute("type");
        if (searchPhone.equals("tel")) {
            System.out.println("Type of field contains tel");
        } else {
            System.out.println("Type of field is not containg type");
        }
        navPage.getLogoutButton().click();



    }

    @Test(priority = 3)
    public void  editsProfile() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getFieldForEmail().sendKeys("admin@admin.com");
        loginPage.getFieldForPassword().sendKeys("12345");
        loginPage.getButtonSubbmitLogin().click();
        navPage.getMyProfileLink().click();
        Thread.sleep(1000);
        WebElement name = driver.findElement(By.xpath("//*[@id='name']"));
        name.sendKeys(Keys.CONTROL + "a");
        loginPage.getTypeofFiledName().sendKeys("Igor Djokic");
        Thread.sleep(1000);
        WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
        country.sendKeys(Keys.CONTROL + "a");
        loginPage.getTypeOfFiledCountry().sendKeys("Serbia");
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys(Keys.CONTROL + "a");
         loginPage.getTypeOfFieldCity().sendKeys("New York");
         driver.findElement(By.xpath("//*[contains(@class,'v-list-item--highlighted')]")).click();
        Thread.sleep(1000);
        WebElement phone = driver.findElement(By.xpath("//*[@id='phone']"));
        phone.sendKeys(Keys.CONTROL + "a");
        loginPage.getPhone().sendKeys("0692624299");
        Thread.sleep(1000);
        WebElement git = driver.findElement(By.xpath("//*[@id='urlGitHub']"));
        git.sendKeys(Keys.CONTROL + "a");
        loginPage.getGitHubb().sendKeys("https://github.com/Zigimanx69");
        Thread.sleep(1000);
        WebElement twit = driver.findElement(By.xpath("//*[@id='urlTwitter']"));
        twit.sendKeys(Keys.CONTROL + "a");
        loginPage.getUrlTwiter().sendKeys("https://berniece.biz");
        loginPage.getSave().click();
        Thread.sleep(2000);
        String actualTMessage = messagePopUpPage.getTextSaveSucssesful();
        String expectedMessage = "Profile saved successfuly";
        Assert.assertTrue(actualTMessage.contains(expectedMessage),"Message of page is not correct");
        String searchText = loginPage.getTypeofFiledName().getAttribute("value");
        if (searchText.equals("Igor Djokic")) {
            System.out.println("Type of field contains Igor Djokic");
        } else {
            System.out.println("Type of field is not contain predicted value");
        }
        String searchCity = loginPage.getTypeOfFieldCity().getAttribute("value");
        if (searchCity.equals("New York")) {
            System.out.println("Type of field contains New York");
        } else {
            System.out.println("Type of field is not contain predicted value");
        }
        String searchCountry = loginPage.getTypeOfFiledCountry().getAttribute("value");
        if (searchCountry.equals("Serbia")) {
            System.out.println("Type of field contains Serbia");
        } else {
            System.out.println("Type of field is not contain predicted value");
        }
        String searchurlTwitter = loginPage.getUrlTwiter().getAttribute("value");
        if (searchurlTwitter.equals("https://berniece.biz")) {
            System.out.println("Type of field contains url");
        } else {
            System.out.println("Type of field is not contain predicted value");
        }
        String searchurlGitHub = loginPage.getGitHubb().getAttribute("value");
        if (searchurlGitHub.equals("https://github.com/zigimanx69")) {
            System.out.println("Type of field contains url");
        } else {
            System.out.println("Type of field is not contain predicted value");
        }
        String searchPhone = loginPage.getPhone().getAttribute("value");
        if (searchPhone.equals("0692624299")) {
            System.out.println("Type of field contains tel");
        } else {
            System.out.println("Type of field is not containg type");
        }
        navPage.getLogoutButton().click();
    }
}
