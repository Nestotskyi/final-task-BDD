package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Add to bag']")
    private WebElement buttonAddToBag;
    @FindBy(xpath = "//span[@class='error basic-error-box']")
    private WebElement massageAboutMissingChooseSizeOptions;
    @FindBy(xpath = "//button[@class='i5hAj _5AuCN']")
    private WebElement buttonOfAddProductToWishList;
    @FindBy(xpath = "//span[@type='heartUnfilled']")
    private WebElement buttonOfWishListPage;
    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement menuOfSize;
    @FindBy(xpath = "//select[@data-id='sizeSelect']//option")
    private List<WebElement> listOfSizeOfProduct;
    @FindBy(xpath = "//span[text()='View Bag']")
    private WebElement buttonOfViewBag;

    public void chooseSizeForProduct(String enterSize) {
        for (WebElement size : listOfSizeOfProduct){
            if(size.getText().equals(enterSize)){
                size.click();
                break;
            }
        }
    }
    public WebElement getButtonOfViewBag(){return buttonOfViewBag;}
    public void clickButtonOfViewBag(){buttonOfViewBag.click();}
    public void clickMenuOfSize(){menuOfSize.click();}
    public void clickButtonOfWishListPage(){
        buttonOfWishListPage.click();
    }
    public void clickButtonOfAddProductToWishList(){
        buttonOfAddProductToWishList.click();
    }
    public void clickButtonAddToBag(){
        buttonAddToBag.click();
    }
    public String getMassageAboutMissingChooseSizeOptions(){
        return massageAboutMissingChooseSizeOptions.getText();
    }
}
