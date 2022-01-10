import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum2InputArrayIsSorted {
    public static void main(String []args){
        int[] numbers = {2,3,4};
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0 ; i < numbers.length ; i++){
            if(hashMap.get(numbers[i]) != null) {
                result.add(hashMap.get(numbers[i]) + 1);
                result.add(i + 1);
            }else{
                hashMap.put(target - numbers[i], i);
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            array[i] = result.get(i);
        return array;
    }
}
