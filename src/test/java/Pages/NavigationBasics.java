package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class NavigationBasics {

    public NavigationBasics(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement loginbtn;

    @FindBy(how = How.ID, using = "contact-link")
    private WebElement contactbtn;

    @FindBy(how = How.ID, using = "header_logo")
    private WebElement home;

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchbar;

    @FindBy(how = How.NAME, using = "submit_search")
    private WebElement searchbtn;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "controller=order")
    private WebElement cartbtn;

    public void LoginPage() { loginbtn.click(); }

    public void ContactPage() { contactbtn.click(); }

    public void HomePage(){ home.click(); }

    public void SearchBar() { searchbar.click(); }

    public void Search(String key){
        searchbar.sendKeys(key);
        searchbtn.click();
    }

    public void CartPage(){ cartbtn.click(); }
}