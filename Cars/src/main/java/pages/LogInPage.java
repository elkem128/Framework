package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends CommonClass {

    @FindBy(xpath ="//*[@data-linkname='header-sign-up']")
    WebElement signUpButton;

    @FindBy(xpath ="//input[@type='text']")
    WebElement email;
    @FindBy(xpath ="//input[@type='password']")
    WebElement password;
    @FindBy(xpath ="//button[@type='submit']")
    WebElement logInButton;

    @FindBy(id ="cars-com-logo")
    WebElement carsLogo;

    @FindBy(xpath ="/html/body/div[2]/section/cars-profiles-lsp/cui-tabs/div/ul[1]/li[1]/div")
    WebElement logInLink;

    public LogInPage(){

        PageFactory.initElements(driver,this);
    }
    //Actions
    public String validateLogInPageTitle(){

        return driver.getTitle();
    }
    public boolean validateCarsImage(){

        return carsLogo.isDisplayed();
    }
    public void clickSingIn(){

        signUpButton.click();
    }
    public void clickLogInLink(){

        logInLink.click();
    }

    public HomePage logIn(String un,String pwd){
        email.sendKeys(un);
        password.sendKeys(pwd);
        logInButton.click();
        return new HomePage();

    }

}
