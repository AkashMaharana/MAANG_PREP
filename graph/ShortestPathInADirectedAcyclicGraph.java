import java.util.*;

public class ShortestPathInADirectedAcyclicGraph {
    public static void main(String[] args) {
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int noOfVertices = 6;
        int noOfEdges = 7;
        int[] result = getShortestPath(edge, noOfVertices, noOfEdges);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] getShortestPath(int[][] edge, int noOfVertices, int noOfEdges) {
        List<List<Pair_2>> adjList = new ArrayList<>();
        for(int i=0;i<noOfVertices;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<noOfEdges;i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            int weight = edge[i][2];
            adjList.get(u).add(new Pair_2(v, weight));
        }
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<noOfVertices;i++) {
            if(!visited[i]) {
                topoSort(i, adjList, visited, stack);
            }
        }
        int[] result = new int[noOfVertices];
        for(int i=0;i<noOfVertices;i++) {
            result[i] = (int)1e9;
        }
        result[0] = 0;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(Pair_2 it : adjList.get(node)) {
                int v = it.node;
                int weight = it.weight;
                if(result[node] + weight < result[v]) {
                    result[v] = result[node] + weight;
                }
            }
        }
        for (int i = 0; i < noOfVertices; i++) {
            if (result[i] == 1e9) {
                result[i] = -1;
            }
        }
        return result;
    }

    private static void topoSort(int node, List<List<Pair_2>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for(Pair_2 it : adjList.get(node)) {
            if(!visited[it.node]) {
                topoSort(it.node, adjList, visited, stack);
            }
        }
        stack.push(node);
    }
}

class Pair_2 {
    int node;
    int weight;

    public Pair_2(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
