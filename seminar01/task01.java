/*  
* Given an input string s, reverse the order of the words.
* A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
* Return a string of the words in reverse order concatenated by a single space.
* Note that s may contain leading or trailing spaces or multiple spaces between two words. 
* The returned string should only have a single space separating the words. Do not include any extra spaces.
*/

public class task01 {

    public static void main(String[] args) {
        System.out.println(reverseWords("I walk through the     valley of the shadow..."));
        System.out.println(reverseWords("          I'm just   a poor  wayfaring    stranger Traveling     through this world of woe   "));
        System.out.println(reverseWords(
            "I know dark clouds will gather round me " +
            "I know my way is rough and steep " +
            "But beauteous field lie just before me " + 
            "Where god's redeemed their vigils keep"));
    }

    /**
     * 
     * @param input -> input string
     * @return -> reversed words in a line
     */
    public static String reverseWords(String input) {
        String[] arrayStrings = input.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = arrayStrings.length - 1; i >= 0; i--) {
            if(!arrayStrings[i].equals(""))
                builder.append(arrayStrings[i].trim() + " ");
        }
        return builder.toString().trim();
    }
}

/* OUTPUT================================
 * shadow... the of valley the through walk I
 * woe of world this through Traveling stranger wayfaring poor a just I'm
 * keep vigils their redeemed god's Where me before just lie field beauteous But steep and rough is way my know I me round gather will clouds dark know I
 */