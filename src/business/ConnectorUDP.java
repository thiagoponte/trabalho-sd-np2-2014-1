package business;

import java.io.IOException;

import interfaces.Connector;

public class ConnectorUDP implements Connector {

	@Override
	public void connect(String ip, int port) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String send(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String receive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startServer(int port) {
		// TODO Auto-generated method stub
	}

	@Override
	public String acceptClient() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
