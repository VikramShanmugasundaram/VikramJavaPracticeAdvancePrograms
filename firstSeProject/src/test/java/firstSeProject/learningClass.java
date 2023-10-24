package firstSeProject;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class learningClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//creating variables
		String chromeDriverPath = "C:\\Users\\91978\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		String websiteURL = "https://demo.guru99.com/test/newtours/";
		String samp = "https://www.lambdatest.com/blog/selenium-standalone-server-and-selenium-server/";
		//setting the chrome driver
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		
		RemoteWebDriver rdriver= null;
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		try {
			rdriver= new RemoteWebDriver(new URL("http://localhost:4444"), options);
		}catch(Exception e){
			System.out.println("the exeception is "+e);
		}
//		Thread.sleep(200000);
		rdriver.get(samp);
		
		
		
		
		
		
		//maximizing the window
		driver.manage().window().maximize();
		
		//portal opening
//		driver.get(websiteURL);
		
		
		//identifying an element with id:
		//driver.findElement(By.id("site-name")).click();
		
		//identifying an element with id:
		driver.findElement(By.name("userName")).sendKeys("vikram");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		//identifying an element with innerText:
		//sdriver.findElement(By.linkText("Login")).click();
		
		//LOCATING WITH CSS SELECTOR
		//identifying an element with (Tag#id  - input#idValue):
		driver.findElement(By.cssSelector("div#site-name")).isEnabled();
		//identifying an element with tag and class(Tag.class – input.classvalue):
		driver.findElement(By.cssSelector("a.dropdown-toggle")).isEnabled();
		//identifying an element with tag and attribute(Tag[attribute] - Input[name=email]):
		driver.findElement(By.cssSelector("input[type=password]")).getText();
		//identifying an element with tag class attribute(Tag.class[attribute=value] – input.inputtext[name=email]):
		driver.findElement(By.cssSelector("div.site-name[id=site-name]")).getText();
		//identifying an element with Tag.contains(“inner text”) – font.contains(“password”)
		//driver.findElement(By.cssSelector("font.contains(password)")).getText();
		
		
		//DROPDOWN SELECT
//		WebElement ele =driver.findElement(By.linkText("Selenium"));
//		Select underSelenium = new Select(ele);
//		underSelenium.selectByVisibleText("Login");
//		underSelenium.selectByIndex(5);
		
		//ITERATING ELEMENTS
		@SuppressWarnings("unchecked")
		List<WebElement> elements = (List<WebElement>) driver.findElement(By.name("name"));
		for(int i=0;i<=elements.size();i++) {
			System.out.println("Radio button texts "+elements.get(i).getAttribute("name"));
		}
		
//		out:
//		Radio button texts: yes
//		Radio button texts: no
		
//		submit button without clicking
		driver.findElement(By.name("elem")).submit();
		
//		out
//		the button gets submitted
		
////		RADIO BUTTON SELECTION
//		WebElement ele1 = driver.findElement(By.id("id-1"));
//		ele1.click();
//		boolean selected =ele1.isSelected();
//		
//		out
//		True
		
//		SELECTING CHECK BOXES
//		WebElement ele2 = driver.findElement(By.name("checkbox-1"));
//		WebElement ele3 = driver.findElement(By.name("Checkbox-2"));
//		ele2.click();
//		ele3.click();
//		boolean checkboxSelected1 = ele2.isEnabled();
//		boolean checkboxSelected2 = ele3.isEnabled();
//		
//		out
//		True
//		True
		
//		FOR ACCEPTING THE ALERT
		driver.switchTo().alert().accept();
//		FOR DISMISSING THE ALERT
		driver.switchTo().alert().dismiss();
		
//		WITHOUT SWITCHING CONTROL TO NEXT WINDOW:
		driver.findElement(By.name("name1")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
//		out
//		return the parent window string CDWINDOW=238324U3HJ3G4327Y3243G
		driver.findElement(By.name("name2")).click();
		String parentWindow2 = driver.getWindowHandle();
		System.out.println(parentWindow2);
//		out
//		return No Such Element Exception as we're is new window but didn't switch to this
		
//		SWITCHING THE CONTROL OF WINDOWS
//		driver.get("url");
		driver.findElement(By.name("name")).click();
		String parentWindowA = driver.getWindowHandle();
		System.out.println(parentWindowA);
//		out
//		parentwindow string value will be returning
		for(String s:driver.getWindowHandles()) {
			if(!(s.equals(parentWindowA))) {
				//when current window string is not 
//				equal to parent then it'll switch to child window
				driver.switchTo().window(s);
				String str = driver.findElement(By.name("name")).getText();
				System.out.println("Child Text "+ str);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindowA);
//		out
//		control has been switched to child window and taken back to parent window
		
		//FRAMES:
		driver.get(websiteURL);
		driver.switchTo().frame("121212");
		driver.findElement(By.xpath("//input[@name='Hello']"));
		driver.switchTo().defaultContent();//going back to default content
		
		//ASSERTION(VALIDATION)
		driver.get(websiteURL);
		String expected = "Title";
		String actual;
		actual=driver.getTitle();
		if(expected.equalsIgnoreCase(actual)) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		//HARD WAIT
		Thread.sleep(10000);
		
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Duration time=20;
		//Explicit wait
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		
		//FLUENT WAIT
		//Declare and initialise a fluent wait
//		FluentWait wait = new FluentWait(driver);
		//Specify the timout of the wait
//		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
		//Sepcify polling time
//		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		//Specify what exceptions to ignore
//		wait.ignoring(NoSuchElementException.class)

		//This is how we specify the condition to wait on.
		//This is what we will explore more in this chapter
//		wait.until(ExpectedConditions.alertIsPresent());
		//closing the browser
		//driver.close();
	}

}
