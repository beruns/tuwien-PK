public class YearFrom1980 {

	public static void main(String args[]) {

		int days = Integer.parseInt(args[0]);
		System.out.println("Year: " + year(days));

		//year(366);

	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
	}

	public  static int year (int days) {

		int year = 1980;
	
		while (days > 365) {

			if (isLeapYear(year)) {
				/**
				 * Fehler liegt hier. Wenn der Wert von days 366 ist, wird days nicht dekrementiert. Endlosschleife
				 */		

				//if (days > 366) {

				/**
				 * Korrigierte Version
				 */

				if (days > 366) {
					days -= 366;
					year += 1;
				} else {
					days = 0;
				}

			} else {
				days -= 365;
				year += 1;
			}
		}
	
		return year;
	
	}
}

