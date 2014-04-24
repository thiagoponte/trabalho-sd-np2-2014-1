package interfaces;

import java.io.IOException;

public interface Connector {

	/**
	 * 
	 * @param ip: IP para conex�o
	 * @param port: Porta para conex�o
	 */
	public void connect(String ip, int port);
	
	/**
	 * 
	 * @param message: Mensagem a ser enviada
	 * @return
	 */
	public String send(String message, String ip);
	
	/**
	 * 
	 * @return A String recebida
	 */
	public String receive(String ip);
	
	public void startServer(int port) throws IOException;
	
	public String acceptClient() throws IOException;
	
	/**
	 * 
	 */
	public void close();

	
}
