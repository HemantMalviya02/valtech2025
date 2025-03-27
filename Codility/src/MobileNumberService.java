

import java.util.Scanner;

public class MobileNumberService {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        String no = sc.nextLine();
        int score = rateNumber(no);
        System.out.println("Memorability rating for " + no + ": " + score);
	}
	
	public static int rateNumber(String number) {
        int score = 0;
        
        if (number.length() <= 3) {
            score += 3;
        } else if (number.length() <= 5) {
            score += 2;
        } else {
            score += 1;
        }
        if (isPalindrome(number)) {
            score += 3; 
        }
        if (hasRepeatingDigits(number)) {
            score += 2;
        }
        return score;
    }

	public static boolean isPalindrome(String number) {
        for (int i = 1; i < number.length()/2; i++) {
            if (number.charAt(i) != number.charAt(number.length()-i-1)) {
                return false;
            }
        }
        return true;
    } 
	
	   public static boolean hasRepeatingDigits(String number) {
	        for (int i = 1; i < number.length(); i++) {
	            if (number.charAt(i) != number.charAt(0)) {
	                return false;
	            }
	        }
	        return true;
	    }
	
}
