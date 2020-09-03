import java.util.*;

/**
 * 429. N叉树的层序遍历
 *
 * 类似广度优先遍历
 *
 * @author xyx
 * @date 2020/9/2 18:14
 */
public class NAryTreeLevelOrderTraversal {


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }



    /**
     * 递归
     *
     * */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null)
            levelOrder1(root, list, 0);
        return list;
    }

    private void levelOrder1(Node node, List<List<Integer>> list, int level) {
        if (list.size() <= level) list.add(new LinkedList<>());
        list.get(level).add(node.val);
        if (node.children == null) return;
        for (Node n : node.children) {
            if (n != null) levelOrder1(n, list, level + 1);
        }

    }







    /**
     * 非递归
     * */
    public List<List<Integer>> levelOrder2(Node root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<QNode> queue = new LinkedList<>();
        queue.add(new QNode(root, 0));

        while (!queue.isEmpty()) {
            QNode qn = queue.poll();
            if (qn.n == null) continue;

            if (list.size() <= qn.lv) list.add(new LinkedList<>());
            list.get(qn.lv).add(qn.n.val);

            if (qn.n.children == null) continue;

            for (Node n : qn.n.children) {
                queue.add(new QNode(n, qn.lv + 1));
            }
        }
        return list;
    }

    static class QNode {
        Node n;
        int lv;
        QNode(Node n, int lv) {
            this.n = n;
            this.lv = lv;
        }
    }



}
