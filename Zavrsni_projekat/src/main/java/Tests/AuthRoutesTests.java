package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 1)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Does not contains /login in path");
    }

    @Test(priority = 2)
    public void forbidsVisitsToProfileUrlIfNotAuthenticate() {
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Does not contains /login in path");
    }

    @Test(priority = 3)
    public void forbidsVisitsToAdminleUrlIfNotAuthenticate() {
        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Does not contains /login in path");
    }

}
