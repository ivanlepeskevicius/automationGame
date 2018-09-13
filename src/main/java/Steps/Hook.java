package Steps;

import Base.BaseUtil;
import Base.EmailSender;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.Utils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.OutputType.BYTES;


public class Hook extends BaseUtil {

    private BaseUtil b;

    public Hook(BaseUtil base) {
        this.b = base;
    }


    @Before
    public void InitializeTest(){
        if (Driver == null) {

            System.out.println("Opening the browser : Chrome");

            System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

    // Disable extensions and hide infobars
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");

            HashMap prefs = new HashMap();

    // Enable Flash
            prefs.put("profile.default_content_setting_values.plugins", 1);
            prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
            prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);

    // Hide save credentials prompt
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            Driver = new ChromeDriver(options);
            Driver.manage().window().maximize();

        }

        Driver.manage().deleteAllCookies();
        Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario)
    {

        if (scenario.isFailed()) {

            scenario.write("url: " + Driver.getCurrentUrl());

            if (Driver instanceof TakesScreenshot) {
                TakesScreenshot camera = (TakesScreenshot) Driver;
                byte[] screenshot = camera.getScreenshotAs(BYTES);
                scenario.embed(screenshot, "image/png");
            }

            scenario.write(Utils.htmlEscape(Driver.getPageSource()));

        }

        System.out.println("Closing the browser : Chrome");
        Driver.quit();

    }
}
