package com.bdd.agoda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageObject.DateHandler;
import PageObject.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrontPageAgoda extends BaseClass {

	public static String search_city = "Hyderabad";
	// String from_date=""
	public static String destination_place_1 = "Kukatpally";
	public static String destination_place_2 = "Hyderabad";
	public static String from_date = "15/Jan/2024";
	public static String to_date = "20/Jan/2024";
	public static String types;
	public static String actual_types = "occupancy-selector-panel-rooms";
	public static String actualDate = " ";
	public static String button_selection = "";
	public static String Guestbooking_duration = "";
	public static String rating_Type = "2-Star rating";
	public static String slider_min_amount = "5000";
	public static String slider_max_amount = "13000";

	public static String roomoffer_type = "Dinner included";
	public static String property_type = "Guesthouse/bed and breakfast";
	public static String hotel_name = "Radisson Hyderabad Hitec City";

	public static String Guestbooking_type = "";
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.agoda.com/");
		String cities;
		datehandler = new DateHandler();
		utilities = new Utilities();
		bookpageUtils= new Booking_PageUtilities();
		

		Utilities.handleclosedialog(driver);
		Thread.sleep(300);
		// Utilities.selectCity(driver,destination_place_2);

		Guestbooking_type = utilities.selectStay_duration(driver);
		// Guestbooking_type="Overnight Stays";
		System.out.println("========Guestbooking_type=========" + Guestbooking_type);

		if (Guestbooking_type.equalsIgnoreCase("Overnight Stays")) {
			driver.findElement(By.id("textInput")).sendKeys(search_city);
			Thread.sleep(800);
			utilities.selectCity(driver, destination_place_2);
			Thread.sleep(800);
			datehandler.selectfromDate(driver, from_date, "dd/MMM/yyyy");
			datehandler.selectToDate(driver, to_date, "dd/MMM/yyyy");
			utilities.clickontravelleroccupancy(driver);
			Thread.sleep(300);
			utilities.search(driver);
			
			Thread.sleep(1000);
			utilities.selectingHotels(driver,hotel_name);
			// search_sort(driver);
			//bookpageUtils.RoomOfferstypes(driver, roomoffer_type);

			//bookpageUtils.SetAccomodationType(driver, property_type);
			//Thread.sleep(500);
			////SetminSlider(driver, slider_min_amount);
			//Thread.sleep(500);
			//SetmaxSlider(driver, slider_max_amount);
			//Thread.sleep(500);
			//bookpageUtils. sortByRating(driver,rating_Type);
			//System.out.println("----Rating type " + rating_Type);

			// utilities.close_driver(driver);

		} else if (Guestbooking_type.equalsIgnoreCase("Day Use Stays")) {
			driver.findElement(By.id("textInput")).sendKeys(search_city);
			Thread.sleep(500);
			utilities.selectCity(driver, destination_place_2);
			datehandler.selectfromDate(driver, from_date, "dd/MMM/yyyy");
			datehandler.selectfromDate_dayStay(driver, from_date, "dd/MMM/yyyy");
			utilities.clickontravelleroccupancy(driver);
			utilities.search(driver);
			utilities.close_driver(driver);

		}
	}

	public static void search_sort(WebDriver driver) throws Exception {
		try {
			List<WebElement> sort_list = driver
					.findElements(By.xpath("//div[@class='Box-sc-kv6pi1-0 dvfiQa SortBar ']/a"));
			for (WebElement a : sort_list) {
				String actualData = a.getText();
				System.out.println("sort_list-----" + actualData);//
			}

		} catch (Exception e) {
			throw new Exception("Matches not present");
		}
	}
}
