import java.util.ArrayList;
import java.util.List;


/**
 * n叉树后续遍历
 * */
public class NAryTreePostorderTraversal {


    /**
     * 递归大法
     * */
    public List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node n : root.children) {
            postorder(n, list);
        }
        list.add(root.val);

    }



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


}

