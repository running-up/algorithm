import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static void main(String args[]) {
    }

    public List<Integer> generate(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    temp.add(1);
                    break;
                }
                int inside = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                temp.add(inside);
            }
            result.add(temp);
        }
        return result.get(rowIndex - 1);
    }
}
