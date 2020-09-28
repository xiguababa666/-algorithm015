import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 * 中序遍历 inorder = [1,9,4,3,15,20,7]
 * 后序遍历 postorder = [1,4,9,15,7,20,3]
 *      3
 *    /   \
 *   9    20
 *  / \   / \
 * 1  4  15 7
 *
 * 2020-09-25
 *
 * @author xyx
 * @date 2020/9/25 09:51
 */
public class LeetCode106 {


    public static void main(String[] args) {
        int[] inorder = new int[]{1,9,4,3,15,20,7};
        int[] postorder = new int[]{1,4,9,15,7,20,3};
        //int[] inorder = new int[]{1,2};
        //int[] postorder = new int[]{1,2};
        TreeNode n = new LeetCode106().buildTree(inorder, postorder);

        System.out.println(n);
    }


    public TreeNode buildTree1(int[] inorder, int[] postorder) {

        if (inorder.length == 0 || postorder.length == 0) return null;
        int rootV = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootV);
        int pos = 0;
        while (inorder[pos++] != rootV);
        pos--;

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, pos);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        root.left = buildTree1(leftInorder, leftPostorder);

        int[] rightInorder = Arrays.copyOfRange(inorder, pos + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, postorder.length - rightInorder.length - 1, postorder.length - 1);
        root.right = buildTree1(rightInorder, rightPostorder);
        return root;

    }




    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int rootV = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootV);
        int pos = 0;
        while (inorder[pos++] != rootV);
        pos--;
        root.left = buildTree(inorder, 0, pos, postorder, 0, pos);
        root.right = buildTree(inorder, pos + 1, inorder.length, postorder, pos, postorder.length - 1);
        return root;
    }
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart == inEnd || postStart == postEnd) return null;
        int rootV = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootV);
        int rootIdx = inStart;
        while (inorder[rootIdx++] != rootV);
        rootIdx--;
        int leftPostEnd = postStart + rootIdx - inStart;
        root.left =  buildTree(inorder, inStart, rootIdx, postorder, postStart, leftPostEnd);
        root.right = buildTree(inorder, rootIdx + 1, inEnd, postorder, leftPostEnd, postStart - inStart + inEnd - 1);
        return root;
    }

}
