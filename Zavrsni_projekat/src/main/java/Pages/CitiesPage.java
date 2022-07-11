package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItem() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnNewItem ')]"));
    }

    public WebElement getInputSearch() {
        return driver.findElement(By.id("search"));
    }

    public void waiterforEditing() {
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'dlgNewEditItem')]")));

    }

    public void waitforDeleteDialog() {
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[9]/div/div")));

    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnSave')]"));
    }

    public WebElement getDeleteBUtton() {
        return driver.findElement(By.xpath("//*[@id='delete']"));
    }

    public void waitForNumberOfProductRowsToBe(int numberOfRows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr/td[2]"), numberOfRows));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver.findElement(By.xpath("//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }

    public WebElement getEditButtonByRowIndex(int index) {
        return driver.findElement(By.id("edit"));
    }

    public WebElement getDeleteButtonByRowIndex(int index) {
        return driver.findElement(By.id("delete"));
    }

    public void waitForSucssesfulSave() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));
    }



}
