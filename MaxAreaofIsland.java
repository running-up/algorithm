import java.util.HashSet;
import java.util.Set;

public class MaxAreaofIsland {
    public static void main(String[] args) {
        // int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
        //         { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
        //         { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
        //         { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        int[][] grid = { { 0, 1}, {1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    static class InnerPoint {
        public int x;
        public int y;

        public InnerPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this.x == ((InnerPoint) o).x && this.y == ((InnerPoint) o).y) {
                return true;
            }
            return false;
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        Set<InnerPoint> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (set.contains(new InnerPoint(i, j)) == false) {
                    int size = dfs(grid, i, j, set);
                    if (size > result) {
                        result = size;
                    }
                }
            }
        }

        return result;
    }

    public static int dfs(int[][] grid, int x, int y, Set<InnerPoint> set) {
        int result = 0;
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return result;
        }

        set.add(new InnerPoint(x, y));
        if (grid[x][y] == 0) {
            return result;
        }
        result++;

        if (set.contains(new InnerPoint(x - 1, y)) == false) {
            result += dfs(grid, x - 1, y, set);
        }
        if (set.contains(new InnerPoint(x, y + 1)) == false) {
            result += dfs(grid, x, y + 1, set);
        }
        if (set.contains(new InnerPoint(x + 1, y)) == false) {
            result += dfs(grid, x + 1, y, set);
        }
        if (set.contains(new InnerPoint(x, y - 1)) == false) {
            result += dfs(grid, x, y - 1, set);
        }

        return result;
    }

}
