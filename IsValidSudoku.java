package leetCodeJava;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		
		// solution 1
//		boolean[][] rows = new boolean[9][9]; // each row represents a row in the board, true if that number is present in that row
//		boolean[][] cols = new boolean[9][9]; // each row represents a column
//		boolean[][] cubes = new boolean[9][9]; // each row represents a cube
//		
//		for (int i=0; i<9; i++)
//		{
//			for (int j=0; j<9; j++)
//			{
//				if (board[i][j] == '.') continue;
//				
//				int b = board[i][j] - '1';
//				if (rows[i][b] || cols[j][b] || cubes[i/3*3 + j/3][b]) return false;
//				
//				rows[i][b] = cols[j][b] = cubes[i/3*3 + j/3][b] = true;
//			}
//		}
//		
//        return true;
		
		// solution 2
		for (int i=0; i<9; i++)
		{
			Set<Character> row = new HashSet<>();
			Set<Character> col = new HashSet<>();
			Set<Character> cube = new HashSet<>();
			
			for (int j=0; j<9; j++)
			{
				if (board[i][j]!='.' && !row.add(board[i][j])) return false;
				if (board[j][i]!='.' && !col.add(board[j][i])) return false;
				if (board[i/3*3+j/3][i%3*3+j%3]!='.' && !cube.add(board[i/3*3+j/3][i%3*3+j%3])) return false;
			}
		}
		
		return true;
    }
}
