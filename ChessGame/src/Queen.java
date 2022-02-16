import java.io.FileNotFoundException;

public class Queen extends ChessPiece { 

	public Queen(boolean b) { // one type for each team - if team is true, then the piece is black and if it is false, then the piece is white
		super(b);
	}

	static int[] maximumQueenStraightMoves = new int[4];
	static int[] maximumQueenDiagonalMoves = new int[4];
	public static double maximumPoint = 9.0; // maximum point each piece can get

	@Override
	public void attack(boardSpot boardSpot) throws FileNotFoundException{ // to determine queen's attack move which is a combination of bishop and rock

		maximumQueenStraightMoves = chessMoves.determineStraightMoveNumber(boardSpot);
		maximumQueenDiagonalMoves = chessMoves.determineDiagonalMoveNumber(boardSpot);

		chessMoves.moveVertical(boardSpot, true, maximumQueenStraightMoves[0]); // queen attacks upwards
		chessMoves.moveVertical(boardSpot, false, maximumQueenStraightMoves[1]); // queen attacks downwards
		chessMoves.moveHorizontal(boardSpot, true, maximumQueenStraightMoves[2]); // queen attacks to the right
		chessMoves.moveHorizontal(boardSpot, false, maximumQueenStraightMoves[3]); // queen attacks to the left

		chessMoves.moveDiagonally(boardSpot, "top right", maximumQueenDiagonalMoves[0]); // queen attacks to top right
		chessMoves.moveDiagonally(boardSpot, "bottom right", maximumQueenDiagonalMoves[1]); // queen attacks to bottom right
		chessMoves.moveDiagonally(boardSpot, "top left", maximumQueenDiagonalMoves[2]); // queen attacks to top left
		chessMoves.moveDiagonally(boardSpot, "bottom left", maximumQueenDiagonalMoves[3]); // queen attacks to bottom left
	}

	@Override
	public double getPoint(ChessPiece chessPiece) {
		return 9.0;
	}

}





