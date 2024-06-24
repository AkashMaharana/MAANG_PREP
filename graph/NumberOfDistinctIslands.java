import java.util.*;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println("No of distinct islands : " + countNumberOfDistinctIslands(grid));
    }

    private static int countNumberOfDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<String>> set = new HashSet<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, grid, visited, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }


    private static void dfs(int row, int column, int[][] grid, boolean[][] visited, List<String> list, int baseRow, int baseColumn) {
        visited[row][column] = true;
        list.add(toString(row - baseRow, column - baseColumn));
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, -1, 0, +1};
        for(int i=0;i<4;i++) {
            int newRow = row + delrow[i];
            int newColumn = column + delcol[i];
            if(newRow >= 0 && newColumn >= 0 && newRow < grid.length && newColumn < grid[0].length &&
                    !visited[newRow][newColumn] && grid[newRow][newColumn] == 1) {
                dfs(newRow,newColumn, grid, visited, list, baseRow, baseColumn);
            }
        }
    }

    private static String toString(int r, int c) {
        return r + " " + c;
    }
}
