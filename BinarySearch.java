import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

public class BinarySearch {
    // https://leetcode.com/problems/binary-search/

    public static void main(String[] args) {
        int[] temp = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(temp, 2));
    }

    // -1,0,3,5,9,12
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public static int binarySearch(int[] nums, int startIndex, int endIndex, int tartget) {
        if(startIndex > endIndex){
            return -1;
        }
        int centerIndex = startIndex + ( endIndex - startIndex ) / 2;
        if(nums[centerIndex] == tartget) {
            return centerIndex;
        }

        if (centerIndex == startIndex || centerIndex == endIndex) {
            return -1;
        }

        if(nums[centerIndex] < tartget) {
            return binarySearch(nums, centerIndex, endIndex, tartget);
        }else{
            return binarySearch(nums, startIndex, centerIndex, tartget);
        }
    }
}
