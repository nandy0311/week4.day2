package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");		
		driver.manage().window().maximize();
		//create lead
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys("Demosalesmanager");
		WebElement passwordElement = driver.findElement(By.name("PASSWORD"));
		passwordElement.sendKeys("crmsfa");
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		WebElement crmLink = driver.findElement(By.linkText("CRM/SFA"));
		crmLink.click();
		WebElement contactsbutton = driver.findElement(By.linkText("Contacts"));
		contactsbutton.click();

		WebElement mergercontacts = driver.findElement(By.linkText("Merge Contacts"));
		mergercontacts.click();

		String window1 = driver.getWindowHandle();
		System.out.println("Parent Window " + window1);


		WebElement fromcontactwidget = driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]"));
		//driver.findElement(By.cssSelector(“tag_name[id=’value_of_id’]”));
		fromcontactwidget.click();

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("All Window Handles:");
		System.out.println(allWindows);
		List<String> list = new ArrayList<>(allWindows);
		System.out.println(driver.getCurrentUrl());
		System.out.println("Switch from win 0 -> win 1");
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

		String window2 = driver.getWindowHandle();
		System.out.println("Window2 " + window2);
		driver.manage().window().maximize();
		Thread.sleep(20000);
		WebElement firstcontact = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1])[1]/div/a"));
		firstcontact.click();
		//	driver.close();
		driver.switchTo().window(window1);
		Thread.sleep(2000);


		WebElement tocontactwidget = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
		tocontactwidget.click();
		Thread.sleep(2000);

		Set<String> allWindows3 = driver.getWindowHandles();
		System.out.println("All Window Handles:");
		System.out.println(allWindows3);
		List<String> list3 = new ArrayList<>(allWindows3);
		System.out.println(driver.getCurrentUrl());
		System.out.println("Switch from win 0 -> win 1b");
		driver.switchTo().window(list3.get(1));
		System.out.println(driver.getCurrentUrl());

		String window3 = driver.getWindowHandle();
		driver.switchTo().window(window3);
		System.out.println(window3);
		driver.manage().window().maximize();
		Thread.sleep(6000);
		WebElement secondtocontact = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1])[2]/div/a"));
		secondtocontact.click();
		driver.switchTo().window(window1);
		Thread.sleep(2000);

		WebElement mergeButton = driver.findElement(By.className("buttonDangerous"));
		mergeButton.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("View Contact")) {
			System.out.println("Title is correct- test pass");}
		else {
			System.out.println("Something wrong- test failed");}


	}
}
