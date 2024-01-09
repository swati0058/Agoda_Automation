package com.bdd.agoda;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Booking_PageUtilities {

	
	
	public String sortByRating(WebDriver driver,String rating_Type) throws Exception {
		try {
			if (rating_Type.equalsIgnoreCase("5-Star rating")) {

				driver.findElement(By.xpath("//span[@class='filter-item-info StarRating-5 ']/span[1]/span")).click();

			} else if (rating_Type.equalsIgnoreCase("4-Star rating")) {

				driver.findElement(By.xpath("//span[@class='filter-item-info StarRating-4 ']/span[1]/span")).click();
			}

			else if (rating_Type.equalsIgnoreCase("3-Star rating")) {

				driver.findElement(By.xpath("//span[@class='filter-item-info StarRating-3 ']/span[1]/span")).click();
			}

			else if (rating_Type.equalsIgnoreCase("2-Star rating")) {

				driver.findElement(By.xpath("//span[@class='filter-item-info StarRating-2 ']/span[1]/span")).click();
			}

			else if (rating_Type.equalsIgnoreCase("1-Star rating")) {

				driver.findElement(By.xpath("//span[@class='filter-item-info StarRating-1 ']/span[1]/span")).click();
			}

			else if (rating_Type.equalsIgnoreCase("0-Star rating")) {

				driver.findElement(By.xpath("//span[@class='filter-item-info StarRating-0 ']/span[1]/span")).click();
			}

			return rating_Type;

		} catch (Exception e) {
			throw new Exception("This rating is not present" + rating_Type);
		}
	}
	
	
	public  void SetminSlider(WebDriver driver, String amount) {

		WebElement minsideramount = driver.findElement(By.id("price_box_0"));
		minsideramount.clear();
		minsideramount.sendKeys(amount);
		minsideramount.sendKeys(Keys.ENTER);

	}

	public  void SetmaxSlider(WebDriver driver, String amount) {
		// System.out.println("----------- amountmax---"+amount);
		WebElement maxslideramount = driver.findElement(By.id("price_box_1"));
		maxslideramount.clear();
		maxslideramount.sendKeys(amount);
		maxslideramount.sendKeys(Keys.ENTER);

		WebElement priceSlider = driver.findElement(By.xpath("//div[@class='rc-slider-track rc-slider-track-1']"));
		Actions action = new Actions(driver);
		action.clickAndHold(priceSlider);
		action.moveByOffset(0, 100).build().perform();

	}

	public  void SetAccomodationType(WebDriver driver, String property_type) throws Exception {
		String accomodation_type = "";
		try {
			List<WebElement> list = driver
					.findElements(By.xpath("//div[@aria-labelledby='filter-menu-AccomdType']//ul/li/span"));
			for (WebElement current_type : list) {
				accomodation_type = current_type.getAttribute("aria-label");
				System.out.println("======accomodation_type======" + accomodation_type);

				if (accomodation_type.equalsIgnoreCase(property_type)) {

					driver.findElement(By.xpath("//span[text()='" + accomodation_type + "']//ancestor::span//span[@class='checkbox-icon']"))
							.click();
					System.out.println(accomodation_type + " is clicked");
					break;
				}
			}

		} catch (Exception e) {
			throw new Exception("This accomodationType is not present" + accomodation_type);
		}
	}
	
	
	public  void RoomOfferstypes(WebDriver driver, String roomoffer_type) throws Exception {
		String roomofferstypes = "";
		try {
				List<WebElement> list = driver
					.findElements(By.xpath("//div[@aria-labelledby='filter-menu-RoomOffers']//ul/li/span"));
			for (WebElement current_type : list) {
				roomofferstypes = current_type.getAttribute("aria-label");
				System.out.println("======roomofferstypes======" + roomofferstypes);

			}

		} catch (Exception e) {
			throw new Exception("This accomodationType is not present" + roomofferstypes);
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
