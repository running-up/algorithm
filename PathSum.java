public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String args[]) {
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        return false;
        return isValid(root, targetSum, 0);
    }

    public boolean isValid(TreeNode node, int targetSum, int currentSum) {
        if(node == null) {
            return false;
        }

        if(node.val + currentSum == targetSum && node.left == null && node.right == null) {
            return true;
        }

        boolean result = isValid(node.left, targetSum, node.val + currentSum);

        if(result) 
            return result;

        result = isValid(node.right, targetSum, node.val + currentSum);

        if(result) 
            return result;

        return false;
    }
}
