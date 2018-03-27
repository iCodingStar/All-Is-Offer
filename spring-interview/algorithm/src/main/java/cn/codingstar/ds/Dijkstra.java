package cn.codingstar.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Dijkstra.java
 * @time: 18-3-27 上午11:06
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 地杰斯特拉算法实现
 */
public class Dijkstra {


    private int edgeNum;//边的数量
    private char[] vex;//顶点集合
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    /**
     * @param vs   起始顶点
     * @param prev 前驱顶点数组，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于的"顶点i"之前的那个顶点
     * @param dist 长度数组，即,dist[i]是"顶点vs"到"顶点i"的最短路径长度
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        // known代表"顶点vs"到顶点i的最短路径是否已知
        boolean[] known = new boolean[vex.length];
        // 初始化
        for (int i = 0; i < vex.length; i++) {
            known[i] = false;//顶点i的最短路径没有获取到
            prev[i] = 0;//顶点i的前驱结点为0
            dist[i] = matrix[vs][i];//顶点i的最短路径为"顶点vs"到"顶点i"的权
        }
        // 遍历次数为顶点数，每次找出一个顶点的最短路径
        int k = 0;
        for (int i = 1; i < vex.length; i++) {
            // 寻找当前的最小路径
            // 即在未获取最短路径的顶点中，找到vs的最近的顶点k
            int min = INF;
            for (int j = 0; j < vex.length; j++) {
                if (known[j] == false) {

                }
            }
        }
    }

}
