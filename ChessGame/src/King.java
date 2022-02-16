import java.io.FileNotFoundException;

public class King extends ChessPiece { 

	public King(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	public static double maximumPoint = 100.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		chessMoves.moveVertical(boardSpot, true, 1); // king attacks upwards
		chessMoves.moveVertical(boardSpot, false, 1); // king attacks downwards
		chessMoves.moveHorizontal(boardSpot, true, 1); // king attacks to the right
		chessMoves.moveHorizontal(boardSpot, false, 1); // king attacks to the left

		chessMoves.moveDiagonally(boardSpot, "top right", 1); // king attacks to top right
		chessMoves.moveDiagonally(boardSpot, "bottom right", 1); // king attacks to bottom right
		chessMoves.moveDiagonally(boardSpot, "top left", 1); // king attacks to top left
		chessMoves.moveDiagonally(boardSpot, "bottom left", 1); // king attacks to bottom left
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return 100.0;
	}

}




