package browseStack.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class JavaSample {
		public static final String USERNAME = "bharatraj4";
	  public static final String AUTOMATE_KEY = "GNzqpyfpaB6dM7XXnbuL";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    @Test
	public static void test_case() throws InterruptedException, MalformedURLException {
		
    	DesiredCapabilities caps = new DesiredCapabilities();
    	
        caps.setCapability("browser", "chrome");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "3 build");

        WebDriver d = new RemoteWebDriver(new URL(URL), caps);
        d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("http://flipkart.com/");
    	  	
    	
    	/*System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("http://flipkart.com/");*/
		WebElement searchBox = d.findElement(By.name("q"));
		searchBox.sendKeys("iPhone 6");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		d.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[1]/div/div/div[1]/section/div[2]/div/div[2]/a[1]")).click();
		WebElement drpdwn = d.findElement(By.xpath("//*[@class='_1QaKk1']/*[@class='a_eCSK']"));
		
		Select s=new Select(drpdwn);
		s.selectByValue("30000");
		d.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[1]/div/div/div[4]/section/div[2]/div[1]/div[1]/div/div/label/div[1]")).click();
		d.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[1]/div/div/div[3]/section/div[1]/label/div[1]")).click();
		Thread.sleep(4000);
		List<WebElement> list = d.findElements(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a"));
		
		for(int i=1;i<=list.size();i++){
			String proName = d.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a/div[2]/div[1]/div[1]")).getText();
			String price = d.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
			String proPrice = price.replaceAll("[?₹]","");
			String proLink = d.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a")).getAttribute("href");
			System.out.println(proName+"--"+proPrice+"---"+proLink);
		}
		
		// Create a list to display price, product name and link to the product details page on console
		
		d.quit();
			
	}
}
