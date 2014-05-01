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
			while(countConnection < 4){
				String ip = connection.acceptClient();
				countConnection++;
				String msg = connection.receive(ip);
				j.put(ip+" - conn-"+countConnection, msg);
				connection.send("recebi as suas coordenadas, player-"+countConnection+".", ip);
			}
			for (Entry<String,Object> entry : j.entrySet()) {
				System.out.println("Key: "+entry.getKey());
				System.out.println("Value: "+entry.getValue());
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
