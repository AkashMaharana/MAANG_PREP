import java.util.*;
public class DetectCycleInUndirectedGraphBFS {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean isCycle(int noOfNodes, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[noOfNodes];
        for(int i=0;i<noOfNodes;i++) {
            if(!visited[i]) {
                if(isCyclicGraph(adjList, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicGraph(List<List<Integer>> adjList, boolean[] visited, int currentNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(currentNode, -1));
        visited[currentNode] = true;
        while(!queue.isEmpty()) {
            int node = queue.peek().current;
            int parent = queue.peek().parent;
            queue.poll();
            for(Integer it : adjList.get(node)) {
                if(!visited[it]) {
                    visited[it] = true;
                    queue.add(new Node(it, node));
                } else if(parent != it) {
                    return true;
                }
            }
        }
        return false;
    }

}

class Node {
    int current;
    int parent;

    public Node(int current, int parent) {
        this.current = current;
        this.parent = parent;
    }
}
