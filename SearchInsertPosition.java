public class SearchInsertPosition {
    public static void main(String []args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public static int binarySearch(int[] nums, int startIndex, int endIndex, int tartget) {
        if(startIndex > endIndex){
            return endIndex;
        }
        int centerIndex = startIndex + ( endIndex - startIndex ) / 2;
        if(nums[centerIndex] == tartget) {
            return centerIndex;
        }

        if (centerIndex == startIndex || centerIndex == endIndex) {
            if(tartget <= nums[centerIndex])
                return centerIndex; 
            else
                return centerIndex + 1;
        }

        if(nums[centerIndex] < tartget) {
            return binarySearch(nums, centerIndex, endIndex, tartget);
        }else{
            return binarySearch(nums, startIndex, centerIndex, tartget);
        }
    }
    
}
