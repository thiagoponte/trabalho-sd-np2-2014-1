package test;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPTest {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				NetworkInterface ni = nis.nextElement();
				System.out.println(ni.getDisplayName());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
