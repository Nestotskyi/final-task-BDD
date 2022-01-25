package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class OutletPage extends BasePage{
    public OutletPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@class='_16nzq18']")
    private List<WebElement> listOfPreviousPrice;
    @FindBy(xpath = "//span[@class='_3VjzNxC']")
    private List<WebElement> listOfPriceWithSale;

    public boolean checkCorrectSalePrice(List<WebElement> listOfPreviousPrice,List<WebElement> listOfPriceWithSale){
        List<Double> doubleListOfPreviousPrice=listOfPreviousPrice.stream()
                .map(a->Double.parseDouble(a.getText().substring(1)))
                .collect(Collectors.toList());
        List<Double> doubleListOfPriceWithSale=listOfPreviousPrice.stream()
                .map(a->Double.parseDouble(a.getText().substring(1)))
                .collect(Collectors.toList());

        boolean isCorrect =true;
        for(int i=0;i<listOfPreviousPrice.size();i++){
            if(doubleListOfPreviousPrice.get(i)<doubleListOfPriceWithSale.get(i)){
                System.out.println(doubleListOfPreviousPrice.get(i));
                isCorrect=false;
            }
        }
        return isCorrect;
    }
    public List<WebElement> getListOfPreviousPrice(){
        return listOfPreviousPrice;
    }
    public List<WebElement> getListOfPriceWithSale(){
        return listOfPriceWithSale;
    }
}
