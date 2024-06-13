import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] printBoard = {
				{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
		};
		
		char currentPlayer = 'X';
		int filledCalls = 0;
		
		while(true) {
			printBoard(printBoard);
			
			System.out.println("Player " +currentPlayer+ " enter your placement [x, y]: ");
			int row = sc.nextInt() * 2 - 2;
			int col = sc.nextInt() * 2 - 2;
			
			if(row >= 0 && row < printBoard.length && col >= 0 && col < printBoard[0].length && printBoard[row][col] == ' ') {
				printBoard[row][col] = currentPlayer;
				filledCalls++;
				
				if(checkWinner(printBoard, currentPlayer)) {
					System.out.println("Player " +currentPlayer+ " win!");
					break;
				}else if(filledCalls == 9){
					System.out.println("Cat!");
					break;
				}
			}else {
				System.out.println("Invalid placement, try again.");
				continue;
			}
			
			currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
		}
	}
	
	public static void printBoard(char[][] board) {
		for(char[] row : board) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
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
