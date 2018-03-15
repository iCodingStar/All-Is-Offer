package cn.codingstar.offer.book.tree;


import cn.codingstar.offer.book.tree.node.TreeNode;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ReconstructBinaryTree.java
 * @time: 18-3-9 下午5:46
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 006 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
 * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReconstructBinaryTree {

    /**
     * 根据前序遍历和中序遍历重建二叉树
     * 用递归的方法解决
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reconstructTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            throw new IllegalArgumentException("Illegal pre sequence and in sequence ...");
        }

        return reconstructTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 通过递归求解答案
     * {1,2,4,7,3,5,6,8}
     * {4,7,2,1,5,3,8,6}
     * 关键是计算根节点左右子树的坐标范围
     *
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reconstructTreeCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 当前序列的根结点
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //获取当前序列的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        // 寻找当前根节点在中序遍历中的位置
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                // i 即为当前中序序列的根节点，左边所有结点都在前序遍历中出现过，右边所有结点在前序遍历中没有出现过
                root.left = reconstructTreeCore(pre, startPre + 1, startPre + (i - startIn), in, startIn, i - 1);
                root.right = reconstructTreeCore(pre, startPre + (i - startIn) + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }

    /**
     * 前序遍历二叉树
     *
     * @param root
     */
    private void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    private void followUpTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        followUpTraversal(root.left);
        followUpTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        ReconstructBinaryTree tree = new ReconstructBinaryTree();
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = tree.reconstructTree(pre, in);
        System.out.print("前序遍历：");
        tree.preOrderTraversal(root);
        System.out.print("中序遍历：");
        tree.inOrderTraversal(root);
        System.out.print("后序遍历：");
        tree.followUpTraversal(root);
    }
}
