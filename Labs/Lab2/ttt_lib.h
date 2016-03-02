#ifndef TTT_LIB_H
#define TTT_LIB_H

#define MAX_BUFFER_LEN 100

void currentBoard(char *buffer);
int play(int row, int column, int player);
int checkWinner();

#endif
