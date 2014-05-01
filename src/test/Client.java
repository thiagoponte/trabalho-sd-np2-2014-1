package test;

import java.util.Random;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

public class Client {
	public static void main(String[] args) {
		try {
			String ip = "localhost";
			Connector client = ConnectorFactory.getConnector(ConnectorFactory.UDP);
			Connection connection = client.connect(ip, 10080);
			Random gerador = new Random();
			connection.send("coordenadas "+gerador.nextInt(), ip, 10080);
			String resposta = connection.receive(ip);
			System.out.println(resposta);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
