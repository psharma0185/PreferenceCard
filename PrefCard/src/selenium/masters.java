package selenium;

import static org.testng.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class masters {

	public masters() {

	}

	static String emailId = "uvishnoi@supplycopia.com";
	static String titleName = "prefcardtest1266";

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://172.16.16.5/prefCard/copyCard");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(emailId);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys("Supplycopia12#$");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit'or contains(.,'sumbit')]")).click(); // login
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='first-ul']/li[@class='item-nav test list-item menu-selected']")).click(); //procedures
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='submenu']/div[@class='item' or contains(.,'Management')][2]")).click(); //Management
		Thread.sleep(1000);
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search Facilities']"))).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Facilities')]")).click(); //Management
		Thread.sleep(1000);
		int rand_int1 = new Random().nextInt(1000);
		String addFaacilityName="Pradeep_"+rand_int1;
		driver.findElement(By.xpath("//button[contains(.,'Add Facility')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Facility Name']")).sendKeys(addFaacilityName);
		driver.findElement(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 80);
		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[contains(text(),'Facility has been added')]")))
				.isDisplayed(), "Unable to validate facility popup");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Facilities"))).sendKeys(addFaacilityName);
		driver.findElement(By.xpath("//input[@placeholder='Search Facilities']")).sendKeys(addFaacilityName);
		
		boolean status=false;
		Thread.sleep(10000);
		List<WebElement> listOfFac=driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for(int i=0;i<listOfFac.size();i++) {
			if(listOfFac.get(i).getText().trim().equalsIgnoreCase(addFaacilityName)) {
				status=true;
				break;
			}
		}
	
		assertTrue(status,"Unable to find the created facility");
		
		
	}

}
