package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='q']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@id='find']")
    private WebElement findButton;

    @FindBy(xpath = "//a[contains(@href, 'computer_equipment')]")
    private WebElement computerEquipmentSidebarButton;

    @FindBy(xpath = "//a[contains(@href, 'mobile_connection')]")
    private WebElement mobileConnectionSidebarButton;

    @FindBy(xpath = "//a[@id='logo']")
    private WebElement homePageButton;

    @FindBy(xpath = "//span[@class='login-link']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='lf']")
    private WebElement loginPopup;

    @FindBy(xpath = "//input[@id='lf-login']")
    private WebElement loginPopupLoginField;

    @FindBy(xpath = "//input[@id='lf-password']")
    private WebElement loginPopupPasswordField;

    @FindBy(xpath = "//button[@class='mw-submit']")
    private WebElement loginPopupEnterButton;

    @FindBy(xpath = "//div[@id='autho']/ul/li/a[@class='ml-a']")
    private WebElement userProfileName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickOnFindButton() {
        findButton.click();
    }

    public void clickOnComputerEquipmentSidebarButton() {
        computerEquipmentSidebarButton.click();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public WebElement getLoginPopup() {
        return loginPopup;
    }

    public boolean isLoginPopupLoginFieldVisible() {
        return loginPopupLoginField.isDisplayed();
    }

    public boolean isLoginPopupPasswordFieldVisible() {
        return loginPopupPasswordField.isDisplayed();
    }

    public boolean isLoginPopupEnterButtonVisible() {
        return loginPopupEnterButton.isDisplayed();
    }

    public void enterLoginToLoginField(String login) {
        loginPopupLoginField.clear();
        loginPopupLoginField.sendKeys(login);
    }

    public void enterPasswordToPasswordField(String password) {
        loginPopupPasswordField.clear();
        loginPopupPasswordField.sendKeys(password);
    }

    public void clickOnLoginPopupEnterButton() {
        loginPopupEnterButton.click();
    }

    public WebElement getUserProfileName() {
        return userProfileName;
    }
}
