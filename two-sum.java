import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String args[]) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] +" " + result[1]);
    }
    //https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++) {
            int gap = target + ( nums[i] * -1 );
            Integer index = map1.get(nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                break;
            } else {
                map1.put(gap, i);
            }
        }
        
        return result;
    }
}