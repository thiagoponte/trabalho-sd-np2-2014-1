package communication;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

import java.util.HashMap;
import java.util.Map.Entry;

public class MiddleManServer {
	HashMap<String, Object> team1 = new HashMap<String, Object>();
	HashMap<String, Object> team2 = new HashMap<String, Object>();
	Connector server = null;
	Connection connection = null;
	public MiddleManServer(){
		try {
			this.server = ConnectorFactory.getConnector(ConnectorFactory.UDP);
			connection = server.startServer(10080);
			int countConnection = 0;
			while (countConnection < 2) {
				Connection c = connection.acceptClient();
				countConnection++;
				if(countConnection % 2 != 0){
					team1.put(c.getIp().getHostAddress(), c);
				}else{
					team2.put(c.getIp().getHostAddress(), c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enviarJogada(String msg){
		
	}
	
	public void receberJogada(){
		
	}

	public void enviarMapa(HashMap<String, Integer> mapa, int i) {
		HashMap<String, Object> team = null;
		if(i == 1){
			team = team1;
		}else if(i == 2){
			team = team2;
		}
		String coordenadas = parseMap(mapa);
		for (Entry<String, Object> e : team.entrySet()) {
			Connection jogador = (Connection) e.getValue();
			jogador.send(coordenadas);
		}
		
	}

	private String parseMap(HashMap<String, Integer> mapa) {
		String s = "";
		for (Entry<String, Integer> entry : mapa.entrySet()) {
			s += entry.getKey() + "|" +entry.getValue()+ ",";
		}
		return s;
	}
}
