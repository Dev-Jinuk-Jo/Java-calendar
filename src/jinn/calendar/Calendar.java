package jinn.calendar;

public class Calendar {
	
	private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	public int getWeekDay(int year, int month) {
		int uYear = 1970;
		int uWeekday = 4;
		int count = 0;
		for(int i = uYear; i < year; i++) {
			int yearDateSum = isLeapYear(i) ? 366 : 365;
			count += yearDateSum;
		}
		for(int i = 1; i < month; i ++) {
			int monthDateSum = isLeapYear(year) ? LEAP_MAX_DAYS[i] : MAX_DAYS[i];
			count += monthDateSum;
		}
		int result = (uWeekday + count) % 7;
		return result;
	}
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;			
		} else {
			return false;			
		}
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];			
		}
	}

	
	public void printCalendar(int year, int month) {
		System.out.printf("    <%4d년%3d월>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		//get weekday automatically
		int weekday = getWeekDay(year, month);
		
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7)? count : 0;
		
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		for(int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();				
			}
		}
		
		System.out.println();
	}
}
