package interfaces;

import java.io.IOException;
import java.net.InetAddress;

public interface Connection {
	/**
	 * 
	 * @param message: Mensagem a ser enviada
	 * @param ip: endere�o IP da origem
	 * @return
	 */
	public String send(String message);
	
	/**
	 * Espera uma resposta do servidor e geralmente � usado ap�s o send.
	 * @return A mensagem recebida
	 * @throws IOException 
	 */
	public String recieve() throws IOException;
	
	/**
	 * Aceita uma conex�o do lado do servidor e deve ser usado ap�s o m�todo startServer
	 * @return O endere�o de IP da origem.
	 * @throws IOException
	 */
	public Connection acceptClient() throws IOException;
	
	/**
	 * Encerra a conex�o.
	 */
	public void close();

	public InetAddress getIp();

	public int getPort();
	
	public boolean isClosed();
}
