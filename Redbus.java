package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Thread sleep does not work here
		WebElement source = driver.findElement(By.id("src"));
		source.sendKeys("Madiwala, Bangalore");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();

		WebElement dest = driver.findElement(By.id("dest"));
		dest.sendKeys("Koyambedu, Chennai");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();

		//	WebElement calendar = driver.findElement(By.xpath("//span[contains(@class,'calendar_icon')]"));
		//	calendar.click();

		driver.findElement(By.id("onward_cal")).click();
		WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> col = table.findElements(By.tagName("th"));
		System.out.println(col.size());
		List<WebElement> row = table.findElements(By.tagName("tr"));
		System.out.println(row.size());

		String month = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		if (month.equals("July 2022")){
			for (int i=2;i<row.size();i++)	{
				for (int j=1;j<=col.size();j++){
					WebElement finddate = driver.findElement(By.xpath("//table//tr["+(i+1)+"]//td["+j+"]"));
					String day = finddate.getText();
					if (day.equals("18"))
					{
						finddate.click();
					}
				}
			}
		}

		//Only for current date
		//	WebElement date = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='current day']"));
		//	date.click();

		WebElement search = driver.findElement(By.id("search_btn"));
		search.click();

		WebElement after6 = driver.findElement(By.xpath("//label[contains(@for,'dtAfter 6 pm')]"));
		after6.click();

		WebElement sleeper = driver.findElement(By.xpath("//label[contains(@for,'bt_SLEEPER')][1]"));
		sleeper.click();

		WebElement primo = driver.findElement(By.xpath("//li[@class='bannerTiles fl' and contains(@style,'primo1')]"));
		primo.click();

		String found = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("No of buses "+ found);

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fare d-block']/span"));
		System.out.println(list.size()); //only 5 is displayed instead of 17??????????????

		String totalbus=driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Number of Bus= "+totalbus);
		//	int totalbus1=Integer.valueOf(totalbus.replace(" Buses", ""));

		String totalbusno=totalbus.replaceAll("\\D", "");
		int totalbus1=Integer.parseInt(totalbusno);

		List<WebElement> list1= new ArrayList();
		List<Integer> listbusFare= new ArrayList();
		for (int i=0;i<totalbus1;i++)

		{	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			list1.add(driver.findElement(By.xpath("(//div[@class='fare d-block'])["+(i+1)+"]/span")));
			listbusFare.add(Integer.valueOf(list1.get(i).getText()));
		}
//		System.out.println(list1);
		Collections.sort(listbusFare);
		System.out.println(listbusFare);

		driver.close();
	}

}
/*
Assignment-4
----------------------
Launch the url https://www.redbus.n/
Enter From -Madiwala Bangalore
Enter To Koyambedu Chennai
Select the Date 10-Jun-2022
Click Search buses
Click After 6pm under Departure time
Click Sleeper under Bus types
Select the Primo
Get the number of buses found
Get the Bus fare and sort them in ascending order
Close the application
 */