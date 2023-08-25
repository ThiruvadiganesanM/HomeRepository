import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Scanner;

public class Courier {
	static HashMap<String, Integer> time = new HashMap<>();

	public Courier() {

		time.put("startPoint", 0);
		time.put("nodePoint1", 4);
		time.put("nodePoint2", 2);
		time.put("nodePoint3", 8);
		time.put("nodePoint4", 10);
		time.put("deliveryOut", 2);
	}

	public static void main(String[] args) {
		new Courier();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the start date");
		String[] date = input.nextLine().split(":");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int datee = Integer.parseInt(date[2]);
		int hour = Integer.parseInt(date[3]);
		int minute = Integer.parseInt(date[4]);

		LocalDateTime startDateTime = LocalDateTime.of(year, month, datee, hour, minute);
		if (isSatSun(startDateTime)) {
			System.out.println("please enter working day date");
		} else {
			System.out.println(startDateTime);
			System.out.println(getDeliveryTime(startDateTime));
		}
	}

	public static LocalDateTime getDeliveryTime(LocalDateTime startDateTime) {
		LocalDateTime times = null;

		for (int i = 1; i < time.size() - 1; i++) {
			if (i == 5) {
				times = times.plusHours(time.get("deliveryOut"));
			}

			// travelling on friday night
			if (times != null && isSatSun(startDateTime.plusHours(time.get("nodePoint" + i)))) {
				System.out.println("h3");
				times = times.plusHours(48 + (24 - (startDateTime.getHour())));
				times = times.plusHours(time.get("nodePoint" + 1));
				continue;
			}

			// travelling on week days
			if (times != null) {
				System.out.println("h");
				times = times.plusHours(time.get("nodePoint" + i));
				continue;
			}

			// started on friday night
			if (times == null && isSatSun(startDateTime.plusHours(time.get("nodePoint" + i)))) {
				System.out.println("h1");
				times = startDateTime.plusHours(48 + (24 - (startDateTime.getHour())));
				times = times.plusHours(time.get("nodePoint" + 1));
				continue;
			}

			// started on weekdays
			if (times == null) {
				System.out.println("h2");
				times = startDateTime.plusHours(time.get("nodePoint" + i));
			}

		}

		return times;

	}

	public static boolean isSatSun(LocalDateTime ld) {

		boolean opt = false;
		if ((ld.getDayOfWeek() == DayOfWeek.SATURDAY) || (ld.getDayOfWeek() == DayOfWeek.SUNDAY)) {
			opt = true;
		}
		return opt;
	}

	public boolean isHoliday(LocalDateTime ld) {
		DayOfWeek dw = ld.getDayOfWeek();
		Month m = ld.getMonth();
		if (dw == DayOfWeek.SUNDAY || dw == DayOfWeek.SATURDAY) {
			return true;
		} else if (ld.getDayOfMonth() == 15 && m == Month.AUGUST) {
			return true;
		} else if (ld.getDayOfMonth() == 1 && m == Month.JANUARY) {
			return true;
		} else if (ld.getDayOfMonth() == 26 && m == Month.JANUARY) {
			return true;
		} else {
			return false;
		}
	}
}