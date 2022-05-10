package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProductsPage extends BasePage {

    @FindBy(xpath = "//td[@class='compare-header-top']")
    private List<WebElement> comparedProductsList;

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getComparedProductsList() {
        return comparedProductsList;
    }
}
