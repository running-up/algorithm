import java.util.LinkedList;
import java.util.Queue;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode root = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = root;
            root = temp;
            head = head.next;
        }
        return root;
    }
}
