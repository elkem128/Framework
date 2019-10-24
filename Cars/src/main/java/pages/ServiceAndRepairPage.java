package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceAndRepairPage  extends CommonClass {

    public ServiceAndRepairPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//a[contains(text(),'Learn how to make repairs to your car.')]")
    WebElement learnHowToLink;

    @FindBy(xpath ="//a[contains(text(),'Find out if there are any recalls on your car.')]")
    WebElement searchRecallLink;

    @FindBy(xpath ="//a[contains(text(),'Learn about maintenance and repairs from our experts.')]")
    WebElement serviceAndRepairAdviceLink;

    @FindBy(xpath="//a[contains(text(),'Find a Service Center')]")
    WebElement findAServiceCenterButton;

    public void clickFindAServiceCenterButton(){
        findAServiceCenterButton.click();
    }
    public void clickLearnHowToLink(){
        learnHowToLink.click();
    }
    public void clickSearchRecallLink(){
        searchRecallLink.click();
    }
    public void clickServiceAndRepairAdviceLink(){
        serviceAndRepairAdviceLink.click();
    }

    public boolean verifyFindAServiceCenterButton(){
        return findAServiceCenterButton.isDisplayed();
    }

    public boolean verifyServiceAndRepairAdviceLink(){
        return serviceAndRepairAdviceLink.isDisplayed();
    }

    public boolean verifySearchRecallLink(){
        return searchRecallLink.isDisplayed();
    }

    public boolean verifyLearnHowToLink(){
       return learnHowToLink.isDisplayed();
    }



}
