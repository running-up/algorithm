import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SquaresofaSortedArray {
    public static void main(String[] args) {
        int test[] = { -4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(test)));
    }

    public static int[] sortedSquares(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int squer = nums[i] * nums[i];
            if (nums[i] > 0) {
                que.add(squer);
            } else {
                stk.add(squer);
            }
        }

        int queNum = -1;
        int stkNum = -1;
        while (stk.isEmpty() == false || que.isEmpty() == false) {
            if (stk.isEmpty() == false && stkNum == -1) {
                stkNum = stk.pop();
            }
            if (que.isEmpty() == false && queNum == -1) {
                queNum = que.poll();
            }
            if (stkNum == -1) {
                result.add(queNum);
                queNum = -1;
            } else if (queNum == -1) {
                result.add(stkNum);
                stkNum = -1;
            } else {
                if (stkNum < queNum) {
                    result.add(stkNum);
                    stkNum = -1;
                } else {
                    result.add(queNum);
                    queNum = -1;
                }
            }
        }
        if (stkNum != -1 && queNum == -1) {
            result.add(stkNum);
        } else if (stkNum == -1 && queNum != -1) {
            result.add(queNum);
        } else if (stkNum != -1 && queNum != -1) {
            if (stkNum < queNum) {
                result.add(stkNum);
                result.add(queNum);
            } else {
                result.add(queNum);
                result.add(stkNum);
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            array[i] = result.get(i);
        return array;
    }
}
