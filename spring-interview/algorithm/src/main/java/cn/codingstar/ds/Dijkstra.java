package cn.codingstar.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Dijkstra.java
 * @time: 18-3-27 上午11:06
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://blog.51cto.com/ahalei/1387799
 * @desc: 地杰斯特拉算法实现
 */
public class Dijkstra {


    private static final int INF = Integer.MAX_VALUE;

    /**
     * @param vs
     * @param vex
     * @param matrix
     * @param dist
     */
    public static void dijkstra(int vs, char[] vex, int[][] matrix, int[] dist) {
        // known代表"顶点vs"到顶点i的最短路径是否已知
        boolean[] known = new boolean[vex.length];
        // 初始化
        for (int i = 0; i < vex.length; i++) {
            known[i] = false;//顶点i的最短路径没有获取到
            dist[i] = matrix[vs][i];//顶点i的最短路径为"顶点vs"到"顶点i"的权
        }
        // 遍历次数为顶点数，每次找出一个顶点的最短路径
        int k = 0;
        // 起始结点到自己的最短路径已知
        known[vs] = true;

        for (int i = 1; i < vex.length; i++) {
            // 即在未获取最短路径的顶点中，找到vs的最近的顶点k
            int min = INF;
            for (int j = 1; j < vex.length; j++) {
                if (known[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记顶点k是获取到的最短路径
            known[k] = true;// 说明 s 到 k的距离最短
            // 修正当前最短路径的前驱顶点
            // 即，当已经得到"顶点k"的最短路径后，更新"未获取最短路径的顶点的最短路径和前驱结点"
            // 以 k 为新的起点，更新相关信息
            for (int j = 1; j < vex.length; j++) {
                // 以k为新的顶点更新dist
                int temp = matrix[k][j] == INF ? INF : (min + matrix[k][j]);
                // 更新以k为起始点的dist
                if (temp < dist[j]) {
                    dist[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 12, INF, INF, INF},
                {INF, 0, 9, 3, INF, INF},
                {INF, INF, 0, INF, 5, INF},
                {INF, INF, 4, 0, 13, 15},
                {INF, INF, INF, INF, 0, 4},
                {INF, INF, INF, INF, INF, 0}
        };

        char[] vex = {'A', 'B', 'C', 'D', 'E', 'F'};

        int[] dist = new int[vex.length];

        int vs = 0;

        dijkstra(vs, vex, matrix, dist);

        for (int i = 0; i < dist.length; i++) {
            System.out.println(vex[vs] + " -- > " + vex[i] + " : " + dist[i]);
        }
    }

}