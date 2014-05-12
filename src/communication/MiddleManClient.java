package communication;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

import java.util.LinkedHashMap;

public class MiddleManClient {
	private Connection connection;
	private Connector client;
	public void conectar(String ip){
		try{
			this.client = ConnectorFactory.getConnector(ConnectorFactory.UDP);
			this.connection = client.connect(ip, 10080);
		} catch(Exception e){
			
		}
	}
	public LinkedHashMap<String, Integer> receberCoordenadas() {
		String msg = connection.receive();
		System.out.println(msg);
		String [] coordenadas = msg.split(",");
		LinkedHashMap<String, Integer> mapa = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < coordenadas.length; i++) {
			String xy = coordenadas[i].split("\\|")[0];
			String barco = coordenadas[i].split("\\|")[1];
			mapa.put(xy, Integer.parseInt(barco));
		}
		return mapa;
	}
}
