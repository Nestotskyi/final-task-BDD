package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;
    public PageFactoryManager(WebDriver driver){this.driver=driver;}
    public HomePage getHomePage(){return new HomePage(driver);}
    public SignInPage getSigInPage(){return new SignInPage(driver);}
    public SearchResultPage getSearchResultPage(){return new SearchResultPage(driver);}
    public OutletPage getOutletPage(){return new OutletPage(driver);}
    public ProductPage getProductPage(){return new ProductPage(driver);}
    public WishListPage getWishListPage(){return new WishListPage(driver);}
    public BagPage getBagPage(){return new BagPage(driver);}

}
