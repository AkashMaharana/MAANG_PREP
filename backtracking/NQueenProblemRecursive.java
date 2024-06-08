import java.util.*;

public class NQueenProblemRecursive {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> list = solveNQueen(n);
        for(int i=0;i<list.size();i++) {
            List<String> list1 = list.get(i);
            list1.forEach(System.out::println);
            System.out.println();
       }
    }

    private static List<List<String>> solveNQueen(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> list = new ArrayList<>();
        findPlaces(0, board, list);
        return list;
    }

    private static void findPlaces(int column, char[][] board, List<List<String>> list) {
        if(column == board.length) {
            list.add(constructBoard(board));
            return;
        }
        for(int row=0;row<board.length;row++) {
            if(isValidCombination(board, row, column)) {
                board[row][column] = 'Q';
                findPlaces(column+1, board, list);
                board[row][column] = '.';
            }
        }
    }

    private static boolean isValidCombination(char[][] board, int row, int column) {
        int tempRow = row;
        int tempColumn = column;
        while(tempRow >=0 && tempColumn >=0) {
            if(board[tempRow][tempColumn] == 'Q') {
                return false;
            }
            tempColumn --;
            tempRow --;
        }
        tempRow = row;
        tempColumn  = column;
        while(tempColumn >=0){
            if(board[tempRow][tempColumn] == 'Q') {
                return false;
            }
            tempColumn--;
        }
        tempColumn = column;
        tempRow = row;
        while(tempRow < board.length && tempColumn>=0) {
            if(board[tempRow][tempColumn] == 'Q') {
                return false;
            }
            tempRow++;
            tempColumn--;
        }
        return true;
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            list.add(new String(board[i]));
        }
        return list;
    }

}
