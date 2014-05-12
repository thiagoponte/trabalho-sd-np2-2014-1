package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import business.Constantes;

import communication.MiddleManClient;

public class Client{
	private static JFrame frame;
	private static LinkedHashMap<String, Integer> coordenadas;
	private static LinkedHashMap<String, JPanel> team1 = new LinkedHashMap<String, JPanel>();
	private static LinkedHashMap<String, JPanel> team2 = new LinkedHashMap<String, JPanel>();
	public static void main(String[] args) {
		try{
			MiddleManClient mmc = new MiddleManClient();
			mmc.conectar("localhost");
			coordenadas = mmc.receberCoordenadas();
			montarJanelas();
			frame.setVisible(true);
		} catch(Exception e){
			
		}
	}

	private static void montarJanelas() {
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Amigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		leftPanel.setBounds(12, 12, 401, 322);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{5, 5, 5, 5, 5, 5};
		gbl_leftPanel.rowHeights = new int[]{5, 5, 5, 5, 5, 5};
		gbl_leftPanel.columnWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				Color color = Color.CYAN;
				if(coordenadas.containsKey(""+i+""+j)){
					if(coordenadas.get(""+i+""+j).equals(Constantes.Posicao.BARCO_1.getTipo())){
						color = Color.BLACK;
					}else if(coordenadas.get(""+i+""+j).equals(Constantes.Posicao.BARCO_2.getTipo())){
						color = Color.ORANGE;
					}
				}
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 50, 50);
				panel.setBackground(color);
				GridBagConstraints contrainst = new GridBagConstraints();
				Insets inset = new Insets(0, 0, 5, 0);
				contrainst.gridx = i;
				contrainst.gridy = j;
				contrainst.ipadx = 45;
				contrainst.ipady = 45;
				contrainst.insets = inset;
				leftPanel.add(panel, contrainst);
				team1.put(""+i+""+j, panel);
			}
		}
		frame.getContentPane().add(leftPanel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Inimigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rightPanel.setBounds(425, 12, 401, 322);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[]{5, 5, 5, 5, 5, 5};                                  
		gbl_rightPanel.rowHeights = new int[]{5, 5, 5, 5, 5, 5};                                    
		gbl_rightPanel.columnWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};
		gbl_rightPanel.rowWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};   
		rightPanel.setLayout(gbl_rightPanel);
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 50, 50);
				panel.setBackground(Color.LIGHT_GRAY);
				GridBagConstraints contrainst = new GridBagConstraints();
				Insets inset = new Insets(0, 0, 5, 0);
				contrainst.gridx = i;
				contrainst.gridy = j;
				contrainst.ipadx = 45;
				contrainst.ipady = 45;
				contrainst.insets = inset;
				rightPanel.add(panel, contrainst);
				team2.put(""+i+""+j, panel);
			}
		}
		frame.getContentPane().add(rightPanel);
	}
}
