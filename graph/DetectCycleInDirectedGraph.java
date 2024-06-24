import java.util.*;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int vertex = 11;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(3).add(7);
        adjList.get(4).add(5);
        adjList.get(5).add(6);
        adjList.get(7).add(5);
        adjList.get(8).add(9);
        adjList.get(9).add(10);
        adjList.get(10).add(8);
        System.out.println("Cycle exists : " + isCycleExists(vertex, adjList));
    }

    private static boolean isCycleExists(int vertex, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[vertex];
        boolean[] pathVisited = new boolean[vertex];
        for(int i=0;i<vertex;i++) {
            if(!visited[i]) {
                if(dfs(i, adjList, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for(Integer it : adjList.get(node)) {
            if(!visited[it]) {
                if(dfs(it, adjList, visited, pathVisited)) {
                    return true;
                }
            } else if(pathVisited[it]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
