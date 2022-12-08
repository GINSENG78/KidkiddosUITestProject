package Pages;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public static final String
    LOGIN_HEADER = "//h1[text()='Login']";
    public static final String
    SIGN_IN_BUTTON = "//input[@value='Sign In']";
    public static final String
    ERROR_MESSAGE = "//*[text()='Incorrect email or password.']";
    public static final String
    EMAIL_MENU = "//input[@id='CustomerEmail']";

    public static final String
    PASSWORD_MENU = "//input[@id='CustomerPassword'] ";

    public boolean isPageTitleVisible(){

        return elementExists(LOGIN_HEADER);
    }
    public boolean isErrorMessageVisible(){
        findElementByXpath(SIGN_IN_BUTTON).click();
    return elementExists(ERROR_MESSAGE);
    }

    public boolean isErrorMessageVisible2() {
        findElementByXpath(EMAIL_MENU).sendKeys("12345@gmail.corm");
        findElementByXpath(PASSWORD_MENU).sendKeys("+++++");
        findElementByXpath(SIGN_IN_BUTTON).click();
        return elementExists(ERROR_MESSAGE);

    }

}
