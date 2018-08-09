package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {

    public PersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "page-subheading")
    private WebElement pageTitle;
    @FindBy(how = How.ID, using = "id_gender1")
    private WebElement male;
    @FindBy(how = How.ID, using = "id_gender2")
    private WebElement female;
    @FindBy(how = How.ID, using = "firstname")
    private WebElement firstname;
    @FindBy(how = How.ID, using = "lastname")
    private WebElement lastname;
    @FindBy(how = How.ID, using = "email")
    private WebElement txtUserName;
    @FindBy(how = How.ID, using = "days")
    private WebElement days;
    @FindBy(how = How.ID, using = "months")
    private WebElement months;
    @FindBy(how = How.ID, using = "years")
    private WebElement years;
    @FindBy(how = How.ID, using = "old_passwd")
    private WebElement oldPasswd;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement newPasswd;
    @FindBy(how = How.ID, using = "confirmation")
    private WebElement confirmationPasswd;
    @FindBy(how = How.ID, using = "newsletter")
    private WebElement newsletter;
    @FindBy(how = How.ID, using = "optin")
    private WebElement optin;
    @FindBy(how = How.XPATH, using = "//*[@name='submitIdentity']")
    private WebElement submit;
    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    private WebElement successMsg;

    public String PageTitle(){
        String subtitle = pageTitle.getText();
        return subtitle;
    }

    public void changeName() {
        String name = firstname.getText();
        String lastName = lastname.getTagName();
        firstname.sendKeys(lastName);
        lastname.sendKeys(name);
    }

    public void submitChanges() {
        oldPasswd.sendKeys("admin1234*");
        submit.click();
    }

}
