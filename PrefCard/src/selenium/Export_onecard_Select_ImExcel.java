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

public class Export_onecard_Select_ImExcel {

	public Export_onecard_Select_ImExcel() {
		
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.16.16.5/signin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("uvishnoi@supplycopia.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys("Supplycopia12#$");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //login
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(.,'Export')]/span[@class='mat-button-wrapper']")).click();
		Thread.sleep(10000);//click export Button
		driver.findElement(By.id("checkbox")).click();//click check box
		Thread.sleep(10000);
		driver.findElement(By.id("exportText")).click();//click export Cards
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]")).click();//download excel
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot5.png"));
	} catch (IOException e) {
		e.printStackTrace();
		
		

	}

}
}