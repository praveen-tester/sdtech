package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;


	@BeforeClass
	public void browsersetup() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the browser (chrome, firefox, edge): ");
		String browser= scanner.nextLine();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver","//Users//apple//Downloads//chrome-mac-arm64.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("Webdriver.edge.driver","//Users//apple//Desktop//untitled folder 2//edgedriver_win64.exe");
			driver=new EdgeDriver();
		}
		FileInputStream f1=new FileInputStream("/Users/apple/eclipse-workspace/Sdtech/src/test/java/demo.properties");
		Properties p1=new Properties();
		p1.load(f1);
		String u1=p1.getProperty("url");
		driver.get(u1);
		driver.manage().window().maximize();

	}
	@Test(priority=1)
	public void m1() throws IOException, InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(5000);
		TakesScreenshot s1=(TakesScreenshot)driver;
		File f1=s1.getScreenshotAs(OutputType.FILE);
		String path="/Users/apple/eclipse-workspace/Sdtech/Screenshot//s1.png";
		FileUtils.copyFile(f1, new File(path));

	}
	@Test(priority=2)
	public void screenshot() throws IOException, InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]")).click();
		Thread.sleep(5000);
		TakesScreenshot s1=(TakesScreenshot)driver;
		File f1=s1.getScreenshotAs(OutputType.FILE);
		String path="/Users/apple/eclipse-workspace/Sdtech/Screenshot//s2.png";
		FileUtils.copyFile(f1, new File(path));

	}
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
