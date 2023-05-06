package solution._0430;
public class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        head.prev = null;
        return head;
    }

    private Node dfs(Node head) {
        Node cur = head;
        while (cur != null) {
            head.prev = cur;
            Node next = cur.next;
            if (cur.child != null) {
                Node h = dfs(cur.child);
                cur.child = null;
                Node t = h.prev;
                cur.next = h;
                h.prev = cur;
                t.next = next;
                if (next != null) {
                    next.prev = t;
                }
                head.prev = t;
            }
            cur = next;
        }
        return head;
    }
    private class Node {
        int val;
        private Node prev;
        private Node next;
        private Node child;

        Node(int x) {
            val = x;
            next = null;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

}
