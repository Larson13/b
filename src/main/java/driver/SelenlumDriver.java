package driver;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.FileUtils;

public class SelenlumDriver {
	private WebDriver driver;

	@BeforeMethod
	public void test1() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println("path:" + path);
		System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void exit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void gotoBaidu() throws InterruptedException {

		driver.get("http://wwww.baidu.com");

		// driver.navigate().forward();
		String url = driver.getCurrentUrl();
		System.out.println("url---:" + url);
		Assert.assertEquals(url, "https://www.baidu.com/");

		// String Title= driver.getTitle();
		// System.out.println("Title---:"+Title);
	}

	@Test
	public void gotoBaidu1() throws InterruptedException {

		driver.get("https://www.baidu.com/");
		

	List<WebElement>   list = driver.findElements(By.xpath(".//*[@id='u1']/a"));
System.out.println(list.size());
	for (WebElement webElement : list) {
		System.out.println("Test1:"+webElement.getText());
		
	}

		

	}
	
	@Test
	public void gotoBaidu2() throws InterruptedException, IOException {
		//*[@id="radio"]
		driver.get("file:///D:/index.html");
File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   File destFile=new File("d:/test2.png");
org.apache.commons.io.FileUtils.copyFile(file, destFile);

	}
}
