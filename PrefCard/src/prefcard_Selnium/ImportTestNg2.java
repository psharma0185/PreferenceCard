package prefcard_Selnium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImportTestNg2 {
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
	@Test(priority = 1)
	public void login_TC() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(emailId);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys(password);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit'or contains(.,'sumbit')]")).click(); // login
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-root//app-pref-card//app-pref-card-page"))).isDisplayed(), "Unable to login");
		Thread.sleep(10000);//Screen shot1			
	}
	 @Test(priority =2)	 
	public void importFile() throws InterruptedException, IOException {		
		WebDriverWait wait = new WebDriverWait(driver,120);
		//click export Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,' Import')]/span[@class='mat-button-wrapper']"))).click();
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='downloadBtn']"))).click();
		Thread.sleep(15000);
		
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='proceedBtn' and contains(.,'Proceed To Upload')]"))).click();
//		//Thread.sleep(5000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='uploadBtn' and contains(.,'Upload From Computer')]"))).click();
//		Thread.sleep(5000);
//		Runtime.getRuntime().exec("D:\\Autoit\\Fileupload4.exe");//Upload system to excel 
//		Thread.sleep(15000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='importBtn' and contains(.,'Upload Cards')]"))).click();
//		Thread.sleep(5000);
	 }
		@Test(priority =3)	 
	public void watchVideo() throws InterruptedException, IOException {		
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='videoBtn' and contains(.,'Watch Explainer Video')]"))).click();
		driver.close();
			

	 }
		
	}





		
		
	

