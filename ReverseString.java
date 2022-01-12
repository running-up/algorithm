public class ReverseString {
    public static void main(String[] args) {

    }

    public static void reverseString(char[] s) {
        int lowIndex = 0;
        int highIndex = s.length - 1;

        while (lowIndex < highIndex) {
            swapString(s, lowIndex, highIndex);
            lowIndex++;
            highIndex--;
        }
    }

    public static void swapString(char[] s, int lowIndex, int highIndex) {
        char temp = s[lowIndex];
        s[lowIndex] = s[highIndex];
        s[highIndex] = temp;
    }
}
