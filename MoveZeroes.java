import java.util.Arrays;

public class MoveZeroes {
    public static void main(String []args){
        int[] nums = {0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        int zeroIndex = -1;
        while(true){            
            if(zeroIndex == -1){
                if(nums[index] == 0) {
                    zeroIndex = index;
                }
            }else{
                if(nums[index] != 0) {
                    swap(nums, zeroIndex, index);
                    index = zeroIndex;
                    zeroIndex = -1;
                }
            }
            index++;
            if(index >= nums.length){
                break;
            }
        }
    }

    public static void swap(int[] nums, int lowIndex, int highIndex) {
        int temp = nums[lowIndex];
        nums[lowIndex] = nums[highIndex];
        nums[highIndex] = temp;
    }
}
