import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] input = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(getNumberOfProvinces(input));
    }

    private static int getNumberOfProvinces(int[][] isConnected) {
        int noOfNodes = isConnected[0].length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<noOfNodes;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++) {
            for (int j=0;j<isConnected[0].length;j++) {
                if(isConnected[i][j]==1 && i!=j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[noOfNodes];
        int count = 0;
        for(int i=0;i<noOfNodes;i++) {
            if(visited[i] == false) {
                dfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for(Integer it : adjList.get(node)) {
            if(visited[it] == false) {
                dfs(it, adjList, visited);
            }
        }
    }
}
