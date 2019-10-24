package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.ResearchPage;

public class ResearchPageTest extends CommonClass {

    LogInPage logInPage;
    HomePage homePage;
    ResearchPage researchPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        //  util = new Util();
        logInPage =new LogInPage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        researchPage = new ResearchPage();
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
        researchPage= homePage.ResearchLink();
    }

    @Test
    public void selectAllMakesDropDownTest(){
        researchPage.selectAllMakesDropDown();
        researchPage.clickSearchButtonElement();
    }
    @Test
    public void VerifySelectAllModelsDropDownTest(){
      boolean verify=  researchPage.selectAllModelsDropDown();
      Assert.assertTrue(verify);
      researchPage.clickSearchButtonElement();
    }

    @Test
    public void VerifySelectAllYearDropDownTest(){
        boolean verify = researchPage.selectAllYearDropDown();
        Assert.assertTrue(verify);
        researchPage.clickSearchButtonElement();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}



