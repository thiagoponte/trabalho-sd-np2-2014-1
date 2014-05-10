package business;

public class Constantes {
	public static enum Posicao{
		BARCO(1), AGUA(2);
		
		private int tipo;
		
		private Posicao(int v){
			tipo = v;
		}
		
		public int getTipo(){
			return tipo;
		}
	};
}
