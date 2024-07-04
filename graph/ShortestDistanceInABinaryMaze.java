import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {
    public static void main(String[] args) {
        int[] source={0,0};
        int[] destination={3,4};
        int[][] grid={
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
        System.out.println("Shortest Distance : " + shortestPathBinaryMatrix(source, destination, grid));
    }

    private static int shortestPathBinaryMatrix(int[] source, int[] destination, int[][] grid) {
        if(source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        int[][] result = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                result[i][j] = (int)1e9;
            }
        }
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(source[0], source[1], 0));
        result[source[0]][source[1]] = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            Element temp = queue.poll();
            int row = temp.row;
            int column = temp.column;
            int distance = temp.distance;
            for(int i=0;i<dr.length;i++) {
                int newRow = row + dr[i];
                int newColumn = column + dc[i];
                if(newRow >= 0 && newColumn >= 0 && newRow < grid.length && newColumn < grid[0].length
                        && grid[newRow][newColumn] == 1 && distance + 1 < result[newRow][newColumn]) {
                    result[newRow][newColumn] = distance + 1;
                    if(destination[0] == newRow && destination[1] == newColumn) {
                        return distance + 1;
                    }
                    queue.add(new Element(newRow, newColumn, distance + 1));
                }
            }
        }
        return -1;
    }
}

class Element {
    int row;
    int column;
    int distance;

    public Element(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }
}
