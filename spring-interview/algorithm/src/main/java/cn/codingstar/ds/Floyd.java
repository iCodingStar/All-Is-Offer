package cn.codingstar.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Floyd.java
 * @time: 18-3-27 下午3:16
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://blog.51cto.com/ahalei/1383613
 * @desc: 最短路径算法之弗洛伊德算法
 */
public class Floyd {

    public static final int INF = 9999;

    /**
     * 允许经过前k个顶点两两顶点之间的最短路径
     *
     * @param matrix
     * @param k
     */
    public static void floyd(int[][] matrix, int k) {

        for (int u = 0; u < k; u++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] > matrix[i][u] + matrix[u][j]) {
                        matrix[i][j] = matrix[i][u] + matrix[u][j];
                    }
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
        floyd(matrix, 6);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(vex[i] + " --> " + vex[j] + " = " + matrix[i][j]);
            }
        }
    }
}
