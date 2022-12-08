package Pages;

public class BookResultPage extends BasePage{
    public static final String
    SELECTED_BOOK = "//*[contains(text(),'I Love to Brush My Teeth')]";
    public static final String
    FORMAT = "//*[@id='SingleOptionSelector-0']";
    public static final String
    HARDCOVER_FORMAT = "//*[@value = 'Hardcover']";
    public static final String
    QUANTITY = "//input[@name = 'quantity']";
    public static final String
    ADD_BUTTON = "//button [@id='AddToCart-product-template']";

    public CartPage bookSelection(){
        findElementByXpath(FORMAT).click();
        findElementByXpath(HARDCOVER_FORMAT).click();
        findElementByXpath(QUANTITY).clear();
        findElementByXpath(QUANTITY).sendKeys("5");
        findElementByXpath(ADD_BUTTON).click();
        return new CartPage();

}
    public boolean isBookResultPageVisible(){
      return elementExists(ADD_BUTTON);
}


}
