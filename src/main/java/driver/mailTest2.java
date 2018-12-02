package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mailTest2 {
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
    public void registerTest() throws InterruptedException {
        driver.switchTo().frame("login_frame");
//        点击注册
        driver.findElement(By.xpath("//*[@id=\"bottom_web\"]/a[2]")).click();
        String handle1 = driver.getWindowHandle();
//        获取当前页面的句柄
        for (String handles : driver.getWindowHandles()) {
            if (handle1.equals(handles)) {
                continue;
            }
            driver.switchTo().window(handles);
        } 

     driver.findElement(By.id("nickname")).sendKeys("liushu");
     driver.findElement(By.id("password")).sendKeys("qq82973834");
     driver.findElement(By.id("phone")).sendKeys("18673967193");
     driver.findElement(By.id("code")).sendKeys("18673967193");
     driver.findElement(By.id("get_acc")).click();
   Thread.sleep(2000);
   WebDriverWait  sDriverWait=  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By));

     String message= driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/form/div[8]/div[2]/div")).getText();
     Boolean sBoolean =driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/form/div[8]/div[2]/div")).isDisplayed();
     System.out.println(sBoolean);
    System.out.println("message:"+message);
    
	Assert.assertEquals(message, "验证码错误");
	}


    @Test
    public void testT() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
