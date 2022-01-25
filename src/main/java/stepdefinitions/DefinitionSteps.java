package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Locale;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final long TIME_TO_WAIT = 30;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SignInPage signInPage;
    SearchResultPage searchResultPage;
    OutletPage outletPage;
    ProductPage productPage;
    WishListPage wishListPage;
    BagPage bagPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User moves cursor on icon of sign in")
    public void userMovesCursorOnIconOfSignIn() {
        homePage.moveCursorOnIconOfSignIn();
    }

    @And("User checks that icon of my account is visible")
    public void userChecksThatIconOfMyAccountIsVisible() {
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getIconOfMyAccount());
        Assert.assertTrue(homePage.isIconOfMyAccountDisplayed());
    }

    @And("User clicks on icon of my account")
    public void userClicksOnIconOfMyAccount() {
        homePage.clickOnIconOfMyAccount();
    }

    @And("User enters {string} and {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        signInPage = pageFactoryManager.getSigInPage();
        signInPage.sendEmail(email);
        signInPage.sendPassword(password);
    }

    @And("User clicks button of sign in")
    public void userClicksButtonOfSignIn() {
        signInPage.clickOnButtonOfSignIn();
    }

    @Then("User check a {string} about wrong email")
    public void userCheckAMassageAboutWrongEmail(String massage) {
        Assert.assertEquals(signInPage.getMassageOfWrongEmail(), (massage));
    }


    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(String searchWord) {
        homePage.searchByWord(searchWord);
    }

    @And("User clicks on menu of sort")
    public void userClicksOnMenuOfSort() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clicksMenuOfSort();
    }

    @And("User chooses sort by {string}")
    public void userChoosesSortByTypeOfSort(String typeOfSort) {
        searchResultPage.chooseTypeOfSort(typeOfSort);
    }

    @And("User checks that {string} is updated")
    public void userChecksThatSortUpdated(String typeOfSort) {
        searchResultPage.clicksMenuOfSort();
        searchResultPage.waitVisibilityOfElement(TIME_TO_WAIT, searchResultPage.getActiveTypeOfSort(typeOfSort));
        Assert.assertTrue(searchResultPage.isActiveTypeOfSortVisibility(typeOfSort));
    }

    @Then("User checks that products are sorted by {string}")
    public void userChecksThatProductsAreSortedByTypeOfSort(String typeOfSort) {
        Assert.assertTrue(searchResultPage.isSortedByPrice(searchResultPage.getListOfProductsPrice(), typeOfSort));
    }

    @And("User chooses products for man")
    public void userChoosesProductsForMan() {
        homePage.clickOnProductsForMan();
    }

    @And("User moves cursor on icon of sale")
    public void userMovesCursorOnIconOfSale() {
        homePage.moveCursorToMenuOfSale();
    }

    @And("User clicks on button off view all")
    public void userClicksOnButtonOffViewAll() {
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getProductsWithSale());
        homePage.clickProductsWithSale();
    }

    @Then("User checks that price with sale is correct")
    public void userChecksThatPriceWithSaleIsCorrect() {
        outletPage = pageFactoryManager.getOutletPage();
        Assert.assertTrue(outletPage.checkCorrectSalePrice(outletPage.getListOfPreviousPrice(), outletPage.getListOfPriceWithSale()));
    }

    @And("User checks that search is working")
    public void userChecksThatSearchIsWorking() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitVisibilityOfElement(TIME_TO_WAIT, searchResultPage.getMassageAboutSearchResult());
        Assert.assertTrue(searchResultPage.isMassageAboutSearchResultVisible());
    }

    @Then("User check that search is working correctly and all products contains {string}")
    public void userCheckThatSearchIsWorkingCorrectlyAndAllProductsContainsKeyword(String searchWord) {
//        for (WebElement element : searchResultPage.getListOfNameOfProducts()) {
//            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains(searchWord));
//        }
        Assert.assertTrue(searchResultPage.isAllProductsContainKeyword(searchWord));
    }

    @And("User clicks on filter by brand")
    public void userClicksOnFilterByAbercrombie() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickButtonOfFilterByBrand();
    }

    @And("User chooses filter by Abercrombie")
    public void userChoosesFilterByAbercrombie() {
        searchResultPage.clickFilterByBrandAbercrombie();
    }

    @Then("User checks that filter is correct and all products are {string}")
    public void userChecksThatAllProductsAreBrand(String brandForFilter) {
        searchResultPage.waitForPageLoadComplete(TIME_TO_WAIT);
        Assert.assertTrue(searchResultPage.isAllProductsAreBrand(brandForFilter));
    }

    @And("User checks that filter is active")
    public void userChecksThatFilterIsActive() {
        searchResultPage.waitVisibilityOfElement(TIME_TO_WAIT, searchResultPage.getFilterByBrandAbercrombieIsActive());
        Assert.assertTrue(searchResultPage.isFilterByBrandAbercrombieIsActiveVisibility());
    }

    @And("User clicks add to bag button on product")
    public void userClicksAddToBagButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickButtonAddToBag();
    }

    @Then("User checks {string} about missing choose side visibility")
    public void userChecksMassageAboutMissingChooseSideVisibility(String massage) {
        Assert.assertEquals(productPage.getMassageAboutMissingChooseSizeOptions(), massage);
    }

    @And("User clicks add product to wish list")
    public void userClicksAddProductToWishList() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickButtonOfAddProductToWishList();
    }

    @And("User clicks on button of wish list page")
    public void userClicksOnButtonOfWishListPage() {
        productPage.clickButtonOfWishListPage();
    }

    @And("User checks visibility of product in wish list")
    public void userChecksVisibilityOfProductInWishList() {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitVisibilityOfElement(TIME_TO_WAIT, wishListPage.getProductInWishList());
        Assert.assertTrue(wishListPage.IsProductInWishListVisibility());
    }

    @Then("User checks that the name of product in wish list is {string}")
    public void userChecksChecksThatTheNameOfProductInWishListIsKeyword(String nameOfProduct) {
        Assert.assertEquals(wishListPage.getNameOfProductInWishList(), nameOfProduct);
    }

    @And("User clicks on button for choose country")
    public void userClicksOnButtonForChooseCountry() {
        homePage.clickButtonForChooseCountry();
    }

    @And("User checks that preferences is open")
    public void userChecksThatPreferencesIsOpen() {
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getTitleOfWindowOfPreference());
        Assert.assertTrue(homePage.isTitleOfWindowPreferenceDisplayed());
    }

    @And("User clicks country menu button")
    public void userClicksCountryMenuButton() {
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getMenuOfCountry());
        homePage.clickMenuOfCountry();
    }

    @And("User choose {string}")
    public void userChooseCountry(String country) {
        homePage.chooseCountry(country);
    }

    @And("User click on button of update")
    public void userClickOnButtonOfUpdate() {
        homePage.waitVisibilityOfElement(TIME_TO_WAIT, homePage.getButtonOfUpdate());
        homePage.clickButtonOfUpdate();
    }

    @Then("User check a new country's flag")
    public void userCheckANewCountrySFlag() {//Assert.assertTrue(homePage.getIconOfFlagOfUs().isDisplayed());
        Assert.assertTrue(homePage.isGetIconOfFlagOfUsVisible());
    }

    @And("User chooses {string} for product")
    public void userChoosesSizeForProduct(String size) {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickMenuOfSize();
        productPage.chooseSizeForProduct(size);
    }

    @And("User adds product to bag")
    public void userAddsProductToBag() {
        productPage.clickButtonAddToBag();
    }

    @And("User opens bag")
    public void userOpensBag() {
        productPage.waitVisibilityOfElement(TIME_TO_WAIT, productPage.getButtonOfViewBag());
        productPage.clickButtonOfViewBag();
    }

    @And("User swap {string}")
    public void userSwapNewSize(String newSize) {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitElementToBeClickable(TIME_TO_WAIT, bagPage.getMenuOfSizeOfProductInBag());
        bagPage.waitElementToBeClickable(TIME_TO_WAIT, bagPage.getElementOfActualSizeOfProductInBag());
        bagPage.clickMenuOFSize();
        bagPage.waitVisibilityOfElement(TIME_TO_WAIT, bagPage.getLoadSizeList());
        bagPage.chooseSizeForProduct(newSize);
    }

    @Then("User checks that product in {string}")
    public void userChecksThatProductInNewSize(String newSize) {
        Assert.assertEquals(bagPage.getActualSizeOfProductInBag(), newSize);
    }

    @And("User clicks delete product from bag")
    public void userClicksDeleteProductFromBag() {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitVisibilityOfElement(TIME_TO_WAIT, bagPage.getButtonOfDeleteProductFromBag());
        bagPage.clickButtonOfDeleteProductFromBag();
    }

    @Then("User checks that bag is empty")
    public void userChecksThatBagIsEmpty() {
        bagPage.waitVisibilityOfElement(TIME_TO_WAIT, bagPage.getMassageAboutEmptyBag());
        Assert.assertTrue(bagPage.isMassageAboutEmptyBagDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
