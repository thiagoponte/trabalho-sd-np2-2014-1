package communication;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

import java.io.IOException;
import java.util.LinkedHashMap;

public class MiddleManClient {
	private Connection connection;
	private Connector client;

	public int conectar(String ip) {
		try {
			this.client = ConnectorFactory.getConnector(ConnectorFactory.UDP);
			this.connection = client.connect(ip, 10080);
			String id = connection.recieve();
			return Integer.parseInt(id);
		} catch (Exception e) {

		}
		return -1;
	}

	public LinkedHashMap<String, Integer> receberMapa() throws IOException {
		String msg = connection.recieve();
		System.out.println(msg);
		String[] coordenadas = msg.split(",");
		LinkedHashMap<String, Integer> mapa = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < coordenadas.length; i++) {
			String xy = coordenadas[i].split("\\|")[0];
			String barco = coordenadas[i].split("\\|")[1];
			mapa.put(xy, Integer.parseInt(barco));
		}
		return mapa;
	}

	public String enviarCoordenadas(String coordenada, int id) {
		// String msg = id+"\\|"+coordenada;
		connection.send(coordenada);
		return null;
	}

	public String enviarMensagem(String msg) {
		connection.send(msg);
		return null;
	}

	public String recebe() throws IOException {
		String msg = connection.recieve();
		return msg;

	}

	public void fechar() {
		connection.close();
	}

	public boolean fechado() {
		return connection.isClosed();
	}
}
