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

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {

        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Before
    public void InitializeTest()
    {
        System.out.println("Opening the browser : Chrome");

        System.setProperty("webdriver.chrome.driver","C:\\libs\\chromedriver.exe");
        base.Driver = new ChromeDriver();

    }

    @After
    public void TearDownTest(Scenario scenario)
    {

        if (scenario.isFailed()) {

            scenario.write("url: " + base.Driver.getCurrentUrl());

            if (base.Driver instanceof TakesScreenshot) {
                TakesScreenshot camera = (TakesScreenshot) base.Driver;
                byte[] screenshot = camera.getScreenshotAs(BYTES);
                scenario.embed(screenshot, "image/png");
            }

            scenario.write(Utils.htmlEscape(base.Driver.getPageSource()));

        }

        System.out.println("Closing the browser : Chrome");
        base.Driver.quit();
    }
}
