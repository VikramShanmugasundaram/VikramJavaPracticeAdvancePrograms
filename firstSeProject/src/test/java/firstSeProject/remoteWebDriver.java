package firstSeProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class remoteWebDriver {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String chromeDriverPath = "C:\\Users\\91978\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		String samp = "https://www.google.com/search?q=selenium+standalone+server+is+executable+jar+or+non+executable+file%3F&rlz=1C1CHBF_enIN1052IN1052&oq=selenium+standalone+server+is+executable+jar+or+non+executable+file%3F&aqs=chrome..69i57.16890j0j7&sourceid=chrome&ie=UTF-8";
		
		
		try {
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			WebDriver driver = new ChromeDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RemoteWebDriver rdriver= null;
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		try {
			rdriver= new RemoteWebDriver(new URL("http://localhost:4444"), options);
//			rdriver.get(samp);
		}catch(Exception e){
			System.out.println("the exeception is "+e);
		}
		rdriver.get(samp);
	}	

}
