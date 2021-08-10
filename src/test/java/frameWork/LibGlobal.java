package frameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	
	Select select;
	Alert alert;
	public static WebDriver driver;
	TakesScreenshot screenshot;
	JavascriptExecutor executor;
	public WebDriver browserLanch() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		return driver;
		}
		public void url(String data) {
			driver.get(data);
			}
		public void type(WebElement element,String data) {
			element.sendKeys(data);
		}
		public void clck(WebElement element) {
			element.click();
		}
		public void maximize() {
			driver.manage().window().maximize();
		}
		public void closeBrowser() {
			driver.close();
	}
		public void closeAll() {
			driver.quit();
		}
		public String text(WebElement element) {
			String text = element.getText();
			return text;
		}
		public String attributes(WebElement element,String data) {
			String string = element.getAttribute(data);
			return string;
		}
		public void title() {
			driver.getTitle();
		}
		public void getCurrentUrl() {
			driver.getCurrentUrl();
		}
		public Navigation navigateTo(String data) {
			Navigation navigate = driver.navigate();
			return navigate;
		}
		public void back() {
			driver.navigate().back();}
		public void refresh() {
			driver.navigate().refresh();
		}
		public void forward() {
			driver.navigate().forward();}
		public Actions actions() {
			Actions action=new Actions(driver);
			return action;}
		public void mouseOverActions(WebElement element) {
		actions().moveToElement(element).perform();
		}
		public void dragAndDrop(WebElement s,WebElement d) {
			actions().dragAndDrop(s,d).perform();
		}
		public void doubleClick() {
			actions().doubleClick().perform();
		}
		public void rightClick() {
			actions().contextClick().perform();
		}
		public void keyUp() {
			actions().keyUp(null).perform();
		}
		public void KeyDown() {
			actions().keyDown(null).perform();
		}
		public void alert() {
			alert=driver.switchTo().alert();
		}
		public void accept() {
		alert.accept();
		}
		public void dismiss() {
			alert.dismiss();
		}
		public String alertPrintText() {
			String text = alert.getText();
		    return text;
		}
		public void typeInAlert(String data) {
			alert.sendKeys(data);
		}
		public void screenShot() {
			screenshot=(TakesScreenshot)driver;
		}
		public File screenShotToFile() {
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		    return screenshotAs;
		}
		public JavascriptExecutor javaScript() {
			executor=(JavascriptExecutor)driver;
			return executor;
		}
        public Object executeUsingJavaExecutor(String name,WebElement element) {
        	Object script = executor.executeScript(name,element);
        	return script;
        }
        public Object scrollUp(String data,WebElement element) {
        	Object object = executor.executeScript(data, element);
        	return object;
        }
        public Select select(WebElement element) {
        	select=new Select(element);
        	return select;
        }
        public void selectByIndex(int i) {
        	select.selectByIndex(i);
        	
        }
        public void selectByValue(String data) {
        	select.selectByValue(data);
        }
        public void selectVisibletext(WebElement element, String data) {
        	new Select(element).selectByVisibleText(data);
        }
        public void deselectAll() {
        	select.deselectAll();
        }
        public void deselectByIndex(int i) {
        	select.deselectByIndex(i);
        }
        public void deselectByValue(String data) {
        	select.deselectByValue(data);
        }
        public void deselectByVisibleText(WebElement element,String data) {
              select.deselectByVisibleText(data);
        }
        public List<WebElement> getOptions() {
        	List<WebElement> options = select.getOptions();
            return options;        
        }
        public WebElement getSelectedOptions() {
        	WebElement selectedOption = select.getFirstSelectedOption();
            return selectedOption;
        }
        public List<WebElement> getAllSelect() {
        	List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
            return allSelectedOptions;
        }
        public void deSelectAll() {
        	select.deselectAll();
        }
        public void frame(int i) {
        	driver.switchTo().frame(i);
        }
        public void frameString(String data) {
        	driver.switchTo().frame(data);
        }
        public void frameStringElement(WebElement element) {
        	driver.switchTo().frame(element);
        }
        public void frameExit() {
        	driver.switchTo().defaultContent();}
        public void previousFrame() {
        	driver.switchTo().parentFrame();
        }
        public String windowHandle() {
        	String handle = driver.getWindowHandle();
        	return handle;
        }
        public Set<String> windowhandles () {
        	Set<String> handles = driver.getWindowHandles();
            return handles;
        }
        public boolean isSelected(WebElement element) {
        	boolean b = element.isSelected();
        	return b;}
        public boolean isEnabled(WebElement element) {
        boolean enabled = element.isEnabled();        	
        	return enabled;
        }
        public boolean isDisplayed(WebElement element) {
        	boolean displayed = element.isDisplayed();
        	return displayed;
        }
        public void clearText(WebElement element)
        {
        	element.clear();}
        public String getData(int r,int c) throws Exception {
        	String value = null;
        File file= new File("C:\\Users\\aravi\\eclipse-workspace\\FaceBook\\Excel\\adactin.xlsx");
		FileInputStream stream =new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("sheet1");
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		int type = cell.getCellType();
		if(type==1) {
			 value = cell.getStringCellValue();
		}if(type==0) {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
		      SimpleDateFormat format =new SimpleDateFormat("dd/mm/yyyy");
		      value = format.format(date);
		     
			}else {
				double d = cell.getNumericCellValue();
				long l=(long)d;
				value=String.valueOf(l);
				
			}
			
		}
		return value;
        }
        public void addData(int r, int c, String data) throws Exception {
        	 File file= new File("C:\\Users\\aravi\\eclipse-workspace\\FaceBook\\Excel\\adactin.xlsx");
     		FileInputStream stream =new FileInputStream(file);
     		Workbook workbook=new XSSFWorkbook(stream);
     		Sheet sheet = workbook.getSheet("sheet1");
     		Row row = sheet.getRow(r);
     		Cell cell = row.getCell(c);
     		cell.setCellValue(data);
     		FileOutputStream fileOutputStream=new FileOutputStream(file);
     		workbook.write(fileOutputStream);
        }


        
        
        
        
        
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



