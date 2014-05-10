package main;

import java.util.LinkedHashMap;

import communication.MiddleManClient;

public class Client {
	public static void main(String[] args) {
		try{
			MiddleManClient mmc = new MiddleManClient();
			mmc.conectar("localhost");
			LinkedHashMap<String, Integer> coordenadas = mmc.receberCoordenadas();
		} catch(Exception e){
			
		}
	}
}
