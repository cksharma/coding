package com.geeks.graph;

/**
 * Created by cksharma on 12/12/15.
 */
public class FloydWarshall {
    private final int INF = (int) 1e6;
    int[][] graph = new int[][]{
            {0, 2, INF, INF, INF, INF},
            {2, 2, 6, 3, 4, INF},
            {INF, 6, 0, INF, INF, 4},
            {INF, 3, INF, 0, INF, 9},
            {INF, 4, INF, INF, 0, INF},
            {INF, INF, 4, 9, INF, 0}
    };

    private void runFloydWarshall() {
        int n = graph.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    private void printFloydWarshall() {
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("Source node: " + i + "  dest: " + j + "  cost: " + graph[i][j]);
                System.out.print(graph[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.runFloydWarshall();
        floydWarshall.printFloydWarshall();
    }
}
