package test;

import interfaces.Connector;
import factory.ConnectorFactory;

public class Client {
	public static void main(String[] args) {
		try {
			String ip = "172.17.9.49";
			Connector client = ConnectorFactory.getConnector(ConnectorFactory.TCP);
			client.connect(ip, 10080);
			client.send("coordenadas xy", ip);
			String resposta = client.receive(ip);
			System.out.println(resposta);
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
