import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BinaryTreeInorderTraversal {
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

    // https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result = traversalEachNode(root, result);
        Collections.reverse(result);
        return result;
    }

    public static List<Integer> traversalEachNode(TreeNode node, List<Integer> result) {
        if (node.right != null) {
            result = traversalEachNode(node.right, result);
        }

        result.add(node.val);

        if (node.left != null) {
            result = traversalEachNode(node.left, result);
        }

        return result;
    }

}
