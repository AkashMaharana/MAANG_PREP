import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image ={
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        floodFill(image, sr, sc, color);
        for(int i=0;i<image.length;i++) {
            for(int j=0;j<image[0].length;j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = color;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, -1, 0, +1};
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int column = pair.column;
            for(int i=0;i<4;i++) {
                int newRow = row + delrow[i];
                int newCol = column + delcol[i];
                if(newRow >= 0 && newCol >=0 && newRow < image.length && newCol <image[0].length &&
                        visited[newRow][newCol] == false && image[newRow][newCol] == currentColor) {
                    image[newRow][newCol] = color;
                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
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
        this. column = column;
    }
}
