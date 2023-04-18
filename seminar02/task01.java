/*
 * Задача 1
 * Дана последовательность N целых чисел. Найти сумму простых чисел
 */
package seminar02;

import java.util.Scanner;

public class task01 {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("the sum of prime numbers: " + getSum());
        sc.close();
    }

    /**
     * calculates the sum of prime numbers,
     * will be stopped when entering less or equal 1
     * 
     * @return the sum of prime numbers
     */
    public static int getSum() {
        int sum = 0;
        int number = -1;
        while ((number = getNextInput()) > 1) {
            if (isPrime(number)) {
                sum += number;
            }
        }
        return sum;
    }

    /**
     * gets the next entered number
     * 
     * @return the next entered number
     */
    public static int getNextInput() {
        System.out.print("Enter a new number: ");
        return sc.nextInt();
    }

    /**
     * checks if a number is prime
     */
    public static boolean isPrime(int number) {
        for (int divider = 2; divider <= (int) Math.sqrt(number); divider++) {
            if (number % divider == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
 * OUTPUT =====================
 * Enter new number: 2
 * Enter new number: 4
 * Enter new number: 9
 * Enter new number: 7
 * Enter new number: 5
 * Enter new number: 11
 * Enter new number: 6
 * Enter new number: 9
 * Enter new number: 1
 * the sum of prime numbers: 25
 */