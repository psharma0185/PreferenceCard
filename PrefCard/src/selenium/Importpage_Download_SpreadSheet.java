package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Importpage_Download_SpreadSheet {

	public Importpage_Download_SpreadSheet() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://172.16.16.5/signin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("uvishnoi@supplycopia.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys("Supplycopia12#$");
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //login
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("span.mat-button-wrapper")).click();////Click Import
		Thread.sleep(5000);
		driver.findElement(By.id("sheetIcon")).click();//click Download Spreadsheet

	}

}
