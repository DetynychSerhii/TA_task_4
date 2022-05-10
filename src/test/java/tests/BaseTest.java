package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private final CapabilityFactory capabilityFactory = new CapabilityFactory();
    private Actions action;

    private static final String ELMIR_URL = "https://elmir.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.131.220:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(ELMIR_URL);
        action = new Actions(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public Actions getAction() {
        return action;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public ComputerEquipmentPage getComputerEquipmentPage() {
        return new ComputerEquipmentPage(getDriver());
    }

    public ComputersPage getComputersPage() {
        return new ComputersPage(getDriver());
    }

    public DesktopsPage getDesktopsPage() {
        return new DesktopsPage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

    public CompareProductsPage getCompareProductsPage() {
        return new CompareProductsPage(getDriver());
    }
}
