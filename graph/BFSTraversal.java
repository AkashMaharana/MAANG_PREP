import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int noOfNodes = 5;
        for(int i=0;i<noOfNodes;i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(4);
        adjList.get(4).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(1).add(3);
        adjList.get(3).add(1);
        List<Integer> list = bfs(noOfNodes, adjList);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static List<Integer> bfs(int noOfNodes, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[noOfNodes];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            result.add(temp);
            for(Integer it : adjList.get(temp)) {
                if(visited[it] == false) {
                    queue.add(it);
                    visited[it] = true;
                }
            }
        }
        return result;
    }
}
