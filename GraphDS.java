import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int vertex1, int vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex1).remove(Integer.valueOf(vertex2));
            adjacencyList.get(vertex2).remove(Integer.valueOf(vertex1));
        }
    }

    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return;
        }

        for (int adjacentVertex : adjacencyList.get(vertex)) {
            adjacencyList.get(adjacentVertex).remove(Integer.valueOf(vertex));
        }
        adjacencyList.remove(vertex);
    }

    public boolean hasPath(int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(vertex1, vertex2, visited);
    }

    private boolean hasPathDFS(int start, int end, Set<Integer> visited) {
        if (start == end) {
            return true;
        }

        visited.add(start);

        for (int neighbor : adjacencyList.get(start)) {
            if (!visited.contains(neighbor)) {
                if (hasPathDFS(neighbor, end, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class GraphDS {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        System.out.println("Has path between 0 and 3: " + graph.hasPath(0, 3)); // true
        System.out.println("Has path between 2 and 3: " + graph.hasPath(2, 3)); // false

        graph.removeEdge(1, 3);
        System.out.println("Has path between 0 and 3 after removing edge: " + graph.hasPath(0, 3)); // false

        graph.removeVertex(0);
        System.out.println("Has path between 1 and 2 after removing vertex 0: " + graph.hasPath(1, 2)); // false
    }
}
