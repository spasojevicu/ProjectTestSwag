import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement onesie;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement shirt;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement light;

    @FindBy(className = "shopping_cart_badge")
    WebElement cart;

    @FindBy(className = "product_sort_container")
    WebElement sort;
    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addItems()
    {
        onesie.click();
        shirt.click();
        light.click();
    }

    public void clickOnCart()
    {
        cart.click();
    }

    public void lowToHigh()
    {
        Select select = new Select(sort);
        select.selectByVisibleText("Price (low to high)");
    }



}
