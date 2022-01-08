public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String args[]) {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = constructTree(nums, 0, nums.length-1);
		return head;
	}

	public TreeNode constructTree(int[] nums, int left, int right){
		if(left>right)
			return null;
		int mid = (left + right)/2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = constructTree(nums, left, mid-1);
		head.right = constructTree(nums, mid+1, right);
		return head;
	}
}
