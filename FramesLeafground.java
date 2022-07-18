package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class FramesLeafground {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement item3 = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee'][3]"));
		item3.click();
		driver.switchTo().defaultContent();
		WebElement download = driver.findElement(By.linkText("Download"));
		download.click();
	}

}
