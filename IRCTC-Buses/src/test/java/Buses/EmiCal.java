package Buses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmiCal {
	public static void main(String[] args) {
		

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		Actions act=new Actions(driver);
		WebElement grap = driver.findElement(By.xpath("//th[.='Year']"));
		Point loc = grap.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		act.scrollByAmount(x, y).perform();
		
		
		
		List<WebElement> graph = driver.findElements(By.xpath("//*[name()='g' and @class=\"highcharts-markers highcharts-series-2 "
				+ "highcharts-spline-series highcharts-tracker\"]/*"));
		for(WebElement a:graph) {
			act.moveToElement(a).pause(1000).perform();
			List<WebElement> grapele = driver.findElements(By.xpath("//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]//*[name()='text']//*"));
			for(WebElement b:grapele) {
				String text=b.getText();
				System.out.println(text);
			}
			
		}
		driver.quit();
	}

}
