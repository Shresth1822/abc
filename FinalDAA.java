import java.util.*;

public class FinalDAA {
    private int V; 
    private int[][] graph; 

    public FinalDAA(int vertices) {
        this.V = vertices;
        graph = new int[V][V];
    }
    private boolean isSafe(int v, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }
    private boolean graphColoringUtil(int m, int[] color, int v) {
        if (v == V) {
            return true; 
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, color, c)) {
                color[v] = c; 
                if (graphColoringUtil(m, color, v + 1)) {
                    return true;
                }
                color[v] = 0; 
            }
        }
        return false; 
    }
    public boolean graphColoring(int m) {
        int[] color = new int[V];
        Arrays.fill(color, 0);

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
        int colors = 3;     
        g.graphColoring(colors);
    }
}
