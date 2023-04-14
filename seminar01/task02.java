/*
* Дана последовательность целых чисел, оканчивающаяся нулем. 
* Найти сумму положительных чисел, после которых следует отрицательное число
*/

public class task02 {
 
    public static void main(String[] args) {
        String input1 = "1 2 -4 6 1 -1 9 8 -2 0";
        String input2 = "5 -2 3 4 5 -2 0 7 7 -1"; // i want '0' to make sense
        String input3 = "9 -1 -2 -3 5 -4 7 -2 0";

        System.out.println(String.format("INPUT: -> \"%s\" OUTPUT -> %s", input1, getSumPositiveNumbers(input1)));
        System.out.println(String.format("INPUT: -> \"%s\" OUTPUT -> %s", input2, getSumPositiveNumbers(input2)));
        System.out.println(String.format("INPUT: -> \"%s\" OUTPUT -> %s", input3, getSumPositiveNumbers(input3)));
    }

    /**
     * 
     * @return the sum of positive numbers, if there is a negative next to it
     */
    public static int getSumPositiveNumbers(String inputString){
        String[] arrayStrings = inputString.split(" ");
        int sum = 0;
        for (int i = 0; i < arrayStrings.length - 1; i++) {
            int number = Integer.parseInt(arrayStrings[i]);
            if(number == 0) break;
            int next = Integer.parseInt(arrayStrings[i + 1]);
            if(number > 0 && next < 0) sum += number;
        }                
        return sum;
    }
 }

/*
 * OUTPUT ========================================
 * INPUT: -> "1 2 -4 6 1 -1 9 8 -2 0" OUTPUT -> 11
 * INPUT: -> "5 -2 3 4 5 -2 0 7 7 -1" OUTPUT -> 10
 * INPUT: -> "9 -1 -2 -3 5 -4 7 -2 0" OUTPUT -> 21
 */