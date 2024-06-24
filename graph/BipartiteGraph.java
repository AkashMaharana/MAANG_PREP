import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        System.out.println("Bipratite Graph : " + isBipartite(graph));
    }

    private static boolean isBipartite(int[][] graph) {
        int[] colorArray = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            colorArray[i] = -1;
        }
        List<List<Integer>> adjList = getAdjList(graph);
        for(int i=0;i<graph.length;i++) {
            if(colorArray[i] == -1) {
                if(!checkBiPartite(i, colorArray, adjList)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkBiPartite(int source, int[] colorArray, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        colorArray[source] = 0;
        while(!queue.isEmpty()) {
            int node = queue.peek();
            queue.poll();
            for(Integer it : adjList.get(node)) {
                if(colorArray[it] == -1) {
                    colorArray[it] = 1 - colorArray[node];
                    queue.add(it);
                } else if(colorArray[it] == colorArray[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<List<Integer>> getAdjList(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i< graph.length;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph[0].length;j++) {
                if(graph[i][j] == 1 && i!=j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        return adjList;
    }
}
