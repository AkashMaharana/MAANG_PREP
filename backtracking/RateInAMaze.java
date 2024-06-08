import java.util.*;
class RateInAMaze {
    
    private static String directions = "DLRU";
    private static int[] dr = { 1, 0, 0, -1 };
    private static int[] dc = { 0, -1, 1, 0 };
    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 1, 1, 0, 0 },
                         { 0, 1, 1, 1 } };

        int n = maze.length;
        List<String> list = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();
        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            findPath(maze, n, list, currentPath, 0, 0);
        }
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
    
    private static void findPath(int[][] maze, int n, List<String> list, StringBuilder currentPath, int row, int column) {
        if(row == n-1 && column == n-1) {
            list.add(currentPath.toString());
            return;
        }
        maze[row][column] = 0;
        for(int i=0;i<4;i++) {
            int nextRow = row + dr[i];
            int nextColumn = column + dc[i];
            if(isValid(nextRow, nextColumn, maze, n)) {
                currentPath.append(directions.charAt(i));
                findPath(maze, n, list, currentPath, nextRow, nextColumn);
                currentPath.deleteCharAt(currentPath.length() -1);
            }
        }
        maze[row][column] = 1;
    }
    
    private static boolean isValid(int row, int column, int[][] maze, int n) {
        return row >= 0 && column >= 0 && row < n && column < n
            && maze[row][column] == 1;
    }
}
