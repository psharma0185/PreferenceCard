package selenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExportTestNg {
	WebDriver driver = null;
	static String emailId = "uvishnoi@supplycopia.com";
	static String password = "Supplycopia12#$";
	@BeforeClass
	public void launchBrwoser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.16.5/signin");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority =1)
	public void login_TC() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(emailId);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit'or contains(.,'sumbit')]")).click(); // login
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-root//app-pref-card//app-pref-card-page"))).isDisplayed(),
				"Unable to login");
		Thread.sleep(1000);
		;
	}
	@Test(priority =2)
	public void newCard() throws InterruptedException, IOException{
		driver.findElement(By.xpath("//button[contains(.,'Export')]/span[@class='mat-button-wrapper']")).click();
		Thread.sleep(5000);//click export Button			
		driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]")).click();//select this Pages	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='exportText']")).click();//click export Cards
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]")).click();//import Excel
	}
	@Test(priority =3)
	public void testcaseName() throws Exception
	{
		//driver.findElement(By.xpath("//button[contains(.,'Export')]/span[@class='mat-button-wrapper']")).click();
		Thread.sleep(10000);//click export Button			
		driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]")).click();//select this Pages	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@id='exportText']")).click();//click export Cards
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]")).click();//import Excel
}
	



}
