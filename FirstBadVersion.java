public class FirstBadVersion {
    public static void main(String[] agrs) {
        System.out.println(firstBadVersion(3));
    }

    public static int firstBadVersion(int n) {       
        return search(1, n);
    }

    public static int search(int start, int end) {
        if (end == 1) {
            if (isBadVersion(end))
                return 1;
            else
                return 0;
        } else if (end == 2) {
            if (isBadVersion(1))
                return 1;
            else
                return 2;
        }

        int center = start + (end - start) / 2;

        if ((end - start) / 2 == 0) {
            center += 1;
        }

        if (isBadVersion(center)) {
            if (center == 0) {
                return 0;
            }
            if (isBadVersion(center - 1) == false) {
                return center;
            } else {
                return search(start, center);
            }
        } else {
            return search(center, end);
        }
    }

    public static boolean isBadVersion(int n) {
        int statnd = 3;
        if (n < statnd)
            return false;
        else
            return true;
    }
}
