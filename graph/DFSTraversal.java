import java.util.*;

public class DFSTraversal {

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int noOfNodes = 5;
        for(int i=0;i<noOfNodes;i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);
        List<Integer> list = dfs(noOfNodes, adjList);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static List<Integer> dfs(int noOfNodes, List<List<Integer>> adjList) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[noOfNodes];
        dfs(0, result, visited, adjList);
        return result;
    }

    private static void dfs(int node, List<Integer> result, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        result.add(node);
        for(Integer it : adjList.get(node)) {
            if(visited[it] == false) {
                dfs(it, result, visited, adjList);
            }
        }
    }
}
