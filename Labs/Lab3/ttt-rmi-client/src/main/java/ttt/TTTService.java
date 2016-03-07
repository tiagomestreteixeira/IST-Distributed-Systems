package ttt;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface TTTService extends Remote {
    public String currentBoard() throws RemoteException;
    public boolean play(int row, int column, int player) throws RemoteException;
    public int checkWinner() throws RemoteException;
}
