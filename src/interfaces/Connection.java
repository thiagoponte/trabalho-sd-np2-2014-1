package interfaces;

import java.io.IOException;
import java.net.InetAddress;

public interface Connection {
	/**
	 * 
	 * @param message: Mensagem a ser enviada
	 * @param ip: endereço IP da origem
	 * @return
	 */
	public String send(String message);
	
	/**
	 * Espera uma resposta do servidor e geralmente é usado após o send.
	 * @return A mensagem recebida
	 * @throws IOException 
	 */
	public String receive() throws IOException;
	
	/**
	 * Aceita uma conexão do lado do servidor e deve ser usado após o método startServer
	 * @return O endereço de IP da origem.
	 * @throws IOException
	 */
	public Connection acceptClient() throws IOException;
	
	/**
	 * Encerra a conexão.
	 */
	public void close();

	public InetAddress getIp();

	public int getPort();
}
