public class SorroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };
        char[][] result = solve(board);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, 1, 0, -1};
        for(int i=0;i<board[0].length;i++) {
            // First Row
            if(!visited[0][i] && board[0][i] == 'O') {
                dfs(0, i, visited, delrow, delcol, board);
            }
            // Last Row
            if(!visited[board.length - 1][i] && board[board.length-1][i] == 'O') {
                dfs(board.length-1, i, visited, delrow, delcol, board);
            }
        }
        for(int i=0;i< board.length;i++) {
            // First Column
            if(!visited[i][0] && board[i][0] == 'O') {
                dfs(i, 0, visited, delrow, delcol, board);
            }
            // Last Column
            if(!visited[i][board[0].length - 1] && board[i][board[0].length-1] == 'O') {
                dfs(i, board[0].length-1, visited, delrow, delcol, board);
            }
        }
        for(int i=0;i< board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    private static void dfs(int row, int column, boolean[][] visited, int[] delRow, int[] delcol, char[][] board) {
        visited[row][column] = true;
        for(int i=0;i<4;i++) {
            int newRow = row + delRow[i];
            int newColumn = column + delcol[i];
            if(newRow >= 0 && newColumn >=0 && newRow < board.length && newColumn < board[0].length &&
                    !visited[newRow][newColumn] && board[newRow][newColumn] == 'O') {
                dfs(newRow, newColumn, visited, delRow, delcol, board);
            }
        }
    }
}
