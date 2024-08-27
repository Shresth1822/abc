import java.util.*;

public class TSP{

    public static int tsp(int[][] graph, StringBuilder path) {
        int n = graph.length;
        int[][] memo = new int[n][1 << n];

        // Initialize memoization array with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return tspHelper(0, 1, graph, memo, path);
    }

    private static int tspHelper(int curr, int visited, int[][] graph, int[][] memo, StringBuilder path) {
        int n = graph.length;

        if (visited == (1 << n) - 1) { // All nodes visited
            path.append(curr + 1).append("--->"); // Add starting node to path
            return graph[curr][0]; // Return to starting node
        }

        if (memo[curr][visited] != -1) {
            return memo[curr][visited];
        }

        int minCost = Integer.MAX_VALUE;
        int nextNode = -1;

        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0) { // If i-th node not visited
                int newCost = graph[curr][i] + tspHelper(i, visited | (1 << i), graph, memo, path);
                if (newCost < minCost) {
                    minCost = newCost;
                    nextNode = i;
                }
            }
        }

        path.append(curr + 1).append("--->"); // Add current node to path
        memo[curr][visited] = minCost;
        return minCost;
    }

    public static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        System.out.println("Graph:");
        printGraph(graph);
        
        StringBuilder path = new StringBuilder();
        int minCost = tsp(graph, path);
        path.append("1"); // Adding starting node to the end of the path to complete the loop
        
        System.out.println("Minimum cost: " + minCost);
        System.out.println("Path: " + path);
    }
}
