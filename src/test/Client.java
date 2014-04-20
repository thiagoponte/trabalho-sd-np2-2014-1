package test;

import interfaces.Connector;
import factory.ConnectorFactory;

public class Client {
	public static void main(String[] args) {
		try {
			Connector client = ConnectorFactory.getConnector(ConnectorFactory.UDP);
			client.connect("localhost", 10080);
			client.send("coordenadas xy");
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
