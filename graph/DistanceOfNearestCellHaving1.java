import java.util.*;

public class DistanceOfNearestCellHaving1 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,1},
                {1,1,0},
                {1,0,0}
        };
        int[][] result = getDistance(grid);
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getDistance(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] result = new int[grid.length][grid[0].length];
        Queue<Pair_1> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Pair_1(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        while(!queue.isEmpty()) {
            Pair_1 pair = queue.poll();
            int row = pair.row;
            int column = pair.column;
            int distance = pair.distance;
            result[row][column] = distance;
            for(int i=0;i<4;i++) {
                int newRow = row + delrow[i];
                int newColumn = column + delcol[i];
                if(newRow >= 0 && newColumn >= 0 && newRow < grid.length &&
                        newColumn < grid[0].length && visited[newRow][newColumn] == false) {
                    visited[newRow][newColumn] = true;
                    queue.add(new Pair_1(newRow, newColumn, distance + 1));
                }
            }
        }
        return result;
    }

}


class Pair_1 {
    int row;
    int column;
    int distance;

    public Pair_1(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }
}
