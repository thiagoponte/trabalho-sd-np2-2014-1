package remote.main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remote.interfaces.Crmi;
import remote.interfaces.Srmi;

public class Server extends UnicastRemoteObject implements Srmi{
	private static final long serialVersionUID = 7261639911758219920L;

	protected Server(int port) throws RemoteException {
		super(port);
	}
	protected Server() throws RemoteException {
		super();
	}

	@Override
	public int getId(String remoteId) throws RemoteException{
		return 1;
	}
	
	@Override
	public void recebeIp(String ip, String refId) throws RemoteException {
		Registry reg = LocateRegistry.getRegistry();
		try {
			Crmi cl = (Crmi) reg.lookup(refId);
			String xy = cl.getCoordenadas();
			System.out.println(xy);
			cl.finalizarJogo("terminou o jogo");
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		startRegistry();
	}

	private static void startRegistry() {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			Srmi serv = (Srmi) new Server();
			try{
				serv = (Srmi) UnicastRemoteObject.exportObject(serv);
			} catch(Exception e2){
//				e2.printStackTrace();
			}
			reg.rebind("serverBS", serv);
			System.out.println("Battleship Server is ready.");
		} catch (Exception e) {
			System.out.println("Battleship Server failed: " + e);
			e.printStackTrace();
		}
	}
}
