package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mailTest {
	private WebDriver driver;
	
	 long time = System.currentTimeMillis();
	@BeforeMethod
	public void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println("path:" + path);
		System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://mail.163.com/");
	}

	@Test
    public void registerTest() {
        driver.switchTo().frame("iframe");
//        点击注册
        driver.findElement(By.id("changepage")).click();
//        获取当前页面的句柄
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handle1.equals(handles)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
//         点击 注册字母邮箱
        driver.findElement(By.xpath(".//*[@id='tabsUl']/li[1]/a")).click();
        driver.findElement(By.id("nameIpt")).sendKeys("M"+String.valueOf(time));
        driver.findElement(By.id("mainPwdIpt")).sendKeys("password");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("password");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time / 100));
        driver.findElement(By.id("vcodeIpt")).sendKeys("966va");
        driver.findElement(By.id("sendMainAcodeBtn")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainRegA")).click();

        String msgText = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        System.out.println(msgText);
        Assert.assertEquals(msgText, "  请填写图片中的验证码");
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
