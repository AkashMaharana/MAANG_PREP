import java.util.*;

public class CheckCourseSchedulePossibility {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0},
                {0,1}
        };

        /*int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};*/

        System.out.println("Is Course Schedule Possible : " + canFinish(numCourses, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
        if(count == numCourses) {
            return true;
        }
        return false;
    }
}
