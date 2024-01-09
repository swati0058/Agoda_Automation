package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Traveller {

	public static void AddRoomsoccupancy(WebDriver driver) {

		System.out.println("=================calling adding room=============");

		// Adding Adults
		driver.findElement(By.xpath("//div[@class='sc-bdfBwQ sc-gsTCUz  ljntSB']//button[contains(@aria-label,'Add')]"))
				.click();
	}

	public static void minusRoomsOccupancy(WebDriver driver) {

		String number = driver.findElement(By.xpath("//div[@data-selenium='desktop-occ-room-value']//h3"))
				.getAttribute("innerText");
		System.out.println("===============number--------" + number);
		if (number.contentEquals("0")) {
			System.out.println("can't remove rooms count cause minus is disabled");
		} else {

			System.out.println("=================calling removing occupancy rooms=============");
			driver.findElement(By.xpath("//div[@data-selenium='occupancyRooms']//button[@aria-label='Subtract']"))
					.click();
		}
	}

	public static void AddoccupancyAdults(WebDriver driver) {

		System.out.println("=================calling adding adultsoccupancy=============");

		// Adding Adults
		driver.findElement(By.xpath("//div[contains(@data-selenium,'occupancyAdults')]//button[@aria-label='Add']"))
				.click();
	}

	public static void minusoccupancyAdults(WebDriver driver) {

		String number = driver.findElement(By.xpath("//div[@data-selenium='desktop-occ-adult-value']//h3"))
				.getAttribute("innerText");
		System.out.println("===============number--------" + number);
		if (number.contentEquals("0")) {
			System.out.println("can't remove adults count cause minus is disabled");
		} else {

			System.out.println("=================calling removing adultsoccupancy=============");
			driver.findElement(By.xpath("//div[@data-selenium='occupancyAdults']//button[@aria-label='Subtract']"))
					.click();

		}
	}

	public static void AddoccupancyChildren(WebDriver driver) {

		System.out.println("=================calling adding childrenoccupancy=============");

		// Adding Adults
		driver.findElement(By.xpath("//div[contains(@data-selenium,'occupancyChildren')]//button[@aria-label='Add']"))
				.click();
	}

	public static void minusoccupancyChildren(WebDriver driver) {

		String number = driver.findElement(By.xpath("//div[@data-selenium='desktop-occ-children-value']//h3"))
				.getAttribute("innerText");
		System.out.println("===============number--------" + number);
		if (number.contentEquals("0")) {
			System.out.println("can't remove children count cause minus is disabled");
		} else {

			System.out.println("=================calling removing childrenoccupancy=============");
			driver.findElement(By.xpath("//div[@data-selenium='occupancyChildren']//button[@aria-label='Subtract']"))
					.click();

		}
	}

	public static void actionsonoccupancy(WebDriver driver) throws InterruptedException {
		AddRoomsoccupancy(driver);
		Thread.sleep(400);
		minusRoomsOccupancy(driver);
		Thread.sleep(400);
		AddoccupancyAdults(driver);
		Thread.sleep(400);
		minusoccupancyAdults(driver);
		Thread.sleep(400);
		AddoccupancyChildren(driver);
		Thread.sleep(400);
		minusoccupancyChildren(driver);

	}

}
