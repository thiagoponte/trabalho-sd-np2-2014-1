package communication;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MiddleManServer {
	HashMap<Integer, Object> team1 = new HashMap<Integer, Object>();
	HashMap<Integer, Object> team2 = new HashMap<Integer, Object>();
	Connector server = null;
	Connection connection = null;
	private String jogadas1 = "";
	private String jogadas2 = "";

	public MiddleManServer(int qtPlayer) {
		try {
			this.server = ConnectorFactory.getConnector(ConnectorFactory.TCP);
			connection = server.startServer(10080);
			int playerId = 0;
			while (playerId < qtPlayer) {
				Connection c = connection.acceptClient();
				playerId++;
				c.send(playerId + "");
				if (playerId % 2 != 0) {
					team1.put(playerId, c);
				} else {
					team2.put(playerId, c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarJogada(String msg) {

	}

	public String receberJogada(int playerId, LinkedHashMap<String, Integer> mapa) throws IOException {
		Connection c = null;
		String jogada = "";
		if (team1.containsKey(playerId)) {
			c = (Connection) team1.get(playerId);
			jogada = jogadas1;
		} else if (team2.containsKey(playerId)) {
			c = (Connection) team2.get(playerId);
			jogada = jogadas2;
		}
		c.send("play");
		String coordenada = c.recieve();
		// Remove o jogador do time
		if (coordenada.equalsIgnoreCase("out")) {
			if (team1.containsKey(playerId)) {
				team1.remove(team1.get(playerId));
				return "out1";
			} else if (team2.containsKey(playerId)) {
				team2.remove(team2.get(playerId));
				return "out2";
			}
		}
		while (jogada.indexOf(coordenada) > -1) {
			c.send("play");
			coordenada = c.recieve();
		}
		jogada += coordenada + ",";
		if (team1.containsKey(playerId)) {
			jogadas1 = jogada;
		} else if (team2.containsKey(playerId)) {
			jogadas2 = jogada;
		}
		String hit = "N";
		if (mapa.containsKey(coordenada)) {
			hit = "S";
			mapa.remove(coordenada);
		}
		// c.send("update|"+hit+"|"+coordenada+"|"+playerId);
		atualizarMapas(mapa, coordenada, hit, playerId);
		return hit;
	}

	private void atualizarMapas(LinkedHashMap<String, Integer> mapa, String coordenada, String hit, int playerId) {
		String team = playerId % 2 != 0 ? "1" : "2";
		for (Entry<Integer, Object> e : team1.entrySet()) {
			// if(e.getKey() != playerId){
			Connection c = (Connection) e.getValue();
			c.send("update|" + hit + "|" + coordenada + "|" + team);
			// }
		}
		for (Entry<Integer, Object> e : team2.entrySet()) {
			// if(e.getKey() != playerId){
			Connection c = (Connection) e.getValue();
			c.send("update|" + hit + "|" + coordenada + "|" + team);
			// }
		}

	}

	public void enviarMapa(HashMap<String, Integer> mapa, int i) {
		HashMap<Integer, Object> team = null;
		if (i == 1) {
			team = team1;
		} else if (i == 2) {
			team = team2;
		}
		String coordenadas = parseMap(mapa);
		for (Entry<Integer, Object> e : team.entrySet()) {
			Connection jogador = (Connection) e.getValue();
			jogador.send(coordenadas);
		}

	}

	private String parseMap(HashMap<String, Integer> mapa) {
		String s = "";
		for (Entry<String, Integer> entry : mapa.entrySet()) {
			s += entry.getKey() + "|" + entry.getValue() + ",";
		}
		return s;
	}

	public void close() {
		connection.close();

	}

	public void finalizarJogo(int team, String extra) {
		String msgVitoria = "Sua equipe ganhou" + extra + "!";
		String msgDerrota = "Sua equipe foi derrotada!";
		HashMap<Integer, Object> teamVencedora = null;
		HashMap<Integer, Object> teamPerdedora = null;
		if (team == 1) {
			teamVencedora = team1;
			teamPerdedora = team2;
		} else {
			teamVencedora = team2;
			teamPerdedora = team1;
		}
		for (Entry<Integer, Object> e : teamVencedora.entrySet()) {
			Connection c = (Connection) e.getValue();
			c.send("fim|" + msgVitoria);
		}
		for (Entry<Integer, Object> e : teamPerdedora.entrySet()) {
			Connection c = (Connection) e.getValue();
			c.send("fim|" + msgDerrota);
		}
	}
}
