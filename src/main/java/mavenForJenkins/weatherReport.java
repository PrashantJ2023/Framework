package mavenForJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class weatherReport {

    @Test
	public void getWeatherreport() throws Exception { 
	
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver =(WebDriver) new ChromeDriver();
	driver.get("https://www.tomorrow.io/weather/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    Thread.sleep(3000);
    
	WebElement city=driver.findElement(By.xpath("//h1[contains(text(),'Weather in Bengaluru, India')]"));
	WebElement ctemp=driver.findElement(By.xpath("//div[@class='_9oCDP5 DsY3vz']"));
    WebElement temp= driver.findElement(By.xpath("//div[@class='TwfjQl']"));
	
    String CityName=city.getText();
    String CurentTemp=ctemp.getText();
    String TodayTemp=temp.getText();
    System.out.println("Today weather forecast is: "+ CurentTemp + TodayTemp);
    
    try {
		sendWeatherMail.sendWeatherMailreport(CityName,CurentTemp,TodayTemp);
	} catch (Throwable e) {
		e.printStackTrace();
	}
    
    driver.quit();

	
}
}
