import java.io.FileNotFoundException;


public class Pawn extends ChessPiece { //PİYON

	public Pawn(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}
	
	public static double maximumPoint = 1.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		int currentRow = boardSpot.getRow(); // holds the values of the pieces's current row value
		int currentColumn = boardSpot.getColumn(); // holds the values of the pieces's current column value
		String[][] totalBoardString = ChessBoard.TextFileReader(fileName); // the piece's attack method would check if the place it can move is occupied or not and if it is occupied is it from opposite team
		//boardSpot[][] totalBoardObject = ChessBoard.fillChessPieceArray(fileName);
		
		char teamChar = boardSpot.moveable(boardSpot); 
		
		//determine the black pawn's move - assuming black team starts from the top of the chess board
		if (teamChar == 's'){	
			if(ChessBoard.inBounds(currentRow+1,currentColumn-1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow+1][currentColumn-1]; // determines the bottom left diagonal trajectory
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow+1,currentColumn-1); // if the black pawn can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
				}
			}
			
			if(ChessBoard.inBounds(currentRow+1,currentColumn+1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow+1][currentColumn+1]; // determines the bottom right diagonal trajectory
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow+1,currentColumn+1); // if the black pawn can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
				}
			}
		}
		
		//determine the white pawn's move - assuming white team starts from the bottom  of the chess board
		if (teamChar == 'b'){	
			if(ChessBoard.inBounds(currentRow-1,currentColumn-1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
			String temp = totalBoardString[currentRow-1][currentColumn-1]; // determines the top left diagonal trajectory
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow-1,currentColumn-1); // if the white pawn can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
				}
			}
			
			if(ChessBoard.inBounds(currentRow-1,currentColumn+1) == true){ //checks if the boardSpot that is under investigation is inside the 8x8 chessBoard
				String temp = totalBoardString[currentRow-1][currentColumn+1]; // determines the top right trajectory
				if (temp.charAt(1) != teamChar && temp.charAt(1) != '-' ) { // checks the boardSpot for not being empty and the piece is from the opposite team
					setChecker(true,currentRow-1,currentColumn+1); // if the white pawn can attack the piece in the investigates location, then the value for the corresponding location in the boolean 2D array is set to true
				}
			}
		}	
	}
	
	public double getPoint(ChessPiece chessPiece) {
		return 1.0;
	}

}
