package prefcard_Selnium;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class masterTestNg2 {
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
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit'or contains(.,'sumbit')]")).click(); // login
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 80);
		assertTrue(wait
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//app-root//app-pref-card//app-pref-card-page")))
				.isDisplayed(), "Unable to login");
		Thread.sleep(5000);// Screen shot1
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\\\eclipse-workspace\\\\image\\\\ScreenShot2.png"));
		} catch (IOException e) {
			e.printStackTrace();
			Thread.sleep(5000);
		}
		;
	}

	@Test(priority = 2)
	public void proceduresManagement() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//ul[@class='first-ul']/li[@class='item-nav test list-item menu-selected']"))
				.click(); // procedures
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='submenu']/div[@class='item' or contains(.,'Management')][2]"))
				.click(); // Management
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search Facilities']"))).build().perform();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot5.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}
	String addFaacilityName="";
	@Test(priority = 3)
	public void masterFacilities() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Facilities')]")))
				.click(); // Management

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		int rand_int1 = new Random().nextInt(1000);
		addFaacilityName = "Pradeep_" + rand_int1;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Facility')]")))
				.click();
		// Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Facility Name']")))
				.sendKeys(addFaacilityName);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 80);
		assertTrue(wait
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[contains(text(),'Facility has been added')]")))
				.isDisplayed(), "Unable to validate facility popup");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Facilities']")))
				.sendKeys(addFaacilityName);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addFaacilityName)) {
				status = true;
				break;
			}

		}
		assertTrue(status, "Unable to find the created facility");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	// @Test(priority=4)
	public void masterDepartments() throws InterruptedException, IOException {
		driver.findElement(
				By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Departments')]"))
				.click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int2 = new Random().nextInt(1000);
		String addDepartmentsName1 = "Neurosurge_" + rand_int2;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Department')]")))
				.click();
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Department Name']")))
				.sendKeys(addDepartmentsName1);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot13.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(10000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot14.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		// assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Departments
		// has been added')]")))
		// .isDisplayed(), "Unable to validate facility popup");
		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Departments')]")).click();
		// Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot15.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Departments']")))
				.sendKeys(addDepartmentsName1);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addDepartmentsName1)) {
				status = true;
				break;
			}
		}

		// assertTrue(status,"Unable to find the created Departments");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot16.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	// @Test(priority=5)
	public void masterSpecialties() throws InterruptedException, IOException {
		driver.findElement(
				By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Specialties')]"))
				.click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot17.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int3 = new Random().nextInt(1000);
		String addSpecialtiesName1 = "Main OR_" + rand_int3;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Specialty')]")))
				.click();
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot18.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Specialty Name']")))
				.sendKeys(addSpecialtiesName1);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot19.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot20.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		// assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Departments
		// has been added')]")))
		// .isDisplayed(), "Unable to validate facility popup");
		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Specialties')]")).click();
		// Thread.sleep(1000);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot21.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Specialties']")))
				.sendKeys(addSpecialtiesName1);

		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addSpecialtiesName1)) {
				status = true;
				break;
			}
		}
		// assertTrue(status,"Unable to find the created Departments");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot22.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	// @Test(priority=6)
	public void masterItem() throws InterruptedException, IOException {
		driver.findElement(
				By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Item Class')]"))
				.click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot23.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int4 = new Random().nextInt(1000);
		String addItemName1 = "Suture_" + rand_int4;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Item Class')]")))
				.click();
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot24.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Item Class Name']")))
				.sendKeys(addItemName1);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot25.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot26.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		// assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Departments
		// has been added')]")))
		// .isDisplayed(), "Unable to validate facility popup");
		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Item Class')]")).click();
		Thread.sleep(1000);
		// Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot27.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Item Classes']")))
				.sendKeys(addItemName1);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addItemName1)) {
				status = true;
				break;
			}
		}
		// assertTrue(status,"Unable to find the created Departments");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot28.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	// @Test(priority=9)
	public void masterlocalprocedure() throws InterruptedException, IOException {
		driver.findElement(By.xpath(
				"//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Local Procedures')]"))
				.click(); // Management
		Thread.sleep(1000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot29.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		int rand_int5 = new Random().nextInt(1000);
		String addProcedures1 = "Debridement Back_" + rand_int5;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Procedure')]")))
				.click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot30.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter Procedure Name']")))
				.sendKeys(addProcedures1);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot31.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button/span[@class='mat-button-wrapper'  and contains(.,'Save')]"))).click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot32.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);

		// assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Departments
		// has been added')]")))
		// .isDisplayed(), "Unable to validate facility popup");
		// driver.findElement(By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content'
		// and contains(.,'Local Procedures')]")).click();
		Thread.sleep(1000);
		// Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot33.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[@placeholder='Search Local Procedures']")))
				.sendKeys(addProcedures1);
		boolean status = false;
		Thread.sleep(10000);
		List<WebElement> listOfFac = driver.findElements(By.xpath("//table//tr//td[2]/span"));
		for (int i = 0; i < listOfFac.size(); i++) {
			if (listOfFac.get(i).getText().trim().equalsIgnoreCase(addProcedures1)) {
				status = true;
				break;
			}
		}
		// assertTrue(status,"Unable to find the created Departments");
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot34.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}

	// @Test(priority=7)
	public void masterlocalProducts() throws InterruptedException, IOException {
		driver.findElement(
				By.xpath("//div[@role='tablist']//div[@class='mat-tab-label-content' and contains(.,'Product')]"))
				.click();
		Thread.sleep(1000);
//				try {
//					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot29.png"));
//				} catch (IOException e) {
//					e.printStackTrace();		
		WebDriverWait wait = new WebDriverWait(driver, 500);
		// int rand_int5 = new Random().nextInt(1000);
		// String addProcedures1="Debridement Back_"+rand_int5;

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Add Product')]")))
				.click();
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\image\\ScreenShot30.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='upload-btn']")).click();
		Runtime.getRuntime()
				.exec("‪‪‪D:\\Autoit\\FileUpload4.exe" + " " + "D:\\eclipse-workspace\\product_image\\testimage.png");//
		Thread.sleep(1000);

	}
	
	
	
	 @Test(priority =10, dependsOnMethods = "masterFacilities")
		public void addNewCard() throws InterruptedException, IOException {
			driver.get("http://172.16.16.5/prefCard");
			Thread.sleep(10000);
			driver.findElement(By.id("newCardBtn")).click();
		
			Thread.sleep(5000);
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot3.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			File file = new File("D:\\eclipse-workspace\\import-template (21).xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook Workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet2 = Workbook.getSheetAt(0);
			for (int i = 0; i < 1; i++) {
				String data0 = sheet2.getRow(i).getCell(0).getStringCellValue();
				// System.out.println("data form excel is:"+data0");
				driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/form/div[1]/div/textarea")).sendKeys(data0);
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[1]/div/span/app-autocomplete-dropdown/form/div/input")).click();
				Thread.sleep(2000);
				driver.findElement(By.className("mat-option-text")).click();
				Thread.sleep(2000);
				
				
				
				
				// FACILITY
				driver.findElement(By.xpath("//input[@placeholder='Search for a Facility']")).sendKeys(addFaacilityName);
				
				driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'"+addFaacilityName+"')]")).click();
				Thread.sleep(1000);
				// DEPARTMENT
				driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[3]/div/div[2]/app-autocomplete-dropdown/form/div/input")).click();
				driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Cardiothor')]")).click();
				Thread.sleep(1000);
				// SPECIALTY
				driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[4]/div/div[2]/app-autocomplete-dropdown/form/div/input")).click();
				driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Main OR')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[4]/div/div[2]/app-autocomplete-dropdown/form/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				// LOCAL PROCEDURE
				driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[5]/div/div[2]/app-autocomplete-dropdown/form/div/input")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Ablation Endometrium')]")).click();
				 //STD. PROCEDURE
				Thread.sleep(2000);			
				driver.findElement(By.xpath("//div[6]/div/div[2]/app-autocomplete-dropdown/form/div/mat-icon")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'ett test')]")).click();
				//screen shot
				Thread.sleep(5000);
				try {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot4.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(1000);
				// Add Product
				driver.findElement(By.xpath("//button[contains(.,'Add Product') or contains(.,'sumbit')]")).click();
				Thread.sleep(2000);
				// Add value
				// driver.findElement(By.xpath("//div[@role='img']//span[contains(.,'Add')]")).click();
				driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span[@class='add-span cp-pointer ng-star-inserted']/button/span/mat-icon[@class='mat-icon notranslate edit-icon material-icons mat-icon-no-color'][1]")).click();
				Thread.sleep(1000);
				// open Value
				driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='open']")).sendKeys("4");
				Thread.sleep(1000);
				// Hold Value
				driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='hold']")).sendKeys("3");
				Thread.sleep(1000);
				try {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot5.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(1000);
				// Save Button
				driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span/span/button/span[@class='mat-button-wrapper']/img[@src='/assets/images/icons_svg/save.svg']")).click();
				Thread.sleep(1000);
				try {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot6.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(1000);
				// close Button
				driver.findElement(By.xpath("//button[contains(.,'close')]")).click();
				Thread.sleep(2000);
				// save
				driver.findElement(By.xpath("//button[contains(.,'Save') or contains(.,'sumbit')]")).click();

				Thread.sleep(5000);
				try {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot7.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}

				driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center mgt-10 btnDiv']/span/button[@class='mat-focus-indicator addBtn mat-stroked-button mat-button-base']/span/span[@class='ng-star-inserted']")).click();
				Thread.sleep(1000);
				try {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot8.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(10000);
				driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn-stroked publishbtn mat-stroked-button mat-button-base']/span[@class='mat-button-wrapper']")).click();
				Thread.sleep(1000);
				try {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot9.png"));
				} catch (IOException e) {
					e.printStackTrace();
				Thread.sleep(5000);
				try {
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot10.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
				Thread.sleep(1000);
				driver.navigate().back();
				try {
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot11.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				Thread.sleep(5000);
				driver.findElement(By.id("newCardBtn")).click();
				Thread.sleep(1000);
		
				}
				}
				}
			}

}
//		}
