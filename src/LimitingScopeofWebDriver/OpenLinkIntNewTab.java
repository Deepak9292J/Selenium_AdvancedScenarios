package LimitingScopeofWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkIntNewTab {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.qaclickacademy.com/practice.php");
		 
		// Suppose in footer also, we need the links of only the first column only. Not the entire footer
		WebElement column_of_footer = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		
		System.out.println(column_of_footer.findElements(By.tagName("a")).size());
		
		//Now, we want to check whether all the links in the first column of the footer are working or not
		int count = column_of_footer.findElements(By.tagName("a")).size();
		for(int i=1 ; i<count ; i++)
		{
			String controlAndHitEnter = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column_of_footer.findElements(By.tagName("a")).get(i).sendKeys(controlAndHitEnter);
		}
		
	}

}
