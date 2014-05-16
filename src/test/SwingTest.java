package test;

import javax.swing.JOptionPane;

public class SwingTest {
	public static void main(String[] args) {
		String xy = "";
		while(xy.length() == 0){
			xy = JOptionPane.showInputDialog("Digite as coordenadas.");
			if(xy == null){
				xy = "";
			}
			System.out.println("tente novamente.");
		}
	}
}
