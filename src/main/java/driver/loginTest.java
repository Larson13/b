package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.WinDef.BYTE;

public class loginTest {
	private WebDriver driver;
	
	 long time = System.currentTimeMillis();
	@BeforeMethod
	public void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println("path:" + path);
		System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://mail.qq.com/");
	}
	 @Test
	 public void login() {
		  driver.switchTo().frame("login_frame");
		  driver.findElement(By.id("u")).sendKeys("516152442@qq.com");
		  driver.findElement(By.id("p")).sendKeys("qq82973834");
		  driver.findElement(By.id("login_button")).click();
		  String handlel = driver.getWindowHandle();
		  for(String handlels:driver.getWindowHandles()){
			  if(handlel.equals(handlels)){
				  continue;
			  }
			  driver.switchTo().frame(handlels);
		  }
		  String message= driver.findElement(By.id("useralias")).getText();
		  Assert.assertEquals(message, "夜迷失了心");
	 }
	 @Test
	 public void errorLogin() throws InterruptedException {
		  driver.switchTo().frame("login_frame");
		  driver.findElement(By.id("u")).sendKeys("516152442@qq.com");
		  driver.findElement(By.id("p")).sendKeys("q82973834");
		  driver.findElement(By.id("login_button")).click();
		  Thread.sleep(1000);
		 String error= driver.findElement(By.id("err_m")).getText();
		 System.out.println(error);
		 Assert.assertEquals(error, "你输入的帐号或密码不正确，请重新输入。");
	 }
    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
