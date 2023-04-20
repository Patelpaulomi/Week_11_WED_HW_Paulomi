package browserfactory;
/**
 * 1. Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 * 2. Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * 1. RegisterTest
 * 2. LoginTest
 * 3. SaleTest
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();
        //Launch URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //Implicit Timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();
    }
}
