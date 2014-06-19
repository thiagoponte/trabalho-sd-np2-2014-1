package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import business.Constantes;

import communication.MiddleManClient;

public class Client implements ActionListener {
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
	private boolean finished = false;

	/**
	 * Inicia o cliente
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			montarJanelas();
			frame.setVisible(true);
			frame.setTitle("Batalha naval");
			frame.setIconImage(ImageIO.read(new File("src/img/b2.png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Faz a conex�o com o server
	 */
	private void conectar() {
		mmc = new MiddleManClient();
		String ip = ipAddr.getText();
		id = mmc.conectar(ip);
		try {
			coordenadas = mmc.receberMapa();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				Color color = Color.BLUE;
				if (coordenadas.containsKey("" + i + "" + j)) {
					if (coordenadas.get("" + i + "" + j).equals(Constantes.Posicao.BARCO_1.getTipo())) {
						color = Color.BLACK;
					} else if (coordenadas.get("" + i + "" + j).equals(Constantes.Posicao.BARCO_2.getTipo())) {
						color = Color.ORANGE;
					}
				}
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 50, 50);
				if (color.equals(Color.BLUE)) {
					BufferedImage myPicture;
					try {
						myPicture = ImageIO.read(new File("src/img/agua.jpg"));
						JLabel picLabel = new JLabel(new ImageIcon(myPicture));
						picLabel.setBounds(0, 0, 46, 46);
						panel.add(picLabel);
					} catch (IOException e) {
						panel.setBackground(color);
						e.printStackTrace();
					}
				} else if (color.equals(Color.BLACK)) {
					BufferedImage myPicture;
					try {
						myPicture = ImageIO.read(new File("src/img/b1.png"));
						JLabel picLabel = new JLabel(new ImageIcon(myPicture));
						picLabel.setBounds(0, 0, 46, 46);
						panel.add(picLabel);
					} catch (IOException e) {
						panel.setBackground(color);
						e.printStackTrace();
					}
				} else if (color.equals(Color.ORANGE)) {
					BufferedImage myPicture;
					try {
						myPicture = ImageIO.read(new File("src/img/b2.png"));
						JLabel picLabel = new JLabel(new ImageIcon(myPicture));
						picLabel.setBounds(0, 0, 46, 45);
						panel.add(picLabel);
					} catch (IOException e) {
						panel.setBackground(color);
						e.printStackTrace();
					}
				} else {
					panel.setBackground(color);
				}
				GridBagConstraints constraints = new GridBagConstraints();
				Insets inset = new Insets(0, 0, 5, 0);
				constraints.gridx = i + 1;
				constraints.gridy = j + 1;
				constraints.ipadx = 20;
				constraints.ipady = 20;
				constraints.insets = inset;
				leftPanel.add(panel, constraints);
				team1.put("" + i + "" + j, panel);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 50, 50);
				panel.setBackground(Color.LIGHT_GRAY);
				GridBagConstraints constraints = new GridBagConstraints();
				Insets inset = new Insets(0, 0, 5, 0);
				constraints.gridx = i + 1;
				constraints.gridy = j + 1;
				constraints.ipadx = 45;
				constraints.ipady = 45;
				constraints.insets = inset;
				rightPanel.add(panel, constraints);
				team2.put("" + i + "" + j, panel);
			}
		}
		new Thread() {
			public void run() {
				while (!finished) {
					try {
						updateUI();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {

			private String jogada;

			public void run() {
				finished = false;
				while (!finished) {
					String comando = null;
					try {
						if (!mmc.fechado()) {
							comando = mmc.recebe();
						} else {
							finished = true;
							comando = "fim";
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(comando);
						finished = true;
						comando = "fim";
						break;

					}
					System.out.println(comando);
					switch (comando.split("\\|")[0]) {
					case "play":
						new Thread(
								new Runnable() {
									public void run() {
										String coordenadas = "";
										while (coordenadas.length() != 2) {
											coordenadas = JOptionPane.showInputDialog(frame,
													"Digite as coordenadas juntas (ex. XY), " + System.getProperty("line.separator")
													+ "jogadas informadas anteriormente " + System.getProperty("line.separator")
													+ "ser\u00E3o desconsideradas.:");
											if (coordenadas != null && coordenadas.equalsIgnoreCase("sair")) {
												finished = true;
												break;
											}
											if ((coordenadas == null) || coordenadas.equals("")) {
												coordenadas = "";
											} else {
												try {
													if (Integer.parseInt(coordenadas.charAt(1)+"") > 5 || Integer.parseInt(coordenadas.charAt(0)+"") > 5) {
														coordenadas = "";
													}
												} catch (Exception e) {
													e.printStackTrace();
													if (!coordenadas.equalsIgnoreCase("out")) {
														System.out.println(coordenadas);
														coordenadas = "";
													} else {
														break;
													}
												}
											}
										}
										if (coordenadas.length() == 2) {
											coordenadas = coordenadas.charAt(1) + "" + coordenadas.charAt(0);
										}
										mmc.enviarCoordenadas(coordenadas, id);
									}
								}
								).start();
						break;
					case "update":
						jogada = String.valueOf(comando);
						new Thread(){
							public void run() {
								Color mark = null;
								if (jogada.indexOf('S') > -1) {
									mark = Color.GREEN;
								} else {
									mark = Color.RED;
								}
								int team = Integer.parseInt(jogada.split("\\|")[3]);
								if (id % 2 != 0) {
									if (team % 2 != 0) {
										team2.get(jogada.split("\\|")[2]).setBackground(mark);
									} else {
										team1.get(jogada.split("\\|")[2]).setBackground(mark);
									}
								} else {
									if (team % 2 != 0) {
										team1.get(jogada.split("\\|")[2]).setBackground(mark);
									} else {
										team2.get(jogada.split("\\|")[2]).setBackground(mark);
									}
								}
								updateUI();
							};
						}.start();
						break;
					case "fim":
						System.out.println(comando.split("\\|")[1]);
						JOptionPane.showMessageDialog(frame, comando.split("\\|")[1]);
						finished = true;
						frame.dispose();
						break;
					}
				}
			};
		}.start();

	}

	/**
	 * Atualiza a GUI
	 */
	private static void updateUI() {
		frame.repaint(12, 12, 401, 322);
		frame.revalidate();
	}

	/**
	 * Monta a tela usando Swing
	 */
	private static void montarJanelas() {
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel principal = new JPanel();
		principal.setBounds(0, 0, 882, 460);
		principal.setLayout(null);

		leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Amigo", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		leftPanel.setBounds(20, 25, 405, 322);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] { 5, 5, 5, 5, 5, 5, 5 };
		gbl_leftPanel.rowHeights = new int[] { 5, 5, 5, 5, 5, 5, 5 };
		gbl_leftPanel.columnWeights = new double[] { 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0 };
		gbl_leftPanel.rowWeights = new double[] { 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0 };
		leftPanel.setLayout(gbl_leftPanel);

		for (int i = 0; i < 6; i++) {
			JLabel lbl = new JLabel(i + "");
			lbl.setBounds(0, 0, 5, 5);
			GridBagConstraints constraints = new GridBagConstraints();
			Insets inset = new Insets(0, 0, 5, 0);
			constraints.gridx = i + 1;
			constraints.gridy = 0;
			constraints.ipadx = 45;
			constraints.ipady = 45;
			constraints.insets = inset;
			leftPanel.add(lbl, constraints);

			lbl = new JLabel(i + "");
			lbl.setBounds(0, 0, 5, 5);
			constraints = new GridBagConstraints();
			inset = new Insets(0, 0, 5, 0);
			constraints.gridx = 0;
			constraints.gridy = i + 1;
			constraints.ipadx = 45;
			constraints.ipady = 45;
			constraints.insets = inset;
			leftPanel.add(lbl, constraints);
		}

		principal.add(leftPanel);

		rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Inimigo", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		rightPanel.setBounds(430, 25, 405, 322);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[] { 5, 5, 5, 5, 5, 5, 5 };
		gbl_rightPanel.rowHeights = new int[] { 5, 5, 5, 5, 5, 5, 5 };
		gbl_rightPanel.columnWeights = new double[] { 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0 };
		gbl_rightPanel.rowWeights = new double[] { 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0 };
		rightPanel.setLayout(gbl_rightPanel);

		for (int i = 0; i < 6; i++) {
			JLabel lbl = new JLabel(i + "");
			lbl.setBounds(0, 0, 5, 5);
			GridBagConstraints constraints = new GridBagConstraints();
			Insets inset = new Insets(0, 0, 5, 0);
			constraints.gridx = i + 1;
			constraints.gridy = 0;
			constraints.ipadx = 45;
			constraints.ipady = 45;
			constraints.insets = inset;
			rightPanel.add(lbl, constraints);

			lbl = new JLabel(i + "");
			lbl.setBounds(0, 0, 5, 5);
			constraints = new GridBagConstraints();
			inset = new Insets(0, 0, 5, 0);
			constraints.gridx = 0;
			constraints.gridy = i + 1;
			constraints.ipadx = 45;
			constraints.ipady = 45;
			constraints.insets = inset;
			rightPanel.add(lbl, constraints);
		}

		principal.add(rightPanel);

		ipAddr = new JTextField();
		ipAddr.setBounds(153, 355, 90, 19);
		ipAddr.setColumns(20);
		ipAddr.setText("localhost");
		principal.add(ipAddr);

		JLabel lblIp = new JLabel("IP Servidor: ");
		lblIp.setBounds(22, 355, 117, 15);
		principal.add(lblIp);

		btnConnect = new JButton("Conectar");
		btnConnect.setBounds(153, 378, 117, 25);
		btnConnect.addActionListener(new Client());
		btnConnect.setActionCommand("conectar");
		principal.add(btnConnect);

		frame.getContentPane().add(principal);
	}

	/**
	 * Captura o clique no bot�o conectar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("conectar")) {
			conectar();
			btnConnect.setActionCommand("");
			ipAddr.setEditable(false);
		}

	}

}
