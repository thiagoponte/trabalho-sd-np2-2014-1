package communication;

import java.util.LinkedHashMap;

import business.Constantes;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

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
			mapa.put(coordenadas[i], Constantes.Posicao.BARCO.getTipo());
		}
		return mapa;
	}
}
