import java.util.List;

/**
 * description
 *
 * @author xyx
 * @date 2020/9/2 18:14
 */
public class NAryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(Node root) {

        return null;

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
