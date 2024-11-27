package utils;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(String Browser) {
       
        if(Browser.equalsIgnoreCase("Chrome"))
        {
        	// WebDriverManager.chromedriver().setup();
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(Browser.equalsIgnoreCase("Edge"))
        {
        	// WebDriverManager.chromedriver().setup();
            io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
           
        
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
