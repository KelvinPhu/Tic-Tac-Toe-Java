public class Main {
	public static void main(String[] args) {
		char[][] printBoard = {
				{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
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
}
