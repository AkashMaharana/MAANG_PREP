import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights={
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println("Minimum effort required : " + minimumEffortPath(heights));
    }

    private static int minimumEffortPath(int[][] heights) {
        PriorityQueue<PathElement> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.effort));
        int[][] result = new int[heights.length][heights[0].length];
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                result[i][j] = (int)1e9;
            }
        }
        result[0][0] = 0;
        queue.add(new PathElement(0,0,0));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int m = heights.length;
        int n = heights[0].length;
        while(!queue.isEmpty()) {
            PathElement element = queue.poll();
            int row = element.row;
            int column = element.column;
            int effort = element.effort;
            if(row == m-1 && column == n-1){
                return effort;
            }
            for(int i=0;i<4;i++) {
                int newRow = row + dr[i];
                int newColumn = column + dc[i];
                if(newRow >= 0 && newColumn >= 0 && newRow < m && newColumn < n) {
                    int newMaxEffort = Math.max(effort, Math.abs(heights[row][column] - heights[newRow][newColumn]));
                    if(newMaxEffort < result[newRow][newColumn]) {
                        result[newRow][newColumn] = newMaxEffort;
                        queue.add(new PathElement(newRow, newColumn, newMaxEffort));
                    }
                }
            }
        }
        return 0;
    }
}

class PathElement {
    int row;
    int column;
    int effort;

    public PathElement(int row, int column, int effort) {
        this.row = row;
        this.column = column;
        this.effort = effort;
    }
}
