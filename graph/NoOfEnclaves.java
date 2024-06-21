import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println("No of Enclaves : " + numEnclaves(grid));
    }

    private static int numEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(i == 0 || j == 0 || i == grid.length -1 || j == grid[0].length - 1) {
                    if(grid[i][j] == 1){
                        queue.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int row = queue.peek().row;
            int column = queue.peek().column;
            queue.remove();
            for(int i=0;i<4;i++) {
                int newRow = row + delRow[i];
                int newColumn = column + delCol[i];
                if(newRow >= 0 && newColumn >= 0 && newRow < grid.length && newColumn < grid[0].length &&
                        grid[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                    queue.add(new Pair(newRow, newColumn));
                    visited[newRow][newColumn] = true;
                }
            }
        }
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Pair {
    int row;
    int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
