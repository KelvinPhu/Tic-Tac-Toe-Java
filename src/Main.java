import java.util.Scanner;

public class Main {
	
	private static final char EMPTY_CELL = ' ';
	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] board = initializeBoard();
		char currentPlayer = PLAYER_X;
		int filledCalls = 0;
		
		while(true) {
			printBoard(board);
			
			System.out.println("Player " +currentPlayer+ " enter your placement [x, y]: ");
			int row = sc.nextInt() * 2 - 2;
			int col = sc.nextInt() * 2 - 2;
			
			if(isValidMove(board, row, col)) {
				board[row][col] = currentPlayer;
				filledCalls++;
				
				if(checkWinner(board, currentPlayer)) {
					System.out.println("Player " +currentPlayer+ " win!");
					break;
				}else if(filledCalls == 9) {
					System.out.println("CAT!");
					break;
				}
				currentPlayer = switchPlayer(currentPlayer);
			}else {
				System.out.println("Invalid move, try again!");
			}
		}
	}
	
	private static char[][] initializeBoard(){
		return new char[][] {
			{EMPTY_CELL, '|', EMPTY_CELL, '|', EMPTY_CELL},
            {'-', '+', '-', '+', '-'},
            {EMPTY_CELL, '|', EMPTY_CELL, '|', EMPTY_CELL},
            {'-', '+', '-', '+', '-'},
            {EMPTY_CELL, '|', EMPTY_CELL, '|', EMPTY_CELL}
		};
	}
	
	public static void printBoard(char[][] board) {
		for(char[] row : board) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	private static boolean isValidMove(char[][] board, int row, int col) {
		if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == EMPTY_CELL) {
			return true;
		}
		
		return false;
	}
	
	private static char switchPlayer(char currentPlayer) {
		return currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
	}
	
	
	
	public static boolean checkWinner(char[][] board, char player) {
		// check all vertically 
		for(int i=0; i<5; i+=2) {
			if(board[i][0] == player && board[i][2] == player && board[i][4] == player) {
				return true;
			}
		}
		
		// check all horizontally
		for(int i=0; i<5; i+=2) {
			if(board[0][i] == player && board[2][i] == player && board[4][i] == player) {
				return true;
			}
		}
		
		// check all diagonally
		if(board[0][0] == player && board[2][2] == player && board[4][4] == player) {
			return true;
		}
		if(board[0][4] == player && board[2][2] == player && board[4][0] == player) {
			return true;
		}
		
		return false;
	}
}
