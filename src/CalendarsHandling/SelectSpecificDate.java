package CalendarsHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectSpecificDate {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		
		// click on any specific date of current month, without using direct xpath of that date. 
		// Logic here is to grab the common element and put it into the list. Parse each element of list and match with the desired element
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td"));
		int count = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td")).size();
		for(int i=0; i<count ; i++)
		{
			String currentDate = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td")).get(i).getText();
			if(currentDate.equals("23"))
			{
				driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td")).get(i).click();
				break;
			}
		}
		
	}

}
