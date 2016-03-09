package ttt;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Game {
	TTTService ttt;
	final int registryPort = 8080;
	Scanner keyboardSc;
	int winner = 0;
	int player = 1;

	public Game() throws Exception {
		ttt = (TTTService) Naming.lookup("//localhost:" + registryPort + "/TTT");
		System.out.println("Found server");

		keyboardSc = new Scanner(System.in);
	}

	public int readPlay() {
		int play;
		do {
			System.out.printf("\nPlayer %d, please enter the number of the square " + "where you want to place your %c (or 0 to refresh the board): \n", player, (player == 1) ? 'X' : 'O');
			play = keyboardSc.nextInt();
		} while (play > 10 || play < 0);
		return play;
	}

	public void playGame() throws RemoteException {
		int play;
		boolean playAccepted;

		do {
			player = ++player % 2;
			do {
				System.out.println(ttt.currentBoard());
				play = readPlay();
				
				if (play == 10) {
					playAccepted = ttt.randomPlay(player);
					if (!playAccepted)
						System.out.println("Invalid play! Try again.");
				} else if (play != 0) {
					playAccepted = ttt.play(--play / 3, play % 3, player);
					if (!playAccepted)
						System.out.println("Invalid play! Try again.");
				} else
					playAccepted = false;
			
			} while (!playAccepted);
			winner = ttt.checkWinner();
		} while (winner == -1);
	}

	public void congratulate() {
		if (winner == 2)
			System.out.printf("\nHow boring, it is a draw\n");
		else
			System.out.printf("\nCongratulations, player %d, YOU ARE THE WINNER!\n", winner);
	}

	public static void main(String[] args) throws Exception {
		Game g = new Game();
		g.playGame();
		g.congratulate();
	}
}
