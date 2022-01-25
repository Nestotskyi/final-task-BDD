package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@type='accountUnfilled']")
    private WebElement iconOfSignIn;
    @FindBy(xpath = "//a[text()='My Account']")
    private WebElement iconOfMyAccount;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement fieldForSearch;
    @FindBy(xpath = "//nav[@class='_3EAPxMS']//a[contains(text(),'Best of sale')]")
    private WebElement productsWithSale;
    @FindBy(xpath = "//nav[@class='_3EAPxMS']//span[text()='Sale']")
    private WebElement menuOfSale;
    @FindBy(xpath = "//a[@data-testid='men-floor']")
    private WebElement productsForMan;
    @FindBy(xpath = "//h1[text()='Preferences']")
    private WebElement titleOfWindowOfPreference;
    @FindBy(xpath = "//option[@value='US']")
    private WebElement chooseUs;
    @FindBy(xpath = "//span[@class='eG8KBrM _36k7qvZ']/..")
    private WebElement buttonForChooseCountry;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement menuOfCountry;
    @FindBy(xpath = "//button[text()='Update Preferences']")
    private WebElement buttonOfUpdate;
    @FindBy(xpath = "//div[@class='_25L--Pi']//img[@alt='United States']")
    private WebElement iconOfFlagOfUs;

    public void chooseCountry(String country){
        if(country.equals("Us")) {
            chooseUs.click();
        }
    }
    public WebElement getProductsWithSale(){return productsWithSale;}
    public boolean isGetIconOfFlagOfUsVisible(){return iconOfFlagOfUs.isDisplayed();}
    public WebElement getButtonOfUpdate(){return buttonOfUpdate;}
    public WebElement getMenuOfCountry(){return menuOfCountry;}
    public void clickButtonForChooseCountry(){buttonForChooseCountry.click();}
    public void clickMenuOfCountry(){menuOfCountry.click();}
    public void clickButtonOfUpdate(){buttonOfUpdate.click();}
    public WebElement getTitleOfWindowOfPreference(){return titleOfWindowOfPreference;}
    public boolean isTitleOfWindowPreferenceDisplayed(){return titleOfWindowOfPreference.isDisplayed();}
    public void clickOnProductsForMan(){productsForMan.click();}
    public void moveCursorToMenuOfSale(){ new Actions(driver).moveToElement(menuOfSale).build().perform();}
    public void clickProductsWithSale(){productsWithSale.click();}
    public void openHomePage(String url)
    {
        driver.get(url);
    }
    public void moveCursorOnIconOfSignIn() {
        new Actions(driver).moveToElement(iconOfSignIn).build().perform();
    }
    public void clickOnIconOfMyAccount(){
        iconOfMyAccount.click();
    }
    public WebElement getIconOfMyAccount(){
        return iconOfMyAccount;
    }
    public boolean isIconOfMyAccountDisplayed(){return iconOfMyAccount.isDisplayed();}
    public void searchByWord(String word){fieldForSearch.sendKeys(word+"\n");}

}
