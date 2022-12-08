package Pages;

import Consts.Consts;

public class MainPage extends BasePage{

    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String CONTACT_US_OPTION = "//a[text()='Contact us']";
    private static final String LOGIN = "//*[@class = 'icon icon-login']";
    private static final String BOOKS_BY_LANGUAGE = "//a[@aria-controls= 'SiteNavLabel-books-by-language']";
    private static final String ENGLISH_ONLY = "//*[text()='English Only']";
    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);
    }
    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
    public ContactUsPage openContactUsTab(){
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }
    public LoginPage openLoginPage(){
        clickElementByXpath(LOGIN);
        return new LoginPage();
    }
    public ProductPage openProductPage (){
        clickElementByXpath(BOOKS_BY_LANGUAGE);
        return new ProductPage();

    }

}
