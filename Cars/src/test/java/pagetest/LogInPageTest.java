package pagetest;

import base.CommonClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class LogInPageTest extends CommonClass {
 LogInPage logInPage;
 HomePage homePage;

 @BeforeMethod
 public void setUP(){
     initialization();
     logInPage= PageFactory.initElements(driver, LogInPage.class);
 }
 @Test(priority = 1)
    public void getLogInPageTitle(){
    String title = logInPage.validateLogInPageTitle();
     Assert.assertEquals(title,"New Cars, Used Cars, Car Reviews and News | Cars.com");
}
 @Test(priority = 2)
    public void carsImageLogo(){
    boolean flag = logInPage.validateCarsImage();
    Assert.assertTrue(flag);
 }
 @Test(priority = 3)
 public void clickSingUp(){
     logInPage.clickSingIn();
     logInPage.clickLogInLink();
 }
 @Test(priority = 4)
    public void logIntest(){
     logInPage.clickSingIn();
     logInPage.clickLogInLink();
     homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
 }
 @AfterMethod
    public void tearDown(){
     driver.quit();
 }
}
