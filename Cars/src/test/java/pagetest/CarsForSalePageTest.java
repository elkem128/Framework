package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarsForSalePage;
import pages.HomePage;
import pages.LogInPage;

public class CarsForSalePageTest extends CommonClass {
    LogInPage logInPage;
    HomePage homePage;
    CarsForSalePage carsForSalePage;

    public CarsForSalePageTest(){
        super();
    }
    @BeforeMethod
    // cause every test is indivisual so for verify we have to login to the homepage , so set this as before method
    public void setUp() throws InterruptedException {
        initialization();
        //  util = new Util();
        logInPage =new LogInPage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        carsForSalePage = new CarsForSalePage();
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
        carsForSalePage= homePage.clickOnCarsForSaleLink();
    }
    @Test(priority = 1)
    public void verifyAdvancedSearchLabelTest(){

        Assert.assertTrue( carsForSalePage.verifyAdvanceSearchLabel());
    }
    @Test(priority = 2)
    public void verifySearchByMakeLabelTest(){
      Assert.assertTrue(carsForSalePage.verifySearchByMakeLabel());
    }

    @Test(priority = 3)
    public void verifySearchByBodyStyleLabelTest(){
      Assert.assertTrue(carsForSalePage.verifySearchByBodyStyleLabel());
    }
    @Test(priority = 4)
    public void chooseCarModuleTest(){
        carsForSalePage.chooseCarModule();
        carsForSalePage.clickOnSearchButton();
    }
    @Test(priority = 5)
    public void selectUserCarDropDownTest(){
        carsForSalePage.selectUserCarDropDown();
        carsForSalePage.clickOnSearchButton();
    }
    @Test(priority = 6)
    public void selectCarBrandTest(){
        carsForSalePage.selectCarBrand();
        carsForSalePage.clickOnSearchButton();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
