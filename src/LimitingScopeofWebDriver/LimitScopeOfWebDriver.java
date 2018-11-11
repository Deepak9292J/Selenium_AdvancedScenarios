package LimitingScopeofWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitScopeOfWebDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.qaclickacademy.com/practice.php");
		
		// Suppose we want to get the number of links in the footer panel only. NOT THE COMPLETE PAGE. 
		//In that case, we need to limit the scope of the webdriver. 
		WebElement footerpanel = driver.findElement(By.id("gf-BIG")); // Locate the section which is under consideration and store it into an object
		System.out.println(footerpanel.findElements(By.tagName("a")).size()); //Use object of the desired section to find the elements in that section only
		
		// Suppose in footer also, we need the links of only the first column only. Not the entire footer
		WebElement column_of_footer = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		
		System.out.println(column_of_footer.findElements(By.tagName("a")).size());
	}

}
