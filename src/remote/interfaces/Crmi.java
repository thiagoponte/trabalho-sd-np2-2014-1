/**
 * 
 */
package remote.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * @author Argeu
 *
 */
public interface Crmi extends Remote {
	String getCoordenadas() throws RemoteException;
	void atualizarUI(String hit, String coordenada, int playerId) throws RemoteException;
	void finalizarJogo(String msg) throws RemoteException;
	void setMapa(HashMap<String, Integer> mapa) throws RemoteException;
}
