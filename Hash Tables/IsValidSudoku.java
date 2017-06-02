public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.println("i =  " + i);
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                if (board[i/3*3 + j/3][i%3*3 + j%3] != '.' && !cube.add(board[i/3*3 + j/3][i%3*3 + j%3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
