import java.io.FileNotFoundException;

public class chessMoves {

	enum Direction {
		VERTICAL,
		HORIZONTAL,
		RIGHT_DIAGONAL,
		LEFT_DIAGONAL
	}

	static String fileName = ChessBoard.fileName;
	static int[] maximumStraightMovesArray = new int[4];
	static int[] maximumDiagonalMovesArray = new int[4];

	public chessMoves() {}

	public static int[] determineStraightMoveNumber(boardSpot boardSpot){ // for pieces that can move more than 1 spot in each move 		
		maximumStraightMovesArray[0] = boardSpot.getRow(); // maximum move number for upwards trajectory
		maximumStraightMovesArray[1] = ChessBoard.size - boardSpot.getRow() - 1; // maximum move number for downwards trajectory
		maximumStraightMovesArray[2] = ChessBoard.size - boardSpot.getColumn() - 1; // maximum move number for the right trajectory
		maximumStraightMovesArray[3] = boardSpot.getColumn(); // maximum move number for the left trajectory

		return maximumStraightMovesArray;
	}

	public static int[] determineDiagonalMoveNumber(boardSpot boardSpot){ // for pieces that can move more than 1 spot in each move 		
		maximumDiagonalMovesArray[0] = Math.min(boardSpot.getRow() + 1, ChessBoard.size - boardSpot.getColumn()) - 1; // maximum move number for top right trajectory
		maximumDiagonalMovesArray[1] = ChessBoard.size - Math.max(boardSpot.getRow() + 1, boardSpot.getColumn() + 1); // maximum move number for bottom right trajectory
		maximumDiagonalMovesArray[2] = Math.min(boardSpot.getRow() + 1,  boardSpot.getColumn() + 1) -  1; // maximum move number for top left trajectory
		maximumDiagonalMovesArray[3] = ChessBoard.size - Math.max(boardSpot.getRow() + 1, ChessBoard.size - boardSpot.getColumn()); // maximum move number for bottom left trajectory

		return maximumDiagonalMovesArray;
	}

	public static int determineUnderAttackPieces(boardSpot boardSpot, int difference, int moveNumber, Direction direction) throws FileNotFoundException{ // method to determine which chess pieces are under attack for each movement direction case
		switch(direction){			
		case VERTICAL:
			String vertical = ChessBoard.TextFileReader(fileName)[boardSpot.getRow() + difference][boardSpot.getColumn()]; //creates the chess piece to be investigated in the vertical trajectory
			if(boardSpot.movable(boardSpot, vertical) == false) 
				return moveNumber; // can not move if the chess piece encounters a piece from the same team
			else if(boardSpot.movable(boardSpot, vertical) == true &&  boardSpot.isEmpty(vertical) == false) { 
				ChessPiece.setChecker(true,boardSpot.getRow() + difference, boardSpot.getColumn()); // if the there is chess piece in the investigated location and if its team is different from the original one, then the investigates chess piece is under attack
				return moveNumber;
			}
			else 
				return Math.abs(difference) -1; // continue iterating until reaching to the maximum move number until chess piece encounter another chess piece

		case HORIZONTAL:
			String horizontal = ChessBoard.TextFileReader(fileName)[boardSpot.getRow()][boardSpot.getColumn() + difference]; //creates the chess piece to be investigated in the horizontal trajectory
			if(boardSpot.movable(boardSpot, horizontal) == false) 
				return moveNumber;  // can not move if the chess piece encounters a piece from the same team
			if(boardSpot.movable(boardSpot, horizontal) == true &&  boardSpot.isEmpty(horizontal) == false) { 
				ChessPiece.setChecker(true,boardSpot.getRow(), boardSpot.getColumn() + difference); // if the there is chess piece in the investigated location and if its team is different from the original one, then the investigates chess piece is under attack
				return moveNumber;
			}
			else
				return Math.abs(difference) -1; // continue iterating until reaching to the maximum move number until chess piece encounter another chess piece

		case RIGHT_DIAGONAL :
			String rightDiagonal = ChessBoard.TextFileReader(fileName)[boardSpot.getRow() - difference][boardSpot.getColumn() + difference]; //creates the chess piece to be investigated in the right diagonal trajectory
			if(boardSpot.movable(boardSpot, rightDiagonal) == false) 
				return moveNumber;  // can not move if the chess piece encounters a piece from the same team
			if(boardSpot.movable(boardSpot, rightDiagonal) == true &&  boardSpot.isEmpty(rightDiagonal) == false) { //upwards.charAt(1) != '-') {
				ChessPiece.setChecker(true,boardSpot.getRow() - difference, boardSpot.getColumn() + difference); // if the there is chess piece in the investigated location and if its team is different from the original one, then the investigates chess piece is under attack
				return moveNumber;
			}
			else
				return Math.abs(difference) -1; // continue iterating until reaching to the maximum move number until chess piece encounter another chess piece

		case LEFT_DIAGONAL:
			String leftDiagonal = ChessBoard.TextFileReader(fileName)[boardSpot.getRow() + difference][boardSpot.getColumn() + difference]; //creates the chess piece to be investigated in the left diagonal trajectory
			if(boardSpot.movable(boardSpot, leftDiagonal) == false) 
				return moveNumber;  // can not move if the chess piece encounters a piece from the same team
			if(boardSpot.movable(boardSpot, leftDiagonal) == true &&  boardSpot.isEmpty(leftDiagonal) == false) { //upwards.charAt(1) != '-') {
				ChessPiece.setChecker(true,boardSpot.getRow() + difference,boardSpot.getColumn() + difference); // if the there is chess piece in the investigated location and if its team is different from the original one, then the investigates chess piece is under attack
				return moveNumber;
			}
			else
				return Math.abs(difference) -1; // continue iterating until reaching to the maximum move number until chess piece encounter another chess piece
		}
		return Math.abs(difference) -1; // continue iterating until reaching to the maximum move number until chess piece encounter another chess piece
	}

	public static void moveVertical(boardSpot boardSpot, boolean direction, int moveNumber) throws FileNotFoundException{ // method to determine chess pieces that are under attack by the chess pieces that move vertically 

		int currentRow = boardSpot.getRow(); // holds the row value for the piece that is attacking
		int currentColumn = boardSpot.getColumn(); // holds the column value for the piece that is attacking

		for(int i=0; i<moveNumber; i++) {
			int difference = 1 + i;
			if(direction == true && ChessBoard.inBounds(currentRow - difference,currentColumn) == true) // moving upward if the direction equals to true
				i = determineUnderAttackPieces(boardSpot, - difference, moveNumber, Direction.VERTICAL);
			if(direction == false && ChessBoard.inBounds(currentRow + difference,currentColumn) == true)  // moving downward if the direction equals to false
				i = determineUnderAttackPieces(boardSpot, difference, moveNumber, Direction.VERTICAL);
		}
	}


	public static void moveHorizontal(boardSpot boardSpot, boolean direction, int moveNumber) throws FileNotFoundException{ // method to determine chess pieces that are under attack by the chess pieces that move horizontally 

		int currentRow = boardSpot.getRow(); // holds the row value for the piece that is attacking
		int currentColumn = boardSpot.getColumn(); // holds the column value for the piece that is attacking

		for(int i=0; i<moveNumber; i++) {
			int difference = 1 + i;
			if(direction == false && ChessBoard.inBounds(currentRow,currentColumn - difference) == true) // moving left if the direction equals to false
				i = determineUnderAttackPieces(boardSpot, - difference, moveNumber, Direction.HORIZONTAL);
			if(direction == true && ChessBoard.inBounds(currentRow, currentColumn + difference) == true)  // moving right if the direction equals to true
				i = determineUnderAttackPieces(boardSpot, difference, moveNumber, Direction.HORIZONTAL);
		}
	}

	public static void moveDiagonally(boardSpot boardSpot, String direction, int moveNumber) throws FileNotFoundException{ // method to determine chess pieces that are under attack by the chess pieces that move diagonally  

		int currentRow = boardSpot.getRow(); // holds the row value for the piece that is attacking
		int currentColumn = boardSpot.getColumn(); // holds the column value for the piece that is attacking

		for(int i=0; i<moveNumber; i++) {
			int difference = 1 + i;
			if(direction.contentEquals("top right") && ChessBoard.inBounds(currentRow - difference, currentColumn + difference) == true) 
				i = determineUnderAttackPieces(boardSpot, difference, moveNumber, Direction.RIGHT_DIAGONAL);
			else if(direction.contentEquals("bottom right") && ChessBoard.inBounds(currentRow + difference, currentColumn + difference) == true)  
				i = determineUnderAttackPieces(boardSpot, difference, moveNumber, Direction.LEFT_DIAGONAL);
			else if(direction.contentEquals("bottom left") && ChessBoard.inBounds(currentRow + difference,currentColumn - difference) == true) 
				i = determineUnderAttackPieces(boardSpot, - difference, moveNumber, Direction.RIGHT_DIAGONAL);
			else if(direction.contentEquals("top left") && ChessBoard.inBounds(currentRow - difference, currentColumn - difference) == true)  
				i = determineUnderAttackPieces(boardSpot, - difference, moveNumber, Direction.LEFT_DIAGONAL);
		}

	}
}

