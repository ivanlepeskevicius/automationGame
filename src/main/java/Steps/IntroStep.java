package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;


public class IntroStep extends BaseUtil{

    private BaseUtil b;

    public IntroStep(BaseUtil base) {
        this.b = base;
    }

    @Given("^I navigate to the game page$")
    public void iNavigateToTheGamePage() throws FindFailed {

        Driver.get("http://www.smbgames.be/super-mario-bros.php");
        //check for the game to load
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/pics/intro.png");

        screen.wait(pattern,6000);
    }


    @When("^I press the Play button$")
    public void iPressThePlayButton() throws FindFailed {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/pics/play.png");
        screen.wait(pattern,5000);
        screen.click();

    }

    @And("^I see the game presentation screen$")
    public void iSeeTheGamePresentationScreen()  throws FindFailed {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/pics/presentation.png");
        screen.wait(pattern,5000);

        Match gift = screen.exists("/pics/presentation.png");
        assertNotNull(gift);

        screen.click(pattern);
    }

    @And("^I press H to start the game$")
    public void iPressHToStartTheGame() throws FindFailed {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/pics/presentation.png");
        screen.wait(pattern,5000);

        screen.click(pattern);
        screen.keyDown("h");

    }

    @Then("^I can start to play the game$")
    public void iCanStartToPlayTheGame() throws FindFailed, InterruptedException {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/pics/gameStart.png");
        screen.wait(pattern,5000);

        Match gift = screen.exists("/pics/gameStart.png");
        assertNotNull(gift);

        screen.click(pattern);
        True: screen.keyDown("d");
        TimeUnit.SECONDS.sleep(10);

    }
}
