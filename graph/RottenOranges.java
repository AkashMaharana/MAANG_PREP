import java.util.*;
public class RottenOranges {
    public static void main(String[] args) {
        int grid[][] = {
                { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 }
        };
        System.out.println("Number of days it will take to rotten all oranges : " + rottenOranges(grid));
    }

    private static int rottenOranges(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i,j));
                }
            }
        }
        queue.add(new Pair(-1,-1));
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, -1, 0, +1};
        int noOfPass = 0;
        while(!queue.isEmpty()) {
            boolean flag = false;
            while(queue.peek().row != -1 && queue.peek().column != -1) {
                Pair pair = queue.poll();
                for(int i=0;i<4;i++) {
                    int newRow = pair.row + delrow[i];
                    int newColumn = pair.column + delcol[i];
                    if(newRow >=0 && newColumn >=0 && newRow < grid.length && newColumn < grid[0].length && grid[newRow][newColumn] == 1) {
                        grid[newRow][newColumn] = 2;
                        queue.add(new Pair(newRow, newColumn));
                        if(!flag) {
                            flag = true;
                            noOfPass++;
                        }
                    }
                }
            }
            queue.poll();
            if(!queue.isEmpty()) {
                queue.add(new Pair(-1,-1));
            }
        }
        return (checkAll(grid)) ? -1 : noOfPass;
    }

    private static boolean checkAll(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
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
