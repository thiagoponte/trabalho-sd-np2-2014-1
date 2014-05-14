package main;

import java.util.LinkedHashMap;
import java.util.Scanner;

import business.Constantes;

import communication.MiddleManClient;

public class SimpleClient {
	private static LinkedHashMap<String, Integer> coordenadas;
	private static String [][] team1 = new String [6][6];
	private static String [][] team2 = new String [6][6];
	private static MiddleManClient mmc;
	private static int id;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mmc = new MiddleManClient();
		String ip = "localhost";//sc.next();
		id = mmc.conectar(ip);
		coordenadas = mmc.receberMapa();
		montarMapas();
		boolean finished = false;
		while(!finished){
			System.out.println("Mapa aliados:");
			printarMapa(team1);
			System.out.println("Mapa inimigos:");
			printarMapa(team2);
			System.out.println();
			String comando = mmc.recebe();
			switch(comando.split("\\|")[0]){
			case "play":
				System.out.println("Digite as coordenadas juntas (ex. XY):");
				String coordenada = sc.next();
				mmc.enviarCoordenadas(coordenada, id);
				break;
			case "update":
				String mark = "";
				if(comando.indexOf('S') > -1){
					mark = "O |";
				}else{
					mark = "X |";
				}
//				String xx = comando.split("\\|")[2].split("")[0];
//				String yy = comando.split("\\|")[2].split("")[1];
//				System.out.println(comando);
//				System.out.println(comando.split("\\|")[2].split("")[2]);
//				System.out.println(xx);
//				System.out.println(yy);
				int x = Integer.parseInt(comando.split("\\|")[2].split("")[1]);
				int y = Integer.parseInt(comando.split("\\|")[2].split("")[2]);
				int team = Integer.parseInt(comando.split("\\|")[3]);
				if(team % 2 != 0){
					team2[x][y] = mark;
				}else{
					team1[x][y] = mark;
				}
				break;
			case "fim":
				System.out.println(comando.split("\\|")[1]);
				finished = true;
				break;
			}
		}
		sc.close();
	}
	private static void montarMapas() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				team2[i][j] = "? |";
				if(coordenadas.containsKey(""+i+""+j)){
					if(coordenadas.get(""+i+""+j).equals(Constantes.Posicao.BARCO_1.getTipo())){
						team1[i][j] = ("B1|");
					}else if(coordenadas.get(""+i+""+j).equals(Constantes.Posicao.BARCO_2.getTipo())){
						team1[i][j] = ("B2|");
					}
				}else{
					team1[i][j] = ("A |");
				}
			}
		}
	}
	private static void printarMapa(String [] [] mapa) {
		System.out.print("   ");
		for (int i = 0; i < 6; i++) {
			System.out.print(i+"  ");
			
		}
		System.out.println();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(j == 0){
					System.out.print(i+"| ");
				}
				System.out.print(mapa[i][j]);
			}
			System.out.println();
		}
	}
}
