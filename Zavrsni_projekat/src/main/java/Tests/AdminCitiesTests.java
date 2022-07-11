package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test (priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
        navPage.getSignUpButton().click();
        navPage.getLoginButton().click();
        driver.findElement(By.id("email")).sendKeys("admin@admin.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        loginPage.getButtonSubbmitLogin().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "Does not contains /admin/cities in path");
    }

    @Test (priority = 2)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItem().click();
        citiesPage.waiterforEditing();
        String searchType = signUpPage.getFieldForName().getAttribute("type");
        if (searchType.equals("text")) {
            System.out.println("Type of field is text");
        } else {
            System.out.println("Type of field is wrong type");
        }
    }

    @Test (priority = 3)
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItem().click();
        citiesPage.waiterforEditing();
        signUpPage.getFieldForName().sendKeys("Igor Djokic");
        citiesPage.getSaveButton().click();
        citiesPage.waitForSucssesfulSave();
        String actualTMessage = messagePopUpPage.getTextSaveSucssesful();
        String expectedMessage = "Saved successfully";
        Assert.assertTrue(actualTMessage.contains(expectedMessage), "Message of page is not correct");

    }

    @Test (priority = 4)
    public void editCities() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getInputSearch().sendKeys("Igor Djokic");
        citiesPage.waitForNumberOfProductRowsToBe(1);
        citiesPage.getEditButtonByRowIndex(1).click();
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys(Keys.CONTROL + "a",Keys.DELETE);
        driver.findElement(By.id("name")).sendKeys("Djura jaksic");
        citiesPage.getSaveButton().click();
        citiesPage.waitForSucssesfulSave();
        String actualTMessage = messagePopUpPage.getTextSaveSucssesful();
        String expectedMessage = "Saved successfully";
        Assert.assertTrue(actualTMessage.contains(expectedMessage),"Message of page is not correct");
    }

    @Test (priority = 5)
    public void serachCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getInputSearch().sendKeys("Djura jaksic");
        citiesPage.waitForNumberOfProductRowsToBe(1);
        Assert.assertEquals("Djura jaksic","Djura jaksic","U name nije naziv koji je ocekivani");

    }

    @Test (priority = 6)
    public void deleteCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getInputSearch().sendKeys("Djura jaksic");
        citiesPage.waitForNumberOfProductRowsToBe(1);
        Assert.assertEquals("Djura jaksic","Djura jaksic","U name nije naziv koji je ocekivani");
        citiesPage.getDeleteButtonByRowIndex(1);
        citiesPage.getDeleteBUtton().click();
        messagePopUpPage.getDialogDeleteBUtton().click();
        messagePopUpPage.getDeleteDialogtobeVisible();
        String actualTMessage = messagePopUpPage.getDeleteSuccsefull();
        String expectedMessage = "Deleted successfully";
        Assert.assertTrue(actualTMessage.contains(expectedMessage),"Message of page is not correct");

    }


}
