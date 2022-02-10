import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ChessBoard {

	static String fileName = "board2.txt";
	static int size = 8;
	public static String[][] chessBoard = new String[8][8];
	public static boardSpot[][] objectChessBoard = new boardSpot[8][8];
	
	public ChessBoard() {}
	
	public static String[][] TextFileReader(String fileName) throws FileNotFoundException { // the board is read and written to a 2D array in string format 
		File boardTextFile = new File(fileName);
		Scanner myReader = new Scanner(boardTextFile);
		int lineCount=0;
		while (myReader.hasNextLine()) {
			String[]  line = myReader.nextLine().trim().split(" ");
				for (int i=0; i<size; i++) {
					chessBoard[lineCount][i] = line[i];
				}
			lineCount ++;
		}
		myReader.close();
		return chessBoard;
	}
	
	public static boardSpot[][] fillChessPieceArray(String fileName) throws FileNotFoundException { // the board is read and written to a 2D array in chessBoard object format 
		File boardTextFile = new File(fileName);
		Scanner myReader = new Scanner(boardTextFile);
		int lineCount=0;
		while (myReader.hasNextLine()) {
			String[]  line = myReader.nextLine().trim().split(" ");
				for (int i=0; i<size; i++) {
				chessBoard[lineCount][i] = line[i];
				}
			lineCount ++;
		}
		myReader.close();		
		
		for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					String str = chessBoard[i][j];
					if (str.charAt(0) == 'k' && str.charAt(1) == 's') {
						objectChessBoard[i][j] = new boardSpot(new Rook(true),i,j); // a black rook piece object is created at the specific location
					}
					else if (str.charAt(0) == 'k' && str.charAt(1) == 'b') {
						objectChessBoard[i][j] = new boardSpot(new Rook(false),i,j); // a white rook piece object is created at the specific location
					}
					else if (str.charAt(0) == 'a' && str.charAt(1) == 's') {
						objectChessBoard[i][j] = new boardSpot(new Knight(true),i,j); // a black knight piece object is created at the specific location
					}
					else if (str.charAt(0) == 'a' && str.charAt(1) == 'b') {
						objectChessBoard[i][j] = new boardSpot(new Knight(false),i,j); // a white knight piece object is created at the specific location
					}
					else if (str.charAt(0) == 'f' && str.charAt(1) == 's') {
						objectChessBoard[i][j] = new boardSpot(new Bishop(true),i,j); // a black bishop piece object is created at the specific location
					}
					else if (str.charAt(0) == 'f' && str.charAt(1) == 'b') {
						objectChessBoard[i][j] = new boardSpot(new Bishop(false),i,j); // a white bishop piece object is created at the specific location
					}
					else if (str.charAt(0) == 'v' && str.charAt(1) == 's') {
						objectChessBoard[i][j] = new boardSpot(new Queen(true),i,j); // a black queen piece object is created at the specific location
					}
					else if (str.charAt(0) == 'v' && str.charAt(1) == 'b') {
						objectChessBoard[i][j] = new boardSpot(new Queen(false),i,j); // a white queen piece object is created at the specific location
					}
					else if (str.charAt(0) == 's' && str.charAt(1) == 's') {
						objectChessBoard[i][j] = new boardSpot(new King(true),i,j); // a black king piece object is created at the specific location
					}
					else if (str.charAt(0) == 's' && str.charAt(1) == 'b') {
						objectChessBoard[i][j] = new boardSpot(new King(false),i,j); // a white king piece object is created at the specific location
					}
					else if (str.charAt(0) == 'p' && str.charAt(1) == 's') {
						objectChessBoard[i][j] = new boardSpot(new Pawn(true),i,j); // a black pawn piece object is created at the specific location
					}
					else if (str.charAt(0) == 'p' && str.charAt(1) == 'b') {
						objectChessBoard[i][j] = new boardSpot(new Pawn(false),i,j); // a white pawn piece object is created at the specific location
					}
					else {
						objectChessBoard[i][j] = new boardSpot(null,i,j); // a null object is created
					}
				}
		}
		return objectChessBoard;
	}
	
	public static boolean inBounds(int row, int column) { // to check if a boardSpot is inside the 8x8 chess board
		return row >= 0 && row < size && column >= 0 && column < size;
	}

	public static void main(String[] args) throws Exception {
		boardSpot[][] spotChessBoard = fillChessPieceArray(fileName);
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {				
				if(spotChessBoard[i][j].getChessPiece() != null) {
					spotChessBoard[i][j].getChessPiece().attack(spotChessBoard[i][j]);
				}
			}
		}
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(spotChessBoard[i][j].getChessPiece() != null) {
					spotChessBoard[i][j].getChessPiece();
					//System.out.println(ChessPiece.getChecker(i,j));
				}	
			}
		}
		
		System.out.println("The black team's point is " + pointCalculation.blackTeamPointCalculation());
		System.out.println("The white team's point is " + pointCalculation.whiteTeamPointCalculation());
		
	}
	
}





