package pages;

import base.CommonClass;
import datasource.DatabaseOperation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class VideosAndReviewsPage extends CommonClass {

    public VideosAndReviewsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='article-search-input']")
       WebElement searchField;

     @FindBy(xpath ="//*[@id='article-search-form']/div[2]/div/svg")
      WebElement submitIcon;
     @FindBy(id ="emailBox")
     WebElement emailInputFiled;

     @FindBy(xpath ="//button[@class ='editorialEmail-button']")
     WebElement sendMeTheLatesButton;
     @FindBy(linkText = "See all")
     WebElement seeAllLink;

     public void clickSeeAllLink(){
         seeAllLink.click();
     }

     public boolean verifySendMeTheLatesButton(){
         return sendMeTheLatesButton.isDisplayed();
     }

     public boolean verifyEmailInputField(){
        return emailInputFiled.isDisplayed();
     }

     public void searchFor(String value){
         searchField.sendKeys(value);
     }
     public void submitSearchIcon(){
         submitIcon.sendKeys(Keys.ENTER);
     }
     public void clearFiled(){
         searchField.clear();
     }

    public void searchItemAndClickEnter() throws Exception, IOException, SQLException, ClassNotFoundException {
        DatabaseOperation databaseOperation = new DatabaseOperation();
        List<String> list = databaseOperation.getItemsListFromDB();
        for (int i = 0; i < list.size(); i++) {
            searchFor(list.get(i));
            submitSearchIcon();
            clearFiled();
        }


    }
}
