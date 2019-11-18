package selenium4;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium4features {

	@Test
	public void screenShootTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		File file = logo.getScreenshotAs(OutputType.FILE);
		File destnition = new File("logo.png");
		FileUtils.copyFile(file, destnition);
		driver.quit();
	}

	@Test
	public void openNewTab() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void openNewWindow()throws InterruptedException  {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(5000);
		driver.quit();

	}

	@Test
	public void Location()throws InterruptedException  {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

		System.out.println("Height "+logo.getRect().getDimension().getHeight());
		System.out.println("Width "+ logo.getRect().getDimension().getHeight());
		
		System.out.println("get X "+logo.getRect().getX());
		System.out.println("get Y "+ logo.getRect().getY());
		
		Thread.sleep(5000);
		driver.quit();

	}

}