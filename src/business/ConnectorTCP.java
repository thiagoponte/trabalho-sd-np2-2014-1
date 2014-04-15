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

public class ConnectorTCP implements Connector {
	private Socket s = null;
	private BufferedWriter os = null;
	private BufferedReader br = null;
	private ServerSocket ss = null;
	private Socket client = null;
	
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
	public String send(String message) {
		String retorno = "S";
		try {
			os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			os.write(message);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
			retorno = "N";
		}
		return retorno;
	}

	@Override
	public String receive() {
		String str = "";
		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public void close() {
		if(os != null){
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void startServer(int port) throws IOException {
		ss = new ServerSocket(port);
	}

	@Override
	public String acceptClient() throws IOException {
		client = ss.accept();
		return client.getLocalAddress().getHostAddress();
	}
	

}
