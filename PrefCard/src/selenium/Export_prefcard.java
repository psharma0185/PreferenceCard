package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Export_prefcard {

	public Export_prefcard() {
			}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.16.16.5/prefCard");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("ngupta@supplycopia.com");
		driver.findElement(By.id("mat-input-1")).sendKeys("12345");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"signin\"]/div/div[2]/form/div[5]/button")).click(); //login
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(.,'Export')]/span[@class='mat-button-wrapper']")).click();
		Thread.sleep(10000);//click export Button
		//driver.findElement(By.id("checkbox")).click();//click check box
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"mat-checkbox-134\"]/label/span[1]")).click();//select this Pages		
		//driver.findElement(By.xpath("//*[@id=\"mat-checkbox-135\"]/label/span[1]")).click();//select all Pages
		//Thread.sleep(10000);
		driver.findElement(By.id("exportText")).click();//click export Cards
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-25\"]/div/button[1]")).click();//download excel
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-25\"]/div/button[2]")).click();
		
		
		
	}

}