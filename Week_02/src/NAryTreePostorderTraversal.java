import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * n叉树后续遍历
 * */
public class NAryTreePostorderTraversal {


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
     * 递归大法
     * */
    public List<Integer> postorder1(Node root) {

        List<Integer> list = new ArrayList<>();
        postorder1(root, list);
        return list;
    }

    public void postorder1(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node n : root.children) {
            postorder1(n, list);
        }
        list.add(root.val);

    }




    /**
     * 非递归
     * */
    public List<Integer> postorder2(Node root) {

        List<Integer> list = new LinkedList<>();
        Stack<SNode> stack = new Stack<>();
        stack.push(new SNode(root, 0));

        while (!stack.isEmpty()) {
            SNode sn = stack.pop();
            if (sn.n == null) continue;
            if (sn.color == 0) {
                sn.color = 1;
                stack.push(sn);
                if (sn.n.children == null) continue;
                int len = sn.n.children.size();
                for (int i = len - 1; i >= 0; i--) {
                    stack.push(new SNode(sn.n.children.get(i), 0));
                }
            } else {
                list.add(sn.n.val);
            }
        }
        return list;

    }

    static class SNode {
        Node n;
        int color;
        SNode(Node n, int color) {
            this.n = n;
            this.color = color;
        }
    }


}

