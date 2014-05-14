package test;

import factory.ConnectorFactory;
import interfaces.Connection;
import interfaces.Connector;

import java.util.HashMap;
import java.util.Map.Entry;

public class Server {
	public static void main(String[] args) {
		Connector server;
		try {
			HashMap<String, Object> j = new HashMap<String, Object>();
			server = ConnectorFactory.getConnector(ConnectorFactory.TCP);
			Connection connection = server.startServer(10080);
			int countConnection = 0;
			while (countConnection < 1) {
				Connection c = connection.acceptClient();
				countConnection++;
				String msg = connection.recieve();
				j.put(c.getIp().getHostAddress(), c);
				connection.send("recebi as suas coordenadas, player-" + countConnection + ".");
				System.out.println(c.getIp().getHostAddress());
				System.out.println("Jogada do player-"+countConnection+": "+msg);
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
