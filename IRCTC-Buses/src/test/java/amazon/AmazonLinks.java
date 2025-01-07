package amazon;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLinks {
	public static void main(String[] args) {
		
	String a="My Name is Muhesh Balaji";
    String [] b=a.split(" ");
    
    String temp=b[b.length-1];
    b[b.length-1]=b[0];
    b[0]=temp;
    System.out.println(Arrays.toString(b));
    
}

}
