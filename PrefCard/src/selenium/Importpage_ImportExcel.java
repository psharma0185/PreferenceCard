package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Importpage_ImportExcel {

	public Importpage_ImportExcel() {
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
		driver.findElement(By.xpath("//input[@type='submit'or contains(.,'sumbit')]")).click(); //login
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.mat-button-wrapper")).click();     //Click Import
		Thread.sleep(5000);
		driver.findElement(By.id("proceedBtn")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("uploadBtn")).click();// click upload Button
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("‪D:\\Autoit\\FileUpload4.exe"+" "+"D:\\eclipse-workspace\\Facility_master_Header_missing.xlsx");//Upload system to excel 
		
		Thread.sleep(10000);
		driver.findElement(By.className("importBtn")).click();//click upload card	
		Thread.sleep(10000);
		try {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in destination directory with name "screenshot.png"
         FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\My first selenium\\src\\selenium\\ScreenShot1.png"));
     } catch (IOException e) {
         e.printStackTrace();
     }   
         
         Thread.sleep(20000);
         driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-import-dialog/div/div[2]/div[3]/button")).click();// Try Again Button
         Thread.sleep(1000);
         driver.findElement(By.className("changeText")).click();//Change File
         Thread.sleep(1000);
         Thread.sleep(5000);
 		 driver.findElement(By.className("uploadBtn")).click();// click upload Button
 		 Thread.sleep(10000);
 		
		 Runtime.getRuntime().exec("D:\\Autoit\\FileUpload2.exe"+" "+"D:\\eclipse-workspace\\Facility_master_Character.xlsx");//Upload system to excel
		 Thread.sleep(10000);
		 driver.findElement(By.className("importBtn")).click();//click upload card
		
		 Thread.sleep(10000);
 		 try {
 		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		 FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\My first selenium\\src\\selenium\\ScreenShot2.png"));
 	  } catch (IOException e) {
 		 e.printStackTrace();
 			
 			
 		 }
 		 
 		
        
        
		
	}	
		
		
		

	}


