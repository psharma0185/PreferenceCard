package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Importpage_Import_file_Change {

	public Importpage_Import_file_Change() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://172.16.16.5/prefCard");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("ngupta@supplycopia.com");
		Thread.sleep(5000);
		driver.findElement(By.id("mat-input-1")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"signin\"]/div/div[2]/form/div[5]/button")).click(); //login
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.mat-button-wrapper")).click();     //Click Import
		Thread.sleep(5000);
		driver.findElement(By.id("proceedBtn")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("uploadBtn")).click();// click upload Button
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\Autoit\\FileUpload2.exe");//Upload system to excel 
		Thread.sleep(10000);
		driver.findElement(By.className("changeText")).click();
		Thread.sleep(10000);
		//Runtime.getRuntime().exec("D:\\Autoit\\FileUpload1.exe");//Upload system to excel 
		//Thread.sleep(10000);
		//driver.findElement(By.className("importBtn")).click();//click upload card

	}

}
