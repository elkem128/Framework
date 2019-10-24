package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellYourCarPage extends CommonClass {

 @FindBy(xpath ="//a[contains(text(),'Log In')]")
    WebElement logInButton;
 @FindBy(xpath ="//a[contains(text(),'Read All Car Buying Advice')]")
 WebElement readAllCarBuyingAdviceButton;

 @FindBy(xpath ="//a[contains(text(),'Start Selling')]")
 WebElement startSellingLink;

 @FindBy(xpath ="//a[contains(text(),'View Your Offers')]")
 WebElement viewYourOffersLink;

 @FindBy(xpath ="//a[contains(text(),'Create Your Listing')]")
 WebElement createYourListingLink;

 @FindBy(xpath ="//a[contains(text(),'Get An Estimate')]")
 WebElement getAnEstimateLink;

 @FindBy(xpath ="//a[contains(text(),'Sell Your Junk Car')]")
 WebElement sellYourJunkCarLink;

 @FindBy(xpath ="//a[contains(text(),'Learn How To Sell')]")
 WebElement learnHowToSellLink;

 @FindBy(xpath ="//a[contains(text(),'Start Shopping')]")
 WebElement startShoppingLink;

 @FindBy(xpath ="//a[contains(text(),'Learn More')]")
 WebElement learnMoreLink;

 public void clickStartSellingLink(){
     startSellingLink.click();
 }
 public void clickViewYourOffersLink(){
     viewYourOffersLink.click();
 }
 public void clickCreateYourListingLink(){
     createYourListingLink.click();
 }
 public void clickGetAnEstimateLink(){
     getAnEstimateLink.click();
 }
 public void clickSellYourJunkCarLink(){
     sellYourJunkCarLink.click();
 }
 public void clickLearnHowToSellLink(){
     learnHowToSellLink.click();
 }
 public void clickStartShoppingLink(){
     startShoppingLink.click();
 }
 public void clickLearnMoreLink(){
     learnMoreLink.click();
 }


 public boolean verifyLearnMoreLink (){
     return learnMoreLink.isDisplayed();
 }

 public boolean verifyStartShoppingLink(){
     return startShoppingLink.isDisplayed();
 }

 public boolean verifyLearnHowToSellLink() {
    return learnHowToSellLink.isDisplayed();
 }
 public boolean verifySellYourJunkCarLink(){
     return sellYourJunkCarLink.isDisplayed();
 }

 public boolean verifyGetAnEstimateLink(){
     return getAnEstimateLink.isDisplayed();
 }

 public boolean verifyCreateYourListingLink(){
        return createYourListingLink.isDisplayed();
    }

 public boolean verifyViewYourOffersLink(){
     return viewYourOffersLink.isDisplayed();
 }

 public SellYourCarPage(){
     PageFactory.initElements(driver,this);
 }

 public boolean verifyStartSellingLink(){
     return startSellingLink.isDisplayed();
 }

 public boolean verifyLogInButton() throws InterruptedException {
     Thread.sleep(3000);
    return logInButton.isDisplayed();
 }
 public boolean verifyReadAllCarBuyingAdviceButton() throws InterruptedException {
     Thread.sleep(3000);
    return readAllCarBuyingAdviceButton.isDisplayed();
 }

}
