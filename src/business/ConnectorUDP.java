package business;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;

import interfaces.Conn;
import interfaces.Connection;
import interfaces.Connector;

public class ConnectorUDP implements Connector, Connection {

	private DatagramSocket ds = null;
	private DatagramSocket ss = null;
	private ArrayList<DatagramSocket> clients = null;

	@Override
	public Connection connect(String ip, int port) {
		// TODO Auto-generated method stub
		try {
			ds = new DatagramSocket();
			ds.connect(new InetSocketAddress(ip, port));
			// Envia uma mensagem para o servidor aceitá-la
			send("Connect", ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public String send(String message, String ip, int port) {
		String retorno = "S";
		DatagramPacket pacote;
		try {
			if (ds != null) {
				pacote = new DatagramPacket(message.getBytes(), message.length(), ds.getInetAddress(), ds.getPort());
				ds.send(pacote);
			} else {
				pacote = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName(ip), port);
				ss.send(pacote);
			}
		} catch (IOException e) {
			e.printStackTrace();
			retorno = "N";
		}
		return retorno;
	}

	@Override
	public String receive(String ip) {

		String str = "";

		byte[] buffer = new byte[1000];
		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
		try {
			if (ds != null) {
				ds.receive(pacote);
			} else if (ss != null) {
				ss.receive(pacote);
			}
			str = new String(pacote.getData(), 0, pacote.getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return str;
	}

	@Override
	public void close() {
		if (ds != null) {
			ds.close();
		}
	}

	@Override
	public Connection startServer(int port) {
		try {
			ss = new DatagramSocket(port);
			clients = new ArrayList<DatagramSocket>();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public Conn acceptClient() throws IOException {
		// accept bloqueia enquanto não receber uma conexão

		byte[] buffer = new byte[1000];
		DatagramSocket c = new DatagramSocket();
		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
		try {
			if (ss != null) {
				ss.receive(pacote);
			}

			c.connect(pacote.getAddress(), pacote.getPort());
			clients.add(c);

		} catch (IOException e) {
			e.printStackTrace();
		}

		//retorna IP e porta da conexão
		Conn cn = new Conn(pacote.getAddress(), pacote.getPort());

		return cn;

	}

}
