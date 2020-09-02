import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉树中序遍历
 * */
public class BinaryBreeInorderTraversal {




    /**
     * 递归大法
     * */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        traversal(root, l);
        return l;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // 调整list.add(root.val)的位置 对应前中后序遍历
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }




    /**
     * 栈 + 颜色标记
     * */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (n.node == null) continue;
            if (n.color == 1) {
                stack.add(new Node(n.node.right, 1));
                stack.add(new Node(n.node, 0));
                stack.add(new Node(n.node.left, 1));
            } else {
                list.add(n.node.val);
            }
        }
        return list;
    }

    static class Node {
        TreeNode node;
        Integer color;
        Node(TreeNode node, Integer color) {
            this.node = node;
            this.color = color;
        }

        public Integer getColor() {
            return color;
        }

        public TreeNode getNode() {
            return node;
        }
    }


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }



}
