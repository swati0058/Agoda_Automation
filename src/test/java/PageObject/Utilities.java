package PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static String button_selection = " ";
	public static String Guestbooking_duration = "Overnight Stays";
//public static WebDriver driver;

	public static void handleclosedialog(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No thanks']")));
		System.out.println("button displayed");
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();

	}

	public void clickontravelleroccupancy(WebDriver driver) {
		driver.findElement(By.id("occupancy-box")).click();

	}

	public void close_driver(WebDriver driver) throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("-***********closing driver***************------");
		driver.close();

	}

	public void search(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//button[@data-selenium='searchButton']")).click();

	}

	public String selectStay_duration(WebDriver driver) throws InterruptedException {
		System.out.println("calling  selectStay_duration");

		WebElement button1 = driver.findElement(By.xpath("//button[@aria-label='Overnight Stays']"));
		String button_overnight_stays = button1.getAttribute("aria-label");
		WebElement button2 = driver.findElement(By.xpath("//button[@aria-label='Day Use Stays']"));
		String button_Day_stays = button2.getAttribute("aria-label");

		if (button_overnight_stays.equalsIgnoreCase(Guestbooking_duration)) {
			System.out.println("*******************user selected " + button_overnight_stays);
			button_selection = button_overnight_stays;
			button1.click();

		}
		// System.out.println("========button1========"+button_overnight_stays);
		else if (button_Day_stays.equalsIgnoreCase(Guestbooking_duration)) {
			System.out.println("*******************user selected " + button_Day_stays);
			button_selection = button_Day_stays;
			button2.click();

		}
		return button_selection;

	}

	public void selectCity(WebDriver driver, String destination_place) {
		System.out.println("Selecting city");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='Popup__content Popup__content_Occupancy']//ul//li[@class='Suggestion Suggestion__categoryName']"));
		for (WebElement current : list) {
			String cities = current.getAttribute("data-element-value");
			 System.out.println("======cities======"+cities);
			//String cities_data[] = cities.split(",");
			//String city = cities_data[0];
			//System.out.println("======city======"+city);
			//System.out.println("cities_data-----" + city);
			
			 if (cities.contains(destination_place)) {
					System.out.println("city is same");
					current.click();
					break;
				}
		}

	}

	
	public void selectingHotels( WebDriver driver, String hotelName)
	{
		System.out.println("Selecting hotels");
		System.out.println(hotelName);
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());
List<WebElement> list=	driver.findElements(By.xpath("//div[@class='sc-bdfBwQ sc-gsTCUz  ljntSB']//h3"));
		
		for(WebElement list_hotels :list )
		{
			String Hotels_name = list_hotels.getAttribute("innerHTML");;
			 System.out.println("======hotels======"+Hotels_name);
	
			 if (Hotels_name.contains(hotelName)) {
					System.out.println("city is same");
					list_hotels.click();
					break;
				}
	}
		

	}
		}}}
	
	

