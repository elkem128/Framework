package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.ServiceAndRepairPage;

public class ServiceAndRepairPageTest extends CommonClass {
    LogInPage logInPage;
    HomePage homePage;
    ServiceAndRepairPage serviceAndRepairPage;

    public ServiceAndRepairPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        //  util = new Util();
        logInPage =new LogInPage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        serviceAndRepairPage = new ServiceAndRepairPage();
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
        serviceAndRepairPage= homePage.clickServiceAndRepairLink();
    }
    @Test
    public void verifyLearnHowToLinkTest(){
        boolean verify = serviceAndRepairPage.verifyLearnHowToLink();
        Assert.assertTrue(verify);
    }
    @Test
    public void verifySearchRecallLinkTest(){
        boolean verify = serviceAndRepairPage.verifySearchRecallLink();
        Assert.assertTrue(verify);
    }

    @Test
    public void verifyServiceAndRepairAdviceLinkTest(){
        boolean verify = serviceAndRepairPage.verifyServiceAndRepairAdviceLink();
        Assert.assertTrue(verify);
    }
    @Test
    public void verifyFindAServiceCenterButtonTest(){
        boolean verify = serviceAndRepairPage.verifyFindAServiceCenterButton();
        Assert.assertTrue(verify);
    }
    @Test
    public void clickFindAServiceCenterButtonTest(){
        serviceAndRepairPage.clickFindAServiceCenterButton();
    }
    @Test
    public void clickLearnHowToLinkTest(){
        serviceAndRepairPage.clickLearnHowToLink();
    }
    @Test
    public void clickSearchRecallLinkTest(){
        serviceAndRepairPage.clickSearchRecallLink();
    }
    @Test
    public void clickServiceAndRepairAdviceLinkTest(){
        serviceAndRepairPage.clickServiceAndRepairAdviceLink();
    }




    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
