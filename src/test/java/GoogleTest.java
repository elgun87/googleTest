import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{

    @Test
    public void loginTest_01(){
        Assert.assertTrue(getDriver().getTitle().equalsIgnoreCase("Google"));

    }

    @Test
    public void searchInputTest_02(){
        getDriver().findElement(By.xpath("*//textarea[@name='q']")).sendKeys("Air Fryer", Keys.ENTER);
    }
}
