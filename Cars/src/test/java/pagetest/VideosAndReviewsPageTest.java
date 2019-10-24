package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.VideosAndReviewsPage;

public class VideosAndReviewsPageTest extends CommonClass {

    LogInPage logInPage;
    HomePage homePage;
    VideosAndReviewsPage videosAndReviewsPage;
    public VideosAndReviewsPageTest(){
      super();
  }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        //  util = new Util();
        logInPage =new LogInPage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        videosAndReviewsPage = new VideosAndReviewsPage();
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
        videosAndReviewsPage= homePage.clickVideosAndReviewLink();
    }


    @Test
    public void searchItemAndClickEnterTest() throws Exception {
        videosAndReviewsPage.searchItemAndClickEnter();
    }

    @Test
    public void verifyEmailInputFieldTest(){
      boolean verify =  videosAndReviewsPage.verifyEmailInputField();
        Assert.assertTrue(verify);
    }
    @Test
    public void verifySendMeTheLatesButtonTest(){
        boolean verify = videosAndReviewsPage.verifySendMeTheLatesButton();
        Assert.assertTrue(verify);
    }
    @Test
    public void clickSeeAllLinkTest(){
        videosAndReviewsPage.clickSeeAllLink();
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
