public class WordSearch {
    int[] dX = {0, 0, 1, -1};
    int[] dY = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (backtrack(board, word, i, j, 1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        for (int d = 0; d < 4; d++) {
            int row = i + dX[d];
            int col = j + dY[d];
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
            || board[row][col] != word.charAt(index)) {
                continue;
            }
            visited[row][col] = true;
            if (backtrack(board, word, row, col, index + 1, visited)) {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }
}
