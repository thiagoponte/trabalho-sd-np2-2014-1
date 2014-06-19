package remote.main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import remote.interfaces.Crmi;
import remote.interfaces.Srmi;
import test.IPTest;
import business.Constantes;

public class Client extends UnicastRemoteObject implements Crmi, ActionListener {
	private static final long serialVersionUID = 6634189107612365845L;
	private static JFrame frame;
	private static HashMap<String, Integer> coordenadas;
	private static LinkedHashMap<String, JPanel> team1 = new LinkedHashMap<String, JPanel>();
	private static LinkedHashMap<String, JPanel> team2 = new LinkedHashMap<String, JPanel>();
	private static JTextField ipAddr;
	private static JPanel leftPanel;
	private static JPanel rightPanel;
	private static JButton btnConnect;
	private static int id;
	private static boolean out;
	private boolean finished = false;
	private static boolean local;
	private static JCheckBox checkLocal;

	protected Client(int port) throws RemoteException {
		super(port);
	}

	/**
	 * Recebe a jogada do cliente
	 */
	@Override
	public String getCoordenadas() throws RemoteException {
		String coordenadas = "";
		while (coordenadas.length() != 2) {
			coordenadas = JOptionPane.showInputDialog(frame,
					"Digite as coordenadas juntas (ex. XY), " + System.getProperty("line.separator") + "jogadas informadas anteriormente "
							+ System.getProperty("line.separator") + "ser\u00E3o desconsideradas.:");
			if ((coordenadas == null) || coordenadas.equals("")) {
				coordenadas = "";
			} else {
				try {
					if (Integer.parseInt(coordenadas.charAt(1) + "") > 5 || Integer.parseInt(coordenadas.charAt(0) + "") > 5) {
						coordenadas = "";
					}
				} catch (Exception e) {
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
		if (out) {
			return "out";
		}
		return coordenadas;
	}

	/**
	 * Atualiza a GUI
	 */
	@Override
	public void atualizarUI(String hit, String coordenada, String teamID) throws RemoteException {
		Color mark = null;
		if (hit.equalsIgnoreCase("S")) {
			mark = Color.GREEN;
		} else {
			mark = Color.RED;
		}
		int team = Integer.parseInt(teamID);
		if (id % 2 != 0) {
			if (team % 2 != 0) {
				team2.get(coordenada).setBackground(mark);
			} else {
				team1.get(coordenada).setBackground(mark);
			}
		} else {
			if (team % 2 != 0) {
				team1.get(coordenada).setBackground(mark);
			} else {
				team2.get(coordenada).setBackground(mark);
			}
		}

	}

	/**
	 * Finaliza o jogo
	 */
	@Override
	public void finalizarJogo(final String msg) throws RemoteException {
		System.out.println(msg);
		finished = true;
		new Thread(new Runnable() {
			public void run() {
				if (!out) {
					JOptionPane.showMessageDialog(frame, msg);
					frame.dispose();
				}
				System.exit(0);
			}
		}).start();
	}

	/**
	 * Seta o mapa do cliente
	 */
	@Override
	public void setMapa(HashMap<String, Integer> mapa) throws RemoteException {
		coordenadas = mapa;
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
	}

	/**
	 * Atualiza a GUI
	 */
	private static void updateUI() {
		frame.repaint(12, 12, 401, 322);
		frame.revalidate();
	}

	/**
	 * Inicia o cliente
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			local = true;
			if(!local){
				
			}
			montarJanelas();
			frame.setVisible(true);
			frame.setTitle("Batalha naval");
			frame.setIconImage(ImageIO.read(new File("src/img/b2.png")));
			out = false;
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosed(java.awt.event.WindowEvent evt) {
					out = true;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
		JLabel lblLocal = new JLabel("Local: ");
		lblLocal.setBounds(22, 375, 117, 15);
		principal.add(lblLocal);
		
		checkLocal = new JCheckBox();
		try {
			checkLocal.addActionListener(new Client(0));
			checkLocal.setActionCommand("local");
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		checkLocal.setBounds(92, 375, 50, 15);
		principal.add(checkLocal);
		
		btnConnect = new JButton("Conectar");
		btnConnect.setBounds(153, 378, 117, 25);
		try {
			btnConnect.addActionListener(new Client(0));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		btnConnect.setActionCommand("conectar");
		principal.add(btnConnect);

		frame.getContentPane().add(principal);
	}

	/**
	 * Captura o clique no botão conectar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("conectar")) {
			conectar();
			btnConnect.setActionCommand("");
			ipAddr.setEditable(false);
			btnConnect.setEnabled(false);
			checkLocal.setEnabled(false);
		} else if(e.getActionCommand().equalsIgnoreCase("local")){
			local = checkLocal.isSelected();
		}

	}

	/**
	 * Conecta ao IP fornecido
	 */
	private void conectar() {
		try {
			Registry reg = LocateRegistry.getRegistry(ipAddr.getText());
			Registry regCl = reg;
			if(!local){
				System.setProperty("java.rmi.server.hostname", IPTest.findoutMyIp());
				regCl = LocateRegistry.createRegistry(1099); // usado para quando for cliente e servidor em maquinas diferentes
			}
			String ip = IPTest.findoutMyIp();
			Random r = new Random();
			int port = 0;
			do {
				port = r.nextInt(10080);
			} while (port < 1500);
			Crmi client = (Crmi) new Client(port);
			try {
				client = (Crmi) UnicastRemoteObject.exportObject(client);
			} catch (Exception e2) {
			}
			Srmi server = (Srmi) reg.lookup("serverBS");
			id = server.getId(client);
			System.out.println(ip);
			System.out.println("clientBS" + id);
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
			e.printStackTrace();
		}
	}
}