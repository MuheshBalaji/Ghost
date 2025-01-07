package Buses;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class PrintBus {
	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[.=\" BUSES \"]")).click();
		String parent = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
		
		for(String a:win) {
		
			driver.switchTo().window(a);
			String url=driver.getCurrentUrl();
			if(url.contains("home")) {
				break;
			}
		}
		
		WebElement scroll=driver.findElement(By.xpath("(//div[@class='col-md-6 col-lg-12'])[1]//li"));
		Point sc = scroll.getLocation();
		int x=sc.getX();
		int y=sc.getY();
		
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();
		
		
		
		
		List<WebElement> services = driver.findElements(By.xpath("(//div[@class='col-md-6 col-lg-12'])[1]//a"));
		for(int i=0;i<services.size();i++) {
			String se=services.get(i).getText().toString();
			System.out.println(se);
		}
		driver.switchTo().window(parent); 	
		driver.findElement(By.xpath("//a[.=' LOGIN ']")).click();
		
		//driver.quit();
		
	}
	

}
