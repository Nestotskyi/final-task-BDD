package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='Username']")
    private WebElement fieldForInputEmail;
    @FindBy(xpath = "//input[@name='Password']")
    private WebElement fieldForInputPassword;
    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonOFSignIn;
    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement massageOfWrongEmail;

    public void sendEmail(final String email){
        fieldForInputEmail.sendKeys(email);
    }
    public void sendPassword(final String password){
        fieldForInputPassword.sendKeys(password);
    }
    public void clickOnButtonOfSignIn(){
        buttonOFSignIn.click();
    }
    public String getMassageOfWrongEmail(){return   massageOfWrongEmail.getText();}
}
