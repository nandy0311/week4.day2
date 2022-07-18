package week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class AlertsLeafground {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		WebElement alertbox = driver.findElement(By.xpath("//button[@onclick='normalAlert()']"));
		alertbox.click();
		Alert alert = driver.switchTo().alert();
		String alerttext=alert.getText();
		System.out.println(alerttext);
		alert.accept();
		WebElement confirmalertbox = driver.findElement(By.xpath("//button[@onclick='confirmAlert()']"));
		confirmalertbox.click();
		alert.accept();
		WebElement confirmpromptbox = driver.findElement(By.xpath("//button[@onclick='confirmPrompt()']"));
		confirmpromptbox.click();
		String alerttext2=alert.getText();
		System.out.println(alerttext2);
		alert.sendKeys("SS academy");
		alert.accept();
		System.out.println(driver.getTitle());
		WebElement linebreaksbox = driver.findElement(By.xpath("//button[@onclick='lineBreaks()']"));
		linebreaksbox.click();
		driver.close();
	}

}