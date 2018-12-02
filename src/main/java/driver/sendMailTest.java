package driver;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.F2D;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sendMailTest {
	private static WebDriver driver;
	
	 long time = System.currentTimeMillis();
	@BeforeMethod
	public void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println("path:" + path);
	System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver.exe");
		//driver = new FirefoxDriver();
		driver= new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://mail.qq.com/");
	}
	@Test
	public void sendMail() throws InterruptedException{
		login("516152442@qq.com","qq82973834");
		driver.findElement(By.id("composebtn")).click();
		driver.findElement(By.xpath("html")).sendKeys("dsfs");
		//WebElement frame =driver.findElement(By.id("mainFrame"));
	
		
		driver.switchTo().frame("mainFrame");
		Thread.sleep(5000);
		
		driver.findElement(By.id("subject")).sendKeys("hello");
		driver.findElement(By.name("UploadFile")).sendKeys("D:\\b.jpg");
		driver.findElement(By.id("toAreaCtrl")).sendKeys("82973834@qq.om");
		  driver.findElements(By.xpath(".//*[text()='·¢ËÍ']")).get(0).click();
		  String dString = driver.findElement(By.id("sendinfomsg")).getText();
		  System.out.println("dString:"+dString);
		
	}
	public static void  login (String username,String password){
		 driver.switchTo().frame("login_frame");
		  driver.findElement(By.id("u")).sendKeys(username);
		  driver.findElement(By.id("p")).sendKeys(password);
		  driver.findElement(By.id("login_button")).click();
		  String handlel = driver.getWindowHandle();
		  for(String handlels:driver.getWindowHandles()){
			  if(handlel.equals(handlels)){
				  continue;
			  }
			  driver.switchTo().frame(handlels);
		  }
		  
	}
    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
