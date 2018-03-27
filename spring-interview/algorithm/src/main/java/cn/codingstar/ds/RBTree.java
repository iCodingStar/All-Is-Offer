package cn.codingstar.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: RBTree.java
 * @time: 18-3-27 下午4:17
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://blog.csdn.net/eson_15/article/details/51144079
 * @desc: 红黑树学习
 * 特征：
 * 1. 每个结点不是红色就是黑色的
 * 2. 根结点总是黑色的
 * 3. 如果结点是红色的，则它的子结点一定是黑色的
 * 4. 从根结点到叶结点或空子结点的每条路径，必须包含相同数目的黑色结点
 * 修正：
 * 1. 改变结点颜色
 * 2. 左旋
 * 3. 右旋
 */

public class RBTree<T extends Comparable<T>> {

    private RBNode<T> root; //根结点
    private static final boolean RED = false; // 定义红黑树标志
    private static final boolean BLACK = true;

    class RBNode<T extends Comparable<T>> {
        boolean color;    // 颜色
        T key;            // 关键字
        RBNode<T> left;   // 左子结点
        RBNode<T> right;  // 右子结点
        RBNode<T> parent; // 父结点

        public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
            this.color = color;
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "" + key + (this.color ? "R" : "B");
        }
    }

    /*************对红黑树节点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x) {

    }
}
