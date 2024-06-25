import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        List<Integer> list = eventualSafeNodes(graph);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<graph.length;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++) {
            int[] temp = graph[i];
            for(int j=0;j<temp.length;j++) {
                adjList.get(temp[j]).add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegreeArray = new int[graph.length];
        for(int i=0;i<inDegreeArray.length;i++) {
            for(Integer it : adjList.get(i)) {
                inDegreeArray[it]++;
            }
        }
        for(int i=0;i<inDegreeArray.length;i++) {
            if(inDegreeArray[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for(Integer it : adjList.get(node)) {
                inDegreeArray[it]--;
                if(inDegreeArray[it] == 0) {
                    queue.add(it);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
