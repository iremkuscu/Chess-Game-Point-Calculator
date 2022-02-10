//import java.io.File;
//import java.io.FileNotFoundException;  
//import java.util.Scanner;


//public class TextFileReader extends ChessPiece {
	
	//	static int size = 8;
	//	static String blackTeam = "s";
	//	static String whiteTeam = "b";
	//	static String fileName = "board1.txt";

	//	public static String[][] chessBoard = new String[8][8];
	//	public static ChessPiece[][] chessPieceArray = new ChessPiece[8][8];
	//	public static ChessPiece[][] totalBoard = new ChessPiece[8][8];
	//	public static ChessPiece[][] onlyBlack = new ChessPiece[8][8];
	//	public static ChessPiece[][] onlyWhite = new ChessPiece[8][8];
	
	//	public TextFileReader(String piece) {
		//		super(piece);}
	
	//public static String[][] TextFileReader(String fileName) throws FileNotFoundException {
		//	File boardTextFile = new File("board1.txt");
		//	Scanner myReader = new Scanner(boardTextFile);
		//	int lineCount=0;
		//	while (myReader.hasNextLine()) {
			//	String[]  line = myReader.nextLine().trim().split(" ");
			//		for (int i=0; i<size; i++) {
					//		chessBoard[lineCount][i] = line[i];
				//}
				//lineCount ++;
			//}
			//	myReader.close();
		//	return chessBoard;
		//}
	
	//	public static ChessPiece[][] fillChessPieceArray(String fileName) throws FileNotFoundException {
		//	File boardTextFile = new File(fileName);
		//	Scanner myReader = new Scanner(boardTextFile);
		//	int lineCount=0;
		//	while (myReader.hasNextLine()) {
			//		String[]  line = myReader.nextLine().trim().split(" ");
			//			for (int i=0; i<size; i++) {
			//			chessBoard[lineCount][i] = line[i];
				//			}
				//		lineCount ++;
				//	}
		//	myReader.close();		
		
		//	for(int i=0; i<size; i++) {
		//			for(int j=0; j<size; j++) {
					//String temp = chessBoard[i][j];
					//ChessPiece c = new ChessPiece(chessBoard[i][j]);
					//				chessPieceArray[i][j] = new ChessPiece(chessBoard[i][j]);
					//				//System.out.println(chessPieceArray[i][j].getPieceTeam());
					//			}
				//		}
		//	return chessPieceArray;
		//}
	
	//public static ChessPiece[][] getBlackBoard(ChessPiece[][] board) throws FileNotFoundException { // method to get the current status of the black pieces
		//totalBoard = fillChessPieceArray(fileName);
		//	for(int i=0; i<size; i++) {
			//		for(int j=0; j<size; j++) {
				//if (blackTeam.equals(chessPieceArray[i][j].getPieceTeam())){
					//onlyBlack[i][j] = chessPieceArray[i][j];
				//		if (blackTeam.equals(board[i][j].getPieceTeam())){
					//			onlyBlack[i][j] = board[i][j];
					//			//			}
					//		else {
					//				onlyBlack[i][j] = new ChessPiece("--");
					//			}
				//		}
			//		}
			//return onlyBlack;
	//	}
	
	//	public static ChessPiece[][] getWhiteBoard(ChessPiece[][] board) throws FileNotFoundException { // method to get the current status of the white pieces
	//	totalBoard = fillChessPieceArray(fileName);
		//	for(int i=0; i<size; i++) {
			//	for(int j=0; j<size; j++) {
				//if (whiteTeam.equals(totalBoard[i][j].getPieceTeam())){
				//	onlyWhite[i][j] = totalBoard[i][j];
				//}
				//			if (whiteTeam.equals(board[i][j].getPieceTeam())){
					//				onlyWhite[i][j] = board[i][j];
					//			}
				//			else {
					//				onlyWhite[i][j] = new ChessPiece("--");
					//			}
				//			}
			//		}
		//	return onlyWhite;
	//	}
	
//	public static void main(String[] args) throws Exception {
//		ChessPiece[][] arr = fillChessPieceArray(fileName);
		//String[][] chessBoard = TextFileReader("board1.txt");
		//ChessPiece[][] arr2 = new ChessPiece[8][8];
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<size; j++) {
				//System.out.println(chessBoard[i][j]);
				//arr[i][j] = new ChessPiece(chessBoard[i][j]);
				//System.out.println(arr[i][j].getPieceTeam());
				
		//	}
//		}
//	}
//	}

//}

//}
//}