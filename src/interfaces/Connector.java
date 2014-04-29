package interfaces;

import java.io.IOException;

public interface Connector {

	/**
	 * Primeiro método a ser iniciado do lado do cliente.
	 * @param ip - IP para conexão
	 * @param port - Porta para conexão
	 */
	public Connection connect(String ip, int port);
	
	
	/**
	 * Primeiro método a ser iniciado para o lado do servidor.
	 * @param port
	 * @return
	 * @throws IOException
	 */
	public Connection startServer(int port) throws IOException;
	
	
}
