import java.io.FileNotFoundException;

public class Knight extends ChessPiece { 

	public Knight(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	public static double maximumPoint = 3.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		int currentRow = boardSpot.getRow(); // holds the values of the pieces's current row value
		int currentColumn = boardSpot.getColumn(); // holds the values of the pieces's current column value
		int[] rowDifference = {2, 2, -2, -2, 1, 1, -1, -1}; // row difference values the knight can possibly reach
		int[] columnDifference = {1, -1, 1, -1, 2, -2, 2, -2}; // column difference values the knight can possibly reach
		String[][] totalBoardString = ChessBoard.TextFileReader(fileName); 

		for(int i=0; i<ChessBoard.size; i++) { // maximum number of a knight can make is 8 - iterates over each possible location		
			if(ChessBoard.inBounds(currentRow + rowDifference[i],currentColumn + columnDifference[i]) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String knightMove = totalBoardString[currentRow + rowDifference[i]][currentColumn + columnDifference[i]]; //takes the String value for the chess piece that is under investigation
				if (boardSpot.movable(boardSpot, knightMove) == true) // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow + rowDifference[i],currentColumn + columnDifference[i]); // if the knight can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
			}
		}
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return 3.0;
	}
	
}





