import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver = null;
    @BeforeMethod
    public void setUp(){
        if(driver == null){
            System.out.println("Driver Started");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
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
