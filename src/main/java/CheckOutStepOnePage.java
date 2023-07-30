import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage extends  BasePage{

    @FindBy(id = "first-name")
    WebElement name;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement cont;

    @FindBy(className = "summary_total_label")
    WebElement priceTotal;

    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotal;

    @FindBy(css = ".cart_footer #finish")
    WebElement finish;

    @FindBy(className = "complete-header")
    WebElement thanksMessage;

    public CheckOutStepOnePage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void form()
    {
        name.sendKeys("Uros");
        lastName.sendKeys("Spasojevic");
        postalCode.sendKeys("11000");
        cont.click();
    }

    public String getPrice()
    {
        return priceTotal.getText();
    }

    public String getPriceItem()
    {
        return itemTotal.getText();
    }

    public void clickFinish()
    {
        finish.click();
    }

    public String getMessage()
    {
        return thanksMessage.getText();
    }

}
