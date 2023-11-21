package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/ ";

    @Before

public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        // find the user name in username field

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");

        //find the password field and enter the password

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        // find and click on login button

        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

        // find the Dashboard text display

        String expectedErrorMessage = "Dashboard";
        String actualErrorMessage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("Dashboard", expectedErrorMessage, expectedErrorMessage);
    }
    @After

    public void tearDown(){
        closeBrowser();








    }


}


