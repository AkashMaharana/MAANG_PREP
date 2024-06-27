import java.util.*;

public class ShortestPathInaUnDirectedGraphHavingUnitEdgeWeight {
    public static void main(String[] args) {
        int noOfVertex=9;
        int noOfEdges=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int[] result = getShortestPath(edge, noOfVertex, noOfEdges);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] getShortestPath(int[][] edge, int noOfVertex, int noOfEdges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<noOfVertex;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<noOfEdges;i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }
        int[] result = new int[noOfVertex];
        for(int i=0;i<noOfVertex;i++) {
            result[i] = (int)1e9;
        }
        result[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(Integer it : adjList.get(node)) {
                if(result[node] + 1 < result[it]) {
                    result[it] = result[node] + 1;
                    queue.add(it);
                }
            }
        }
        for(int i = 0;i<noOfVertex;i++) {
            if(result[i] == 1e9) {
                result[i] = -1;
            }
        }
        return result;
    }
}
