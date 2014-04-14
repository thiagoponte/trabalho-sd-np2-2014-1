package interfaces;

import java.io.IOException;

public interface Connector {

	/**
	 * 
	 * @param ip
	 * @param port
	 */
	public void connect(String ip, int port);
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	public String send(String message);
	
	/**
	 * 
	 * @return
	 */
	public String recieve();
	
	public void startServer(int port) throws IOException;
	
	public String acceptClient() throws IOException;
	
	/**
	 * 
	 */
	public void close();
	
}
