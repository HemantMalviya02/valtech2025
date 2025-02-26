package day3;

public enum Month {
		JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31),
		JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31),
		NOVEMBER(30), DECEMBER(31);
		
		private int noOfDays;
		
		Month(int noOfDays) {
			this.noOfDays = noOfDays;
		}
		
		@Override
			public String toString() {
				return "Month" + " "+ name() + " "+ "No of Days = " + noOfDays;
			}

		public int getNoOfDays() {
			return noOfDays;
		}

		public static void main(String[] args) {
			for(Month m : Month.values()) {
				System.out.println(m);
			}
		}
		
}
