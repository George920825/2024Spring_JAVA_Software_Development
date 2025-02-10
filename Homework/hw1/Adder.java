package hw1;

import java.util.Scanner;

public class Adder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get inputs
		Scanner keyboard = new Scanner(System.in);
		String a = keyboard.next();
		String b = keyboard.next();
		keyboard.close();
		// addition and output
		String sum = addBigFloats(a, b);
		System.out.println(sum);
	}
	public static String addBigFloats(String a, String b) {
		// split inputs
		String[] part_a = a.split("\\.");
		String[] part_b = b.split("\\.");
		String int_a = part_a[0];
		String dec_a = (part_a.length > 1) ? part_a[1] : "0";
		String int_b = part_b[0];
		String dec_b = (part_b.length > 1) ? part_b[1] : "0";
		// expand decimal part
		int maxLength = Math.max(dec_a.length(), dec_b.length());
		dec_a = addZeros(dec_a, maxLength);
		dec_b = addZeros(dec_b, maxLength);
		// add decimal part
		String dec_c = addStrings(dec_a, dec_b);
		// check carry
		int carry = 0;
		if(dec_c.length() > maxLength) {
			carry = 1;
			dec_c = dec_c.substring(1);
		}
		// add integer part
		String int_c = addStrings(int_a, int_b);
		// add 1 if decimal addition has carry
		if(carry == 1) {
			int_c = addStrings(int_c, "1");
		}
		// combine integer and decimal parts together and return
		return int_c + "." + dec_c;
	}
	public static String addZeros(String str, int length) {
		// add "0" to fit the length
		while(str.length() < length) {
			str += "0";
		}
		return str;
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
}
