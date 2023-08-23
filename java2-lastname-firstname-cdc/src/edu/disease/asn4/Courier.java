package Assignments;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

public class Courier {
	static HashMap<String, Integer> time = new HashMap<>();

	public Courier() {

		time.put("startPoint", 0);
		time.put("nodePoint1", 4);
		time.put("nodePoint2", 2);
		time.put("nodePoint3", 8);
		time.put("nodePoint4", 10);
		time.put("nodePoint5", 2);
	}

	public static void main(String[] args) {

		new Courier();
		LocalDateTime startDateTime = LocalDateTime.of(2023, 8, 23, 20, 00);
		System.out.println(startDateTime);
		System.out.println(getDeliveryTime(startDateTime));
	}

	public static LocalDateTime getDeliveryTime(LocalDateTime startDateTime) {
		LocalDateTime times = null;
		boolean flag = true;
		if (!isSatSun(startDateTime)) {
			for (int i = 1; i < time.size() - 1; i++) {
				
				if (times == null && !isSatSun(startDateTime.plusHours(time.get("nodePoint"+i)))) { // when started not weekend
					times = startDateTime.plusHours(time.get("nodePoint" + i));
				}
				if(times!=null && isSatSun(times.plusHours(time.get("nodePoint"+i)))) {
					times=times.plusHours(time.get("nodePoint"+i));
				}
//				if (times == null) { // when started friday night
//					if (isSatSun(startDateTime.plusHours(time.get("nodePoint" + i)))) {
//						times = startDateTime.plusHours(24 - startDateTime.getHour());
//						times = times.plusHours(48);
//						flag = false;
//
//					}
//				}
//				if (times == null && flag) { // when started friday evening
//					System.out.println("h");
//					times = startDateTime.plusHours(time.get("nodePoint" + i));
//				}
//				if (times != null) { // when
//					if (isSatSun(times.plusHours(time.get("nodePoint" + i)))) {
//
//					}
//				}

		}} else {
			System.out.println("Please enter valid start Date Time");
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
}

//	public static boolean isHoliday(LocalDateTime ld1) {
//		boolean opt1=false;
//		if(ld1.getMonth()==)
//	}
//}
