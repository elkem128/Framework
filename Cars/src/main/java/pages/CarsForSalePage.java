package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CarsForSalePage extends CommonClass {

    @FindBy(xpath =".ng-pristine.ng-valid.ng-not-empty.ng-touched")
    WebElement userCarDropDown;

    @FindBy(xpath ="//a[@class ='advanced-search']")
    WebElement advancedSearchLabel;

    @FindBy(xpath ="//a[@id='shopindex-make']")
    WebElement searchByMakeLabel;

    @FindBy(xpath ="//a[@id ='shopindex-bodyStyle']")
    WebElement searchByBodyStyleLabel;

    @FindBy(xpath ="//*[@ng-model='selectedModel']")
    WebElement carMobule;

    @FindBy(xpath ="//input[@type='submit']")
    WebElement searchButton;

    public CarsForSalePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifySearchByMakeLabel(){

        return  searchByMakeLabel.isDisplayed();
    }
    public boolean verifySearchByBodyStyleLabel(){

        return searchByBodyStyleLabel.isDisplayed();
    }

    public boolean verifyAdvanceSearchLabel(){

        return  advancedSearchLabel.isDisplayed();
    }

    public void chooseCarModule(){
      Select s = new Select(carMobule);
      s.selectByVisibleText("Avalon");

    }
    public void selectUserCarDropDown(){
        Select s = new Select(userCarDropDown);
        s.selectByValue("new");
    }
    @FindBy(xpath ="//*[@ng-model='selectedMake']")
    WebElement carBrand;

    public void selectCarBrand(){
        Select s = new Select(carBrand);
        s.selectByIndex(2);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }


}
