import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(className = "shopping_cart_link")
    WebElement number;

    @FindBy(css = ".cart_footer #checkout")
    WebElement checkout;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    WebElement removeR;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeJ;

    @FindBy(id = "continue-shopping")
    WebElement back;

    public void erase()
    {
        removeJ.click();
        removeR.click();
        back.click();
    }


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
