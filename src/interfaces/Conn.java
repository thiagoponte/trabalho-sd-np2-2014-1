package interfaces;

import java.net.InetAddress;

public class Conn {

	private InetAddress ip;
	private int port;

	public Conn(InetAddress ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public InetAddress getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
