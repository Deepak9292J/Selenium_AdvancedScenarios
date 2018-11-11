package CalendarsHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMonthAnddate {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\c-deepak.jindal\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]")).click();
		
		//Get the list of months into list, traverse through each. And click on the month which we want to click finally. 
		List<WebElement> months = driver.findElements(By.xpath("//span[contains(@class,'month')]"));
		int count = driver.findElements(By.xpath("//span[contains(@class,'month')]")).size();
		for(int i=0 ; i<count ; i++)
		{
			String currentMonth = driver.findElements(By.xpath("//span[contains(@class,'month')]")).get(i).getText();
			if(currentMonth.equals("Nov"))
			{
				driver.findElements(By.xpath("//span[contains(@class,'month')]")).get(i).click();
				break;
			}
		}
		
		//Once the month is selected, select the date of choice
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td"));
		int dayscount = driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td")).size();
		for(int i=0; i<dayscount ; i++)
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
