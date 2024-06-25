import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int noOfVetrex = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < noOfVetrex; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);

        int[] topoSortArray = topologicalSortDFS(noOfVetrex, adjList);
        for(int i=0;i<topoSortArray.length;i++) {
            System.out.print(topoSortArray[i] + " ");
        }
    }

    private static int[] topologicalSortDFS(int noOfVetrex, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[noOfVetrex];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<noOfVetrex;i++) {
            if(!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }
        int[] result = new int[noOfVetrex];
        for(int i=0;i<noOfVetrex;i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for(Integer it : adjList.get(node)) {
            if(!visited[it]) {
                dfs(it, adjList, visited, stack);
            }
        }
        stack.push(node);
    }

}
