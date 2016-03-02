/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "ttt.h"

 void
 ttt_1(char *host)
 {
 	CLIENT *clnt;

 	int player = 0;                              /* Player number - 0 or 1               */
	int go = 0;                                  /* Square selection number for turn     */
	int row = 0;                                 /* Row index for a square               */  
	int column = 0;                              /* Column index for a square            */
	int winner = -1;                              /* The winning player                   */
 	int play_res;
 	char *buffer;
 	play_args p_args;

 	clnt = clnt_create (host, TTT, V1, "udp");
 	if (clnt == NULL) {
 		clnt_pcreateerror (host);
 		exit (1);
 	}

 	/*if (result_3 == (int *) NULL) {
 		clnt_perror (clnt, "call failed");
 	}
*/

	/* The main game loop. The game continues for up to 9 turns */
	/* As long as there is no winner                            */
 	do {
		/* Get valid player square selection */
 		do {
			/* Print current board */
 			buffer = *currentboard_1(NULL,clnt);
 			if (buffer == (char *) NULL) {
 				clnt_perror (clnt, "call failed");
 			}

 			printf("%s\n", buffer);
 			free(buffer);

 			printf("\nPlayer %d, please enter the number of the square "
 				"where you want to place your %c (or 0 to refresh the board): ", player,(player==1)?'X':'O');
 			scanf(" %d", &go);

 			if (go == 0){
 				play_res = 0;
 				continue;
 			}

			row = --go/3;                                 /* Get row index of square      */
			column = go%3;                                /* Get column index of square   */

 			p_args.row = row;
 			p_args.column = column;
 			p_args.player = player;

 			play_res = *play_1(&p_args, clnt);
 			if (&play_res == (int *) NULL) {
 				clnt_perror (clnt, "call failed");
 			}

 			if (play_res != 0) {
 				switch (play_res) {
 					case 1:
 					printf("Position outside board.");
 					break;
 					case 2:
 					printf("Square already taken.");
 					break;
 					case 3:
 					printf("Not your turn.");
 					break;
 					case 4:
 					printf("Game has finished.");
 					break;
 				}
 				printf(" Try again...\n");
 			}
 		} while(play_res != 0);

 		winner = *checkwinner_1(NULL, clnt);
 		if (&winner == (int *) NULL) {
 			clnt_perror (clnt, "call failed");
 		}
		player = (player+1)%2;                           /* Select player */

 		printf("player %d\n", player);

 	} while (winner == -1);

	/* Game is over so display the final board */
 	buffer = *currentboard_1(NULL,clnt);
 	if (buffer == (char *) NULL) {
 		clnt_perror (clnt, "call failed");
 	}
 	printf("%s\n", buffer);
 	free(buffer);

	/* Display result message */
 	if(winner == 2)
 		printf("\nHow boring, it is a draw\n");
 	else
 		printf("\nCongratulations, player %d, YOU ARE THE WINNER!\n", winner);

 	clnt_destroy (clnt);
 }


 int
 main (int argc, char *argv[])
 {
 	char *host;

 	if (argc < 2) {
 		printf ("usage: %s server_host\n", argv[0]);
 		exit (1);
 	}
 	host = argv[1];
 	ttt_1 (host);
 	exit (0);
 }
