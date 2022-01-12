public class RemoveNthNodeFromEndofList {
    public static void main(String []args) {
        
    }


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalCount = 0;
        ListNode temp = head;
        while(true){
            if(temp != null){
                totalCount++;
                temp = temp.next;
            }else{
                break;
            }
        }
        int reverseN = totalCount - n;
        if(reverseN == 0){
            if(totalCount == 1){
                return null;
            }else{
                return    head.next;
            }
        }
            
        temp = head;
        int currentIndex = 1;
        while(true){
            if(currentIndex == reverseN) {
                if(temp.next != null)
                    temp.next = temp.next.next;
                else
                    temp.next = null;
                break;
            }else{
                temp = temp.next;
                currentIndex++;
            }
        }

        return head;
    }

}
