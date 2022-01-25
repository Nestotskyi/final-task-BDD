package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='overflowFade_2Vvqr']//p")
    private WebElement productInWishList;

    public String getNameOfProductInWishList(){
        return productInWishList.getText();
    }
    public boolean IsProductInWishListVisibility(){
       return productInWishList.isDisplayed();
    }
    public WebElement getProductInWishList(){
        return productInWishList;
    }
}
