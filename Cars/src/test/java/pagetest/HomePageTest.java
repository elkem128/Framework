package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarsForSalePage;
import pages.HomePage;
import pages.LogInPage;

import java.util.List;

public class HomePageTest extends CommonClass {
    HomePage homePage;
    LogInPage logInPage;
    CarsForSalePage carsForSalePage;
   // Util util;
    // test case should be independent  with each other

    @BeforeMethod  // cause every test is indivisual so for verify we have to login to the homepage , so set this as before method
    public void setUp(){
        initialization();
      //  util = new Util();
        logInPage =new LogInPage();
        carsForSalePage = new CarsForSalePage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
    }

    @Test
    public void webElementListTest(){
        List actual = homePage.webElementList();
        List expected = homePage.expectedWebElementXlsx();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void verifyHomePageTitleTest(){
       String title = homePage.verifyHomePageTitle();
       Assert.assertEquals(title,"Cars.com | Sign Up");
    }
    @Test
    public void carsImageLogo() {
        boolean flag = homePage.validateCarsImage();
        Assert.assertTrue(flag);
    }
    @Test
    public void verifyLogInIconTest(){
       boolean verify = homePage.verifyLogInIcon();
       Assert.assertTrue(verify);
    }

    @Test
    public void verifyCarsForSaleLinkTest() throws InterruptedException {
     carsForSalePage = homePage.clickOnCarsForSaleLink();
    }
    @Test
    public void selectCarTypeDropDown() throws InterruptedException {
        homePage.carTypeDropDown();
       homePage.clickSearchButton();
    }
    @Test
    public void selectCarMakeDropDown(){
        homePage.carMakeDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarModelDropDown(){
        homePage.carModelIdDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarPriceDropDown(){
        homePage.carPriceDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarRadiosDropDown(){
        homePage.radioDropDown();
        homePage.clickSearchButton();
    }
    @Test
   public void clickSearchByBodyStyle(){
        homePage.searchByBodyStyleTag();
    }
    @Test
    public void allBodyStyleDropDownTest(){
        homePage.searchByBodyStyleTag();
        homePage.allBodyStyleDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void carQualityDropDownTest(){
        homePage.searchByBodyStyleTag();
        homePage.carQualityDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void carPriceTest(){
        homePage.searchByBodyStyleTag();
        homePage.carPrice();
        homePage.clickSearchButton();
    }
    @Test
    public void setRadiusDropDownTest(){
        homePage.searchByBodyStyleTag();
        homePage.setRadiusDropDown();
        homePage.clickSearchButton();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
