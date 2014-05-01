package business;

import interfaces.Conn;
import interfaces.Connection;
import interfaces.Connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class ConnectorTCP implements Connector, Connection {
	private Socket s = null;
	private BufferedWriter os = null;
	private BufferedReader br = null;
	private ServerSocket ss = null;
	private Socket client = null;
	HashMap<String, Socket> clients;

	@Override
	public Connection connect(String ip, int port) {
		// TODO Auto-generated method stub
		try {
			s = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public String send(String message, String ip, int port) {
		String retorno = "N";
		try {
			if (ss == null) {
				os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				ip = s.getLocalAddress().getHostAddress();
				System.out.println(ip);
			} else {
				os = new BufferedWriter(new OutputStreamWriter(clients.get(ip).getOutputStream()));
			}
			os.write(ip + "|" + message + "\n");
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public String receive(String ip) {
		String str = "";
		try {
			if (ss == null) {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(clients.get(ip).getInputStream()));
			}
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public void close() {
		if (os != null) {
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Connection startServer(int port) throws IOException {
		ss = new ServerSocket(port);
		clients = new HashMap<String, Socket>();
		return this;
	}

	@Override
	public Conn acceptClient() throws IOException {
		client = ss.accept();
		Conn c = new Conn(client.getInetAddress(), client.getPort());
		clients.put(client.getInetAddress().getHostAddress(), client);
		return c;
	}

}
