package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;

import business.Constantes;

import communication.MiddleManServer;

public class Server {
	public static void main(String[] args) throws IOException {
		int qtPlayer = 2;
		MiddleManServer mms = new MiddleManServer(qtPlayer);
//		System.out.println("MAPA 1--------------------------------");
		LinkedHashMap<String, Integer> mapa1 = gerarMapa();
//		System.out.println("MAPA 2--------------------------------");
		LinkedHashMap<String, Integer> mapa2 = gerarMapa();
		mms.enviarMapa(mapa1, 1);
		mms.enviarMapa(mapa2, 2);
		boolean finished = false;
		int countPlayer = 1;
		while (!finished) {
			String hit = "";
			try {
				if (countPlayer % 2 != 0) {
					hit = mms.receberJogada(countPlayer, mapa2);
				} else {
					hit = mms.receberJogada(countPlayer, mapa1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(hit);
			// Terminar o jogo por desist�ncia de um jogador
			if (hit.contains("out")) {
				if (hit.contains("1")) {
					mms.finalizarJogo(2, " pois a outra equipe desistiu");
				} else {
					mms.finalizarJogo(1, " pois a outra equipe desistiu");
				}

				finished = true;
				mms.close();
			}else{
				String coordenada = hit.split(";")[0];
				hit = hit.split(";")[1];
				if (countPlayer % 2 != 0) {
					mms.atualizarMapas(mapa2, coordenada, hit, countPlayer);
				} else {
					mms.atualizarMapas(mapa1, coordenada, hit, countPlayer);
				}
				if (!hit.equalsIgnoreCase("S")) {
					countPlayer++;
				}
				if (countPlayer > qtPlayer) {
					countPlayer = 1;
				}
				if (mapa1.size() == 0 || mapa2.size() == 0) {
					int team = 0;
					if (mapa1.size() == 0) {
						team = 2;
					} else {
						team = 1;
					}
					mms.finalizarJogo(team, "");
					finished = true;
					mms.close();
				}
			}
		}
	}

	private static LinkedHashMap<String, Integer> gerarMapa() {
		LinkedHashMap<String, Integer> mapa = new LinkedHashMap<String, Integer>();
		gerarNavio1(mapa);
		gerarNavio2(mapa);
//		printMap(mapa);
		return mapa;
	}

	@Deprecated
	private static void printMap(HashMap<String, Integer> mapa) {
		for (Entry<String, Integer> entry : mapa.entrySet()) {
			System.out.println(entry.getKey() + " - > " + entry.getValue());
		}

	}

	private static void gerarNavio2(LinkedHashMap<String, Integer> mapa) {
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			Random r1 = new Random();
			int x = r.nextInt(5);
			int y = r1.nextInt(5);
			while (mapa.containsKey("" + x + "" + y)) {
				r = new Random();
				r1 = new Random();
				x = r.nextInt(5);
				y = r1.nextInt(5);
			}
			while (!mapa.containsKey("" + x + "" + y)) {
				int x1 = x + 1;
				int y1 = y + 1;
				int x0 = x - 1;
				int y0 = y - 1;
				if (!mapa.containsKey("" + x + "" + y) && x0 > 0 && y0 > 0) {
					if (!mapa.containsKey("" + x + "" + y1)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x + "" + y1, Constantes.Posicao.BARCO_2.getTipo());
					} else if (!mapa.containsKey("" + x1 + "" + y)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x1 + "" + y, Constantes.Posicao.BARCO_2.getTipo());
					} else if (!mapa.containsKey("" + x + "" + y0)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x + "" + y0, Constantes.Posicao.BARCO_2.getTipo());
					} else if (!mapa.containsKey("" + x0 + "" + y)) {
						mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_2.getTipo());
						mapa.put("" + x0 + "" + y, Constantes.Posicao.BARCO_2.getTipo());
					} else {
						r = new Random();
						r1 = new Random();
						x = r.nextInt(5);
						y = r1.nextInt(5);
						while (mapa.containsKey("" + x + "" + y)) {
							r = new Random();
							r1 = new Random();
							x = r.nextInt(5);
							y = r1.nextInt(5);
						}
					}
				} else {
					r = new Random();
					r1 = new Random();
					x = r.nextInt(5);
					y = r1.nextInt(5);
					while (mapa.containsKey("" + x + "" + y)) {
						r = new Random();
						r1 = new Random();
						x = r.nextInt(5);
						y = r1.nextInt(5);
					}
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
			while (mapa.containsKey("" + x + "" + y)) {
				r = new Random();
				r1 = new Random();
				x = r.nextInt(5);
				y = r1.nextInt(5);
			}
			mapa.put("" + x + "" + y, Constantes.Posicao.BARCO_1.getTipo());
		}
	}
}
