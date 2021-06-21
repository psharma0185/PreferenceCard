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
		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//app-root//app-pref-card//app-pref-card-page")))
				.isDisplayed(), "Unable to login");
		Thread.sleep(10000);//Screen shot1			
	}
	 @Test(priority =2)	 
	public void selectOneCard() throws InterruptedException, IOException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,80);
		//click export Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Export')]/span[@class='mat-button-wrapper']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox"))).click();//click check box
		//click export Cards	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='exportText']"))).click();	
		//import Excel
		//Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]"))).click();
		//click export Cards
		Thread.sleep(5000);		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Individual Cards (.pdf)')]"))).click();	
		Thread.sleep(15000);	
	 }
	 @Test(priority =3)
	public void selectthisPages	() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,80);			
		//select this Pages	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]"))).click();
		Thread.sleep(5000);
		//click export Cards
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='exportText']"))).click();	
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]"))).click();//import Excel
		Thread.sleep(15000);
	}	 
	@Test(priority =4)
	public void selectAllPages() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,80);
		//select All Pages
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mat-checkbox-label' and contains(.,'Select All Pages')]"))).click();	
		Thread.sleep(5000);
		//click export Cards
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='exportText']"))).click();
		Thread.sleep(5000);
		//import Excel
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]"))).click();
		Thread.sleep(15000);
	}
	@Test(priority =5)
	public void Select20Cards() throws Exception
	{
		
		WebDriverWait wait = new WebDriverWait(driver,80);
		List<WebElement> ListOfCheckBoxes = driver.findElements(By.id("checkbox"));
		for (int i=0;i<20;i++) {
		   // ((WebElement) ListOfCheckBoxes).click();
			//System.out.println(ListOfCheckBoxes.get(i));
			ListOfCheckBoxes.get(i).click();
			Thread.sleep(10000);				
		}
		//click export Cards
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exportText"))).click();
		Thread.sleep(5000);
		//Export_pdfDownload
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Individual Cards (.pdf)')]"))).click();
		Thread.sleep(20000);
			}
	@Test(priority =6)
	public void Select21Cards() throws Exception
	{		
		WebDriverWait wait = new WebDriverWait(driver,80);
		List<WebElement> ListOfCheckBoxes = driver.findElements(By.id("checkbox"));
		for (int i=0;i<21;i++) {
		   // ((WebElement) ListOfCheckBoxes).click();
			//System.out.println(ListOfCheckBoxes.get(i));
			ListOfCheckBoxes.get(i).click();
			Thread.sleep(10000);				
		}
		//click export Cards
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("exportText"))).click();
		Thread.sleep(5000);
		//Export_pdfDownload
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Spreadsheet (.xlsx)')]"))).click();
			}
		
	}





		
		
	

