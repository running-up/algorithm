public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        mergeTrees(null, null);
    }

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

    // [1,3,2,5]
    // [2,1,3,null,4,null,7]

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode result = null;
        if (root1 != null && root2 == null) {
            result = new TreeNode(root1.val);
            result.left = dfs(root1.left, null);
            result.right = dfs(root1.right, null);
        } else if (root1 == null && root2 != null) {
            result = new TreeNode(root2.val);
            result.left = dfs(null, root2.left);
            result.right = dfs(null, root2.right);
        } else if (root1 != null && root2 != null) {
            result = new TreeNode(root1.val + root2.val);
            result.left = dfs(root1.left, root2.left);
            result.right = dfs(root1.right, root2.right);
        }

        return result;
    }

    public static TreeNode dfs(TreeNode root1, TreeNode root2) {
        TreeNode treeNode = null;

        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            treeNode = new TreeNode(root1.val);
            treeNode.left = dfs(root1.left, null);
            treeNode.right = dfs(root1.right, null);
        } else if (root1 == null && root2 != null) {
            treeNode = new TreeNode(root2.val);
            treeNode.left = dfs(null, root2.left);
            treeNode.right = dfs(null, root2.right);
        } else if (root1 != null && root2 != null) {
            treeNode = new TreeNode(root1.val + root2.val);
            treeNode.left = dfs(root1.left, root2.left);
            treeNode.right = dfs(root1.right, root2.right);
        }
        return treeNode;
    }
}
