package test;

import factory.ConnectorFactory;
import interfaces.Conn;
import interfaces.Connection;
import interfaces.Connector;

import java.util.HashMap;
import java.util.Map.Entry;

public class Server {
	public static void main(String[] args) {
		Connector server;
		try {
			HashMap<String, Object> j = new HashMap<String, Object>();
			server = ConnectorFactory.getConnector(ConnectorFactory.UDP);
			Connection connection = server.startServer(10080);
			int countConnection = 0;
			while (countConnection < 4) {
				Conn c = connection.acceptClient();
				countConnection++;
				String msg = connection.receive(c.getIp().getHostName());
				j.put(c.getIp().getHostName() + " - conn-" + countConnection, msg);
				connection.send("recebi as suas coordenadas, player-" + countConnection + ".", c.getIp().getHostName(), c.getPort());
			}
			for (Entry<String, Object> entry : j.entrySet()) {
				System.out.println("Key: " + entry.getKey());
				System.out.println("Value: " + entry.getValue());
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
