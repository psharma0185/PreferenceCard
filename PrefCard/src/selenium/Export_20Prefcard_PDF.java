package selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Export_20Prefcard_PDF {

	public Export_20Prefcard_PDF() {
			}
	static String emailId="uvishnoi@supplycopia.com";
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://172.16.16.5/signin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(emailId);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys("Supplycopia12#$");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //login
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(.,'Export')]/span[@class='mat-button-wrapper']")).click();
		Thread.sleep(10000);//click export Button
		List<WebElement> ListOfCheckBoxes = driver.findElements(By.id("checkbox"));
		for (int i=0;i<20;i++) {
		   // ((WebElement) ListOfCheckBoxes).click();
			//System.out.println(ListOfCheckBoxes.get(i));
			ListOfCheckBoxes.get(i).click();
			Thread.sleep(10000);				
		}
		driver.findElement(By.id("exportText")).click();//click export Cards
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(.,'Individual Cards (.pdf)')]")).click();//pdf Download
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot5.png"));
	} catch (IOException e) {
		e.printStackTrace();
		}
		Thread.sleep(10000);	
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot6.png"));
	} catch (IOException e) {
		e.printStackTrace();
		}
		
		
		
}		
}
