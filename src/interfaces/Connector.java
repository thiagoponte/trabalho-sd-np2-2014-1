package interfaces;

import java.io.IOException;

public interface Connector {

	/**
	 * 
	 * @param ip: IP para conexão
	 * @param port: Porta para conexão
	 */
	public void connect(String ip, int port);
	
	/**
	 * 
	 * @param message: Mensagem a ser enviada
	 * @return
	 */
	public String send(String message);
	
	/**
	 * 
	 * @return A String recebida
	 */
	public String receive();
	
	public void startServer(int port) throws IOException;
	
	public String acceptClient() throws IOException;
	
	/**
	 * 
	 */
	public void close();
	
}
