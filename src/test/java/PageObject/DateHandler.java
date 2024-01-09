package PageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DateHandler {

	public void selectfromDate(WebDriver driver, String bookfromDate, String dateformat) throws Exception {
		System.out.println("bookDate-----" + bookfromDate);
		System.out.println("dateformat-----" + dateformat);

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateformat);
		Date formattedTargetDate;
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(bookfromDate);
			calendar.setTime(formattedTargetDate);

			String date[] = bookfromDate.split("/");
			System.out.println("===day" + date[0] + "== month" + date[1]);
			String expecteddate = date[1] + " " + date[0];
			System.out.println("------expecteddate" + expecteddate);
			// System.out.println();

			System.out.println("formattedDate------" + formattedTargetDate);
			System.out.println("bookDate----" + bookfromDate);

			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("targetDay======" + targetDay);
			int targetMonth = calendar.get(Calendar.MONTH);
			System.out.println("targetMonth======" + targetMonth);
			int targetYear = calendar.get(Calendar.YEAR);
			System.out.println("targetYear======" + targetYear);
			Thread.sleep(1000);

			String actualDate = driver.findElement(By.xpath("//div[@class='DayPicker-Caption DayPicker-Caption-Wide']")).getText();
			System.out.println("=====actualDate========" + actualDate);

			// System.out.println("actualfromDate"+actualDate);// Fri 05 2024

			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

			int actualMonth = calendar.get(Calendar.MONTH);
			int actualYear = calendar.get(Calendar.YEAR);
			System.out.println("actualMonth-------" + actualMonth);
			System.out.println("targetMonth-------" + targetMonth);
			// targetMonth// actualMonth-------0

			System.out.println("actualYear------" + actualYear);// actualYear------2024

			while (targetMonth < actualMonth || targetYear < actualYear) {
				System.out.println("********************smaller than target******************");

				// String labelText = element.getAttribute("aria-label");
				List<WebElement> actualDate1 = driver.findElements(By.xpath("//div[@class='DayPicker-Caption DayPicker-Caption-Wide']"));

				for (WebElement a : actualDate1) {
					actualDate = a.getText();
					System.out.println("actualfromDate-----" + actualDate);//
				}

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			while (targetMonth > actualMonth || targetYear > actualYear) {
				System.out.println("*****************targetmonth is greater than actualmomth ********************");
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
				// System.out.println("for departure ");
				System.out.println("targetMonth ----" + targetMonth);
				System.out.println("targetYear----" + targetYear);
				actualDate = driver.findElement(By.xpath("//div[@class='DayPicker-Caption DayPicker-Caption-Wide']")).getText();

				/*
				 * for (WebElement a : actualDate1) { actualDate = a.getText();
				 * System.out.println("actualDatein greater than-----" + actualDate);// }
				 */
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				// System.out.println("actualDate=======" + actualDate);
				// System.out.println(actualDate);

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			Thread.sleep(500);
			// System.out.println("for departure-----" + targetDay);

			// int targetday1=targetDay+1;
			//driver.findElement(By.xpath("//div[contains(@aria-label,'" + expecteddate+ "')]//span[@class='class='PriceSurgePicker-Day__label PriceSurgePicker-Day__label--wide'][normalize-space()='" + targetDay + "']")).click();
			driver.findElement(By.xpath("//div[contains(@aria-label,'" + expecteddate+ "')]//span[text()='" + targetDay + "']")).click();
			
			// driver.findElement(By.xpath("//div[@class='DayPicker-Day']//span[text()=" +
			// targetDay + "]")).click();

		} catch (ParseException e) {
			throw new Exception("Invalid date is provided, please check input date");
		}
	}

	public void selectToDate(WebDriver driver, String bookToDate, String dateformat) throws Exception {
		System.out.println("bookToDate-----" + bookToDate);
		System.out.println("dateformat-----" + dateformat);

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateformat);
		Date formattedTargetDate;

		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(bookToDate);
			calendar.setTime(formattedTargetDate);

			String date[] = bookToDate.split("/");
			System.out.println("===day" + date[0] + "== month" + date[1]);
			String expecteddate = date[1] + " " + date[0];
			System.out.println("------expecteddate" + expecteddate);

			System.out.println("formattedDate------" + formattedTargetDate);
			System.out.println("bookDate----" + bookToDate);

			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("targetDay======" + targetDay);
			int targetMonth = calendar.get(Calendar.MONTH);
			System.out.println("targetMonth======" + targetMonth);
			int targetYear = calendar.get(Calendar.YEAR);
			System.out.println("targetYear======" + targetYear);
			Thread.sleep(1000);

			String actualDate = driver.findElement(By.xpath("//div[@class='DayPicker-Caption DayPicker-Caption-Wide']")).getText();

			System.out.println("actualDate-----" + actualDate);

			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

			int actualMonth = calendar.get(Calendar.MONTH);
			int actualYear = calendar.get(Calendar.YEAR);
			System.out.println("actualMonth-------" + actualMonth);
			System.out.println("targetMonth-------" + targetMonth);
			// targetMonth// actualMonth-------0

			System.out.println("actualYear------" + actualYear);// actualYear------2024

			while (targetMonth < actualMonth || targetYear < actualYear) {
				System.out.println("********************smaller than target******************");

				// String labelText = element.getAttribute("aria-label");
				List<WebElement> actualDate1 = driver.findElements(By.xpath("//div[@class='DayPicker-Caption DayPicker-Caption-Wide']"));

				for (WebElement a : actualDate1) {
					actualDate = a.getText();
					System.out.println("actualfromDate-----" + actualDate);//
				}

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			while (targetMonth > actualMonth || targetYear > actualYear) {
				System.out.println("*****************targetmonth is greater than actualmomth ********************");
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
				// System.out.println("for departure ");
				System.out.println("targetMonth ----" + targetMonth);
				System.out.println("targetYear----" + targetYear);
				List<WebElement> actualDate1 = driver.findElements(By.xpath("//div[@class='DayPicker-Caption DayPicker-Caption-Wide']"));

				for (WebElement a : actualDate1) {
					actualDate = a.getText();
					System.out.println("actualDatein greater than-----" + actualDate);//
				}

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				// System.out.println("actualDate=======" + actualDate);
				// System.out.println(actualDate);

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}
			
			driver.findElement(By.xpath("//div[contains(@aria-label,'" + expecteddate+ "')]//span[text()='" + targetDay + "']")).click();

			//driver.findElement(By.xpath("//div[contains(@aria-label,'" + expecteddate+ "')]//span[@class='class='PriceSurgePicker-Day__label PriceSurgePicker-Day__label--wide'][normalize-space()='" + targetDay + "']")).click();

			// System.out.println("for departure-----" + targetDay);

			// int targetday1=targetDay+1;
			// driver.findElement(By.xpath("//div[@class='DayPicker-Day']//span[text()=" +
			// targetDay + "]")).click();

		} catch (ParseException e) {
			throw new Exception("Invalid date is provided, please check input date");
		}

	}

	public void selectfromDate_dayStay(WebDriver driver, String bookfromDate, String dateformat) throws Exception {
		System.out.println("bookDate-----" + bookfromDate);
		System.out.println("dateformat-----" + dateformat);

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateformat);
		Date formattedTargetDate;
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(bookfromDate);
			calendar.setTime(formattedTargetDate);

			System.out.println("formattedDate------" + formattedTargetDate);
			System.out.println("bookDate----" + bookfromDate);

			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("targetDay======" + targetDay);
			int targetMonth = calendar.get(Calendar.MONTH);
			System.out.println("targetMonth======" + targetMonth);
			int targetYear = calendar.get(Calendar.YEAR);
			System.out.println("targetYear======" + targetYear);
			Thread.sleep(1000);

			String actualDate = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

			System.out.println("actualfromDate" + actualDate);// Fri 05 2024
			/*
			 * String date[]=actualDate.split(" ");
			 * 
			 * for(int i=0;i<date.length;i++) {
			 * System.out.println("At index 0----"+date[0]);
			 * System.out.println("At index 1----"+date[1]);//At index 1----Jan String
			 * month=date[1]; System.out.println(month);
			 * 
			 * String date_actual=date[2]; System.out.println(date_actual);
			 * 
			 * }
			 */

			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

			int actualMonth = calendar.get(Calendar.MONTH);
			int actualYear = calendar.get(Calendar.YEAR);
			System.out.println("actualMonth-------" + actualMonth);
			System.out.println("targetMonth-------" + targetMonth);
			// targetMonth// actualMonth-------0

			System.out.println("actualYear------" + actualYear);
			while (targetMonth < actualMonth || targetYear < actualYear) {
				System.out.println("********************smaller than target******************");

				// String labelText = element.getAttribute("aria-label");
				actualDate = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			} // actualYear------2024
			while (targetMonth > actualMonth || targetYear > actualYear) {
				System.out.println("*****************targetmonth is greater than actualmomth ********************");
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
				// System.out.println("for departure ");
				System.out.println("targetMonth ----" + targetMonth);
				System.out.println("targetYear----" + targetYear);
				actualDate = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();

				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				// System.out.println("actualDate=======" + actualDate);
				// System.out.println(actualDate);

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			// System.out.println("for departure-----" + targetDay);

			// int targetday1=targetDay+1;
			driver.findElement(By.xpath("//div[@class='DayPicker-Day']//span[text()=" + targetDay + "]")).click();

		} catch (ParseException e) {
			throw new Exception("Invalid date is provided, please check input date");
		}
	}

	// String actualtoDate =
	// driver.findElement(By.xpath("//div[@aria-label=]//span")).getAttribute("data-selenium-date");

//		System.out.println(actualtoDate);// Fri Jan 05 2024
	/*
	 * String date[]=actualDate.split(" ");
	 * 
	 * for(int i=0;i<date.length;i++) {
	 * System.out.println("At index 0----"+date[0]);
	 * System.out.println("At index 1----"+date[1]);//At index 1----Jan String
	 * month=date[1]; System.out.println(month);
	 * 
	 * String date_actual=date[2]; System.out.println(date_actual);
	 * 
	 * }
	 */

	// calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

}
