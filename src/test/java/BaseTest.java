import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private WebDriver driver = null;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        if(driver == null){
            System.out.println("Driver Started");
            // Replace with the URL of your remote Selenium Grid hub
            String gridHubUrl = "http://34.69.172.226:4444/wd/hub";
            // Set ChromeOptions
            ChromeOptions options = new ChromeOptions();
            // Set desired capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            // Create a RemoteWebDriver instance
            WebDriver driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
            // Maximize the browser window
            driver.manage().window().maximize();

        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if(driver != null){
            System.out.println("Driver Ended");
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
