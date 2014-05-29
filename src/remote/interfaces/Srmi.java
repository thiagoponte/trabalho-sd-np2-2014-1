package remote.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Srmi extends Remote{
	int getId(String remoteId) throws RemoteException;
	void recebeIp(String ip, String refIp) throws RemoteException;
}
