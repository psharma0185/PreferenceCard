package prefcard_Selnium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewcardTestNg {
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
		Thread.sleep(2000);//Screen shot1
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot2.png"));
		} catch (IOException e) {
			e.printStackTrace();
			Thread.sleep(5000);
		}
		;
	}
	
	

	 @Test(priority =2)
	public void newCard() throws InterruptedException, IOException {
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
			driver.findElement(
					By.cssSelector("input.mat-autocomplete-trigger.input-search.ng-untouched.ng-pristine.ng-valid"))
					.click();
			driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'FACILITY')]")).click();
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
			driver.findElement(By.xpath("//input[@placeholder=\"Search for a Standard Procedure\"]")).sendKeys("ett test");
			//Thread.sleep(1000);
			//driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'ett test')]")).click();
			//screen shot
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot4.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Thread.sleep(5000);
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

	@Test(priority = 3)
		public void mostRecent() throws InterruptedException, IOException {
			driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-menu-trigger sc-btn-height mat-button mat-button-base ng-star-inserted']/span[@class='mat-button-wrapper']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(.,'Descending ')]/div[@class='mat-ripple mat-menu-ripple']")).click();
			try {
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot12.png"));
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			Thread.sleep(10000);
		}
	 
	 

	static String titleName = "newprefcardtest709";//card name

	@Test(priority = 4)
	public void duplicateCart() throws InterruptedException, IOException {
		boolean flag = false;
		driver.get("http://172.16.16.5/prefCard");
		List<WebElement> list = driver.findElements(By.xpath("//app-card-view//span[@class='sc-card-heading']"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().trim().equalsIgnoreCase(titleName.trim())) {
				list.get(i).click();
				flag = true;
				break;
			}
		}
		Thread.sleep(5000);
		assertTrue(flag, "my given cart tiltle not appearing");
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']/img[@src='/assets/images/icons_svg/duplicate.svg']")).click();
		Thread.sleep(1000);
		Thread.sleep(5000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot13.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		//old card name clear
//		driver.findElement(By.xpath("//textarea[@name='textarea']")).clear();
//		Thread.sleep(5000);
//		try {
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot14.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		WebDriverWait wait = new WebDriverWait(driver, 80);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='textarea'"))).sendKeys("newprefcardtest03");
		//Thread.sleep(15000);
		//duplicate card name print
		//driver.findElement(By.xpath("//textarea[@name='textarea']")).sendKeys("newprefcardtest32");//value change
		//Thread.sleep(10000);
//		try {
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot15.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//card name save button
		driver.findElement(By.xpath("//button[contains(.,'Save') or contains(.,'sumbit')]")).click();
		Thread.sleep(10000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot16.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator addBtn mat-stroked-button mat-button-base']")).click();
		Thread.sleep(10000);
		//similer product
		driver.findElement(By.xpath("//span[@class='similer-prod cp-pointer']")).click();
		Thread.sleep(10000);
		//replace card
		driver.findElement(By.xpath("//button[contains(.,'Replace') or@class='btn-replace btn-add ng-star-inserted']")).click();
		Thread.sleep(10000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot17.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(10000);
		//click notes
		driver.findElement(By.xpath("//button[contains(.,' Notes ')]")).click();
		Thread.sleep(15000);		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot18.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//click notes add button
		driver.findElement(By.xpath("//span[@class='add-icon-text']")).click();
		Thread.sleep(1500);		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot19.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//value pass Text box
		driver.findElement(By.xpath("//textarea[@name='textarea']")).sendKeys("supplycopia2");
		Thread.sleep(15000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot20.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//click save note page
		driver.findElement(By.xpath("//button[contains(.,'Save') or contains(.,'sumbit')]")).click();
		Thread.sleep(15000);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot21.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//back 
		driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12 col-sm-12']/img[@class='back-icon cursor-pointer']")).click();
		Thread.sleep(15000);		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot22.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//click column
		driver.findElement(By.xpath("//button[contains(.,'Column') or@class='mat-button-wrapper']")).click();
		Thread.sleep(15000);		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot23.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//click column_category
		WebElement checkbox =driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Category ')]"));
		checkbox.click();
		Thread.sleep(10000);
		WebElement uncheckbox =driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Category ')]"));
		uncheckbox.click();
		Thread.sleep(1000);
		WebElement checkbox1 =driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Sub-category')]"));
		checkbox1.click();
		Thread.sleep(5000);
		WebElement uncheckbox1 =driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Sub-category')]"));
		uncheckbox1.click();
		Thread.sleep(1000);
		WebElement checkbox2=driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Brand Name ')]"));
		checkbox2.click();
		Thread.sleep(5000);
		WebElement uncheckbox2=driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Brand Name ')]"));
		uncheckbox2.click();
		Thread.sleep(1000);
		WebElement checkbox3=driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Manufacturer ')]"));
		checkbox3.click();
		Thread.sleep(5000);
		WebElement uncheckbox3=driver.findElement(By.xpath("//mat-list-option[@role='option']//div[@class='mat-list-text' and contains(.,' Manufacturer ')]"));
		uncheckbox3.click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[contains(.,'Column') or@class='mat-button-wrapper']")).click();
		//Thread.sleep(5000);
		//delete card
		//driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[2]/div/div[2]/button[3]")).click();
		//Thread.sleep(5000);
		//confirm
		//driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-stroked-button mat-button-base']/span[@class=''or contains(.,'Confirm')]")).click();
		//driver.navigate().back();
		
		
//		driver.findElement(By.xpath("//img[@class='mat-menu-trigger pl-2 cp-pointer ng-star-inserted']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[contains(.,'Edit')]/div[@class='mat-ripple mat-menu-ripple']")).click();

	}
	

}
		
		
	

