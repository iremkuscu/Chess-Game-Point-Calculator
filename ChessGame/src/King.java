import java.io.FileNotFoundException;

public class King extends ChessPiece { 

	public King(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}
	
	public static double maximumPoint = 100.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {
		
		int currentRow = boardSpot.getRow(); // holds the values of the pieces's current row value
		int currentColumn = boardSpot.getColumn(); // holds the values of the pieces's current column value
		int[] rowDifference = {-1, -1, -1, 0, 0, 1, 1, 1}; // row difference values the king can possibly reach
		int[] columnDifference = {-1, 0, 1, -1, 1, -1, 0, 1}; // column difference values the king can possibly reach
		String[][] totalBoardString = ChessBoard.TextFileReader(fileName); // the piece's attack method would check if the place it can move is occupied or not and if it is occupied is it from opposite team
		//boardSpot[][] totalBoardObject = ChessBoard.fillChessPieceArray(fileName);
				
		char teamChar = boardSpot.moveable(boardSpot);
				
		for(int i=0; i<ChessBoard.size; i++) { // maximum number of a king can make is 8 - iterates over each possible location				
			if(ChessBoard.inBounds(currentRow + rowDifference[i],currentColumn + columnDifference[i]) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
			String temp = totalBoardString[currentRow + rowDifference[i]][currentColumn + columnDifference[i]]; //takes the String value for the chess piece that is under investigation
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow + rowDifference[i],currentColumn + columnDifference[i]); // if the king can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
				}
			}
		}
	}
	
	public double getPoint(ChessPiece chessPiece) {
		return 100.0;
	}

}
		
		


