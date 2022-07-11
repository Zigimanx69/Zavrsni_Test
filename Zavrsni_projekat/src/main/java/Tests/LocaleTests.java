package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 1)
    public void setLocaleToEs() {
        navPage.getButttonForLanguage().click();
        navPage.getEsButton().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("de aterrizaje"),
                "[ERROR] Header does not contains that text");
    }

    @Test(priority = 2)
    public void setlocaleToEn() {
        navPage.getButttonForLanguage().click();
        navPage.getEnButton().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("Landing"),
                "[ERROR] Header does not contains that text");
    }

    @Test(priority = 3)
    public void setLocaleToCn() {
        navPage.getButttonForLanguage().click();
        navPage.getCnButton().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("首页"),
                "[ERROR] Header does not contains that text");
    }

    @Test(priority = 4)
    public void setLocaleToFr() {
        navPage.getButttonForLanguage().click();
        navPage.getFrButton().click();
        Assert.assertTrue(navPage.getHeaderFromChangedLanguage().getText().contains("Page d'atterrissage"),
                "[ERROR] Header does not contains that text");
    }
}
