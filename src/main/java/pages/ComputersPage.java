package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersPage extends BasePage{

    @FindBy(xpath = "//div[@class='cat-cell']//a[contains(@href, 'desktops')]")
    private WebElement desktopsButton;

    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDesktopsButton() {
        desktopsButton.click();
    }
}
