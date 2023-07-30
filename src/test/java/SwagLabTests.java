import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabTests extends BaseTest{

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckOutStepOnePage checkOutStepOnePage;

    @BeforeMethod
    public void setUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
    }

    @Test
    public void login()
    {
        loginPage.LoginOnPage("standard_user","secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void loginWithOutPassword()
    {
        loginPage.LoginOnPage("standard_user","");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Password is required");
    }

    @Test
    public void loginWithInvalidPassword()
    {
        loginPage.LoginOnPage("standard_user","sreta");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidUsername()
    {
        loginPage.LoginOnPage("uros","secret_sauce");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void buyProducts()
    {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.lowToHigh();
        inventoryPage.addItems();
        inventoryPage.clickOnCart();

        Assert.assertEquals(cartPage.getNumberOfItem(),"3");
    }

    @Test
    public void checkTotalPrice()
    {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addItems();
        inventoryPage.clickOnCart();
        cartPage.clickCheckout();
        checkOutStepOnePage.form();

        Assert.assertEquals(checkOutStepOnePage.getPrice(), "Total: $36.69");
    }

    @AfterMethod
    public void after()
    {
        driver.quit();

    }




}
