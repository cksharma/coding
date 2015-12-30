package medium;

import java.util.*;

/**
 * Created by cksharma on 12/29/15.
 */
public class CourseScheduleIITusharWay {
    class Graph {
        int subjectId;
        List<Integer> neighboursList = new LinkedList<>();
    }

    private Graph[] graphs;
    private Set visited;
    private Stack<Integer> stack;

    private boolean dfs(int subjectId) {
        if (visited.contains(subjectId)) return false;
        visited.add(subjectId);
        for (int neighbour : graphs[subjectId].neighboursList) {
            if (visited.contains(neighbour)) continue;
            dfs(neighbour);
        }
        stack.push(subjectId);
        return true;
    }

    private boolean containsCycle() {
        boolean[][] path = new boolean[graphs.length][graphs.length];
        for (int subjectId = 0; subjectId < graphs.length; subjectId++) {
            for (int neighbour : graphs[subjectId].neighboursList) {
                path[subjectId][neighbour] = true;
            }
        }
        for (int k = 0; k < graphs.length; k++) {
            for (int i = 0; i < graphs.length; i++) {
                for (int j = 0; j < graphs.length; j++) {
                    if (path[i][j] == false && path[i][k] && path[k][j]) {
                        path[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                if (i == j) continue;
                if (path[i][j] && path[j][i]) return true;
            }
        }
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.graphs = new Graph[numCourses];
        this.visited = new HashSet<>();
        this.stack = new Stack<>();

        for (int i = 0; i < graphs.length; i++)
            graphs[i] = new Graph();

        for (int[] keyVal : prerequisites) {
            graphs[keyVal[1]].neighboursList.add(keyVal[0]);
        }

        //check for cycle first
        if (containsCycle()) return new int[0];


        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) continue;
            dfs(i);
        }

        int[] arr = new int[stack.size()]; int index = 0;
        while (stack.isEmpty() == false) {
            arr[index++] = stack.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        CourseScheduleIITusharWay schedule = new CourseScheduleIITusharWay();
        System.out.println(Arrays.toString(schedule.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(schedule.findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(schedule.findOrder(3, new int[][]{{0, 2}, {1, 2}, {2, 0}})));

        System.out.println(Arrays.toString(schedule.findOrder(3, new int[][]{{1, 0}, {2, 0}, {0, 2}})));
        System.out.println(Arrays.toString(schedule.findOrder(3, new int[][]{{1, 0}, {2, 1}})));
        System.out.println(Arrays.toString(schedule.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
