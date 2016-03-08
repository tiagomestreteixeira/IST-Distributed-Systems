package ttt;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Game {
    TTTService ttt = null;
    Scanner keyboardSc;
    int winner = 0;
    int player = 1;
    public static final int port = 8090;
    public static final String object = "ttt-galo";

    public Game(String url) {
        try{
            ttt = (TTTService) Naming.lookup(url);
            keyboardSc = new Scanner(System.in);
        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Cliente:" + e.getMessage());
        }
    }

    public int readPlay() {
        int play;
        do {
            System.out.printf("\nPlayer %d, please enter the number of the square "
                            + "where you want to place your %c (or 0 to refresh the board): \n",
                    player, (player == 1) ? 'X' : 'O');
            play = keyboardSc.nextInt();
        } while (play > 9 || play < 0);
        return play;
    }

    public void playGame() {
        int play;
        boolean playAccepted;

        try {
            do {
                player = ++player % 2;
                do {
                    System.out.println(ttt.currentBoard());
                    play = readPlay();
                    if (play != 0) {
                        playAccepted = ttt.play(--play / 3, play % 3, player);
                        if (!playAccepted)
                            System.out.println("Invalid play! Try again.");
                    } else
                        playAccepted = false;
                } while (!playAccepted);
                winner = ttt.checkWinner();
            } while (winner == -1);

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public void congratulate() {
        if (winner == 2)
            System.out.printf("\nHow boring, it is a draw\n");
        else
            System.out.printf(
                    "\nCongratulations, player %d, YOU ARE THE WINNER!\n",
                    winner);
    }

    public static void main(String[] args) {
        // Check arguments
        if (args.length < 1) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s host file%n", Game.class.getName());
            return;
        }

        String host = args[0];

        // Url string builder
        String url ="//"+host+":8090"+"/"+object;

        Game g = new Game(url);




        g.playGame();
        g.congratulate();
    }
}
