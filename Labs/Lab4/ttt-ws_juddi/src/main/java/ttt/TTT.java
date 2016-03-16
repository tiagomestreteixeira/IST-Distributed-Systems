package ttt;

import javax.jws.WebService;

@WebService
public interface TTT {
	String currentBoard();

	boolean play(int row, int column, int player);

	int checkWinner();
}
