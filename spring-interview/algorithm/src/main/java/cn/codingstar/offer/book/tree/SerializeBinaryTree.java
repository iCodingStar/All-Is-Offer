package cn.codingstar.offer.book.tree;

import cn.codingstar.offer.book.tree.node.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SerializeBinaryTree.java
 * @time: 18-3-15 下午8:21
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class SerializeBinaryTree {

    private int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        return sb.toString();
    }

    private void preSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            // 若为空结点，则用"#!"标记分割
            sb.append("#!");
        } else {
            sb.append(root.val + "!"); //在结点值的后面用"!"分隔
            //注意递归边界：如果当前结点不是null则递归左右儿子；如果不判断当前结点是否为空，则在递归到null时出现空指针异常
            preSerialize(root.left, sb);
            preSerialize(root.right, sb);
        }
    }

    /**
     * 反序列化
     *
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        String[] sequence = str.split("!");
        return deSerializedCore(sequence);
    }

    private TreeNode deSerializedCore(String[] sequence) {
        index++;
        if (sequence[index].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(sequence[index]));
        root.left = deSerializedCore(sequence);
        root.right = deSerializedCore(sequence);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBinaryTree tree = new ReconstructBinaryTree();
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = tree.reconstructTree(pre, in);
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        System.out.println(serializeBinaryTree.Serialize(root));
        // 1!2!4!#!7!#!#!#!3!5!#!#!6!8!#!#!#!
        // 1!2!4!#!7!#!#!#!3!5!#!#!6!8!#!#!#!
        TreeNode node = serializeBinaryTree.Deserialize("1!2!4!#!7!#!#!#!3!5!#!#!6!8!#!#!#!");
        System.out.println(node);
    }
}
