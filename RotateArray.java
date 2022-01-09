import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String []args) {
        int []nums = {1, 2};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        if(nums.length < k) {
            k = k - (k / nums.length) * nums.length;
        }

        for(int i = nums.length - k ; i < nums.length ; i++) {
            result.add(nums[i]);
        }

        for(int i = 0 ; i < nums.length - k; i++) {
            result.add(nums[i]);
        }
        for (int i = 0; i < result.size(); i++)
            nums[i] = result.get(i);
    }
}
