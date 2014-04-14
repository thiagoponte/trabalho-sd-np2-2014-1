package factory;

import interfaces.Connector;
import business.ConnectorTCP;
import business.ConnectorUDP;

public class ConnectorFactory {
	public static int TCP = 1;
	public static int UDP = 2;
	
	public static Connector getConnector(int type) throws Exception{
		Connector c = null;
		if(type == TCP){
			c = new ConnectorTCP();
		}else if(type == UDP){
			c = new ConnectorUDP();
		}else{
			throw new Exception("Not a valid connector type");
		}
		return c;
	}
	
}
