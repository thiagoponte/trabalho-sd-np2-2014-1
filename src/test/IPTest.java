package test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IPTest {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				NetworkInterface ni = nis.nextElement();
				Enumeration<InetAddress> inets = ni.getInetAddresses();
				while(inets.hasMoreElements()){
					InetAddress inet = inets.nextElement();
					if(inet.getHostAddress().length() < 15 && !inet.getHostAddress().startsWith("127.0")){
						System.out.println(inet.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static String findoutMyIp() {
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				NetworkInterface ni = nis.nextElement();
				Enumeration<InetAddress> enu = ni.getInetAddresses();
				while(enu.hasMoreElements()){
					InetAddress inet = enu.nextElement();
					if(inet.getHostAddress().length() < 15 && !inet.getHostAddress().startsWith("127.0")){
						return (inet.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return "127.0.0.1";
	}
}
