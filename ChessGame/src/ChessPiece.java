import java.io.FileNotFoundException;

public abstract class ChessPiece{

	static String fileName = ChessBoard.fileName;
	public boolean team = false; // if team equals to true, the piece is BLACK & if team equals to false, the piece is WHITE
	public static boolean[][] checker = new boolean[8][8]; // a 2D boolean array is initialized which holds the corresponding values for each chess piece - if the piece is threatened, the same index is set to true 

	public ChessPiece(boolean team) {
		this.team = team;
	}

	public boolean getTeam() {
		return team;
	}

	public void setTeam(boolean team) {
		this.team = team;
	}

	public static void setChecker(boolean t, int row, int column){
		checker[row][column] = t;
	}
	
	public static boolean getChecker(int row, int column){
		return checker[row][column];
	}

	public abstract double getPoint(ChessPiece chessPiece);

	public abstract void attack(boardSpot boardSpot) throws FileNotFoundException; // for each chessPiece type returns the places all possible places
	
}
