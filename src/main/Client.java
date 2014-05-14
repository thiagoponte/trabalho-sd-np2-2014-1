package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import business.Constantes;

import communication.MiddleManClient;

public class Client implements ActionListener, MouseListener{
	private static JFrame frame;
	private static LinkedHashMap<String, Integer> coordenadas;
	private static LinkedHashMap<String, JPanel> team1 = new LinkedHashMap<String, JPanel>();
	private static LinkedHashMap<String, JPanel> team2 = new LinkedHashMap<String, JPanel>();
	private static JTextField ipAddr;
	private static JPanel leftPanel;
	private static JPanel rightPanel;
	private static JButton btnConnect;
	private static MiddleManClient mmc;
	private static int id;
	public static void main(String[] args) {
		try{
			montarJanelas();
			frame.setVisible(true);
			frame.setTitle("Batalha naval");
			boolean finished = false;
			while(!finished){
				String comando = mmc.recebe();
				switch(comando.split("\\|")[0]){
				case "play":
					
					break;
				case "S":
				case "N":
					if(comando.split("\\|")[0].equalsIgnoreCase("S")){
						
					}
					break;
				}
			}
		} catch(Exception e){
			
		}
	}
	
	private void conectar(){
		mmc = new MiddleManClient();
		String ip = ipAddr.getText();
		id = mmc.conectar(ip);
		coordenadas = mmc.receberMapa();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				Color color = Color.BLUE;
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
				GridBagConstraints constraints = new GridBagConstraints();
				Insets inset = new Insets(0, 0, 5, 0);
				constraints.gridx = i;
				constraints.gridy = j;
				constraints.ipadx = 45;
				constraints.ipady = 45;
				constraints.insets = inset;
				leftPanel.add(panel, constraints);
				team1.put(""+i+""+j, panel);
			}
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 50, 50);
				panel.setBackground(Color.LIGHT_GRAY);
				GridBagConstraints constraints = new GridBagConstraints();
				Insets inset = new Insets(0, 0, 5, 0);
				constraints.gridx = i;
				constraints.gridy = j;
				constraints.ipadx = 45;
				constraints.ipady = 45;
				constraints.insets = inset;
				panel.addMouseListener(new Client());
				panel.setToolTipText(""+i+""+j);
				rightPanel.add(panel, constraints);
				team2.put(""+i+""+j, panel);
			}
		}
		
		updateUI();
	}

	private void updateUI() {
		frame.repaint(12, 12, 401, 322);
		frame.revalidate();
	}
	
	private static void montarJanelas() {
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Amigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		leftPanel.setBounds(12, 12, 401, 322);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{5, 5, 5, 5, 5, 5};
		gbl_leftPanel.rowHeights = new int[]{5, 5, 5, 5, 5, 5};
		gbl_leftPanel.columnWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		
		frame.getContentPane().add(leftPanel);
		
		rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Inimigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rightPanel.setBounds(425, 12, 401, 322);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[]{5, 5, 5, 5, 5, 5};                                  
		gbl_rightPanel.rowHeights = new int[]{5, 5, 5, 5, 5, 5};                                    
		gbl_rightPanel.columnWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};
		gbl_rightPanel.rowWeights = new double[]{5.0, 5.0, 5.0, 5.0, 5.0, 5.0, Double.MIN_VALUE};   
		rightPanel.setLayout(gbl_rightPanel);
		
		
		frame.getContentPane().add(rightPanel);
		
		ipAddr = new JTextField();
		ipAddr.setBounds(153, 346, 90, 19);
		frame.getContentPane().add(ipAddr);
		ipAddr.setColumns(20);
		ipAddr.setText("localhost");
		
		JLabel lblIp = new JLabel("IP Servidor: ");
		lblIp.setBounds(22, 346, 117, 15);
		frame.getContentPane().add(lblIp);
		
		btnConnect = new JButton("Connectar");
		btnConnect.setBounds(153, 366, 117, 25);
		btnConnect.addActionListener(new Client());
		btnConnect.setActionCommand("conectar");
		frame.getContentPane().add(btnConnect);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("conectar")){
			conectar();
			btnConnect.setActionCommand("");
			ipAddr.setEditable(false);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JPanel panel = ((JPanel)arg0.getSource());
		panel.removeMouseListener(new Client());
		String coordenada = panel.getToolTipText();
		String resposta = mmc.enviarCoordenadas(coordenada, id);
		Color cor = null;
		if(resposta.equals("S")){
			cor = Color.GREEN;
		}else{
			cor = Color.RED;
		}
		panel.setBackground(cor);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
