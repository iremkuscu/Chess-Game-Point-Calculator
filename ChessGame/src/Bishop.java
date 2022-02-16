import java.io.FileNotFoundException;

public class Bishop extends ChessPiece { //

	public Bishop(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	static int[] maximumBishopMoves = new int[4];
	public static double maximumPoint = 3.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		maximumBishopMoves = chessMoves.determineDiagonalMoveNumber(boardSpot);

		chessMoves.moveDiagonally(boardSpot, "top right", maximumBishopMoves[0]); // bishop attacks to top right
		chessMoves.moveDiagonally(boardSpot, "bottom right", maximumBishopMoves[1]); // bishop attacks to bottom right
		chessMoves.moveDiagonally(boardSpot, "top left", maximumBishopMoves[2]); // bishop attacks to top left
		chessMoves.moveDiagonally(boardSpot, "bottom left", maximumBishopMoves[3]); // bishop attacks to bottom left	
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return 3.0;
	}

}
