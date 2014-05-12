package business;

public class Constantes {
	public static enum Posicao{
		BARCO_1(1), BARCO_2(2);
		
		private int tipo;
		
		private Posicao(int v){
			tipo = v;
		}
		
		public int getTipo(){
			return tipo;
		}
	};
}
