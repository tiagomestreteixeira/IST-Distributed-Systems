#include "ttt_lib.h"
#include <stdio.h>
#include <pthread.h>

/* *** GAME STATE *** */

/* The board */
static char board[3][3] = {
    {'1','2','3'},  /* Initial values are reference numbers */
    {'4','5','6'},  /* used to select a vacant square for   */
    {'7','8','9'}   /* a turn.                              */
};

/* Next player allowed to play */
static int nextPlayer = 0;
/* Number of plays so far */
static int numPlays = 0;
/* Mutex */
static pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

/* ********** */

void currentBoard(char *buffer) {
    pthread_mutex_lock(&mutex);
    /* Display the board in the provided buffer*/
    snprintf(buffer, MAX_BUFFER_LEN, "\n\n %c | %c | %c\n---+---+---\n %c | %c | %c\n---+---+---\n %c | %c | %c\n ",
        board[0][0], board[0][1], board[0][2],
        board[1][0], board[1][1], board[1][2],
        board[2][0], board[2][1], board[2][2]);
    pthread_mutex_unlock(&mutex);
}

/* Returns 0 if correct request, >0 otherwise */
int play(int row, int column, int player) {
    if (!(row >=0 && row <3 && column >= 0 && column < 3)) {
        /* outside board */
        return 1;
    }
    pthread_mutex_lock(&mutex);
    if (board[row][column] > '9') {
        /* invalid square */
        pthread_mutex_unlock(&mutex);
        return 2;
    }
    if (player != nextPlayer)  {
        /* not players turn */
        pthread_mutex_unlock(&mutex);
        return 3;
    }
    if (numPlays == 9) {
        /* no more plays left */
        pthread_mutex_unlock(&mutex);
        return 4;
    }

    board[row][column] = (player == 1) ? 'X' : 'O';  /* Insert player symbol   */
    nextPlayer = (nextPlayer + 1) % 2;
    numPlays ++;
    pthread_mutex_unlock(&mutex);
    return 0;
}

/* Returns 0 or 1 if there is a winner, 2 if there is a draw, -1 otherwise */
int checkWinner() {
    int line;
    int result = -1;

    pthread_mutex_lock(&mutex);
    /* Check for a winning line - diagonals first */
    if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
       (board[0][2] == board[1][1] && board[0][2] == board[2][0]))
    {
		if (board[1][1]=='X')
			result = 1;
		else
			result = 0;
    }
    else
    {
        /* Check rows and columns for a winning line */
        for(line = 0; line <= 2; line ++)
        {
            if((board[line][0] == board[line][1] && board[line][0] == board[line][2]))
            {
                if (board[line][0]=='X')
					result = 1;
				else
					result = 0;
				break;
            }

            if ((board[0][line] == board[1][line] && board[0][line] == board[2][line]))
            {
                if (board[0][line]=='X')
					result = 1;
				else
					result = 0;
				break;
            }
        }
    }
    if (result == -1 && numPlays == 9)
    {
        result = 2; /* A draw! */
    }
    
    pthread_mutex_unlock (&mutex);
    return result; 
}
