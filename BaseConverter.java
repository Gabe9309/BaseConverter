import java.util.Scanner;

public class BaseConverter {
	private static final char ZERO_ASCII_VALUE = 48;
	private static Scanner keyboard = new Scanner(System.in);
	private static int number;
	
	public static void main(String[] args) {
		
		int currentBase;
		
		System.out.println("Enter the starting base");
		currentBase = keyboard.nextInt();
		keyboard.nextLine();
		switch(currentBase) {
		case 2:
			handleBase2();
			break;
		case 16:
			handleBase16();
			break;
		case 10:
			handleBase10();
			break;
		default:
			System.out.println("Wrong entry!!");
			return;
		}

	}
	public static StringBuffer convertBase10To16(int number) {
		StringBuffer strBuffer = new StringBuffer();
		int result = 0;
		int reminder = 0;
		
		result = number / 16;
		reminder = number % 16;
		strBuffer.append(determineBase10ToBase16Char(reminder));
		
		while(result != 0) {
			
			reminder = result % 16;
			result = result / 16;
			strBuffer.append(determineBase10ToBase16Char(reminder));
			
		}
		
		strBuffer = strBuffer.reverse();
		
		return strBuffer;
	}
	
	public static StringBuffer convertBase10To2(int number) {
		StringBuffer strBuffer = new StringBuffer();
		int result = 0;
		int reminder = 0;
		
		result = number / 2;
		reminder = number % 2;
		strBuffer.append(reminder);
		
		while(result != 0) {
			
			reminder = result % 2;
			result = result / 2;
			strBuffer.append(reminder);
			
		}
		
		strBuffer = strBuffer.reverse();
		
		return strBuffer;
		
	}// end convertBase10to2
	
	public static int convertBase2To10(String entry) {
		StringBuffer strBuffer = new StringBuffer(entry);
		strBuffer = strBuffer.reverse();
		int length = strBuffer.length();
		int number = 0;
		int currentNumber = 0;
		
		for(int i  = length - 1; i >= 0; i--) {
			currentNumber = strBuffer.charAt(i) - ZERO_ASCII_VALUE;
			number = number + ((int) (currentNumber * Math.pow(2, i)));
		}
		
		return number;
	}// end convertBase2To10
	
	public static int convertBase16To10(String entry) {
		StringBuffer strBuffer = new StringBuffer(entry);
		strBuffer = strBuffer.reverse();
		int length = strBuffer.length();
		int number = 0;
		int currentNumber = 0;
		
		for(int i  = length - 1; i >= 0; i--) {
			currentNumber = determineBase16CharToBase10(strBuffer.charAt(i));
			number = number + ((int) (currentNumber * Math.pow(16, i)));
		}
		
		return number;
	} //end convertBase16To10
	
	public static char determineBase10ToBase16Char(int number) {
		switch(number) {
		case 10:
			return 'A';
		case 11:
			return 'B';
		case 12:
			return 'C';
		case 13:
			return 'D';
		case 14:
			return 'E';
		case 15:
			return 'F';
			
		default:
			return (char)(ZERO_ASCII_VALUE + (char)number);
		}
	}
	
	public static int determineBase16CharToBase10(char checkChar) {

		switch(checkChar) {
		case 'A':
		case 'a':
			return 10;
		case 'B':
		case 'b':
			return 11;
		case 'C':
		case 'c':
			return 12;
		case 'D':
		case 'd':
			return 13;
		case 'E':
		case 'e':
			return 14;
		case 'F':
		case 'f':
			return 15;
			
		default:
			return  Character.valueOf(checkChar) - ZERO_ASCII_VALUE;
		}
	}
	
	public static void handleBase2() {
		String entry;
		int convertedToBase10 = 0;
		int targetBase = 0;
		
		System.out.println("Enter the number");
		entry = keyboard.nextLine();
		
		convertedToBase10 = convertBase2To10(entry);
		
		System.out.println("Enter the target base");
		targetBase = keyboard.nextInt();
		
		switch(targetBase) {
		case 2:
			System.out.println(entry);
			break;
		case 16:
			System.out.println(convertBase10To16(convertedToBase10));
			break;
		case 10:
			System.out.println(convertedToBase10);
			break;
		default:
			System.out.println("Wrong entry!!");
			return;
		}
		
	}

	public static void handleBase10() {
		int base10 = 0;
		int targetBase = 0;
		
		System.out.println("Enter the number");
		base10 = keyboard.nextInt();
		
		
		System.out.println("Enter the target base");
		targetBase = keyboard.nextInt();
		
		switch(targetBase) {
		case 2:
			System.out.println(convertBase10To2(base10));
			break;
		case 16:
			System.out.println(convertBase10To16(base10));
			break;
		case 10:
			System.out.println(base10);
			break;
		default:
			System.out.println("Wrong entry!!");
			return;
		}
		
	}
	public static void handleBase16() {
		String entry;
		int convertedToBase10 = 0;
		int targetBase = 0;
		
		System.out.println("Enter the number");
		entry = keyboard.nextLine();
		
		convertedToBase10 = convertBase16To10(entry);
		
		System.out.println("Enter the target base");
		targetBase = keyboard.nextInt();
		
		switch(targetBase) {
		case 2:
			System.out.println(convertBase10To2(convertedToBase10));
			break;
		case 16:
			System.out.println(entry);
			break;
		case 10:
			System.out.println(convertedToBase10);
			break;
		default:
			System.out.println("Wrong entry!!");
			return;
		}
		
	}

}
