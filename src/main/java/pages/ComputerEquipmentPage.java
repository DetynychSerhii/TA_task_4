package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerEquipmentPage extends BasePage{

    @FindBy(xpath = "//a[contains(@href, 'computers')]")
    private WebElement computersButton;

    public ComputerEquipmentPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnComputersButton() {
        computersButton.click();
    }
}
