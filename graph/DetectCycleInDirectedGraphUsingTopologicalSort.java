import java.util.*;

public class DetectCycleInDirectedGraphUsingTopologicalSort {
    public static void main(String[] args) {
        int noOfVertex = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < noOfVertex; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(3).add(5);
        adjList.get(4).add(2);
        System.out.println("Graph is cyclic : " + isCyclic(noOfVertex, adjList));
    }

    private static boolean isCyclic(int noOfVertex, List<List<Integer>> adjList) {
        int[] inDegreeArray = new int[noOfVertex];
        for(int i=0;i<noOfVertex;i++) {
            for(Integer it : adjList.get(i)) {
                inDegreeArray[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegreeArray.length;i++) {
            if(inDegreeArray[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for(Integer it : adjList.get(node)) {
                inDegreeArray[it]--;
                if(inDegreeArray[it] == 0) {
                    queue.add(it);
                }
            }
        }
        if(count == noOfVertex) {
            return false;
        }
        return true;
    }
}
