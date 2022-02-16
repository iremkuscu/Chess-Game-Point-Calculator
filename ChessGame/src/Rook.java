import java.io.FileNotFoundException;

public class Rook extends ChessPiece { 

	public Rook(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	static int[] maximumRockMoves = new int[4];
	protected static double maximumPoint = 5.0; // the maximum point a rook object can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException {

		maximumRockMoves = chessMoves.determineStraightMoveNumber(boardSpot);

		chessMoves.moveVertical(boardSpot, true, maximumRockMoves[0]); // rock attacks upwards
		chessMoves.moveVertical(boardSpot, false, maximumRockMoves[1]); // rock attacks downwards
		chessMoves.moveHorizontal(boardSpot, true, maximumRockMoves[2]); // rock attacks to the right
		chessMoves.moveHorizontal(boardSpot, false, maximumRockMoves[3]); // rock attacks to the left
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return maximumPoint;
	}

}














