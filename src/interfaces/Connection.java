package interfaces;

import java.io.IOException;

public interface Connection {
	/**
	 * 
	 * @param message: Mensagem a ser enviada
	 * @param ip: endereço IP da origem
	 * @return
	 */
	public String send(String message, String ip, int port);
	
	/**
	 * Espera uma resposta do servidor e geralmente é usado após o send.
	 * @return A mensagem recebida
	 */
	public String receive(String ip);
	
	/**
	 * Aceita uma conexão do lado do servidor e deve ser usado após o método startServer
	 * @return O endereço de IP da origem.
	 * @throws IOException
	 */
	public Conn acceptClient() throws IOException;
	
	/**
	 * Encerra a conexão.
	 */
	public void close();
}
