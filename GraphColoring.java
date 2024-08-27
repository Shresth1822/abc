import java.util.*;

public class GraphColoring {
    private int V; // Number of vertices
    int[][] graph; // Adjacency matrix representation of the graph

    public GraphColoring(int vertices) {
        this.V = vertices;
        graph = new int[V][V];
    }

    // Check if it's safe to color the vertex with 'c'
    private boolean isSafe(int v, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    // Recursive utility function to solve graph coloring
    private boolean graphColoringUtil(int m, int[] color, int v) {
        if (v == V) {
            return true; // All vertices are colored
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, color, c)) {
                color[v] = c; // Assign color 'c' to vertex 'v'
                if (graphColoringUtil(m, color, v + 1)) {
                    return true; // If the coloring leads to a solution
                }
                color[v] = 0; // Backtrack
            }
        }
        return false; // No solution found
    }

    // Main function to solve graph coloring problem
    public boolean graphColoring(int m) {
        int[] color = new int[V];
        Arrays.fill(color, 0); // Initialize all vertices as uncolored

        if (!graphColoringUtil(m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        System.out.println("Solution exists with the following coloring:");
        for (int c : color) {
            System.out.print(c + " ");
        }
        return true;
    }

    public static void main(String[] args) {
        GraphColoring g = new GraphColoring(4);
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        g.graph = graph;
        int colors = 3; // Number of colors available
        g.graphColoring(colors);
    }
}
