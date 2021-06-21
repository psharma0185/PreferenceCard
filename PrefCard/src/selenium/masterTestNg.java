package selenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class masterTestNg {
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
		//WebDriverWait wait = new WebDriverWait(driver, 80);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys(emailId);
		driver.findElement(By.xpath("//input[@name='password'and @type='password']")).sendKeys(password);		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit'or contains(.,'sumbit')]")).click(); // login
		Thread.sleep(5000);
//		try {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("‪D:\\eclipse-workspace\\mcard_image\\ScreenShot1.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//			Thread.sleep(5000);
//		}
		WebDriverWait wait = new WebDriverWait(driver, 80);
		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-root//app-pref-card//app-pref-card-page")))
				.isDisplayed(), "Unable to login");
		Thread.sleep(5000);// Screen shot1
//		try {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("‪D:\\eclipse-workspace\\mcard_image\\ScreenShot2.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//			Thread.sleep(5000);
//		}
		;
	}

	@Test(priority = 2)
	public void proceduresManagement() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//ul[@class='first-ul']/li[@class='item-nav test list-item menu-selected']")).click(); // procedures
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='submenu']/div[@class='item' or contains(.,'Management')][2]")).click(); // Management
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search Facilities']"))).build().perform();
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot5.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
	}
	String addFaacilityName="";
	@Test(priority = 3)
	public void masterFacilities() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Facilities')]")))
				.click(); // Management

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		int rand_int1 = new Random().nextInt(1000);
		addFaacilityName = "Pradeep_" + rand_int1;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Facility')]")))
				.click();
		// Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Facility Name']"))).sendKeys(addFaacilityName);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		
//		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Facility has been added')]")))
//			.isDisplayed(), "Unable to validate facility popup");
//		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Facilities']")))
				.sendKeys(addFaacilityName);
		boolean status = false;
		//Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addFaacilityName)) {
				status = true;
				break;
			}

		}
		assertTrue(status, "Unable to find the created facility");
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
	}
		
	String addDepartmentsName="";
	@Test(priority=4)
	public void masterDepartments() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Departments')]"))).click(); // Management
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		int rand_int1 = new Random().nextInt(1000);
		addDepartmentsName = "Gastroente_" + rand_int1;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Department')]"))).click();
		// Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Department Name']"))).sendKeys(addDepartmentsName);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot13.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
//		Thread.sleep(10000);
		//WebDriverWait wait2 = new WebDriverWait(driver, 80);
//		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Departments has been added')]")))
//		.isDisplayed(), "Unable to validate Department popup");
		Thread.sleep(15000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot14.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Departments']"))).sendKeys(addDepartmentsName);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addFaacilityName)) {
				status = true;
				break;
			}

		}
		assertTrue(status, "Unable to find the created Departments");
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot15.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	 String addSpecialtiesName ="";	
	// @Test(priority=5)
	public void masterSpecialties() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,240);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Specialties')]"))).click(); // Management
		//Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot16.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		int rand_int = new Random().nextInt(1000);
		addSpecialtiesName = "Main OR_" + rand_int;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Specialty')]"))).click();
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot17.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Specialty Name']"))).sendKeys(addSpecialtiesName);
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot18.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot19.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
//		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Specialties has been added')]")))
//				.isDisplayed(),"Unable to validate Specialties popup");	
//		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Specialties')]")).click();
		// Thread.sleep(1000);		
//		try {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot20.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Specialties']"))).sendKeys(addSpecialtiesName);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addSpecialtiesName)) {
				status = true;
				break;
			}
		}
		assertTrue(status,"Unable to find the created Specialties");
		//Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot21.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Thread.sleep(5000);
	}

	 
	 
	String addItemName ="";
	@Test(priority=6)
	public void masterItem() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Item Class')]")).click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot22.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int4 = new Random().nextInt(1000);
		addItemName = "Suture_" + rand_int4;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Item Class')]"))).click();
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot23.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Item Class Name']"))).sendKeys(addItemName);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot24.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot25.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Thread.sleep(5000);
//		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Item has been added')]")))
//		.isDisplayed(), "Unable to validate facility popup");
//		 driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Item Class')]")).click();
//		Thread.sleep(1000);
//		try {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot26.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	//	Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Item Classes']"))).sendKeys(addItemName);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addItemName)) {
				status = true;
				break;
			}
		}
		assertTrue(status,"Unable to find the created Item");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot27.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}
	 @Test(priority=7)
		public void masterlocalProducts() throws InterruptedException, IOException {
			driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Product')]")).click();
			Thread.sleep(1000);
//					try {
//						File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//						FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot29.png"));
//					} catch (IOException e) {
//						e.printStackTrace();		
			WebDriverWait wait = new WebDriverWait(driver, 500);
			int rand_int5 = new Random().nextInt(1000);
			String ProductDesc="ProductDesc_"+rand_int5;
			String Sku=""+rand_int5;

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Product')]")))
					.click();
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot28.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='upload-btn']")).click();
			Thread.sleep(2000);
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot29.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			Runtime.getRuntime().exec("D:\\Autoit\\Fileupload1.exe");
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot30.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			//PRODUCT DESCRIPTION
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Provide Product Description']"))).sendKeys(ProductDesc);
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot31.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			//ITEM CLASS
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Select Class']"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mat-option-text' and contains(.,'Anesthesia Supplies')]"))).click();
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot32.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			//PRICE TREND
			Select dropdown = new Select(driver.findElement(By.xpath("//select[@placeholder='Select Price Trend']")));
			dropdown.selectByVisibleText("Neutral");
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot33.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			//SKU
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter SKU']"))).sendKeys(Sku);
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot34.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			//PRICE PER UNIT
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='number']"))).sendKeys("2");
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot35.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
			//save
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot36.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread.sleep(1000);
					}
		
	String addStdProcedures="";
	String addStdCode="";	
	@Test(priority=8)

	public void masterStdProcedures() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Std. Procedures')]")).click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot37.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int5 = new Random().nextInt(1000);
		addStdProcedures = "StandardPro_" + rand_int5;
		addStdCode = "" + rand_int5;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Standard Procedure')]")))
				.click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot38.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Standard Procedure Name']"))).sendKeys(addStdProcedures);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Standard Procedure Code']"))).sendKeys(addStdCode);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot39.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot40.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Thread.sleep(5000);
//		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Procedures has been added')]")))
//		.isDisplayed(), "Unable to validate Procedures popup");
		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'addStdProcedures')]")).click();
//		Thread.sleep(1000);		
//		try {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot41.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Standard Procedures']"))).sendKeys(addStdProcedures);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addStdProcedures)) {
				status = true;
				break;
			}
		}
		assertTrue(status,"Unable to find the created Search Standard Procedures");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot42.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}


	String locProcedures="";
	@Test(priority=9)

	public void masterlocalprocedure() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Local Procedures')]")).click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot43.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int5 = new Random().nextInt(1000);
		locProcedures = "Debridement Back_" + rand_int5;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Procedure')]")))
				.click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot44.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Procedure Name']"))).sendKeys(locProcedures);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot45.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot46.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Thread.sleep(5000);
//		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Procedures has been added')]")))
//		.isDisplayed(), "Unable to validate Procedures popup");
		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Local Procedures')]")).click();
//		Thread.sleep(1000);		
//		try {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot47.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Local Procedures']")))
				.sendKeys(locProcedures);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(locProcedures)) {
				status = true;
				break;
			}
		}
		assertTrue(status,"Unable to find the created Procedures");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot48.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}
	
	 String addNewCardname="";
	 
	@Test(priority =10, dependsOnMethods = "masterFacilities")
		public void addNewCard() throws InterruptedException, IOException {
			driver.get("http://172.16.16.5/prefCard");
			Thread.sleep(10000);
			driver.findElement(By.id("newCardBtn")).click();		
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot49.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
			int rand_int1 = new Random().nextInt(1000);
			addNewCardname = "testcase_" + rand_int1;
			driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/form/div[1]/div/textarea")).sendKeys(addNewCardname);
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot50.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[1]/div/span/app-autocomplete-dropdown/form/div/input")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("mat-option-text")).click();
			Thread.sleep(2000);			
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot51.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			// FACILITY
//			driver.findElement(By.xpath("//input[@placeholder='Search for a Facility']")).sendKeys(addFaacilityName);			
//			driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'"+addFaacilityName+"')]")).click();
//			Thread.sleep(1000);
//			// DEPARTMENT
//			driver.findElement(By.xpath("//input[@placeholder='Search for a Department']")).click();
//			driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'"+addDepartmentsName+"')]")).click();
//			Thread.sleep(1000);
//			// SPECIALTY
//			driver.findElement(By.xpath("//input[@placeholder='Search for a Specialty']")).click();
//			driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'"+addSpecialtiesName+"')]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[4]/div/div[2]/app-autocomplete-dropdown/form/div/input")).sendKeys(Keys.TAB);
			Thread.sleep(1000);
			// LOCAL PROCEDURE
			driver.findElement(By.xpath("//input[@placeholder='Search for a Local Procedure']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@placeholder='Search for a Local Procedure']")).sendKeys(locProcedures);
			//driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'"+locProcedures+"')]")).click();
			 //STD. PROCEDURE
			Thread.sleep(10000);			
			driver.findElement(By.xpath("//input[@placeholder='Search for a Standard Procedure']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'"+addStdProcedures+"')]")).click();
			//screen shot
			Thread.sleep(10000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot52.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Thread.sleep(1000);
			// Add Product
			driver.findElement(By.xpath("//button[contains(.,'Add Product') or contains(.,'sumbit')]")).click();
			Thread.sleep(10000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot53.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);
			// Add value
			// driver.findElement(By.xpath("//div[@role='img']//span[contains(.,'Add')]")).click();
			driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span[@class='add-span cp-pointer ng-star-inserted']/button/span/mat-icon[@class='mat-icon notranslate edit-icon material-icons mat-icon-no-color'][1]")).click();
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot54.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);
			// open Value
			driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='open']")).sendKeys("4");
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot55.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);
			// Hold Value
			driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='hold']")).sendKeys("3");
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot56.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);
			// Save Button
			driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span/span/button/span[@class='mat-button-wrapper']/img[@src='/assets/images/icons_svg/save.svg']")).click();
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot57.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);
			// close Button
			driver.findElement(By.xpath("//button[contains(.,'close')]")).click();
			Thread.sleep(2000);
			// save
			driver.findElement(By.xpath("//button[contains(.,'Save') or contains(.,'sumbit')]")).click();

			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot58.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);

			driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center mgt-10 btnDiv']/span/button[@class='mat-focus-indicator addBtn mat-stroked-button mat-button-base']/span/span[@class='ng-star-inserted']")).click();
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot59.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn-stroked publishbtn mat-stroked-button mat-button-base']/span[@class='mat-button-wrapper']")).click();
			Thread.sleep(1000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot60.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
			driver.navigate().back();
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\mcard_image\\ScreenShot61.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}Thread.sleep(10000);
			driver.findElement(By.id("newCardBtn")).click();
			Thread.sleep(1000);
	
			}
			}
			
		


	

			
				