

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeClass {

	    public static void calculateDifference(String dateTime1, String dateTime2) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        LocalDateTime dt1 = LocalDateTime.parse(dateTime1, formatter);
	        LocalDateTime dt2 = LocalDateTime.parse(dateTime2, formatter);

	        Duration duration = Duration.between(dt1, dt2);

	        long days = duration.toDays();
	        long hours = duration.toHours() % 24;
	        long minutes = duration.toMinutes() % 60;
	        long seconds = duration.getSeconds() % 60;

	        System.out.println("Difference between " + dateTime1 + " and " + dateTime2 + " is:");
	        System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
	    }

	    public static void main(String[] args) {
	        String dateTime1 = "2025-03-25 14:30:00";
	        String dateTime2 = "2025-03-27 16:45:30";

	        calculateDifference(dateTime1, dateTime2);
	    }
	
}
