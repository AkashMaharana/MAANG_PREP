import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        // N - No of words given
        // K - No of english alphabet letters from beginning
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println("Order of characters in alien dictionary : " + getOrder(dict, N, K));
    }

    private static String getOrder(String[] dict, int noOfWords, int noOfAlphabets) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<noOfAlphabets;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<noOfWords-1;i++) {
            String s1= dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j=0;j<len;j++) {
                if(s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        List<Integer> list = topoSort(adjList, noOfAlphabets);
        String result = "";
        for(Integer it : list) {
            result = result + (char) (it + (int)'a');
        }
        return result;
    }

    private static List<Integer> topoSort(List<List<Integer>> adjList, int noOfAlphabets) {
        int[] inDegreeArray = new int[noOfAlphabets];
        for(int i=0;i<inDegreeArray.length;i++) {
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
        List<Integer> result = new ArrayList<>();
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
        return result;
    }
}
