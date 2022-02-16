public class boardSpot { // chessBoard is filled with boardSpot objects that includes ChessPiece objects

	private ChessPiece chessPiece;
	private int row; // from 0 to 7
	private int column; // from 0 to 7
	static char teamChar = 's';
	boolean movable = false;
	boolean isEmpty = false;

	public boardSpot(ChessPiece chessPiece, int row, int column) { //boardSpot object takes three arguments, for the type of ChessPiece object and two integers for location storage
		this.setChessPiece(chessPiece);
		this.setRow(row);
		this.setColumn(column);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public ChessPiece getChessPiece() {
		return chessPiece;
	}

	public void setChessPiece(ChessPiece chessPiece) {
		this.chessPiece = chessPiece;
	}

	public boolean movable(boardSpot currentBoardSpot, String underInvestigation) { // method to check if the chessPiece object can move or not 
		if (currentBoardSpot.getChessPiece().getTeam() == true)  // to determine which team does the ChessPiece object belongs and compare while finding other pieces to attack
			teamChar = 's'; // if boolean team value which is set while creating the object equals to true, the piece belongs to the BLACK team
		else if (currentBoardSpot.getChessPiece().getTeam() == false)
			teamChar = 'b'; // if boolean team value which is set while creating the object equals to false, the piece belongs to the WHITE team	

		if (underInvestigation.charAt(1) == teamChar) 
			movable = false; // chessPiece object is not movable if there is a chess piece from the same team at the investigated location
		else
			movable = true; // chessPiece object is movable if there is a chess piece from the opposite team or is empty at the investigated location
		return movable;
	}

	public boolean isEmpty(String underInvestigation) { // method to check if there is a chess piece at the investigated location
		if (underInvestigation.charAt(1) == '-') 
			isEmpty = true;
		else
			isEmpty = false;
		return isEmpty;
	}

}



