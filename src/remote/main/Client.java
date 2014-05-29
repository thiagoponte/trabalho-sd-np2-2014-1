package remote.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import javax.swing.JOptionPane;

import remote.interfaces.Crmi;
import remote.interfaces.Srmi;

public class Client extends UnicastRemoteObject implements Crmi{
	private static final long serialVersionUID = 6634189107612365845L;
	
	protected Client(int port) throws RemoteException {
		super(port);
	}

	@Override
	public String getCoordenadas() throws RemoteException{
		String xy = JOptionPane.showInputDialog("Digite as coordenadas");
		return xy;
	}

	@Override
	public void atualizarUI(String hit, String coordenada, int playerId) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarJogo(String msg) throws RemoteException{
		System.out.println(msg);
		System.exit(0);
	}

	@Override
	public void setMapa(HashMap<String, Integer> mapa) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry();
			Crmi client = (Crmi) new Client(10080);
			try{
				client = (Crmi) UnicastRemoteObject.exportObject(client);
			} catch(Exception e2){
//				e2.printStackTrace();
			}
			Srmi server = (Srmi) reg.lookup("serverBS");
			int playerId = server.getId("rmId");
			reg.rebind("clientBS"+playerId, client);
			server.recebeIp("", "clientBS"+playerId);
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
			e.printStackTrace();
		}
	}
}
