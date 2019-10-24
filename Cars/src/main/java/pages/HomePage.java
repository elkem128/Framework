package pages;

import base.CommonClass;
import databases.XlsxDataReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonClass {

    @FindBy(xpath = "//label[@id='profile_menu-avatar']")
    WebElement logInIcon;

    @FindBy(linkText = "Cars for Sale")
    WebElement carsForSaleLink;

    @FindBy(linkText = "Sell Your Car")
    WebElement sellYourCarLink;

    @FindBy(linkText = "Service & Repair")
    WebElement serviceAndRepairLink;

    @FindBy(xpath = "//img[contains(@class,'global-nav__logo')]")
    WebElement carsLogo;

    @FindBy(name = "stockType")
    WebElement NewNUsedCarDropDown;

    @FindBy(name = "makeId")
    WebElement carMakeDropDown;

    @FindBy(name = "modelId")
    WebElement carModelDropDown;

    @FindBy(name = "priceMax")
    WebElement priceDropDown;

    @FindBy(name = "radius")
    WebElement radiusDropDown;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\'root\']/div[2]/section[2]/div[2]/form/ul/li[2]/label")
    WebElement searchByBodyStyle;

    @FindBy(name = "bodyStyle")
    WebElement allBodyDropDown;

    @FindBy(name = "stockType")
    WebElement carType;

    @FindBy(name = "priceMax")
    WebElement carPriceDropDown;

    @FindBy(name = "radius")
    WebElement nextRadius;

    @FindBy(linkText = "Research")
    WebElement researchLink;

    @FindBy(linkText = "Videos & Reviews")
    WebElement videosAndReviewsLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLogInIcon() {
        return logInIcon.isDisplayed();
    }

    public String verifyHomePageTitle() {

        return driver.getTitle();
    }

    public CarsForSalePage clickOnCarsForSaleLink() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(carsForSaleLink).build().perform();
        Thread.sleep(3000);
        carsForSaleLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return new CarsForSalePage();
    }

    public SellYourCarPage clickSellYourCarLink() throws InterruptedException {

        Actions act = new Actions(driver);
        act.moveToElement(sellYourCarLink).build().perform();
        Thread.sleep(3000);
        sellYourCarLink.click();
        //sellYourCarLink.click();
        return new SellYourCarPage();
    }

    public ServiceAndRepairPage clickServiceAndRepairLink() throws InterruptedException {
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(serviceAndRepairLink).build().perform();
        serviceAndRepairLink.click();
        return new ServiceAndRepairPage();
    }

    public ResearchPage ResearchLink() throws InterruptedException {
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(researchLink).build().perform();
        researchLink.click();
        return new ResearchPage();
    }

    public VideosAndReviewsPage clickVideosAndReviewLink() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(videosAndReviewsLink).build().perform();
        Thread.sleep(3000);
        videosAndReviewsLink.click();
        return new VideosAndReviewsPage();
    }


    public void allBodyStyleDropDown() {
        Select s = new Select(allBodyDropDown);
        int n = 1;
        while (n < 3) {
            allBodyDropDown.click();
            n++;
        }
    }

    public void carQualityDropDown() {
        Select s = new Select(carType);
        for (int k = 1; k < 3; k++) {
            carType.click();
        }
    }

    public void carPrice() {
        Select s = new Select(carPriceDropDown);
        s.selectByValue("35000");
        boolean isSelected = carPriceDropDown.isSelected();
        Assert.assertTrue(isSelected);
    }

    public void setRadiusDropDown() {
        Select s = new Select(nextRadius);
        s.selectByVisibleText("40 Miles from");
        boolean isSelect = nextRadius.isSelected();
        Assert.assertTrue(isSelect);
    }


    public void searchByBodyStyleTag() {

        searchByBodyStyle.click();
    }

    public void carTypeDropDown() throws InterruptedException {
        Select s = new Select(NewNUsedCarDropDown);
        s.selectByValue("28880");
        Thread.sleep(3000);
    }

    public void carMakeDropDown() {
        Select s = new Select(carMakeDropDown);
        s.selectByVisibleText("Aston Martin");
    }

    public void carModelIdDropDown() {
        Select s = new Select(carModelDropDown);
        s.selectByIndex(1);
    }

    public void carPriceDropDown() {
        Select s = new Select(priceDropDown);
        s.selectByValue("35000");
    }

    public void radioDropDown() {
        Select s = new Select(radiusDropDown);
        s.selectByVisibleText("40 Miles from");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean validateCarsImage() {

        return carsLogo.isDisplayed();
    }

    public List webElementList() {
        List<WebElement> webElements = new ArrayList<>();
        webElements.add(logInIcon);
        webElements.add(carsForSaleLink);
        webElements.add(sellYourCarLink);
        webElements.add(serviceAndRepairLink);
        webElements.add(carsLogo);
        webElements.add(NewNUsedCarDropDown);
        webElements.add(carMakeDropDown);
        webElements.add(carModelDropDown);
        webElements.add(priceDropDown);
        webElements.add(radiusDropDown);
        webElements.add(searchButton);
        webElements.add(searchByBodyStyle);
        webElements.add(allBodyDropDown);
        webElements.add(carType);
        webElements.add(carPriceDropDown);
        webElements.add(nextRadius);
        webElements.add(researchLink);
        webElements.add(videosAndReviewsLink);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < webElements.size(); i++) {
            list.add(webElements.get(i).getText());
        }
        System.out.println(list);
        return list;
    }

    XlsxDataReader xlxData = new XlsxDataReader("C:\\Users\\Elzat\\IdeaProjects\\Auto3\\Cars\\CarsData.xlsx");

    public List expectedWebElementXlsx() {
        int rowCount = xlxData.getRowCount("Sheet1");
        List<String> expect = new ArrayList<>();
        for (int i = 1; i <= rowCount; i++) {
            expect.add(xlxData.getData(0,i,0));

        }
        System.out.println(expect);
        return expect;
    }
}
