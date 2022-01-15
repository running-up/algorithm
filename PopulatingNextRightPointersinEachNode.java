import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        // [1,2,3,4,5,6,7]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Node result = connect(root1);
        System.out.println(result);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        root.next = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        int nextCount = 1;
        Node before = null;
        while (queue.peek() != null) {
            Node temp = queue.poll();
            queue.add(temp.left);
            queue.add(temp.right);

            count++;
            if (count >= nextCount) {
                if (before != null) {
                    before.next = null;
                }

                nextCount = nextCount * 2;
            } else {
                if (before != null) {
                    before.next = temp;
                }
            }
            before = temp;
        }
        return root;
    }
}
