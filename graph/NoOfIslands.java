import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(getNumberOfIslands(grid));
    }

    private static int getNumberOfIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    private static void bfs(int ro, int col, char[][] grid, boolean[][] visited) {
        visited[ro][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, col));
        int m = grid.length;
        int n = grid[0].length;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, -1, 0, +1};
        while(!queue.isEmpty()) {
            int row = queue.peek().row;
            int column = queue.peek().column;
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int newRow = row + delrow[i];
                int newColumn = column + delcol[i];
                if(newRow >= 0 && newColumn >= 0 && newRow < m && newColumn < n && visited[newRow][newColumn] == false && grid[newRow][newColumn] == '1') {
                    visited[newRow][newColumn] = true;
                    queue.add(new Pair(newRow, newColumn));
                }
            }
        }
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
