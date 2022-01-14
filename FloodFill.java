import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = { { 0, 0, 0 }, { 0, 1, 1 } };
        floodFill(image, 1, 1, 1);
    }

    static class InnerPoint {
        public int x;
        public int y;

        public InnerPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<InnerPoint> queue = new LinkedList<>();
        int initialColor = image[sr][sc];
        boolean[][] checked = new boolean[image.length][image[0].length];
        queue.add(new InnerPoint(sr, sc));

        while (queue.peek() != null) {
            InnerPoint innerPoint = queue.poll();

            if (innerPoint.y - 1 >= 0 && image[innerPoint.x][innerPoint.y - 1] == initialColor
                    && !checked[innerPoint.x][innerPoint.y - 1]) {
                checked[innerPoint.x][innerPoint.y - 1] = true;
                queue.add(new InnerPoint(innerPoint.x, innerPoint.y - 1));
            }
            if (innerPoint.x + 1 < image.length && image[innerPoint.x + 1][innerPoint.y] == initialColor
                    && !checked[innerPoint.x + 1][innerPoint.y]) {
                checked[innerPoint.x + 1][innerPoint.y] = true;
                queue.add(new InnerPoint(innerPoint.x + 1, innerPoint.y));
            }
            if (innerPoint.x - 1 >= 0 && image[innerPoint.x - 1][innerPoint.y] == initialColor
                    && !checked[innerPoint.x - 1][innerPoint.y]) {
                checked[innerPoint.x - 1][innerPoint.y] = true;
                queue.add(new InnerPoint(innerPoint.x - 1, innerPoint.y));
            }
            if (innerPoint.y + 1 < image[0].length && image[innerPoint.x][innerPoint.y + 1] == initialColor
                    && !checked[innerPoint.x][innerPoint.y + 1]) {
                checked[innerPoint.x][innerPoint.y + 1] = true;
                queue.add(new InnerPoint(innerPoint.x, innerPoint.y + 1));
            }

            image[innerPoint.x][innerPoint.y] = newColor;

        }
        return image;
    }
}