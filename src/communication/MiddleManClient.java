package communication;

import java.util.LinkedHashMap;

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
		return null;
	}
}
