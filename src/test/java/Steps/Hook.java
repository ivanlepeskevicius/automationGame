package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.BeforeClass;
import cucumber.runtime.Utils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.OutputType.BYTES;


public class Hook extends BaseUtil {

    private BaseUtil b;

    public Hook(BaseUtil base) {
        this.b = base;
    }

    @Before
    public void InitializeTest()
    {
        System.out.println("Opening the browser : Chrome");

        System.setProperty("webdriver.chrome.driver","C:\\libs\\chromedriver.exe");
        b.Driver = new ChromeDriver();

        b.Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario)
    {

        if (scenario.isFailed()) {

            scenario.write("url: " + b.Driver.getCurrentUrl());

            if (b.Driver instanceof TakesScreenshot) {
                TakesScreenshot camera = (TakesScreenshot) b.Driver;
                byte[] screenshot = camera.getScreenshotAs(BYTES);
                scenario.embed(screenshot, "image/png");
            }

            scenario.write(Utils.htmlEscape(b.Driver.getPageSource()));

        }

        System.out.println("Closing the browser : Chrome");
        b.Driver.quit();
    }
}
