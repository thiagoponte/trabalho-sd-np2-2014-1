package business;

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

public class ConnectorTCP implements Connector {
	private Socket s = null;
	private BufferedWriter os = null;
	private BufferedReader br = null;
	private ServerSocket ss = null;
	private Socket client = null;
	HashMap<String, Socket> clients;

	@Override
	public void connect(String ip, int port) {
		// TODO Auto-generated method stub
		try {
			s = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String send(String message, String ip) {
		String retorno = "N";
		try {
			if(ss == null){
				os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				ip = s.getLocalAddress().getHostAddress();
				System.out.println(ip);
			}else{
				os = new BufferedWriter(new OutputStreamWriter(clients.get(ip).getOutputStream()));
			}
			os.write(ip+"|"+message+"\n");
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
			if(ss == null){
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			}else{
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
	public void startServer(int port) throws IOException {
		ss = new ServerSocket(port);
		clients = new HashMap<String, Socket>();
	}

	@Override
	public String acceptClient() throws IOException {
		client = ss.accept();
		clients.put(client.getInetAddress().getHostAddress(), client);
		return client.getInetAddress().getHostAddress();
	}

}
