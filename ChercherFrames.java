package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ChercherFrames {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement topic = driver.findElement(By.xpath("//b[@id='topic']/following::input"));
		topic.sendKeys("test");
		driver.switchTo().frame(0);
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='a' and @type='checkbox']"));
		checkbox.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement animals = driver.findElement(By.id("animals"));
		animals.click();
		Select animalobj = new Select(animals);
		animalobj.selectByVisibleText("Avatar");
		

	}

}
