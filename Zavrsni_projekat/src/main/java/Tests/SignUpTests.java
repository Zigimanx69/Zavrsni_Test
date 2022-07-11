package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest{

    @Test(priority = 1)
    public void visitsTheSignupPage(){
      navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Url does not contain /signup path");
    }

    @Test(priority = 2)
    public void checksInputTypes(){
        navPage.getSignUpButton().click();
        String searchEmail = signUpPage.getFieldForEmail().getAttribute("type");
        if (searchEmail.equals("email")) {
            System.out.println("Type of field is email");
        } else {
            System.out.println("Type of field is wrong type");
        }
        String searchPassword = signUpPage.getFieldForPassword().getAttribute("type");
        if (searchPassword.equals("password")) {
            System.out.println("Type of field is password");
        } else {
            System.out.println("Type of field is wrong type");
        }
        String searchPasswordValidation = signUpPage.getFieldForValidation().getAttribute("type");
        if (searchPassword.equals("password")) {
            System.out.println("Type of field is password");
        } else {
            System.out.println("Type of field is wrong type");
        }
    }

    @Test (priority = 3)
    public void displaysErrorsWhenUserAlreadyExists(){
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Url does not contain /signup path");
        signUpPage.getFieldForName().sendKeys("Another User");
        signUpPage.getFieldForEmail().sendKeys("admin@admin.com");
        signUpPage.getFieldForPassword().sendKeys("12345");
        signUpPage.getFieldForValidation().sendKeys("12345");
        navPage.getSignUpAfterInput().click();
        messagePopUpPage.waitForPopUp();
        String actualTitle = messagePopUpPage.getTextEmailExixst();
        String expectedTitle = "E-mail already exists";
        Assert.assertTrue(messagePopUpPage.getTextEmailExixst().contains(expectedTitle) , "Message of page is not correct");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Url does not contain /signup path");
    }

    @Test (priority = 4)
    public void signUp() throws InterruptedException {
        navPage.getSignUpButton().click();
        signUpPage.getFieldForName().sendKeys("Igor Djokic");
        signUpPage.getFieldForEmail().sendKeys("igor.djokic8@itbootcamp.rs");
        signUpPage.getFieldForPassword().sendKeys("12345");
        signUpPage.getFieldForValidation().sendKeys("12345");
        navPage.getSignUpAfterInput().click();
        Thread.sleep(2000);
       // driver.get(baseUrl + "/home");
        String actualTitle = messagePopUpPage.getVerifyAccount();
        String expectedTitle = "IMPORTANT: Verify your account";
        Assert.assertTrue(actualTitle.contains(expectedTitle) , "Message of page is not correct");
        messagePopUpPage.getCloseButtonPopUp().click();
        navPage.getLogoutButton().click();
    }

}
