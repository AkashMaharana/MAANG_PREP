import java.util.*;

public class TopologicalSortKahnAlgorithm {
    public static void main(String[] args) {
        int noOfVertex = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<noOfVertex;i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(2).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);
        int[] topoSort = topologicalSort(noOfVertex, adjList);
        for(int i=0;i<topoSort.length;i++) {
            System.out.print(topoSort[i] + " ");
        }
    }

    private static int[] topologicalSort(int noOfVertex, List<List<Integer>> adjList) {
        int[] topoSortArray = new int[noOfVertex];
        int[] inDegreeArray = new int[noOfVertex];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<noOfVertex;i++) {
            for(Integer it : adjList.get(i)) {
                inDegreeArray[it]++;
            }
        }
        for(int i=0;i<inDegreeArray.length;i++) {
            if(inDegreeArray[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            int node = queue.peek();
            queue.poll();
            topoSortArray[i++] = node;
            for(Integer it : adjList.get(node)) {
                inDegreeArray[it]--;
                if(inDegreeArray[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return topoSortArray;
    }
}
