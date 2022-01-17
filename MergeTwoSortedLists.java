public class MergeTwoSortedLists {
    public static void main(String[] args) {
        //[1,2,4]
        //[1,3,4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode result = mergeTwoLists(list1, list2);
        System.out.println("a");
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = null;
        ListNode result = null;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    if (root == null) {
                        root = new ListNode(list1.val);  
                        result = root;
                    } else {
                        result.next = new ListNode(list1.val);           
                        result = result.next;             
                    }
                    list1 = list1.next;
                } else {
                    if (result == null) {
                        root = new ListNode(list2.val); 
                        result = root;
                    } else {
                        result.next = new ListNode(list2.val);  
                        result = result.next;  
                    }
                    list2 = list2.next;
                }
            } else if (list1 != null && list2 == null) {
                if (result == null) {
                    root = new ListNode(list1.val);  
                    result = root;
                } else {
                    result.next = new ListNode(list1.val);  
                    result = result.next;
                }
            } else if (list1 == null && list2 != null) {
                if (result == null) {
                    root = new ListNode(list2.val);  
                    result = root;
                } else {
                    result.next = new ListNode(list2.val);  
                    result = result.next;  
                }
            }
        }
        return root;
    }
}
