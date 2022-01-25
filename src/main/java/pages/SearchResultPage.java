package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[text()='Sort']")
    private WebElement menuOfSort;
    @FindBy(xpath = "//li[text()='Price high to low']")
    private WebElement priceFromHighToLow;
    @FindBy(xpath = "//li[text()='Price low to high']")
    private WebElement priceFromLowToHigh;
    @FindBy(xpath = "//span[@class='_3VjzNxC']")
    private List<WebElement> listOfProductsPrice;
    @FindBy(xpath = "//li[@class='_1qJXvQ0 _3UVTD1P' and text()='Price low to high']")
    private WebElement activeSortByPriceFromLowToHigh;
    @FindBy(xpath = "//li[@class='_1qJXvQ0 _3UVTD1P' and text()='Price high to low']")
    private WebElement activeSortByPriceFromHighToLow;
    @FindBy(xpath = "//p[text()='Your search results for:']")
    private WebElement massageAboutSearchResult;
    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']//h2")
    private List<WebElement> listOfNameOfProducts;
    @FindBy(xpath = "//div[text()='Brand']")
    private WebElement buttonOfFilterByBrand;
    @FindBy(xpath = "//div[text()='Abercrombie & Fitch']")
    private WebElement filterByBrandAbercrombie;
    @FindBy(xpath = "//label[contains(@class,' _2epgqE1')]//div[text()='Abercrombie & Fitch']")
    private WebElement filterByBrandAbercrombieIsActive;

    public boolean isSortedByPrice(List<WebElement> webElements, String typeOfSort) {
        List<Double> ppp=webElements.stream()
                .map(a->Double.parseDouble(a.getText().substring(1)))
                .collect(Collectors.toList());
        boolean isSorted = true;
        for (int i = 0; i < webElements.size() - 1; i++) {
            if (typeOfSort.equals("FromHighToLow")) {
                if (ppp.get(i) < ppp.get(i + 1)) {
                    isSorted = false;
                }
            } else {
                if (ppp.get(i) > ppp.get(i + 1)) {
                    isSorted = false;
                }
            }
        }
        return isSorted;
    }
    public boolean isAllProductsAreBrand(String brand){
        boolean result = true;
        for(WebElement element:listOfNameOfProducts){
            if(!element.getText().toLowerCase(Locale.ROOT).contains(brand.toLowerCase(Locale.ROOT))){
                result=false;
            }
        }return result;
    }
    public void chooseTypeOfSort(String typeOfSort) {
        if(typeOfSort.equals("FromHighToLow")) {
            priceFromHighToLow.click();
        }else priceFromLowToHigh.click();
    }
    public WebElement getActiveTypeOfSort(String typeOfSort){
        if (typeOfSort.equals("FromHighToLow")) {
            return activeSortByPriceFromHighToLow;
        }else return activeSortByPriceFromLowToHigh;}

    public boolean isActiveTypeOfSortVisibility(String typeOfSort){
        if (typeOfSort.equals("FromHighToLow")) {
            return activeSortByPriceFromHighToLow.isDisplayed();
        }else return activeSortByPriceFromLowToHigh.isDisplayed();}

    public boolean isAllProductsContainKeyword(String keyword){
        boolean result = true;
        for(WebElement element:listOfNameOfProducts){
            if(!element.getText().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))){
                result=false;
            }
        }return result;
    }
    public boolean isMassageAboutSearchResultVisible(){return massageAboutSearchResult.isDisplayed();}
    public WebElement getMassageAboutSearchResult(){return massageAboutSearchResult;}
    public void clicksMenuOfSort(){menuOfSort.click();}
    public List<WebElement> getListOfProductsPrice(){return listOfProductsPrice;}
    public WebElement getFilterByBrandAbercrombieIsActive(){return filterByBrandAbercrombieIsActive;}
    public void clickButtonOfFilterByBrand(){
        buttonOfFilterByBrand.click();
    }
    public void clickFilterByBrandAbercrombie(){filterByBrandAbercrombie.click();}
    public List<WebElement> getListOfNameOfProducts(){return listOfNameOfProducts;}
    public boolean isFilterByBrandAbercrombieIsActiveVisibility(){return filterByBrandAbercrombieIsActive.isDisplayed();}
}
