import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author xyx
 * @date 2020/9/28 12:08
 */
public class LeetCode117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    /**
     * BFS  >.<
     * */
    public Node connect1(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int lvSize = queue.size();
            for (int i = 0; i < lvSize; i++) {
                Node n = queue.poll();
                if (i < lvSize - 1) n.next = queue.peek();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
        }
        return root;
    }


    public Node connect(Node root) {
        if (root == null) return null;




        return root;
    }











}
