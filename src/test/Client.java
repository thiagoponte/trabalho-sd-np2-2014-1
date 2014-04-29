package test;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

public class Client {
	public static void main(String[] args) {
		try {
			String ip = "localhost";
			Connector client = ConnectorFactory.getConnector(ConnectorFactory.TCP);
			Connection connection = client.connect(ip, 10080);
			connection.send("coordenadas xy", ip);
			String resposta = connection.receive(ip);
			System.out.println(resposta);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
