package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.print("\nOrigem: ");
				ChessPosition source = UI.readChessPosition(scanner);
				
				System.out.print("\nDestino: ");
				ChessPosition target = UI.readChessPosition(scanner);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch(ChessException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}
	}
}
