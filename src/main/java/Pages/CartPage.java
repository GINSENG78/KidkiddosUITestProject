package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage extends BasePage {
    public static final String
            CART_HEADER = "//*[text() = 'Your cart']";
    public static final String
            QUANTITY = "//input[@type='number']";
    public static final String
            UPDATE_BUTTON = "//input[@class='cart__update']";
    public static final String
            TOTAL_PRICE = "//span[@class = 'cbb-price-digits']";

    public static final String
            NEW_TOTAL_PRICE = "191,94";

    public boolean isCartPageTitleVisible() {

        return elementExists(CART_HEADER);

    }
    public void changeQuantity() {
        findElementByXpath(QUANTITY).clear();
        findElementByXpath(QUANTITY).sendKeys("6");

        WebElement updateButton = webDriver.findElement(By.xpath(UPDATE_BUTTON));
//Instantiating Actions class
        Actions actions = new Actions(webDriver);
//Hovering on main menu
        actions.moveToElement(updateButton);

//build()- used to compile all the actions into a single step
        actions.click().build().perform();


    }

    public String getUpdatedPrice(){
//        String newValue =
        System.out.println(findElementByXpath(TOTAL_PRICE).getText());
        return findElementByXpath(TOTAL_PRICE).getText();
    }
}
