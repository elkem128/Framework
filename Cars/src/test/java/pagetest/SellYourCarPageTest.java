package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.SellYourCarPage;

public class SellYourCarPageTest extends CommonClass {

    LogInPage logInPage;
    HomePage homePage;
    SellYourCarPage sellYourCarPage;

    public SellYourCarPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        //  util = new Util();
        logInPage =new LogInPage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        sellYourCarPage = new SellYourCarPage();
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
        sellYourCarPage= homePage.clickSellYourCarLink();
    }

    @Test(priority = 1)
    public void verifyStartSellingLinkTest(){
      boolean verify=  sellYourCarPage.verifyStartSellingLink();
      Assert.assertTrue(verify);
    }

    @Test(priority = 2)
    public void verifyLearnMoreLinkTest(){
        boolean verify=  sellYourCarPage.verifyLearnMoreLink();
        Assert.assertTrue(verify);
    }
    @Test(priority = 3)
    public void verifyStartShoppingLinkTest(){
        boolean verify=  sellYourCarPage.verifyStartShoppingLink();
        Assert.assertTrue(verify);
    }
    @Test(priority = 4)
    public void verifyLearnHowToSellLinkTest(){
        boolean verify=  sellYourCarPage.verifyLearnHowToSellLink();
        Assert.assertTrue(verify);
    }
    @Test(priority = 5)
    public void verifySellYourJunkCarLinkTest(){
        boolean verify=  sellYourCarPage.verifySellYourJunkCarLink();
        Assert.assertTrue(verify);
    }
    @Test(priority = 6)
    public void verifyGetAnEstimateLinkTest(){
        boolean verify=  sellYourCarPage.verifyGetAnEstimateLink();
        Assert.assertTrue(verify);
    }
    @Test(priority = 7)
    public void verifyCreateYourListingLinkTest(){
        boolean verify=  sellYourCarPage.verifyCreateYourListingLink();
        Assert.assertTrue(verify);
    }
    @Test(priority = 8)
    public void verifyViewYourOffersLinkTest(){
        boolean verify=  sellYourCarPage.verifyViewYourOffersLink();
        Assert.assertTrue(verify);
    }

    @Test(priority = 9)
    public void verifyLogInButtonTest() throws InterruptedException {
        boolean verify=  sellYourCarPage.verifyLogInButton();
        Assert.assertTrue(verify);
    }
    @Test(priority = 10)
    public void verifyReadAllCarBuyingAdviceButtonTest() throws InterruptedException {
        boolean verify=  sellYourCarPage.verifyReadAllCarBuyingAdviceButton();
        Assert.assertTrue(verify);
    }

    @Test
    public void clickStartSellingLinkTest(){
        sellYourCarPage.clickStartSellingLink();
    }
    @Test
    public void clickViewYourOffersLinkTest(){
        sellYourCarPage.clickViewYourOffersLink();
    }
    @Test
    public void clickCreateYourListingLinkTest(){
        sellYourCarPage.clickCreateYourListingLink();
    }
    @Test
    public void clickGetAnEstimateLinkTest(){
        sellYourCarPage.clickGetAnEstimateLink();
    }
    @Test
    public void clickSellYourJunkCarLinkTest(){
        sellYourCarPage.clickSellYourJunkCarLink();
    }
    @Test
    public void clickLearnHowToSellLinkTest(){
        sellYourCarPage.clickLearnHowToSellLink();
    }

    @Test
    public void clickStartShoppingLinkTest(){
        sellYourCarPage.clickStartShoppingLink();
    }
    @Test
    public void clickLearnMoreLinkTest(){
        sellYourCarPage.clickLearnMoreLink();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
