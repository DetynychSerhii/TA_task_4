package tests;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {

    private static final long DEFAULT_TIME_TO_WAIT = 90;
    private static final long DEFAULT_ACTIONS_TIME_TO_WAIT = 2;
    private static final String SEARCH_KEYWORD = "intel core i9";
    private static final int COMPARED_PRODUCTS_COUNT = 2;
    private static final String LOGIN = "tovawim588@3dmasti.com";
    private static final String PASSWORD = "Qazwsxedc123";


    @Test(priority = 3)
    public void checkCostASCSorting() {
        getHomePage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().waitForAjaxComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().clickOnComputerEquipmentSidebarButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getComputerEquipmentPage().clickOnComputersButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getComputersPage().clickOnDesktopsButton();
        getAction().moveToElement(getSearchResultPage().getFirstFilterDropdown())
                .click()
                .pause(Duration.ofSeconds(DEFAULT_ACTIONS_TIME_TO_WAIT))
                .moveToElement(getSearchResultPage().getOrderByCostASCButton())
                .click()
                .pause(Duration.ofSeconds(DEFAULT_ACTIONS_TIME_TO_WAIT)).build().perform();
        getDesktopsPage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getDesktopsPage().waitForAjaxComplete(DEFAULT_TIME_TO_WAIT);


        assertTrue(getSearchResultPage().isProductListOrderByCostASC());
    }

    @Test(priority = 2)
    public void checkThatProductsCanBeCompare() {
        getHomePage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().waitForAjaxComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().enterTextToSearchField(SEARCH_KEYWORD);
        getHomePage().clickOnFindButton();
        getSearchResultPage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getSearchResultPage().clickOnSecondProductInList();
        getProductPage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getProductPage().clickOnAddToCompareButton();
        getDriver().navigate().back();
        getSearchResultPage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getSearchResultPage().clickOnFirstProductInList();
        getProductPage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getProductPage().clickOnAddToCompareButton();
        getProductPage().waitForAjaxComplete(DEFAULT_TIME_TO_WAIT);
        assertTrue(getProductPage().isCompareButtonVisible());
        getProductPage().clickOnCompareButton();
        getCompareProductsPage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        assertEquals(getCompareProductsPage().getComparedProductsList().size(), COMPARED_PRODUCTS_COUNT);
    }

    @Test(priority = 1)
    public void checkLoginAbility() {
        getHomePage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().waitForAjaxComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().clickOnLoginButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_TIME_TO_WAIT, getHomePage().getLoginPopup());

        assertTrue(getHomePage().isLoginPopupLoginFieldVisible());
        assertTrue(getHomePage().isLoginPopupPasswordFieldVisible());
        assertTrue(getHomePage().isLoginPopupEnterButtonVisible());

        getHomePage().enterLoginToLoginField(LOGIN);
        getHomePage().enterPasswordToPasswordField(PASSWORD);
        getHomePage().clickOnLoginPopupEnterButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_TIME_TO_WAIT);
        getHomePage().waitForAjaxComplete(DEFAULT_TIME_TO_WAIT);

        assertTrue(getHomePage().getUserProfileName().getText().toLowerCase(Locale.ROOT).contains("user"));
    }
}
