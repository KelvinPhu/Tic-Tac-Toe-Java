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
		
		while(true) {
			printBoard(printBoard);
			
			System.out.println("Player " +currentPlayer+ " enter your placement [x, y]: ");
			int row = sc.nextInt() * 2 - 2;
			int col = sc.nextInt() * 2 - 2;
			
			if(row >= 0 && row < printBoard.length && col >= 0 && col < printBoard[0].length && printBoard[row][col] == ' ') {
				printBoard[row][col] = currentPlayer;
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
}
