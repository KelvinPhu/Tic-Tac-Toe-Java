import java.util.Random;
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
		
		System.out.println("Choose a game mode: \n1. Player vs Player\n2. Player vs Computer");
		int gameMode = sc.nextInt();
		
		while(true) {
			printBoard(board);
			
			if(gameMode == 1 || (gameMode == 2 && currentPlayer == PLAYER_X)) {
				System.out.println("Player " +currentPlayer+ " enter your placement [x, y]: ");
				int row = sc.nextInt() * 2 - 2;
				int col = sc.nextInt() * 2 - 2;
				
				if(isValidMove(board, row, col)) {
					board[row][col] = currentPlayer;
					
				}else {
					System.out.println("Invalid move, try again!");
				}
			}else if(gameMode == 2 && currentPlayer == PLAYER_O) {
				computerMove(board, currentPlayer);
			}
			filledCalls++;
			
			if(checkWinner(board, currentPlayer)) {
				System.out.println("Player " +currentPlayer+ " win!");
				break;
			}else if(filledCalls == 9) {
				System.out.println("CAT!");
				break;
			}
			currentPlayer = switchPlayer(currentPlayer);

		}
		
		sc.close();
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
			if(checkThreeInRow(board[i][0], board[i][2], board[i][4], player)){
				return true;
			}
		}
		
		// check all horizontally
		for(int i=0; i<5; i+=2) {
			if(checkThreeInRow(board[0][i], board[2][i], board[4][i], player)) {
				return true;
			}
		}
		
		// check all diagonally
		
		if(checkThreeInRow(board[0][0], board[2][2], board[4][4], player)) {
			return true;
		}
		if(checkThreeInRow(board[0][4], board[2][2], board[4][0], player)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean checkThreeInRow(char cell1, char cell2, char cell3, char player) {
		return cell1 == player && cell2 == player && cell3 == player;
	}
	
	private static void computerMove(char[][] board, char currentPlayer) {
		Random rand = new Random();
		int row, col;
		
		do {
			row = rand.nextInt(3) * 2;
			col = rand.nextInt(3) * 2;
		}while(!isValidMove(board, row, col));
		
		board[row][col] = currentPlayer;
	}
}
