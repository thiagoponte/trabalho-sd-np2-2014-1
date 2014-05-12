package main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;

import business.Constantes;

import communication.MiddleManServer;

public class Server {
	public static void main(String[] args) {
		MiddleManServer mms = new MiddleManServer();
		System.out.println("MAPA 1--------------------------------");
		LinkedHashMap<String, Integer> mapa1 = gerarMapa();
		System.out.println("MAPA 2--------------------------------");
		LinkedHashMap<String, Integer> mapa2 = gerarMapa();
		mms.enviarMapa(mapa1, 1);
		mms.enviarMapa(mapa2, 2);
		boolean finished = false;
		while(finished){
			
		}
	}

	private static LinkedHashMap<String, Integer> gerarMapa() {
		LinkedHashMap<String, Integer> mapa = new LinkedHashMap<String, Integer>();
		gerarNavio1(mapa);
		gerarNavio2(mapa);
		printMap(mapa);
		return mapa;
	}

	private static void printMap(HashMap<String, Integer> mapa) {
		for (Entry<String, Integer> entry : mapa.entrySet()) {
			System.out.println(entry.getKey()+" - > "+entry.getValue());
		}
		
	}

	private static void gerarNavio2(LinkedHashMap<String, Integer> mapa) {
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			Random r1 = new Random();
			int x = r.nextInt(5);
			int y = r1.nextInt(5);
			while(mapa.containsKey(""+x+""+y)){
				r = new Random();
				r1 = new Random();
				x = r.nextInt(5);
				y = r1.nextInt(5);
			}
			while(!mapa.containsKey(""+x+""+y)){
				int x1= x+1;
				int y1= y+1;
				if(!mapa.containsKey(""+x+""+y)){
					if(!mapa.containsKey(""+x+""+y1)){
						mapa.put(""+x+""+y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put(""+x+""+y1, Constantes.Posicao.BARCO_2.getTipo());
					}else if(!mapa.containsKey(""+x1+""+y)){
						mapa.put(""+x+""+y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put(""+x1+""+y, Constantes.Posicao.BARCO_2.getTipo());
					}
				}else{
					r = new Random();
					r1 = new Random();
					x = r.nextInt(5);
					y = r1.nextInt(5);
				}
			}
		}
		
	}

	private static void gerarNavio1(LinkedHashMap<String, Integer> mapa) {
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			Random r1 = new Random();
			int x = r.nextInt(5);
			int y = r1.nextInt(5);
			while(mapa.containsKey(""+x+""+y)){
				r = new Random();  
				r1 = new Random(); 
				x = r.nextInt(5);  
				y = r1.nextInt(5); 
			}
			mapa.put(""+x+""+y, Constantes.Posicao.BARCO_1.getTipo());
		}
		
	}
}
