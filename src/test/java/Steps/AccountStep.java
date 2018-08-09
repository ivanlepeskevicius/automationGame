package Steps;

import Base.BaseUtil;
import Pages.AccountPage;
import Pages.PersonalInfoPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class AccountStep extends BaseUtil{

    private BaseUtil b;

    public AccountStep(BaseUtil base) {
        this.b = base;
    }

    @Given("^I navigate to the personal information page$")
    public void iNavigateToThePersonalInformationPage() {

        AccountPage page = new AccountPage(b.Driver);
        page.PersonalInformationPage();
    }

    @When("^I update my name")
    public void iUpdateMyName() {
        PersonalInfoPage page = new PersonalInfoPage(b.Driver);
        page.changeName();
        page.submitChanges();
    }

    @Then("^I receive feedback that my account is updated$")
    public void iReceiveFeedbackThatMyAccountIsUpdated() throws Throwable {

        assertTrue(b.Driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @When("^I change my street name$")
    public void iChangeMyStreetName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I navigate to my orders$")
    public void iNavigateToMyOrders() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see a list of my orders$")
    public void iSeeAListOfMyOrders() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I can open an order to see the order details$")
    public void iCanOpenAnOrderToSeeTheOrderDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click the Log out button$")
    public void iClickTheLogOutButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I receive feedback that I am logged out$")
    public void iReceiveFeedbackThatIAmLoggedOut() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I cannot visit my account page anymore$")
    public void iCannotVisitMyAccountPageAnymore() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
