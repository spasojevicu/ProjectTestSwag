import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(className = "shopping_cart_link")
    WebElement number;

    @FindBy(css = ".cart_footer #checkout")
    WebElement checkout;


    public CartPage(ChromeDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getNumberOfItem()
    {
        return  number.getText();
    }

    public void clickCheckout()
    {
        checkout.click();
    }

}
