import java.util.ArrayList;
import java.util.List;

public class NQueenProblemOptimized {

    public static void main(String[] args) {
        int n = 4;
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n - 1];
        int[] upperDiagonal = new int[2*n -1];
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        solveNQueen(leftRow, lowerDiagonal, upperDiagonal, 0, list, board);
        for(int i=0;i<list.size();i++) {
            List<String> list1 = list.get(i);
            list1.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void solveNQueen(int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal,
                                                  int column, List<List<String>> list, char[][] board) {
        if(column == board.length) {
            list.add(constructBoard(board));
            return;
        }
        for(int row = 0; row<board.length;row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row+column] == 0 && upperDiagonal[board.length-1 + column - row] == 0) {
                leftRow[row] = 1;
                lowerDiagonal[row+column] = 1;
                upperDiagonal[board.length - 1 + column - row] = 1;
                board[row][column] = 'Q';
                solveNQueen(leftRow, lowerDiagonal, upperDiagonal, column + 1, list, board);
                leftRow[row] = 0;
                lowerDiagonal[row+column] = 0;
                upperDiagonal[board.length - 1 + column - row] = 0;
                board[row][column] = '.';
            }
        }
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
