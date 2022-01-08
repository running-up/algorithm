public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("."));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isSmallChar(s.charAt(i))) {
                sBuilder.append(s.charAt(i));                
            }
        }

        s = sBuilder.toString();

        if (s.length() == 0) {
            return true;
        }

        int start = 0;
        int last = s.length() - 1;

        while (true) {
            if (s.charAt(start) != s.charAt(last)) {
                return false;
            }
            start++;
            last--;
            if (start > last)
                break;
        }
        return true;
    }

    public static boolean isSmallChar(char a) {
        if ((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9')) {
            return true;
        }
        return false;
    }
}
