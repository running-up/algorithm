import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<String, Integer> storeMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String a = s.substring(i, i + 1);
            if (storeMap.get(a) == null) {
                storeMap.put(a, i);       
            } else {
                int temp = storeMap.get(a);
                if (temp!= -1 && max < i - temp) {
                    max = i - temp;
                }
                storeMap.put(a, i);
                for (String k : storeMap.keySet()) {
                    if(storeMap.get(k) != -1 && storeMap.get(k) <= temp) {
                        if (max < i - storeMap.get(k)) {
                            max = i - storeMap.get(k);
                        }
                        storeMap.put(k, -1);
                    }
                }
            }
        }
        for (String a : storeMap.keySet()) {
            int temp = storeMap.get(a);
            if (temp != -1 && max < s.length() - temp) {
                max = s.length() - temp;
            }
        }
        return max;
    }
}
