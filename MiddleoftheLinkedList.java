import java.util.LinkedList;
import java.util.Queue;

public class MiddleoftheLinkedList {
    public static void main(String[] args) {

    }

    public class ListNode {
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

    public ListNode middleNode(ListNode head) {
        Queue<ListNode> result = new LinkedList<>();
        int totalCount = 0;
        int currentIndex = 1;
        do {
            result.add(head);
            totalCount++;
            int targetIndex = totalCount / 2 + 1;
            while(currentIndex < targetIndex) {
                result.poll();
                currentIndex++;
            }
            head = head.next;
        }while(head != null);

        return result.poll();
    }
}
