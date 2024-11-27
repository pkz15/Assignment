package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task_1 {
	
	@SuppressWarnings("deprecation")
	public static void output()
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
    driver.get("https://en-gb.facebook.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    
	}
}
