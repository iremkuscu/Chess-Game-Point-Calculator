import java.io.FileNotFoundException;


public class Pawn extends ChessPiece { //PİYON

	public Pawn(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	public static double maximumPoint = 1.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		if (boardSpot.getChessPiece().getTeam() == true) { // black pawn attacks
			chessMoves.moveDiagonally(boardSpot, "bottom right", 1); // black pawn attacks to bottom right
			chessMoves.moveDiagonally(boardSpot, "bottom left", 1); // black pawn attacks to bottom left
		}
		else if (boardSpot.getChessPiece().getTeam() == false) { // white pawn attacks
			chessMoves.moveDiagonally(boardSpot, "top right", 1); // white pawn  attacks to top right
			chessMoves.moveDiagonally(boardSpot, "top left", 1); // white pawn  attacks to top left
		}
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return 1.0;
	}

}
