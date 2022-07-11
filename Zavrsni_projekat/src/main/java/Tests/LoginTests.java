package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1)
    public void visitsLoginPage() throws InterruptedException {
        navPage.getButttonForLanguage().click();
        navPage.getEnButton().click();
        driver.navigate().to(baseUrl + "/login");
        navPage.getLoginButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Url does not contain /login path");
    }

    @Test(priority = 2)
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        String searchEmail = signUpPage.getFieldForEmail().getAttribute("type");
        if (searchEmail.equals("email")) {
            System.out.println("Type of field is email");
        } else {
            System.out.println("Type of field is wrong type");
        }

        String searchPassword = signUpPage.getFieldForPassword().getAttribute("value");
        if (searchPassword.equals("password")) {
            System.out.println("Type of field is password");
        } else {
            System.out.println("Type of field is wrong type");
        }

    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {
       navPage.getLoginButton().click();
        signUpPage.getFieldForEmail().sendKeys("non-existing-user@gmal.com");
        signUpPage.getFieldForPassword().sendKeys("password123");
        loginPage.getButtonSubbmitLogin().click();
        messagePopUpPage.waitPopUpforLogin();
        String actualTitle = messagePopUpPage.getElementTextMessage();
        String expectedTitle = "User does not exists";
        Assert.assertEquals(actualTitle, expectedTitle, "Message of page is not correct");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Does not contains /login in path");

    }

    @Test(priority = 4)
    public void displaysErrorsWhenPasswordIsWrong() throws InterruptedException {
        navPage.getLoginButton().click();
        signUpPage.getFieldForEmail().sendKeys("admin@admin.com");
        signUpPage.getFieldForPassword().sendKeys("password123");
        loginPage.getButtonSubbmitLogin().click();
        messagePopUpPage.waitPopUpforLogin();

        String actualTitle = messagePopUpPage.getElementTextMessage();
        String expectedTitle = "Wrong password";
        Assert.assertEquals(actualTitle, expectedTitle, "Message of page is not correct");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Does not contains /login in path");
    }

    @Test(priority = 5)
    public void login() throws InterruptedException {
        navPage.getLoginButton().click();
        signUpPage.getFieldForEmail().sendKeys("admin@admin.com");
        signUpPage.getFieldForPassword().sendKeys("12345");
        loginPage.getButtonSubbmitLogin().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "Does not contains /home in path");
    }

    @Test(priority = 6)
    public void logOut() {
        try {
            navPage.getLogoutButton();
            System.out.println("Element is visible");
        } catch (Exception e) {
            System.out.println("Logout button is not on the page");
        }

        navPage.getLogoutButton().click();

    }

}
