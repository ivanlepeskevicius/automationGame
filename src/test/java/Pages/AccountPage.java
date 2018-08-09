package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AccountPage {

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using =  "page-heading")
    private  WebElement pageTitle;

    @FindBy(how = How.XPATH, using = "//*[@title='Orders']")
    private WebElement orders;

    @FindBy(how = How.XPATH, using = "//*[@title='Credit slips']")
    private WebElement credits;

    @FindBy(how = How.XPATH, using = "//*[@title='Addresses']")
    private WebElement addresses;

    @FindBy(how = How.XPATH, using = "//*[@title='Information']")
    private WebElement information;

    @FindBy(how = How.XPATH, using = "//*[@title='My wishlists']")
    private WebElement wishlists;


    public String PageTitle(){
        String title = pageTitle.getText();
        return title;
    }

    public void OrdersPage(){ orders.click(); }

    public void CreditsPage(){ credits.click(); }

    public void AddressesPage(){ addresses.click(); }

    public void PersonalInformationPage(){ information.click(); }

    public void WishlistsPage(){ wishlists.click(); }


}