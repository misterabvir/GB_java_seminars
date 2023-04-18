/*
 * Задача 2
 * Дана последовательность из N целых чисел. 
 * Верно ли, что последовательность является возрастающей.
 */

package seminar02;

import java.util.Random;

public class task02 {

    public static void main(String[] args) {
        System.out.println("\nthe sequence is increasing: " + checkWether());
    }

    /**
     * creates a sequence and checks if it is increasing
     * 
     * @return the sequence is increasing
     */

    public static String checkWether() {
        int count = generateRandomInt(2, 4);
        int current = -1;
        int previous = generateRandomInt(1, 15);
        System.out.print(previous + " ");
        boolean isIncrease = true;
        while (count > 1) {

            current = generateRandomInt(1, 15);
            if (current < previous && isIncrease) {
                isIncrease = false;
            }
            previous = current;
            System.out.print(previous + " ");
            count--;
        }
        return (isIncrease ? "yes" : "no");
    }

    /**
     * generates random integer in range
     * 
     * @param min - minimum limit range
     * @param max - maximum limit range (not included)
     * @return random integer
     */
    private static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}

/*
 * OUTPUT ===============================
 * 13 15 10
 * whether the sequence is increasing: no
 * OUTPUT ===============================
 * 1 3 8
 * whether the sequence is increasing: yes
 */
