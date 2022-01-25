package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BagPage extends BasePage{
    public BagPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@aria-label='Size']//span[@class='select2-selection__arrow']")
    private WebElement menuOfSizeOfProductInBag;
    @FindBy(xpath = "//select[@class='bag-item-size bag-item-selector select2-hidden-accessible']//option")
    private List<WebElement> listOfSizeOfProductInBag;
    @FindBy(xpath = "//select[@class='bag-item-size bag-item-selector select2-hidden-accessible']//option[text()='W34 L34']")
    private WebElement loadSizeList;
    @FindBy(xpath = "//span[contains(@class,'-size-')]")
    private WebElement actualSizeOfProductInBag1;
    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    private WebElement actualSizeOfProductInBag;
    @FindBy(xpath = "//h2[text()='Your bag is empty']")
    private WebElement massageAboutEmptyBag;
    @FindBy(xpath = "//button[@aria-label='Delete this item']")
    private WebElement buttonOfDeleteProductFromBag;

    public void chooseSizeForProduct(String enterSize) {
         for (WebElement size : listOfSizeOfProductInBag){
        System.out.println(size.getText());
        if(size.getText().equals(enterSize)){
            size.click();
            break;
        }
    }
}
    public WebElement getLoadSizeList(){return loadSizeList;}
    public WebElement getMenuOfSizeOfProductInBag(){return menuOfSizeOfProductInBag;}
    public WebElement getElementOfActualSizeOfProductInBag(){return actualSizeOfProductInBag;}
    public String getActualSizeOfProductInBag(){return actualSizeOfProductInBag.getText();}
    public WebElement getButtonOfDeleteProductFromBag(){return buttonOfDeleteProductFromBag;}
    public void clickButtonOfDeleteProductFromBag(){buttonOfDeleteProductFromBag.click();}
    public WebElement getMassageAboutEmptyBag(){return massageAboutEmptyBag;}
    public boolean isMassageAboutEmptyBagDisplayed(){return massageAboutEmptyBag.isDisplayed();}
    public void clickMenuOFSize(){
        menuOfSizeOfProductInBag.click();
    }
}
