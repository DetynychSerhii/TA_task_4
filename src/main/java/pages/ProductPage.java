package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class,'compare')]")
    private WebElement addToCompareButton;

    @FindBy(xpath = "//a[contains(@class,'compare')]")
    private WebElement compareButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCompareButton() {
        addToCompareButton.click();
    }

    public boolean isCompareButtonVisible() {
        return compareButton.isDisplayed();
    }

    public void clickOnCompareButton() {
        compareButton.click();
    }

    public WebElement getAddToCompareButton() {
        return addToCompareButton;
    }
}
