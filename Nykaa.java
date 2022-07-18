package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");		
		driver.manage().window().maximize();
		Thread.sleep(6000);
		//	WebElement brands1 = driver.findElement(By.linkText("brands"));
		//brands1.click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='brands']")));
		action.build().perform();


		WebElement search = driver.findElement(By.id("brandSearchBox"));
		search.sendKeys("L'Oreal Paris");
		WebElement loreal = driver.findElement(By.xpath("//img[contains(@src,'lorealparis')]"));
		loreal.click();
		Thread.sleep(2000);
		String lorealtitle=driver.getTitle();
		System.out.println(lorealtitle);
		if(lorealtitle.contains("L'Oreal")) {
			System.out.println("title is correct");}
		else {
			System.out.println("title is not correct");}

		WebElement sort = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
		sort.click();

		WebElement toprated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		toprated.click();
		Thread.sleep(2000);

		WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
		category.click();
		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		hair.click();
		WebElement haircare = driver.findElement(By.xpath("//span[contains(text(),'Hair Care')]"));
		haircare.click();
		WebElement shampoo = driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]"));
		shampoo.click();


		WebElement concern = driver.findElement(By.xpath("//span[contains(text(),'Concern')]"));
		concern.click();
		WebElement colorprotect = driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]"));
		colorprotect.click();
		Thread.sleep(2000);

		String filtercheck = driver.findElement(By.xpath("//span[@class='filter-value' and contains(text(),'Shampoo')]")).getText();
		System.out.println("Filter contains- "+filtercheck);

		WebElement colourprotect = driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]"));
		colourprotect.click();

		Set<String> allwindows= driver.getWindowHandles();
		System.out.println("All windows- "+ allwindows);
		List<String> list= new ArrayList<>(allwindows);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getTitle());

		WebElement size = driver.findElement(By.xpath("//select[@title='SIZE']"));
		size.click();
		Select sizeobj = new Select(size);
		sizeobj.selectByValue("0");


		String price = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("Price of the product is "+price);

		WebElement addtobag = driver.findElement(By.xpath("//span[text()='Add to Bag']"));
		addtobag.click();
		Thread.sleep(2000);

		WebElement cart = driver.findElement(By.className("cart-count"));
		cart.click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);

		String grandtotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("GrandTotal is "+grandtotal);
		String grandtotal1=grandtotal.replaceAll("\\D", "");
		int grandtotalrs=Integer.parseInt(grandtotal1);
		System.out.println("Int GrandTotal is "+grandtotalrs);
		Thread.sleep(2000);

		WebElement proceed = driver.findElement(By.xpath("//span[contains(@class,'uppercase-vernacular')]"));
		proceed.click();
		Thread.sleep(6000);

		WebElement continueasguest = driver.findElement(By.xpath("//button[contains(@class,'btn full big')]"));
		continueasguest.click();
		String grandtotalnew = driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]//following-sibling::div/span")).getText();
		System.out.println("New GrandTotal is "+grandtotalnew);
		int grandtotalnew1 = Integer.parseInt(grandtotalnew);
		if (grandtotalnew1==grandtotalrs) {
			System.out.println("Test pass");}
		else {
			System.out.println("Test fail");	}
		
		driver.quit();
	}
}

/*Assignment 3:
============
1) Go to https://www.nykaa.com/
2) Click Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows
 */