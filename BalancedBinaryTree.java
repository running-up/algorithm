
public class BalancedBinaryTree {

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

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == -1 || rightHeight == -1){
            return false;
        }

        if(leftHeight > rightHeight +1 || rightHeight > leftHeight +1){
            return false;
        }

        return true;
    }

    public static int getHeight(TreeNode root){
        int height = 1;
        if(root == null ){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight > rightHeight +1 || rightHeight > leftHeight +1){
            return -1;
        }

        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }

        if(leftHeight > rightHeight){
            height += leftHeight;
        }else{
            height += rightHeight;
        }
        
        return height;
    }
}
