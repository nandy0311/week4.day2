package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class LeafgroundWindows {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String window1 = driver.getWindowHandle();
		System.out.println("Parent Window " + window1);
		
		WebElement openHome = driver.findElement(By.id("home"));
		openHome.click();
		Set<String> allWindows= driver.getWindowHandles();
		System.out.println("All Window Handles after clicking openHome button");
		System.out.println(allWindows);
		List<String> list1 = new ArrayList<>(allWindows);
		System.out.println(driver.getCurrentUrl());
		System.out.println("Switch from win 0 -> win 1");
		driver.switchTo().window(list1.get(1));
		System.out.println("new window2 " + driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(window1);
		
		WebElement openMultiple = driver.findElement(By.xpath("//button[@onclick='openWindows()']"));
		openMultiple.click();
		Set<String> allWindows2= driver.getWindowHandles();
		System.out.println("All Window Handles after clicking openMultiple");
		System.out.println(allWindows);
		int numberOfWindows = allWindows.size();
		System.out.println("number of windows = " + numberOfWindows);
		List<String> list2 = new ArrayList<>(allWindows2);
		driver.switchTo().window(list2.get(1));
		driver.close();
		driver.switchTo().window(list2.get(2));
		driver.close();
		driver.switchTo().window(window1);
		
		WebElement donotclose = driver.findElement(By.id("color"));
		donotclose.click();
		Set<String> allWindows3= driver.getWindowHandles();
		System.out.println("All Window Handles:");
		System.out.println(allWindows3);
		List<String> list3 = new ArrayList<>(allWindows3);
		System.out.println(driver.getCurrentUrl());
		System.out.println("Switch from win 0 -> win 1c");
		driver.switchTo().window(list3.get(1));
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(window1);
		WebElement waitfor5 = driver.findElement(By.xpath("//button[@onclick='openWindowsWithWait();']"));
		waitfor5.click();
		Thread.sleep(5000);
		Set<String> allWindows4= driver.getWindowHandles();
		System.out.println("All Window Handles:");
		System.out.println(allWindows4);
		List<String> list4 = new ArrayList<>(allWindows4);
		System.out.println(driver.getCurrentUrl());
		System.out.println("Switch from win 0 -> win 1d");
		driver.switchTo().window(list4.get(1));
		System.out.println("last button window1-> "+ driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(list4.get(2));
		System.out.println("last button window2-> "+driver.getCurrentUrl());
		driver.close();
	}

}
