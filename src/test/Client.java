package test;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

import java.util.Random;

public class Client {
	public static void main(String[] args) {
		try {
			String ip = "localhost";
			Connector client = ConnectorFactory.getConnector(ConnectorFactory.TCP);
			Connection connection = client.connect(ip, 10080);
			Random gerador = new Random();
			connection.send("coordenadas "+gerador.nextInt());
			String resposta = connection.receive();
			System.out.println(resposta);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
