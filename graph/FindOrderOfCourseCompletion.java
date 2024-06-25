import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrderOfCourseCompletion {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0},
                {0,1}
        };

        /*int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};*/

        int[] order = canFinish(numCourses, prerequisites);
        for(int i=0;i<order.length;i++) {
            System.out.print(order[i] + " ");
        }
    }

    private static int[] canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] inDegreeArray = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            for(Integer it : adjList.get(i)) {
                inDegreeArray[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(inDegreeArray[i] == 0) {
                queue.add(i);
            }
        }
        int[] topoSort = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[index++] = node;
            for(Integer it : adjList.get(node)) {
                inDegreeArray[it]--;
                if(inDegreeArray[it] == 0) {
                    queue.add(it);
                }
            }
        }
        if(index == numCourses) {
            return topoSort;
        }
        return new int[]{};
    }
}
