/*
 * Дан массив целых чисел. 
 * Заменить отрицательные элементы на сумму индексов двузначных элементов массива. 
 */

package seminar02;

import java.util.Random;

public class task03 {
    public static void main(String[] args) {
        int[] numbers = getNewRandomArray();
        print("Started :", numbers);
        int sum = getSumTwoDigitsNumbersIndexes(numbers);
        print("Sum of indexes of two digits number:", sum);
        modifyArray(numbers, sum);
        print("Modified: ", numbers);
    }

    /**
     * replaces negative numbers in an array with a modifier
     * 
     * @param numbers  - input array
     * @param modifier - modifier for replace
     */
    private static void modifyArray(int[] numbers, int modifier) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] = modifier;
            }
        }
    }

    /**
     * gets the sum of indices containing a two-digit number (negative and positive)
     * 
     * @param numbers input array
     * @return sum of indices
     */
    private static int getSumTwoDigitsNumbersIndexes(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] >= 10 && numbers[i] < 100) || (numbers[i] <= -10 && numbers[i] > -100)) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * prints message with number after message
     * 
     * @param message input message
     * @param number  input number
     */
    private static void print(String message, int number) {
        System.out.println(message + " " + number);
    }

    /**
     * prints message with array of integers after message
     * 
     * @param message input message
     * @param numbers input array of integers
     */
    private static void print(String message, int[] numbers) {
        System.out.print(message);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
        System.out.println();
    }

    /**
     * gets random array of integers
     * 
     * @return random array
     */
    private static int[] getNewRandomArray() {
        int length = generateRandomInt(5, 20);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomInt(-200, 200);
        }
        return array;
    }

    /**
     * gets random integer in range
     * 
     * @param min minimum limit of the range
     * @param max maximum limit of the range
     * @return random integer
     */
    private static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }
}

/*
 * OUTPUT
 * ========================================================================
 * Started : 148 104 -111 71 -21 -172 -27 199 79 -143 -138 -197 -54 153 -118
 * Sum of indexes of two digits number: 33
 * Modified: 148 104 33 71 33 33 33 199 79 33 33 33 33 153 33
 * OUTPUT
 * ========================================================================
 * Started : 124 -174 55 -49 28 192 -180 -87 -199 -76 41 -21
 * Sum of indexes of two digits number: 46
 * Modified: 124 46 55 46 28 192 46 46 46 46 41 46
 */