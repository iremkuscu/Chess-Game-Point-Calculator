public class boardSpot { // chessBoard is filled with boardSpot objects that includes ChessPiece objects
	
	private ChessPiece chessPiece;
	private int row; // from 0 to 7
	private int column; // from 0 to 7
	static char teamChar = 's';

	public boardSpot(ChessPiece chessPiece, int row, int column) { //boardSpot object takes three arguments, for for the ChessPiece object and two integer arguments for location storage
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
	
	public char moveable(boardSpot boardSpot) {
		if (boardSpot.getChessPiece().getTeam() == true) // to determine which team does the ChessPiece object belongs and compare while finding other pieces to attack
			teamChar = 's'; // if boolean team value which is set while creating the object equals to true, the piece belongs to the BLACK team
		else
			teamChar = 'b'; // if boolean team value which is set while creating the object equals to false, the piece belongs to the WHITE team
		return teamChar;
	}

}
