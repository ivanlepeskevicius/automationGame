package Steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import Pages.LoginPage;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginStep extends BaseUtil{

    private  BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage(){

        System.out.println("Navigate Login Page");
        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base.Driver.navigate().to("http://automationpractice.com/index.php");
        base.Driver.findElement(By.className("login")).click();

    }

    @When("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table){
        //Create an ArrayList
        List<User> users;
        //Store all the users
        users = table.asList(User.class);

        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base.Driver.findElement(By.id("login_form"));

        LoginPage page = new LoginPage(base.Driver);

        for (User user: users){
            page.Login(user.username, user.password);
        }

        base.Driver.findElement(By.className("box")).click();
    }

    @And("^I click login button$")
    public void iClickLoginButton(){

        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password){
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);

        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base.Driver.findElement(By.id("login_form"));

        LoginPage page = new LoginPage(base.Driver);
        page.Login(userName, password);

        base.Driver.findElement(By.className("box")).click();

    }

    @Then("^I should see my account page$")
    public void iShouldSeeMyAccountPage(){

        Assert.assertTrue(base.Driver.findElement(By.id("login_form")).isDisplayed());
    }

    @Then("^I should see an error message$")
    public void iShouldSeeAnErrorMessage(){

        WebDriverWait wait = new WebDriverWait(base.Driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")));

        Assert.assertTrue(base.Driver.findElement(By.className("alert-danger")).isDisplayed(), "The error message was displayed");
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }

}
