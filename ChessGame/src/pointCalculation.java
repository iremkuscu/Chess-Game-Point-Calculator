import java.io.FileNotFoundException;

public class pointCalculation{

	public pointCalculation() { }

	public static double pointer(boardSpot boardSpot) throws FileNotFoundException{ // method to calculate each chess piece's point regardless of their type 
		double point;
		int row = boardSpot.getRow();
		int column = boardSpot.getColumn();
		boardSpot[][] totalBoardObject = ChessBoard.fillChessPieceArray(ChessBoard.fileName);

		if(ChessPiece.getChecker(row, column) == true) // each chess piece's boolean value of under threat or not is stored in an 8x8 boolean array
			point = totalBoardObject[row][column].getChessPiece().getPoint(totalBoardObject[row][column].getChessPiece())/2; // if the chess piece is under threat, then it gets its maximum point is halved
		else 
			point = totalBoardObject[row][column].getChessPiece().getPoint(totalBoardObject[row][column].getChessPiece()); // if the chess piece is not under threat, then it gets its maximum possible point

		return point;		
	}

	public static double pointCalculator(String team) throws FileNotFoundException{ // method to calculate total point of black team
		double blackTotalPoint = 0;
		double whiteTotalPoint = 0;
		double totalPoint = 0;
		String[][] totalBoardString = ChessBoard.TextFileReader(ChessBoard.fileName);
		boardSpot[][] totalBoardObject = ChessBoard.fillChessPieceArray(ChessBoard.fileName);

		for(int i=0; i<ChessBoard.size; i++) { //iterates over whole String chessBoard
			for(int j=0; j<ChessBoard.size; j++) {
				if(totalBoardString[i][j].charAt(1) == 's') { // only gets the black team's chess pieces' points
					double point = pointer(totalBoardObject[i][j]);
					blackTotalPoint = blackTotalPoint + point; 
				}
				else if(totalBoardString[i][j].charAt(1) == 'b') { // only gets the white team's chess pieces' points
					double point = pointer(totalBoardObject[i][j]);
					whiteTotalPoint = whiteTotalPoint + point;
				}	
			}	
		}

		if (team == "black") 
			totalPoint = blackTotalPoint;
		else if (team == "white") 
			totalPoint = whiteTotalPoint;

		return totalPoint;
	}
}










