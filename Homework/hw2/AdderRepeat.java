package hw2;

import java.util.Scanner;

public class AdderRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		// get test case #
		int caseNumber = keyboard.nextInt();
		String junk = keyboard.nextLine();
		// get test case one by one
		for (int i = 0; i < caseNumber; i++) {
			// get input numbers
			String a = keyboard.next();
			String b = keyboard.next();
			junk = keyboard.nextLine();
			// call adder
			adder(a, b);
		}
		keyboard.close();
	}
	public static void adder(String a, String b) {
		// addition and output
		String sum = addInfiniteDecimal(a, b);
		System.out.println(sum);
	}
	public static String addInfiniteDecimal(String a, String b) {
		// split inputs
		String[] part_a = a.split("\\.");
		String[] part_b = b.split("\\.");
		String int_a = part_a[0];
		String dec_a = (part_a.length > 1) ? part_a[1] : "0";
		String int_b = part_b[0];
		String dec_b = (part_b.length > 1) ? part_b[1] : "0";
		// expand decimal part
		int LengthLCM = findLCM(dec_a.length(), dec_b.length());
		dec_a = addRepeats(dec_a, LengthLCM);
		dec_b = addRepeats(dec_b, LengthLCM);
		// add decimal part
		String dec_c = addStrings(dec_a, dec_b);
		// check carry
		int carry = 0;
		if(dec_c.length() > LengthLCM) {
			carry = 1;
			dec_c = dec_c.substring(1);
			dec_c = addStrings(dec_c, "1");
		}
		// check decimal repeat
		dec_c = checkReapeat(dec_c, LengthLCM);
		// add integer part
		String int_c = addStrings(int_a, int_b);
		// add 1 if decimal addition has carry
		if(carry == 1) {
			int_c = addStrings(int_c, "1");
		}
		// check 0.9...
		if(dec_c.equals("9")) {
			dec_c = "";
			int_c = addStrings(int_c, "1");
		}
		// return
		return int_c + ((dec_c.length() > 0) ? "." + dec_c : "");
    }
    public static int findLCM(int num1, int num2) {
		// find least common multiple
        return (num1 * num2) / findGCD(num1, num2);
    }
    public static int findGCD(int num1, int num2) {
		// find greatest common divisor
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
	public static String addRepeats(String str, int requireLength) {
		// expand the decimal by adding repeating parts until require lenght
		int repeatTimes = requireLength / str.length();
		String returnString = "";
		for (int i = 0; i < repeatTimes; i++) {
			returnString += str;
		}
		return returnString;
	}
	public static String addStrings(String a, String b) {
		// add string char by char
		StringBuilder c = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		// check if addition is done
		while(i >= 0 || j >= 0 || carry > 0) {
			int sum = carry;
			if(i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if(j >= 0) {
				sum += b.charAt(j--) - '0';
			}
			c.insert(0, sum % 10);
			carry = sum / 10;
		}
		return c.toString();
	}
	public static String checkReapeat(String str, int strLength) {
		int i = 0;
		while(i < strLength) {
			String repeatPart = str.substring(0, i + 1);
			int j = 0;
			int k = i + 1;
			while(k < strLength) {
				if(str.charAt(k) != repeatPart.charAt(j)) {
					break;
				}
				j = (j + 1) % (i + 1);
				k++;
			}
			if(k == strLength) {
				break;
			}
			i++;
		}
		if(i != strLength) {
			str = str.substring(0, i + 1);
		}
		return str;
	}
}