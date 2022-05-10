package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//div[@class='sb-item current']")
    private List<WebElement> filtersDropdownsList;

    @FindBy(xpath = "//a[@class='vit-name']")
    private List<WebElement> productsOnSearchResultPage;

    @FindBy(xpath = "//div[@class='select-filter clearfix']//a[contains(@href,'cost&orderdir=asc')]")
    private WebElement orderByCostASCButton;

    @FindBy(xpath = "//li[@class='vit-item']//span[@class='tovar-price']")
    private List<WebElement> cellphonesPriceList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstProductInList() {
        productsOnSearchResultPage.get(0).click();
    }

    public void clickOnSecondProductInList() {
        productsOnSearchResultPage.get(1).click();
    }

    public WebElement getFirstFilterDropdown() {
        return filtersDropdownsList.get(0);
    }

    public WebElement getOrderByCostASCButton() {
        return orderByCostASCButton;
    }

    public List<WebElement> getCellphonesPriceList() {
        return cellphonesPriceList;
    }

    public boolean isProductListOrderByCostASC() {
        boolean isOrdered;
        if (getCellphonesPriceList().size() != 0) {
            int price = parseFullStringPriceIntoInt(getCellphonesPriceList().get(0));
            for (WebElement element : getCellphonesPriceList()) {
                isOrdered = price <= parseFullStringPriceIntoInt(element);
                if (!isOrdered) {
                    return false;
                }
                price = parseFullStringPriceIntoInt(element);
            }
        }
        return true;
    }

    private int parseFullStringPriceIntoInt(WebElement element) {
        return Integer.parseInt(element.getText().replaceAll("[a-zA-Zа-яА-Я ]+", ""));
    }

}
