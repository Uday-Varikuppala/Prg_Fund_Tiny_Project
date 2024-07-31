import java.util.Scanner;

public class Project2 {
	
//	1.digit sum
//	2.digit count
//	3.digit table
//	4.reverse
//	5.amstrong
//	6.polyndrom
//	7.digit number
//	8.digit even/odd
//	9.digit prime no.
//	10.digit factorial
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num  = sc.nextInt();
		char repeat;
		
		do {
			System.out.println("1. Sum of numbers");
			System.out.println("2. Count numbers");
			System.out.println("3. Reverse Number");
			System.out.println("4. Numbers Table");
			System.out.println("5. Check Amstrong Number");
			System.out.println("6. Check Palindrome Number");
			System.out.println("7. Number in words");
			System.out.println("8. Check number even or odd");
			System.out.println("9. Check Prime Number");
			System.out.println("10. Get Factorial of Number");
			
			System.out.print("Enter Your choice[1-10]: ");
			int choice = sc.nextInt();
			System.out.println("-------------OUTPUT-----------------");
			
			switch (choice) {
			case 1:
				sum(num);
				break;
			case 2:
				count(num);
				break;
			case 3:
				System.out.println("Reverse of the number: " + reverse(num));
				break;
			case 4:
				table(num);
				break;
			case 5:
				amstrong(num);
				break;
			case 6:
				palindrome(num);
				break;
			case 7:
				digitnumber(num);
			case 8:
				evenodd(num);
				break;
			case 9:
				prime(num);
				break;
			case 10:
				int[] digits = getDigits(num);
				for (int digit : digits) {
                System.out.println("Factorial of " + digit + " is " + factorial(digit));
				}
				break;
				
			default:
				System.err.println("Invalid Choice!");
			
			}
			System.out.println("------------------------------------");
			System.out.println("");

			System.out.println("Do you want to continue(y/n): ");
			repeat = sc.next().charAt(0);
			
		}while (repeat == 'y' || repeat == 'Y');
		System.out.println(">>>>>>>>>>>> THANK YOU <<<<<<<<<<<<<");
	}
	
	public static void sum(int num) {						//1.SUM
		int sum = 0;
		while (num != 0) {
			int digit = num % 10;
			num = num /10;
			sum += digit;
		}
		System.out.println("sum: " + sum);
	}
	
	public static void count(int num) {						//2.COUNT
		int count = 0;
		while (num != 0) {
			num = num /10;
			count++;
		}
	System.out.println("Entered number has " + count + " digits");
	}

    public static int reverse(int num) {					//3.REVERSE
		int reverseNumber = 0;
		while(num!=0) {
			int digit = num %10;
			reverseNumber = reverseNumber*10 + digit;
			num = num /10;
		}
		return reverseNumber;
	}

    public static int[] getDigits(int num) {				// getDigits
        int numberOfDigits = Integer.toString(num).length();
        int[] digits = new int[numberOfDigits];
        int index = numberOfDigits -1;

        while (num != 0) {
            int digit = num % 10;
            digits[index] = digit;
            num = num / 10;
            index--;
        }
        return digits;
    }

    public static void table(int num) {						//4.TABLE
        int[] digits = getDigits(num);
        for (int digit : digits) {
            if (digit == 0) {
                continue; // to Skip zero digits
            }
            System.out.println("Table for digit: " + digit);
            for (int i = 1; i <= 10; i++) {
                int table = digit * i;
                System.out.println(digit + " * " + i + " = " + table);
            }
            System.out.println(); 
        }
    }
	
	public static void amstrong(int num) {					//5.AMSTRONG
		int originalNumber = num;
		int sum = 0;
		while(num!=0) {
			int digit = num %10;
			sum = sum + (digit*digit*digit) ;
         	num = num /10;	
		}
		System.out.println("Sum: " + sum);
		if (originalNumber == sum) {
			System.out.println("It is an Armstrong Number");
		}else {
			System.out.println("It is not an Armstrong Number");			
		}
	}
	
	public static void palindrome(int num) {				//6.PALINDROME
		int reverseNumber = reverse(num);
		if (num == reverseNumber) {
			System.out.println(num + " is a Palindrome");
		}else {
			System.out.println(num + " is not a Palindrome");
		}
	}
	
	public static void digitnumber(int num) {				//7.NUM IN WORDS
		int[] digits = getDigits(num);
		for (int digit: digits) {
		   switch (digit) {
		   		case 1: System.out.println("One"); break;
				case 2: System.out.println("Two"); break;
				case 3: System.out.println("Three"); break;
				case 4: System.out.println("Four"); break;
				case 5: System.out.println("Five"); break;
				case 6: System.out.println("Six"); break;
				case 7: System.out.println("Seven"); break;
				case 8: System.out.println("Eight"); break;
				case 9: System.out.println("Nine"); break;
				case 0: System.out.println("Zero"); break;
				default : System.err.println("Invalid number");
			}
		}
	   System.out.println();
	}
	
	public static void evenodd(int num) {				//8.EVENODD
		int[] digits = getDigits(num);
		for (int digit: digits) {
			if(isNumEvenOrOdd(digit)){
				System.out.println(digit + " is even");
			}else {
				System.out.println(digit + " is odd");
			}
		}
	}
	
	public static boolean isNumEvenOrOdd(int digit) {		//odd or even
		if(digit % 2 ==0){
			return true;
		}else {
			return false;
		}
	}
	

	public static void prime(int num) {					//9.PRIME
        int[] digits = getDigits(num);
        for (int digit : digits) {
            if (digit <= 1) {
                System.out.println(digit + " is Not a prime number");
                continue;
            }
            boolean isPrime = true;
            for (int i = 2; i <= digit / 2; i++) {
                if (digit % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(digit + " is a Prime number");
            } else {
                System.out.println(digit + " is Not a Prime number");
            }
        }
    }
	
	public static int factorial(int digit) {				//10.FACTORIAL
		if (digit <= 1) {
			return 1;
		}
		int fact = 1;
		for (int i =1; i <=digit; i++) {
			fact*=i;
		}
		return fact;
	}
	
	
//END
}

