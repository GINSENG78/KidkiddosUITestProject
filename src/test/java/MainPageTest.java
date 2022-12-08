import Pages.*;
import Utils.UseCaseBase;
import com.sun.jdi.Value;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {
    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest() {
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }

    @Test
    public void openContactUsPage() {
        ContactUsPage contactUsPage = mainPage.openContactUsTab();
        boolean isLoaded = contactUsPage.isPageTitleIsVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openLoginPage() {
        logger.info("Open Login Page test");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isLoaded = loginPage.isPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void emptyLogin() {
        logger.info("Empty login test");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isVisible = loginPage.isErrorMessageVisible();
        loginPage.takeScreenshot("Error message Empty login and password");
        assertTrue(isVisible);
    }

    @Test
    public void wrongLoginAndPassword() {
        logger.info("Wrong Login and Password test");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isVisible = loginPage.isErrorMessageVisible2();
        loginPage.takeScreenshot("Error message Wrong login and password");
        assertTrue(isVisible);

    }
    @Test
            public void orderBookByLanguage() throws InterruptedException {
        logger.info("Book by language- English Only");
        ProductPage productPage = mainPage.openProductPage();
        boolean isVisible = productPage.isBookTitleVisible();
        assertTrue(isVisible);
        productPage.chooseBook();
        BookResultPage bookResultPage = new BookResultPage();
        assertTrue(bookResultPage.isBookResultPageVisible());
        bookResultPage.bookSelection();
        CartPage cartPage = new CartPage();
        assertTrue(cartPage.isCartPageTitleVisible());
        cartPage.changeQuantity();

        assertEquals("191,94",cartPage.getUpdatedPrice() );
    }



}
