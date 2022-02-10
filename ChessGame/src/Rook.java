import java.io.FileNotFoundException;

public class Rook extends ChessPiece { 
	
	public Rook(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}
	
	protected static double maximumPoint = 5.0; // the maximum point a rook object can get
	
	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		int currentRow = boardSpot.getRow(); // holds the values of the pieces's current row value
		int currentColumn = boardSpot.getColumn(); // holds the values of the pieces's current column value
		String[][] totalBoardString = ChessBoard.TextFileReader(fileName); // the piece's attack method would check if the place it can move is occupied or not and if it is occupied is it from opposite team
		//boardSpot[][] totalBoardObject = ChessBoard.fillChessPieceArray(fileName);
		
		char teamChar = boardSpot.moveable(boardSpot);
				
		//determine the right trajectory - same row but changing columns - look to the entire right row	
		for(int i=0; i<ChessBoard.size-currentColumn-1; i++) {		
			if(ChessBoard.inBounds(currentRow,currentColumn+1+i) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow][currentColumn+1+i]; //takes the String value for the chess piece that is under investigation
				if (temp.charAt(1) == teamChar) // if the piece encounters another piece from its own team it can no longer move in that direction
					break;
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow,currentColumn+1+i); // if the rook can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
					break; // rook cannot move after it encounters another piece
				}
			}
		}
		
		//determine the left trajectory - same row but changing columns - look to the entire left row
		for(int i=0; i<currentColumn; i++) {
			if(ChessBoard.inBounds(currentRow,currentColumn-1-i) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow][currentColumn-1-i]; //takes the String value for the chess piece that is under investigation
				if (temp.charAt(1) == teamChar) // if the piece encounters another piece from its own team it can no longer move in that direction
					break; 
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow,currentColumn-1-i); // if the rook can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
					break; //rook cannot move after it encounters another piece
				}
			}			
		}
		
		//determine the upwards trajectory - same column but changing rows - look to the entire upwards column
		for(int i=0; i<currentRow; i++) {	
			if(ChessBoard.inBounds(currentRow-1-i,currentColumn) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow-1-i][currentColumn]; //takes the String value for the chess piece that is under investigation
				if (temp.charAt(1) == teamChar) // if the piece encounters another piece from its own team it can no longer move in that direction
					break; 
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow-1-i,currentColumn); // if the rook can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
					break; //rook cannot move after it encounters another piece
				}
			}
		}
		
		//determine the downwards trajectory - same column but changing rows - look to the entire downwards row
		for(int i=0; i<ChessBoard.size-currentRow-1; i++) {	
			if(ChessBoard.inBounds(currentRow+1+i,currentColumn) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow+1+i][currentColumn]; //takes the String value for the chess piece that is under investigation
				if (temp.charAt(1) == teamChar) // if the piece encounters another piece from its own team it can no longer move in that direction
					break; 
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow+1+i,currentColumn); // if the rook can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
					break; //rook cannot move after it encounters another piece
				}	
			}
		}
		
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return maximumPoint;
	}


}
		
	

	


	




	


