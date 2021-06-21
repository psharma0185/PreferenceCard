package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_card {

	public New_card() {

	}

	static String emailId = "uvishnoi@supplycopia.com";
	static String titleName="prefcardtest1266";
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
		// driver.findElement(By.id("newCardBtn")).click();
//		File file = new File("D:\\eclipse-workspace\\import-template (21).xlsx");
//		FileInputStream inputStream = new FileInputStream(file);
//		XSSFWorkbook Workbook=new XSSFWorkbook(inputStream);
//		XSSFSheet sheet2=Workbook.getSheetAt(0);
//		for (int i = 0;i<5;i++) {
//		String data0=sheet2.getRow(i).getCell(0).getStringCellValue();
//		//System.out.println("data form excel is:"+data0");
//		driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/form/div[1]/div/textarea")).sendKeys(data0);
//		Thread.sleep(5000);		
//		driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[1]/div/span/app-autocomplete-dropdown/form/div/input")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.className("mat-option-text")).click();
//		Thread.sleep(2000);
//		//FACILITY
//		driver.findElement(By.cssSelector("input.mat-autocomplete-trigger.input-search.ng-untouched.ng-pristine.ng-valid")).click();
//		driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'FACILITY')]")).click();
//		Thread.sleep(1000);
//		//DEPARTMENT
//		driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[3]/div/div[2]/app-autocomplete-dropdown/form/div/input")).click();
//		driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Cardiothor')]")).click();
//		Thread.sleep(1000);
//		//SPECIALTY
//		driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[4]/div/div[2]/app-autocomplete-dropdown/form/div/input")).click();
//		driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Main OR')]")).click();
//		Thread.sleep(1000);
//		//LOCAL PROCEDURE
//		driver.findElement(By.xpath("/html/body/app-root/app-pref-card/app-edit-card/div/div[2]/div[1]/app-edit-card-info/div/div[1]/div[5]/div/div[2]/app-autocomplete-dropdown/form/div/input")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'Ablation Endometrium')]")).click();
//		
//		//STD. PROCEDURE
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[6]/div/div[2]/app-autocomplete-dropdown/form/div/mat-icon")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@role='listbox']//span[contains(.,'001FDSFSDFS')]")).click();
//		//Add Product
//		driver.findElement(By.xpath("//button[contains(.,'Add Product') or contains(.,'sumbit')]")).click();
//		Thread.sleep(2000);	
//		// Add value
//		//driver.findElement(By.xpath("//div[@role='img']//span[contains(.,'Add')]")).click();
//		driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span[@class='add-span cp-pointer ng-star-inserted']/button/span/mat-icon[@class='mat-icon notranslate edit-icon material-icons mat-icon-no-color'][1]")).click();
//		Thread.sleep(1000);
//		//open Value
//		driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='open']")).sendKeys("4");
//		Thread.sleep(1000);
//		//Hold Value
//		driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='hold']")).sendKeys("3");
//		Thread.sleep(1000);
//		//Save Button
//		driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span/span/button/span[@class='mat-button-wrapper']/img[@src='/assets/images/icons_svg/save.svg']")).click();
//		Thread.sleep(1000);
//		//edit button
//		//driver.findElement(By.xpath("//button[contains(.,'Edit') or contains(.,'sumbit')]")).click();
//		//Thread.sleep(1000);
//		//value change
//		//driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='open']")).sendKeys("6");
//		//Thread.sleep(1000);
//		//Hold Value
//		//driver.findElement(By.xpath("//div[@class='qty-div ng-star-inserted']//input[@name='hold']")).sendKeys("5");		
//		//Thread.sleep(1000);
//		//save button
//		//driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center th-action-div mr-3']/span/span/span/button/span[@class='mat-button-wrapper']/img[@src='/assets/images/icons_svg/save.svg']")).click();
//		//Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[contains(.,'close')]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[contains(.,'Save') or contains(.,'sumbit')]")).click();
//		
//		//Thread.sleep(5000);
//		try {
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot4.png"));
//	} catch (IOException e) {
//		e.printStackTrace();
//		}	
//		
//		driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center mgt-10 btnDiv']/span/button[@class='mat-focus-indicator addBtn mat-stroked-button mat-button-base']/span/span[@class='ng-star-inserted']")).click();
//		Thread.sleep(1000);
//		try {
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("D:\\eclipse-workspace\\ScreenShot5.png"));
//    } catch (IOException e) {
//    	e.printStackTrace();
//			}
//		Thread.sleep(5000);
//		driver.navigate().back();
//		Thread.sleep(5000);
//		driver.findElement(By.id("newCardBtn")).click();
		//driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-menu-trigger sc-btn-height mat-button mat-button-base ng-star-inserted']/span[@class='mat-button-wrapper']")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[contains(.,'Descending ')]/div[@class='mat-ripple mat-menu-ripple']")).click();
		//checkbox0.click();
		//Thread.sleep(5000);
		//delete card
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator sc-btn-height btn-table mat-button mat-button-base ng-star-inserted']/span[@class=''or contains(.,'Delete Card')]")).click();
		Thread.sleep(1000);
		//confirm
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-stroked-button mat-button-base']/span[@class=''or contains(.,' Confirm ')]")).click();
		//driver.navigate().back();
		
		
	
	}
}
