package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ResearchPage extends CommonClass {

    public ResearchPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name ="makeId")
    WebElement allMakesDropDown;

    @FindBy(xpath ="//input[@type='submit']")
    WebElement searchButtonElement;

    @FindBy(name ="modelId")
    WebElement allModelsElement;

    @FindBy(name="year")
    WebElement allYearElement;

    public boolean selectAllYearDropDown(){
       return allYearElement.isSelected();
    }

    public void selectAllMakesDropDown(){
        Select s = new Select(allMakesDropDown);
        s.selectByVisibleText("Acura");
    }

    public boolean selectAllModelsDropDown(){
       return allModelsElement.isSelected();
    }
    public void clickSearchButtonElement(){
        searchButtonElement.click();
    }



}
