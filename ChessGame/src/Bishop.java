import java.io.FileNotFoundException;

public class Bishop extends ChessPiece { //
	
	public Bishop(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	public static double maximumPoint = 3.0; // maximum point each piece can get
	
	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		int currentRow = boardSpot.getRow(); // holds the values of the pieces's current row value
		int currentColumn = boardSpot.getColumn(); // holds the values of the pieces's current column value
		int topRight = Math.min(currentRow + 1, 9 - currentColumn - 1) - 1; // how many moves bishop can make for each direction
		int topLeft = Math.min(currentRow + 1,  currentColumn + 1) -  1;
		int bottomRight = 8 - Math.max(currentRow + 1, currentColumn + 1);
		int bottomLeft = 8 - Math.max(currentRow + 1, 9 - currentColumn - 1);
		String[][] totalBoardString = ChessBoard.TextFileReader(fileName); // the piece's attack method would check if the place it can move is occupied or not and if it is occupied is it from opposite team
		//boardSpot[][] totalBoardObject = ChessBoard.fillChessPieceArray(fileName);
		
		char teamChar = boardSpot.moveable(boardSpot);
		
		//determine the top right diagonal trajectory 
			for(int i=0; i<topRight; i++) {	
				if(ChessBoard.inBounds(currentRow-i-1,currentColumn+i+1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
					String temp = totalBoardString[currentRow-i-1][currentColumn+i+1]; //takes the String value for the chess piece that is under investigation
					if (temp.charAt(1) == teamChar) // if bishop encounters a piece from its own team it can no longer move in that direction
						break; 
					if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
						setChecker(true,currentRow-1-i,currentColumn+1+i); // if the bishop can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
						break; // bishop cannot move after it encounters another piece
					} 
				}
			}
			
			//determine the top left diagonal trajectory 
			for(int i=0; i<topLeft; i++) {		
				if(ChessBoard.inBounds(currentRow-i-1,currentColumn-i-1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
					String temp = totalBoardString[currentRow-i-1][currentColumn-i-1]; //takes the String value for the chess piece that is under investigation
					if (temp.charAt(1) == teamChar) // if bishop encounters a piece from its own team it can no longer move in that direction
						break; 
					if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
						setChecker(true,currentRow-1-i,currentColumn-1-i); // if the bishop can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
						break; // bishop cannot move after it encounters another piece
					} 
				}
			}
			
			//determine the bottom right diagonal trajectory 
			for(int i=0; i<bottomRight; i++) {	
				if(ChessBoard.inBounds(currentRow+i+1,currentColumn+i+1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
					String temp = totalBoardString[currentRow+i+1][currentColumn+i+1]; //takes the String value for the chess piece that is under investigation
					if (temp.charAt(1) == teamChar) // if bishop encounters a piece from its own team it can no longer move in that direction
						break; 
					if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
						setChecker(true,currentRow+1+i,currentColumn+1+i); // if the bishop can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
						break; // bishop cannot move after it encounters another piece
					}
				}
			}
			
			//determine the bottom left diagonal trajectory 
			for(int i=0; i<bottomLeft; i++) {		
				if(ChessBoard.inBounds(currentRow+i+1,currentColumn-i-1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
					String temp = totalBoardString[currentRow+i+1][currentColumn-i-1]; //takes the String value for the chess piece that is under investigation
					if (temp.charAt(1) == teamChar) // if bishop encounters a piece from its own team it can no longer move in that direction
						break;
					if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
						setChecker(true,currentRow+1+i,currentColumn-1-i); // if the bishop can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
						break; // bishop cannot move after it encounters another piece
					}
				}
			}
	}
	
	public double getPoint(ChessPiece chessPiece) {
		return 3.0;
	}

}
