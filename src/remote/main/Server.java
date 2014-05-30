package remote.main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;

import remote.interfaces.Crmi;
import remote.interfaces.Srmi;
import test.IPTest;
import business.Constantes;

public class Server extends UnicastRemoteObject implements Srmi{
	private static final long serialVersionUID = 7261639911758219920L;
	private static Integer qtJogadores = 1;
	static HashMap<Integer, Crmi> team1 = new HashMap<Integer, Crmi>();
	static HashMap<Integer, Crmi> team2 = new HashMap<Integer, Crmi>();
	static HashMap<Integer, HashMap<Integer, Crmi>> teams = new HashMap<Integer, HashMap<Integer, Crmi>>();
	private static int qtPlayer = 2;
	private static String jogadas1 = "";
	private static String jogadas2 = "";
	protected Server(int port) throws RemoteException {
		super(port);
	}
	protected Server() throws RemoteException {
		super();
	}

	@Override
	public int getId(Crmi cl) throws RemoteException{
		int pID = qtJogadores;
		qtJogadores++;
		if(pID % 2 != 0){
			team1.put(pID, cl);
		}else{
			team2.put(pID, cl);
		}
		return pID;
	}
	
	@Override
	public void recebeIp(String ip, String refId) throws RemoteException {
		Registry reg = LocateRegistry.getRegistry(ip);
		try {
			Crmi cl = (Crmi) reg.lookup(refId);
			int pID = Integer.parseInt(String.valueOf(refId.charAt(refId.length()-1)));
			if(pID % 2 != 0){
				team1.put(pID, cl);
			}else{
				team2.put(pID, cl);
			}
			qtJogadores++;
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.setProperty("java.rmi.server.hostname", IPTest.findoutMyIp());
		startRegistry();
		try{
			while(qtJogadores <= qtPlayer){
				Thread.sleep(500);
			}
			LinkedHashMap<String, Integer> mapa1 = gerarMapa();
			LinkedHashMap<String, Integer> mapa2 = gerarMapa();
			for (Entry<Integer, Crmi> e : team1.entrySet()) {
				e.getValue().setMapa(mapa1);
			}
			for (Entry<Integer, Crmi> e : team2.entrySet()) {
				e.getValue().setMapa(mapa2);
			}
			teams.put(1, team1);
			teams.put(2, team2);
			boolean finished = false;
			int countPlayer = 1;
			while (!finished) {
				LinkedHashMap<String, Integer> mapa = countPlayer%2!=0?mapa2:mapa1;
				String hit = receberJogada(countPlayer, mapa);
				System.out.println(hit);
				// Terminar o jogo por desistencia de um jogador
				if (hit.contains("out")) {
					if (hit.contains("1")) {
						finalizarJogo(2, " pois a outra equipe desistiu");
					} else {
						finalizarJogo(1, " pois a outra equipe desistiu");
					}
					finished = true;
				}else{
					String coordenada = hit.split(";")[0];
					hit = hit.split(";")[1];
					if (countPlayer % 2 != 0) {
						atualizarMapas(mapa2, coordenada, hit, countPlayer);
					} else {
						atualizarMapas(mapa1, coordenada, hit, countPlayer);
					}
					if (!hit.equalsIgnoreCase("S")) {
						countPlayer++;
					}
					if (countPlayer > qtPlayer) {
						countPlayer = 1;
					}
					if (mapa1.size() == 0 || mapa2.size() == 0) {
						int team = 0;
						if (mapa1.size() == 0) {
							team = 2;
						} else {
							team = 1;
						}
						finalizarJogo(team, "");
						finished = true;
					}
				}
			}
			System.exit(0);
		} catch(Exception e){
			
		}
	}

	private static void atualizarMapas(LinkedHashMap<String, Integer> mapa,	String coordenada, String hit, int countPlayer) {
		try {
			String team = countPlayer % 2 != 0 ? "1" : "2";
			for (Entry<Integer, Crmi> e : team1.entrySet()) {
				// if(e.getKey() != playerId){
				Crmi c = e.getValue();
				c.atualizarUI(hit, coordenada, team);
				// }
			}
			for (Entry<Integer, Crmi> e : team2.entrySet()) {
				// if(e.getKey() != playerId){
				Crmi c = e.getValue();
				c.atualizarUI(hit, coordenada, team);
				// }
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}
	private static void finalizarJogo(int team, String extra) {
		final String msgVitoria = "Sua equipe ganhou" + extra + "!";
		final String msgDerrota = "Sua equipe foi derrotada!";
		HashMap<Integer, Crmi> teamVencedora = null;
		HashMap<Integer, Crmi> teamPerdedora = null;
		if (team == 1) {
			teamVencedora = team1;
			teamPerdedora = team2;
		} else {
			teamVencedora = team2;
			teamPerdedora = team1;
		}
		for (final Entry<Integer, Crmi> e : teamVencedora.entrySet()) {
			Crmi c = e.getValue();
			try {
				c.finalizarJogo(msgVitoria);
			} catch (RemoteException e1) {
			}
		}
		System.out.println("Mandou o fim dos ganhadores");
		for (final Entry<Integer, Crmi> e : teamPerdedora.entrySet()) {
			Crmi c = e.getValue();
			try {
				c.finalizarJogo(msgDerrota);
			} catch (RemoteException e1) {
			}
		}
		System.out.println("Mandou o fim dos perdedores");
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
	private static String receberJogada(int countPlayer, LinkedHashMap<String, Integer> mapa) {
		Crmi cl;
		String jogadas;
		if(countPlayer % 2 != 0){
			cl = team1.get(countPlayer);
			jogadas = jogadas1;
		}else{
			cl = team2.get(countPlayer);
			jogadas = jogadas2;
		}
		String coordenadas = "";
		String hit = "N";
		try {
			do{
				coordenadas = cl.getCoordenadas();
			} while(jogadas.contains(coordenadas) || coordenadas.indexOf("out") < -1);
			if (coordenadas.equalsIgnoreCase("out")) {
				if (team1.containsKey(countPlayer)) {
					return "out1";
				} else if (team2.containsKey(countPlayer)) {
					return "out2";
				}
			}
			jogadas += coordenadas+",";
			if(countPlayer%2!=0){
				jogadas1 = jogadas;
			}else{
				jogadas2 = jogadas;
			}
			if(mapa.containsKey(coordenadas)){
				hit = "S";
				mapa.remove(coordenadas);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return coordenadas+";"+hit;
	}
	private static LinkedHashMap<String, Integer> gerarMapa() {
		LinkedHashMap<String, Integer> mapa = new LinkedHashMap<String, Integer>();
		gerarNavio1(mapa);
		gerarNavio2(mapa);
		return mapa;
	}

	private static void gerarNavio2(LinkedHashMap<String, Integer> mapa) {
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			Random r1 = new Random();
			int x = r.nextInt(5);
			int y = r1.nextInt(5);
			while (mapa.containsKey("" + x + "" + y)) {
				r = new Random();
				r1 = new Random();
				x = r.nextInt(5);
				y = r1.nextInt(5);
			}
			while (!mapa.containsKey("" + x + "" + y)) {
				int x1 = x + 1;
				int y1 = y + 1;
				int x0 = x - 1;
				int y0 = y - 1;
				if (!mapa.containsKey("" + x + "" + y) && x0 > 0 && y0 > 0) {
					if (!mapa.containsKey("" + x + "" + y1)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x + "" + y1, Constantes.Posicao.BARCO_2.getTipo());
					} else if (!mapa.containsKey("" + x1 + "" + y)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x1 + "" + y, Constantes.Posicao.BARCO_2.getTipo());
					} else if (!mapa.containsKey("" + x + "" + y0)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x + "" + y0, Constantes.Posicao.BARCO_2.getTipo());
					} else if (!mapa.containsKey("" + x0 + "" + y)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x0 + "" + y, Constantes.Posicao.BARCO_2.getTipo());
					} else {
						r = new Random();
						r1 = new Random();
						x = r.nextInt(5);
						y = r1.nextInt(5);
						while (mapa.containsKey("" + x + "" + y)) {
							r = new Random();
							r1 = new Random();
							x = r.nextInt(5);
							y = r1.nextInt(5);
						}
					}
				} else {
					r = new Random();
					r1 = new Random();
					x = r.nextInt(5);
					y = r1.nextInt(5);
					while (mapa.containsKey("" + x + "" + y)) {
						r = new Random();
						r1 = new Random();
						x = r.nextInt(5);
						y = r1.nextInt(5);
					}
				}
			}
		}
	}

	private static void gerarNavio1(LinkedHashMap<String, Integer> mapa) {
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			Random r1 = new Random();
			int x = r.nextInt(5);
			int y = r1.nextInt(5);
			while (mapa.containsKey("" + x + "" + y)) {
				r = new Random();
				r1 = new Random();
				x = r.nextInt(5);
				y = r1.nextInt(5);
			}
			mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_1.getTipo());
		}
	}
}
