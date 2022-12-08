package Pages;

public class ProductPage extends BasePage {

    public static final String
    PRODUCT_PAGE_HEADER = "//*[text()='English Only']";

    public static final String
            BOOK_1 = "//*[contains(text(),'I Love to Brush My Teeth')]";

    public boolean isBookTitleVisible(){
        return elementExists(PRODUCT_PAGE_HEADER);
    }

    public BookResultPage chooseBook(){
        findElementByXpath(BOOK_1).click();
    return new BookResultPage();
    }


}
