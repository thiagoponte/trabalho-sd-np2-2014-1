package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GBL {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GBL window = new GBL();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GBL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Amigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		leftPanel.setBounds(12, 12, 401, 322);
		frame.getContentPane().add(leftPanel);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_leftPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_leftPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		/*
		 * x = column
		 * y = row
		 */
		
		JButton c0r0 = new JButton("\n");
		c0r0.setBackground(Color.GREEN);
		c0r0.setEnabled(false);
		GridBagConstraints gbc_c0r0 = new GridBagConstraints();
		gbc_c0r0.insets = new Insets(0, 0, 5, 5);
		gbc_c0r0.gridx = 0;
		gbc_c0r0.gridy = 0;
		leftPanel.add(c0r0, gbc_c0r0);
		
		JButton button_8 = new JButton("\n");
		button_8.setEnabled(false);
		button_8.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 1;
		gbc_button_8.gridy = 0;
		leftPanel.add(button_8, gbc_button_8);
		
		JButton button_17 = new JButton("\n");
		button_17.setEnabled(false);
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 5);
		gbc_button_17.gridx = 2;
		gbc_button_17.gridy = 0;
		leftPanel.add(button_17, gbc_button_17);
		
		JButton button_27 = new JButton("\n");
		button_27.setEnabled(false);
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 3;
		gbc_button_27.gridy = 0;
		leftPanel.add(button_27, gbc_button_27);
		
		JButton button_49 = new JButton("\n");
		button_49.setEnabled(false);
		GridBagConstraints gbc_button_49 = new GridBagConstraints();
		gbc_button_49.insets = new Insets(0, 0, 5, 5);
		gbc_button_49.gridx = 4;
		gbc_button_49.gridy = 0;
		leftPanel.add(button_49, gbc_button_49);
		
		JButton button_50 = new JButton("\n");
		button_50.setEnabled(false);
		GridBagConstraints gbc_button_50 = new GridBagConstraints();
		gbc_button_50.insets = new Insets(0, 0, 5, 5);
		gbc_button_50.gridx = 5;
		gbc_button_50.gridy = 0;
		leftPanel.add(button_50, gbc_button_50);
		
		JButton button_51 = new JButton("\n");
		button_51.setEnabled(false);
		GridBagConstraints gbc_button_51 = new GridBagConstraints();
		gbc_button_51.insets = new Insets(0, 0, 5, 5);
		gbc_button_51.gridx = 6;
		gbc_button_51.gridy = 0;
		leftPanel.add(button_51, gbc_button_51);
		
		JButton button_52 = new JButton("\n");
		button_52.setEnabled(false);
		GridBagConstraints gbc_button_52 = new GridBagConstraints();
		gbc_button_52.insets = new Insets(0, 0, 5, 5);
		gbc_button_52.gridx = 7;
		gbc_button_52.gridy = 0;
		leftPanel.add(button_52, gbc_button_52);
		
		JButton button_53 = new JButton("\n");
		button_53.setEnabled(false);
		GridBagConstraints gbc_button_53 = new GridBagConstraints();
		gbc_button_53.insets = new Insets(0, 0, 5, 5);
		gbc_button_53.gridx = 8;
		gbc_button_53.gridy = 0;
		leftPanel.add(button_53, gbc_button_53);
		
		JButton c9r0 = new JButton("\n");
		c9r0.setEnabled(false);
		c9r0.setBackground(Color.RED);
		GridBagConstraints gbc_c9r0 = new GridBagConstraints();
		gbc_c9r0.insets = new Insets(0, 0, 5, 0);
		gbc_c9r0.gridx = 9;
		gbc_c9r0.gridy = 0;
		leftPanel.add(c9r0, gbc_c9r0);
		
		JButton button = new JButton("\n");
		button.setEnabled(false);
		button.setBackground(Color.RED);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		leftPanel.add(button, gbc_button);
		
		JButton btnNewButton = new JButton("\n");
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		leftPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton button_18 = new JButton("\n");
		button_18.setEnabled(false);
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 2;
		gbc_button_18.gridy = 1;
		leftPanel.add(button_18, gbc_button_18);
		
		JButton button_28 = new JButton("\n");
		button_28.setEnabled(false);
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 3;
		gbc_button_28.gridy = 1;
		leftPanel.add(button_28, gbc_button_28);
		
		JButton button_54 = new JButton("\n");
		button_54.setEnabled(false);
		GridBagConstraints gbc_button_54 = new GridBagConstraints();
		gbc_button_54.insets = new Insets(0, 0, 5, 5);
		gbc_button_54.gridx = 4;
		gbc_button_54.gridy = 1;
		leftPanel.add(button_54, gbc_button_54);
		
		JButton button_62 = new JButton("\n");
		button_62.setEnabled(false);
		button_62.setBackground(Color.RED);
		GridBagConstraints gbc_button_62 = new GridBagConstraints();
		gbc_button_62.insets = new Insets(0, 0, 5, 5);
		gbc_button_62.gridx = 5;
		gbc_button_62.gridy = 1;
		leftPanel.add(button_62, gbc_button_62);
		
		JButton button_70 = new JButton("\n");
		button_70.setEnabled(false);
		GridBagConstraints gbc_button_70 = new GridBagConstraints();
		gbc_button_70.insets = new Insets(0, 0, 5, 5);
		gbc_button_70.gridx = 6;
		gbc_button_70.gridy = 1;
		leftPanel.add(button_70, gbc_button_70);
		
		JButton button_93 = new JButton("\n");
		button_93.setEnabled(false);
		GridBagConstraints gbc_button_93 = new GridBagConstraints();
		gbc_button_93.insets = new Insets(0, 0, 5, 5);
		gbc_button_93.gridx = 7;
		gbc_button_93.gridy = 1;
		leftPanel.add(button_93, gbc_button_93);
		
		JButton button_78 = new JButton("\n");
		button_78.setEnabled(false);
		button_78.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_78 = new GridBagConstraints();
		gbc_button_78.insets = new Insets(0, 0, 5, 5);
		gbc_button_78.gridx = 8;
		gbc_button_78.gridy = 1;
		leftPanel.add(button_78, gbc_button_78);
		
		JButton button_43 = new JButton("\n");
		button_43.setEnabled(false);
		GridBagConstraints gbc_button_43 = new GridBagConstraints();
		gbc_button_43.insets = new Insets(0, 0, 5, 0);
		gbc_button_43.gridx = 9;
		gbc_button_43.gridy = 1;
		leftPanel.add(button_43, gbc_button_43);
		
		JButton button_1 = new JButton("\n");
		button_1.setEnabled(false);
		button_1.setBackground(Color.RED);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 2;
		leftPanel.add(button_1, gbc_button_1);
		
		JButton button_9 = new JButton("\n");
		button_9.setEnabled(false);
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 1;
		gbc_button_9.gridy = 2;
		leftPanel.add(button_9, gbc_button_9);
		
		JButton button_19 = new JButton("\n");
		button_19.setEnabled(false);
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 2;
		gbc_button_19.gridy = 2;
		leftPanel.add(button_19, gbc_button_19);
		
		JButton button_29 = new JButton("\n");
		button_29.setEnabled(false);
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 3;
		gbc_button_29.gridy = 2;
		leftPanel.add(button_29, gbc_button_29);
		
		JButton button_55 = new JButton("\n");
		button_55.setEnabled(false);
		button_55.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_55 = new GridBagConstraints();
		gbc_button_55.insets = new Insets(0, 0, 5, 5);
		gbc_button_55.gridx = 4;
		gbc_button_55.gridy = 2;
		leftPanel.add(button_55, gbc_button_55);
		
		JButton button_63 = new JButton("\n");
		button_63.setEnabled(false);
		button_63.setBackground(Color.RED);
		GridBagConstraints gbc_button_63 = new GridBagConstraints();
		gbc_button_63.insets = new Insets(0, 0, 5, 5);
		gbc_button_63.gridx = 5;
		gbc_button_63.gridy = 2;
		leftPanel.add(button_63, gbc_button_63);
		
		JButton button_71 = new JButton("\n");
		button_71.setEnabled(false);
		GridBagConstraints gbc_button_71 = new GridBagConstraints();
		gbc_button_71.insets = new Insets(0, 0, 5, 5);
		gbc_button_71.gridx = 6;
		gbc_button_71.gridy = 2;
		leftPanel.add(button_71, gbc_button_71);
		
		JButton button_92 = new JButton("\n");
		button_92.setEnabled(false);
		GridBagConstraints gbc_button_92 = new GridBagConstraints();
		gbc_button_92.insets = new Insets(0, 0, 5, 5);
		gbc_button_92.gridx = 7;
		gbc_button_92.gridy = 2;
		leftPanel.add(button_92, gbc_button_92);
		
		JButton button_77 = new JButton("\n");
		button_77.setEnabled(false);
		button_77.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_77 = new GridBagConstraints();
		gbc_button_77.insets = new Insets(0, 0, 5, 5);
		gbc_button_77.gridx = 8;
		gbc_button_77.gridy = 2;
		leftPanel.add(button_77, gbc_button_77);
		
		JButton button_44 = new JButton("\n");
		button_44.setEnabled(false);
		GridBagConstraints gbc_button_44 = new GridBagConstraints();
		gbc_button_44.insets = new Insets(0, 0, 5, 0);
		gbc_button_44.gridx = 9;
		gbc_button_44.gridy = 2;
		leftPanel.add(button_44, gbc_button_44);
		
		JButton button_2 = new JButton("\n");
		button_2.setEnabled(false);
		button_2.setBackground(Color.RED);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 3;
		leftPanel.add(button_2, gbc_button_2);
		
		JButton button_10 = new JButton("\n");
		button_10.setEnabled(false);
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 1;
		gbc_button_10.gridy = 3;
		leftPanel.add(button_10, gbc_button_10);
		
		JButton button_20 = new JButton("\n");
		button_20.setEnabled(false);
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 2;
		gbc_button_20.gridy = 3;
		leftPanel.add(button_20, gbc_button_20);
		
		JButton button_30 = new JButton("\n");
		button_30.setEnabled(false);
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 3;
		gbc_button_30.gridy = 3;
		leftPanel.add(button_30, gbc_button_30);
		
		JButton button_56 = new JButton("\n");
		button_56.setEnabled(false);
		button_56.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_56 = new GridBagConstraints();
		gbc_button_56.insets = new Insets(0, 0, 5, 5);
		gbc_button_56.gridx = 4;
		gbc_button_56.gridy = 3;
		leftPanel.add(button_56, gbc_button_56);
		
		JButton button_64 = new JButton("\n");
		button_64.setEnabled(false);
		button_64.setBackground(Color.RED);
		GridBagConstraints gbc_button_64 = new GridBagConstraints();
		gbc_button_64.insets = new Insets(0, 0, 5, 5);
		gbc_button_64.gridx = 5;
		gbc_button_64.gridy = 3;
		leftPanel.add(button_64, gbc_button_64);
		
		JButton button_72 = new JButton("\n");
		button_72.setEnabled(false);
		button_72.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_72 = new GridBagConstraints();
		gbc_button_72.insets = new Insets(0, 0, 5, 5);
		gbc_button_72.gridx = 6;
		gbc_button_72.gridy = 3;
		leftPanel.add(button_72, gbc_button_72);
		
		JButton button_91 = new JButton("\n");
		button_91.setEnabled(false);
		GridBagConstraints gbc_button_91 = new GridBagConstraints();
		gbc_button_91.insets = new Insets(0, 0, 5, 5);
		gbc_button_91.gridx = 7;
		gbc_button_91.gridy = 3;
		leftPanel.add(button_91, gbc_button_91);
		
		JButton button_75 = new JButton("\n");
		button_75.setEnabled(false);
		button_75.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_75 = new GridBagConstraints();
		gbc_button_75.insets = new Insets(0, 0, 5, 5);
		gbc_button_75.gridx = 8;
		gbc_button_75.gridy = 3;
		leftPanel.add(button_75, gbc_button_75);
		
		JButton button_45 = new JButton("\n");
		button_45.setEnabled(false);
		GridBagConstraints gbc_button_45 = new GridBagConstraints();
		gbc_button_45.insets = new Insets(0, 0, 5, 0);
		gbc_button_45.gridx = 9;
		gbc_button_45.gridy = 3;
		leftPanel.add(button_45, gbc_button_45);
		
		JButton button_3 = new JButton("\n");
		button_3.setEnabled(false);
		button_3.setBackground(Color.RED);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 4;
		leftPanel.add(button_3, gbc_button_3);
		
		JButton button_11 = new JButton("\n");
		button_11.setEnabled(false);
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 1;
		gbc_button_11.gridy = 4;
		leftPanel.add(button_11, gbc_button_11);
		
		JButton button_21 = new JButton("\n");
		button_21.setEnabled(false);
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 2;
		gbc_button_21.gridy = 4;
		leftPanel.add(button_21, gbc_button_21);
		
		JButton button_31 = new JButton("\n");
		button_31.setEnabled(false);
		GridBagConstraints gbc_button_31 = new GridBagConstraints();
		gbc_button_31.insets = new Insets(0, 0, 5, 5);
		gbc_button_31.gridx = 3;
		gbc_button_31.gridy = 4;
		leftPanel.add(button_31, gbc_button_31);
		
		JButton button_57 = new JButton("\n");
		button_57.setEnabled(false);
		button_57.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_57 = new GridBagConstraints();
		gbc_button_57.insets = new Insets(0, 0, 5, 5);
		gbc_button_57.gridx = 4;
		gbc_button_57.gridy = 4;
		leftPanel.add(button_57, gbc_button_57);
		
		JButton button_65 = new JButton("\n");
		button_65.setEnabled(false);
		button_65.setBackground(Color.RED);
		GridBagConstraints gbc_button_65 = new GridBagConstraints();
		gbc_button_65.insets = new Insets(0, 0, 5, 5);
		gbc_button_65.gridx = 5;
		gbc_button_65.gridy = 4;
		leftPanel.add(button_65, gbc_button_65);
		
		JButton button_73 = new JButton("\n");
		button_73.setEnabled(false);
		button_73.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_73 = new GridBagConstraints();
		gbc_button_73.insets = new Insets(0, 0, 5, 5);
		gbc_button_73.gridx = 6;
		gbc_button_73.gridy = 4;
		leftPanel.add(button_73, gbc_button_73);
		
		JButton button_90 = new JButton("\n");
		button_90.setEnabled(false);
		GridBagConstraints gbc_button_90 = new GridBagConstraints();
		gbc_button_90.insets = new Insets(0, 0, 5, 5);
		gbc_button_90.gridx = 7;
		gbc_button_90.gridy = 4;
		leftPanel.add(button_90, gbc_button_90);
		
		JButton button_76 = new JButton("\n");
		button_76.setEnabled(false);
		button_76.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_76 = new GridBagConstraints();
		gbc_button_76.insets = new Insets(0, 0, 5, 5);
		gbc_button_76.gridx = 8;
		gbc_button_76.gridy = 4;
		leftPanel.add(button_76, gbc_button_76);
		
		JButton button_46 = new JButton("\n");
		button_46.setEnabled(false);
		GridBagConstraints gbc_button_46 = new GridBagConstraints();
		gbc_button_46.insets = new Insets(0, 0, 5, 0);
		gbc_button_46.gridx = 9;
		gbc_button_46.gridy = 4;
		leftPanel.add(button_46, gbc_button_46);
		
		JButton button_4 = new JButton("\n");
		button_4.setEnabled(false);
		button_4.setBackground(Color.RED);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 5;
		leftPanel.add(button_4, gbc_button_4);
		
		JButton button_12 = new JButton("\n");
		button_12.setEnabled(false);
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 1;
		gbc_button_12.gridy = 5;
		leftPanel.add(button_12, gbc_button_12);
		
		JButton button_22 = new JButton("\n");
		button_22.setEnabled(false);
		GridBagConstraints gbc_button_22 = new GridBagConstraints();
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 2;
		gbc_button_22.gridy = 5;
		leftPanel.add(button_22, gbc_button_22);
		
		JButton button_32 = new JButton("\n");
		button_32.setEnabled(false);
		GridBagConstraints gbc_button_32 = new GridBagConstraints();
		gbc_button_32.insets = new Insets(0, 0, 5, 5);
		gbc_button_32.gridx = 3;
		gbc_button_32.gridy = 5;
		leftPanel.add(button_32, gbc_button_32);
		
		JButton button_58 = new JButton("\n");
		button_58.setEnabled(false);
		button_58.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_58 = new GridBagConstraints();
		gbc_button_58.insets = new Insets(0, 0, 5, 5);
		gbc_button_58.gridx = 4;
		gbc_button_58.gridy = 5;
		leftPanel.add(button_58, gbc_button_58);
		
		JButton button_66 = new JButton("\n");
		button_66.setEnabled(false);
		GridBagConstraints gbc_button_66 = new GridBagConstraints();
		gbc_button_66.insets = new Insets(0, 0, 5, 5);
		gbc_button_66.gridx = 5;
		gbc_button_66.gridy = 5;
		leftPanel.add(button_66, gbc_button_66);
		
		JButton button_74 = new JButton("\n");
		button_74.setEnabled(false);
		button_74.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_74 = new GridBagConstraints();
		gbc_button_74.insets = new Insets(0, 0, 5, 5);
		gbc_button_74.gridx = 6;
		gbc_button_74.gridy = 5;
		leftPanel.add(button_74, gbc_button_74);
		
		JButton button_89 = new JButton("\n");
		button_89.setEnabled(false);
		GridBagConstraints gbc_button_89 = new GridBagConstraints();
		gbc_button_89.insets = new Insets(0, 0, 5, 5);
		gbc_button_89.gridx = 7;
		gbc_button_89.gridy = 5;
		leftPanel.add(button_89, gbc_button_89);
		
		JButton button_79 = new JButton("\n");
		button_79.setEnabled(false);
		button_79.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_79 = new GridBagConstraints();
		gbc_button_79.insets = new Insets(0, 0, 5, 5);
		gbc_button_79.gridx = 8;
		gbc_button_79.gridy = 5;
		leftPanel.add(button_79, gbc_button_79);
		
		JButton button_47 = new JButton("\n");
		button_47.setEnabled(false);
		GridBagConstraints gbc_button_47 = new GridBagConstraints();
		gbc_button_47.insets = new Insets(0, 0, 5, 0);
		gbc_button_47.gridx = 9;
		gbc_button_47.gridy = 5;
		leftPanel.add(button_47, gbc_button_47);
		
		JButton button_5 = new JButton("\n");
		button_5.setEnabled(false);
		button_5.setBackground(Color.RED);
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 0;
		gbc_button_5.gridy = 6;
		leftPanel.add(button_5, gbc_button_5);
		
		JButton button_13 = new JButton("\n");
		button_13.setEnabled(false);
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 1;
		gbc_button_13.gridy = 6;
		leftPanel.add(button_13, gbc_button_13);
		
		JButton button_23 = new JButton("\n");
		button_23.setEnabled(false);
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 2;
		gbc_button_23.gridy = 6;
		leftPanel.add(button_23, gbc_button_23);
		
		JButton button_33 = new JButton("\n");
		button_33.setEnabled(false);
		GridBagConstraints gbc_button_33 = new GridBagConstraints();
		gbc_button_33.insets = new Insets(0, 0, 5, 5);
		gbc_button_33.gridx = 3;
		gbc_button_33.gridy = 6;
		leftPanel.add(button_33, gbc_button_33);
		
		JButton button_59 = new JButton("\n");
		button_59.setEnabled(false);
		button_59.setBackground(Color.RED);
		GridBagConstraints gbc_button_59 = new GridBagConstraints();
		gbc_button_59.insets = new Insets(0, 0, 5, 5);
		gbc_button_59.gridx = 4;
		gbc_button_59.gridy = 6;
		leftPanel.add(button_59, gbc_button_59);
		
		JButton button_67 = new JButton("\n");
		button_67.setEnabled(false);
		GridBagConstraints gbc_button_67 = new GridBagConstraints();
		gbc_button_67.insets = new Insets(0, 0, 5, 5);
		gbc_button_67.gridx = 5;
		gbc_button_67.gridy = 6;
		leftPanel.add(button_67, gbc_button_67);
		
		JButton button_83 = new JButton("\n");
		button_83.setEnabled(false);
		GridBagConstraints gbc_button_83 = new GridBagConstraints();
		gbc_button_83.insets = new Insets(0, 0, 5, 5);
		gbc_button_83.gridx = 6;
		gbc_button_83.gridy = 6;
		leftPanel.add(button_83, gbc_button_83);
		
		JButton button_88 = new JButton("\n");
		button_88.setEnabled(false);
		GridBagConstraints gbc_button_88 = new GridBagConstraints();
		gbc_button_88.insets = new Insets(0, 0, 5, 5);
		gbc_button_88.gridx = 7;
		gbc_button_88.gridy = 6;
		leftPanel.add(button_88, gbc_button_88);
		
		JButton button_87 = new JButton("\n");
		button_87.setEnabled(false);
		GridBagConstraints gbc_button_87 = new GridBagConstraints();
		gbc_button_87.insets = new Insets(0, 0, 5, 5);
		gbc_button_87.gridx = 8;
		gbc_button_87.gridy = 6;
		leftPanel.add(button_87, gbc_button_87);
		
		JButton button_48 = new JButton("\n");
		button_48.setEnabled(false);
		GridBagConstraints gbc_button_48 = new GridBagConstraints();
		gbc_button_48.insets = new Insets(0, 0, 5, 0);
		gbc_button_48.gridx = 9;
		gbc_button_48.gridy = 6;
		leftPanel.add(button_48, gbc_button_48);
		
		JButton button_6 = new JButton("\n");
		button_6.setEnabled(false);
		button_6.setBackground(Color.RED);
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 0;
		gbc_button_6.gridy = 7;
		leftPanel.add(button_6, gbc_button_6);
		
		JButton button_14 = new JButton("\n");
		button_14.setEnabled(false);
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 1;
		gbc_button_14.gridy = 7;
		leftPanel.add(button_14, gbc_button_14);
		
		JButton button_24 = new JButton("\n");
		button_24.setEnabled(false);
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 2;
		gbc_button_24.gridy = 7;
		leftPanel.add(button_24, gbc_button_24);
		
		JButton button_34 = new JButton("\n");
		button_34.setEnabled(false);
		GridBagConstraints gbc_button_34 = new GridBagConstraints();
		gbc_button_34.insets = new Insets(0, 0, 5, 5);
		gbc_button_34.gridx = 3;
		gbc_button_34.gridy = 7;
		leftPanel.add(button_34, gbc_button_34);
		
		JButton button_60 = new JButton("\n");
		button_60.setEnabled(false);
		button_60.setBackground(Color.RED);
		GridBagConstraints gbc_button_60 = new GridBagConstraints();
		gbc_button_60.insets = new Insets(0, 0, 5, 5);
		gbc_button_60.gridx = 4;
		gbc_button_60.gridy = 7;
		leftPanel.add(button_60, gbc_button_60);
		
		JButton button_68 = new JButton("\n");
		button_68.setEnabled(false);
		GridBagConstraints gbc_button_68 = new GridBagConstraints();
		gbc_button_68.insets = new Insets(0, 0, 5, 5);
		gbc_button_68.gridx = 5;
		gbc_button_68.gridy = 7;
		leftPanel.add(button_68, gbc_button_68);
		
		JButton button_84 = new JButton("\n");
		button_84.setEnabled(false);
		GridBagConstraints gbc_button_84 = new GridBagConstraints();
		gbc_button_84.insets = new Insets(0, 0, 5, 5);
		gbc_button_84.gridx = 6;
		gbc_button_84.gridy = 7;
		leftPanel.add(button_84, gbc_button_84);
		
		JButton button_85 = new JButton("\n");
		button_85.setEnabled(false);
		GridBagConstraints gbc_button_85 = new GridBagConstraints();
		gbc_button_85.insets = new Insets(0, 0, 5, 5);
		gbc_button_85.gridx = 7;
		gbc_button_85.gridy = 7;
		leftPanel.add(button_85, gbc_button_85);
		
		JButton button_86 = new JButton("\n");
		button_86.setEnabled(false);
		GridBagConstraints gbc_button_86 = new GridBagConstraints();
		gbc_button_86.insets = new Insets(0, 0, 5, 5);
		gbc_button_86.gridx = 8;
		gbc_button_86.gridy = 7;
		leftPanel.add(button_86, gbc_button_86);
		
		JButton button_42 = new JButton("\n");
		button_42.setEnabled(false);
		GridBagConstraints gbc_button_42 = new GridBagConstraints();
		gbc_button_42.insets = new Insets(0, 0, 5, 0);
		gbc_button_42.gridx = 9;
		gbc_button_42.gridy = 7;
		leftPanel.add(button_42, gbc_button_42);
		
		JButton button_7 = new JButton("\n");
		button_7.setEnabled(false);
		button_7.setBackground(Color.RED);
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 0;
		gbc_button_7.gridy = 8;
		leftPanel.add(button_7, gbc_button_7);
		
		JButton button_15 = new JButton("\n");
		button_15.setEnabled(false);
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 1;
		gbc_button_15.gridy = 8;
		leftPanel.add(button_15, gbc_button_15);
		
		JButton button_25 = new JButton("\n");
		button_25.setEnabled(false);
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 2;
		gbc_button_25.gridy = 8;
		leftPanel.add(button_25, gbc_button_25);
		
		JButton button_35 = new JButton("\n");
		button_35.setEnabled(false);
		GridBagConstraints gbc_button_35 = new GridBagConstraints();
		gbc_button_35.insets = new Insets(0, 0, 5, 5);
		gbc_button_35.gridx = 3;
		gbc_button_35.gridy = 8;
		leftPanel.add(button_35, gbc_button_35);
		
		JButton button_61 = new JButton("\n");
		button_61.setEnabled(false);
		button_61.setBackground(Color.RED);
		GridBagConstraints gbc_button_61 = new GridBagConstraints();
		gbc_button_61.insets = new Insets(0, 0, 5, 5);
		gbc_button_61.gridx = 4;
		gbc_button_61.gridy = 8;
		leftPanel.add(button_61, gbc_button_61);
		
		JButton button_69 = new JButton("\n");
		button_69.setEnabled(false);
		GridBagConstraints gbc_button_69 = new GridBagConstraints();
		gbc_button_69.insets = new Insets(0, 0, 5, 5);
		gbc_button_69.gridx = 5;
		gbc_button_69.gridy = 8;
		leftPanel.add(button_69, gbc_button_69);
		
		JButton button_80 = new JButton("\n");
		button_80.setEnabled(false);
		button_80.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_80 = new GridBagConstraints();
		gbc_button_80.insets = new Insets(0, 0, 5, 5);
		gbc_button_80.gridx = 6;
		gbc_button_80.gridy = 8;
		leftPanel.add(button_80, gbc_button_80);
		
		JButton button_81 = new JButton("\n");
		button_81.setEnabled(false);
		button_81.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_81 = new GridBagConstraints();
		gbc_button_81.insets = new Insets(0, 0, 5, 5);
		gbc_button_81.gridx = 7;
		gbc_button_81.gridy = 8;
		leftPanel.add(button_81, gbc_button_81);
		
		JButton button_82 = new JButton("\n");
		button_82.setEnabled(false);
		button_82.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_82 = new GridBagConstraints();
		gbc_button_82.insets = new Insets(0, 0, 5, 5);
		gbc_button_82.gridx = 8;
		gbc_button_82.gridy = 8;
		leftPanel.add(button_82, gbc_button_82);
		
		JButton c9r8 = new JButton("\n");
		c9r8.setEnabled(false);
		GridBagConstraints gbc_c9r8 = new GridBagConstraints();
		gbc_c9r8.insets = new Insets(0, 0, 5, 0);
		gbc_c9r8.gridx = 9;
		gbc_c9r8.gridy = 8;
		leftPanel.add(c9r8, gbc_c9r8);
		
		JButton c0r9 = new JButton("\n");
		c0r9.setBackground(Color.RED);
		c0r9.setEnabled(false);
		GridBagConstraints gbc_c0r9 = new GridBagConstraints();
		gbc_c0r9.insets = new Insets(0, 0, 0, 5);
		gbc_c0r9.gridx = 0;
		gbc_c0r9.gridy = 9;
		leftPanel.add(c0r9, gbc_c0r9);
		
		JButton button_16 = new JButton("\n");
		button_16.setEnabled(false);
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 0, 5);
		gbc_button_16.gridx = 1;
		gbc_button_16.gridy = 9;
		leftPanel.add(button_16, gbc_button_16);
		
		JButton button_26 = new JButton("\n");
		button_26.setEnabled(false);
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.insets = new Insets(0, 0, 0, 5);
		gbc_button_26.gridx = 2;
		gbc_button_26.gridy = 9;
		leftPanel.add(button_26, gbc_button_26);
		
		JButton button_36 = new JButton("\n");
		button_36.setEnabled(false);
		GridBagConstraints gbc_button_36 = new GridBagConstraints();
		gbc_button_36.insets = new Insets(0, 0, 0, 5);
		gbc_button_36.gridx = 3;
		gbc_button_36.gridy = 9;
		leftPanel.add(button_36, gbc_button_36);
		
		JButton button_37 = new JButton("\n");
		button_37.setEnabled(false);
		GridBagConstraints gbc_button_37 = new GridBagConstraints();
		gbc_button_37.insets = new Insets(0, 0, 0, 5);
		gbc_button_37.gridx = 4;
		gbc_button_37.gridy = 9;
		leftPanel.add(button_37, gbc_button_37);
		
		JButton button_38 = new JButton("\n");
		button_38.setEnabled(false);
		GridBagConstraints gbc_button_38 = new GridBagConstraints();
		gbc_button_38.insets = new Insets(0, 0, 0, 5);
		gbc_button_38.gridx = 5;
		gbc_button_38.gridy = 9;
		leftPanel.add(button_38, gbc_button_38);
		
		JButton button_39 = new JButton("\n");
		button_39.setEnabled(false);
		GridBagConstraints gbc_button_39 = new GridBagConstraints();
		gbc_button_39.insets = new Insets(0, 0, 0, 5);
		gbc_button_39.gridx = 6;
		gbc_button_39.gridy = 9;
		leftPanel.add(button_39, gbc_button_39);
		
		JButton button_40 = new JButton("\n");
		button_40.setEnabled(false);
		GridBagConstraints gbc_button_40 = new GridBagConstraints();
		gbc_button_40.insets = new Insets(0, 0, 0, 5);
		gbc_button_40.gridx = 7;
		gbc_button_40.gridy = 9;
		leftPanel.add(button_40, gbc_button_40);
		
		JButton button_41 = new JButton("\n");
		button_41.setEnabled(false);
		GridBagConstraints gbc_button_41 = new GridBagConstraints();
		gbc_button_41.insets = new Insets(0, 0, 0, 5);
		gbc_button_41.gridx = 8;
		gbc_button_41.gridy = 9;
		leftPanel.add(button_41, gbc_button_41);
		
		JButton c9r9 = new JButton("\n");
		c9r9.setEnabled(false);
		c9r9.setBackground(Color.RED);
		GridBagConstraints gbc_c9r9 = new GridBagConstraints();
		gbc_c9r9.gridx = 9;
		gbc_c9r9.gridy = 9;
		leftPanel.add(c9r9, gbc_c9r9);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Time Inimigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		rightPanel.setBounds(425, 12, 401, 322);
		frame.getContentPane().add(rightPanel);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_rightPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_rightPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_rightPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		rightPanel.setLayout(gbl_rightPanel);
		
		JButton button_94 = new JButton("\n");
		button_94.setEnabled(false);
		button_94.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_94 = new GridBagConstraints();
		gbc_button_94.insets = new Insets(0, 0, 5, 5);
		gbc_button_94.gridx = 0;
		gbc_button_94.gridy = 0;
		rightPanel.add(button_94, gbc_button_94);
		
		JButton button_95 = new JButton("\n");
		button_95.setEnabled(false);
		button_95.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_button_95 = new GridBagConstraints();
		gbc_button_95.insets = new Insets(0, 0, 5, 5);
		gbc_button_95.gridx = 1;
		gbc_button_95.gridy = 0;
		rightPanel.add(button_95, gbc_button_95);
		
		JButton button_96 = new JButton("\n");
		button_96.setEnabled(false);
		GridBagConstraints gbc_button_96 = new GridBagConstraints();
		gbc_button_96.insets = new Insets(0, 0, 5, 5);
		gbc_button_96.gridx = 2;
		gbc_button_96.gridy = 0;
		rightPanel.add(button_96, gbc_button_96);
		
		JButton button_97 = new JButton("\n");
		button_97.setEnabled(false);
		GridBagConstraints gbc_button_97 = new GridBagConstraints();
		gbc_button_97.insets = new Insets(0, 0, 5, 5);
		gbc_button_97.gridx = 3;
		gbc_button_97.gridy = 0;
		rightPanel.add(button_97, gbc_button_97);
		
		JButton button_98 = new JButton("\n");
		button_98.setEnabled(false);
		GridBagConstraints gbc_button_98 = new GridBagConstraints();
		gbc_button_98.insets = new Insets(0, 0, 5, 5);
		gbc_button_98.gridx = 4;
		gbc_button_98.gridy = 0;
		rightPanel.add(button_98, gbc_button_98);
		
		JButton button_99 = new JButton("\n");
		button_99.setEnabled(false);
		GridBagConstraints gbc_button_99 = new GridBagConstraints();
		gbc_button_99.insets = new Insets(0, 0, 5, 5);
		gbc_button_99.gridx = 5;
		gbc_button_99.gridy = 0;
		rightPanel.add(button_99, gbc_button_99);
		
		JButton button_100 = new JButton("\n");
		button_100.setEnabled(false);
		GridBagConstraints gbc_button_100 = new GridBagConstraints();
		gbc_button_100.insets = new Insets(0, 0, 5, 5);
		gbc_button_100.gridx = 6;
		gbc_button_100.gridy = 0;
		rightPanel.add(button_100, gbc_button_100);
		
		JButton button_101 = new JButton("\n");
		button_101.setEnabled(false);
		GridBagConstraints gbc_button_101 = new GridBagConstraints();
		gbc_button_101.insets = new Insets(0, 0, 5, 5);
		gbc_button_101.gridx = 7;
		gbc_button_101.gridy = 0;
		rightPanel.add(button_101, gbc_button_101);
		
		JButton button_102 = new JButton("\n");
		button_102.setEnabled(false);
		GridBagConstraints gbc_button_102 = new GridBagConstraints();
		gbc_button_102.insets = new Insets(0, 0, 5, 5);
		gbc_button_102.gridx = 8;
		gbc_button_102.gridy = 0;
		rightPanel.add(button_102, gbc_button_102);
		
		JButton button_103 = new JButton("\n");
		button_103.setEnabled(false);
		button_103.setBackground(Color.RED);
		GridBagConstraints gbc_button_103 = new GridBagConstraints();
		gbc_button_103.insets = new Insets(0, 0, 5, 0);
		gbc_button_103.gridx = 9;
		gbc_button_103.gridy = 0;
		rightPanel.add(button_103, gbc_button_103);
		
		JButton button_104 = new JButton("\n");
		button_104.setEnabled(false);
		button_104.setBackground(Color.RED);
		GridBagConstraints gbc_button_104 = new GridBagConstraints();
		gbc_button_104.insets = new Insets(0, 0, 5, 5);
		gbc_button_104.gridx = 0;
		gbc_button_104.gridy = 1;
		rightPanel.add(button_104, gbc_button_104);
		
		JButton button_105 = new JButton("\n");
		button_105.setEnabled(false);
		GridBagConstraints gbc_button_105 = new GridBagConstraints();
		gbc_button_105.insets = new Insets(0, 0, 5, 5);
		gbc_button_105.gridx = 1;
		gbc_button_105.gridy = 1;
		rightPanel.add(button_105, gbc_button_105);
		
		JButton button_106 = new JButton("\n");
		button_106.setEnabled(false);
		GridBagConstraints gbc_button_106 = new GridBagConstraints();
		gbc_button_106.insets = new Insets(0, 0, 5, 5);
		gbc_button_106.gridx = 2;
		gbc_button_106.gridy = 1;
		rightPanel.add(button_106, gbc_button_106);
		
		JButton button_107 = new JButton("\n");
		button_107.setEnabled(false);
		GridBagConstraints gbc_button_107 = new GridBagConstraints();
		gbc_button_107.insets = new Insets(0, 0, 5, 5);
		gbc_button_107.gridx = 3;
		gbc_button_107.gridy = 1;
		rightPanel.add(button_107, gbc_button_107);
		
		JButton button_108 = new JButton("\n");
		button_108.setEnabled(false);
		GridBagConstraints gbc_button_108 = new GridBagConstraints();
		gbc_button_108.insets = new Insets(0, 0, 5, 5);
		gbc_button_108.gridx = 4;
		gbc_button_108.gridy = 1;
		rightPanel.add(button_108, gbc_button_108);
		
		JButton button_109 = new JButton("\n");
		button_109.setEnabled(false);
		button_109.setBackground(Color.RED);
		GridBagConstraints gbc_button_109 = new GridBagConstraints();
		gbc_button_109.insets = new Insets(0, 0, 5, 5);
		gbc_button_109.gridx = 5;
		gbc_button_109.gridy = 1;
		rightPanel.add(button_109, gbc_button_109);
		
		JButton button_110 = new JButton("\n");
		button_110.setEnabled(false);
		GridBagConstraints gbc_button_110 = new GridBagConstraints();
		gbc_button_110.insets = new Insets(0, 0, 5, 5);
		gbc_button_110.gridx = 6;
		gbc_button_110.gridy = 1;
		rightPanel.add(button_110, gbc_button_110);
		
		JButton button_111 = new JButton("\n");
		button_111.setEnabled(false);
		GridBagConstraints gbc_button_111 = new GridBagConstraints();
		gbc_button_111.insets = new Insets(0, 0, 5, 5);
		gbc_button_111.gridx = 7;
		gbc_button_111.gridy = 1;
		rightPanel.add(button_111, gbc_button_111);
		
		JButton button_112 = new JButton("\n");
		button_112.setEnabled(false);
		button_112.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_112 = new GridBagConstraints();
		gbc_button_112.insets = new Insets(0, 0, 5, 5);
		gbc_button_112.gridx = 8;
		gbc_button_112.gridy = 1;
		rightPanel.add(button_112, gbc_button_112);
		
		JButton button_113 = new JButton("\n");
		button_113.setEnabled(false);
		GridBagConstraints gbc_button_113 = new GridBagConstraints();
		gbc_button_113.insets = new Insets(0, 0, 5, 0);
		gbc_button_113.gridx = 9;
		gbc_button_113.gridy = 1;
		rightPanel.add(button_113, gbc_button_113);
		
		JButton button_114 = new JButton("\n");
		button_114.setEnabled(false);
		button_114.setBackground(Color.RED);
		GridBagConstraints gbc_button_114 = new GridBagConstraints();
		gbc_button_114.insets = new Insets(0, 0, 5, 5);
		gbc_button_114.gridx = 0;
		gbc_button_114.gridy = 2;
		rightPanel.add(button_114, gbc_button_114);
		
		JButton button_115 = new JButton("\n");
		button_115.setEnabled(false);
		GridBagConstraints gbc_button_115 = new GridBagConstraints();
		gbc_button_115.insets = new Insets(0, 0, 5, 5);
		gbc_button_115.gridx = 1;
		gbc_button_115.gridy = 2;
		rightPanel.add(button_115, gbc_button_115);
		
		JButton button_116 = new JButton("\n");
		button_116.setEnabled(false);
		GridBagConstraints gbc_button_116 = new GridBagConstraints();
		gbc_button_116.insets = new Insets(0, 0, 5, 5);
		gbc_button_116.gridx = 2;
		gbc_button_116.gridy = 2;
		rightPanel.add(button_116, gbc_button_116);
		
		JButton button_117 = new JButton("\n");
		button_117.setEnabled(false);
		GridBagConstraints gbc_button_117 = new GridBagConstraints();
		gbc_button_117.insets = new Insets(0, 0, 5, 5);
		gbc_button_117.gridx = 3;
		gbc_button_117.gridy = 2;
		rightPanel.add(button_117, gbc_button_117);
		
		JButton button_118 = new JButton("\n");
		button_118.setEnabled(false);
		button_118.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_118 = new GridBagConstraints();
		gbc_button_118.insets = new Insets(0, 0, 5, 5);
		gbc_button_118.gridx = 4;
		gbc_button_118.gridy = 2;
		rightPanel.add(button_118, gbc_button_118);
		
		JButton button_119 = new JButton("\n");
		button_119.setEnabled(false);
		button_119.setBackground(Color.RED);
		GridBagConstraints gbc_button_119 = new GridBagConstraints();
		gbc_button_119.insets = new Insets(0, 0, 5, 5);
		gbc_button_119.gridx = 5;
		gbc_button_119.gridy = 2;
		rightPanel.add(button_119, gbc_button_119);
		
		JButton button_120 = new JButton("\n");
		button_120.setEnabled(false);
		GridBagConstraints gbc_button_120 = new GridBagConstraints();
		gbc_button_120.insets = new Insets(0, 0, 5, 5);
		gbc_button_120.gridx = 6;
		gbc_button_120.gridy = 2;
		rightPanel.add(button_120, gbc_button_120);
		
		JButton button_121 = new JButton("\n");
		button_121.setEnabled(false);
		GridBagConstraints gbc_button_121 = new GridBagConstraints();
		gbc_button_121.insets = new Insets(0, 0, 5, 5);
		gbc_button_121.gridx = 7;
		gbc_button_121.gridy = 2;
		rightPanel.add(button_121, gbc_button_121);
		
		JButton button_122 = new JButton("\n");
		button_122.setEnabled(false);
		button_122.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_122 = new GridBagConstraints();
		gbc_button_122.insets = new Insets(0, 0, 5, 5);
		gbc_button_122.gridx = 8;
		gbc_button_122.gridy = 2;
		rightPanel.add(button_122, gbc_button_122);
		
		JButton button_123 = new JButton("\n");
		button_123.setEnabled(false);
		GridBagConstraints gbc_button_123 = new GridBagConstraints();
		gbc_button_123.insets = new Insets(0, 0, 5, 0);
		gbc_button_123.gridx = 9;
		gbc_button_123.gridy = 2;
		rightPanel.add(button_123, gbc_button_123);
		
		JButton button_124 = new JButton("\n");
		button_124.setEnabled(false);
		button_124.setBackground(Color.RED);
		GridBagConstraints gbc_button_124 = new GridBagConstraints();
		gbc_button_124.insets = new Insets(0, 0, 5, 5);
		gbc_button_124.gridx = 0;
		gbc_button_124.gridy = 3;
		rightPanel.add(button_124, gbc_button_124);
		
		JButton button_125 = new JButton("\n");
		button_125.setEnabled(false);
		GridBagConstraints gbc_button_125 = new GridBagConstraints();
		gbc_button_125.insets = new Insets(0, 0, 5, 5);
		gbc_button_125.gridx = 1;
		gbc_button_125.gridy = 3;
		rightPanel.add(button_125, gbc_button_125);
		
		JButton button_126 = new JButton("\n");
		button_126.setEnabled(false);
		GridBagConstraints gbc_button_126 = new GridBagConstraints();
		gbc_button_126.insets = new Insets(0, 0, 5, 5);
		gbc_button_126.gridx = 2;
		gbc_button_126.gridy = 3;
		rightPanel.add(button_126, gbc_button_126);
		
		JButton button_127 = new JButton("\n");
		button_127.setEnabled(false);
		GridBagConstraints gbc_button_127 = new GridBagConstraints();
		gbc_button_127.insets = new Insets(0, 0, 5, 5);
		gbc_button_127.gridx = 3;
		gbc_button_127.gridy = 3;
		rightPanel.add(button_127, gbc_button_127);
		
		JButton button_128 = new JButton("\n");
		button_128.setEnabled(false);
		button_128.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_128 = new GridBagConstraints();
		gbc_button_128.insets = new Insets(0, 0, 5, 5);
		gbc_button_128.gridx = 4;
		gbc_button_128.gridy = 3;
		rightPanel.add(button_128, gbc_button_128);
		
		JButton button_129 = new JButton("\n");
		button_129.setEnabled(false);
		button_129.setBackground(Color.RED);
		GridBagConstraints gbc_button_129 = new GridBagConstraints();
		gbc_button_129.insets = new Insets(0, 0, 5, 5);
		gbc_button_129.gridx = 5;
		gbc_button_129.gridy = 3;
		rightPanel.add(button_129, gbc_button_129);
		
		JButton button_130 = new JButton("\n");
		button_130.setEnabled(false);
		button_130.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_130 = new GridBagConstraints();
		gbc_button_130.insets = new Insets(0, 0, 5, 5);
		gbc_button_130.gridx = 6;
		gbc_button_130.gridy = 3;
		rightPanel.add(button_130, gbc_button_130);
		
		JButton button_131 = new JButton("\n");
		button_131.setEnabled(false);
		GridBagConstraints gbc_button_131 = new GridBagConstraints();
		gbc_button_131.insets = new Insets(0, 0, 5, 5);
		gbc_button_131.gridx = 7;
		gbc_button_131.gridy = 3;
		rightPanel.add(button_131, gbc_button_131);
		
		JButton button_132 = new JButton("\n");
		button_132.setEnabled(false);
		button_132.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_132 = new GridBagConstraints();
		gbc_button_132.insets = new Insets(0, 0, 5, 5);
		gbc_button_132.gridx = 8;
		gbc_button_132.gridy = 3;
		rightPanel.add(button_132, gbc_button_132);
		
		JButton button_133 = new JButton("\n");
		button_133.setEnabled(false);
		GridBagConstraints gbc_button_133 = new GridBagConstraints();
		gbc_button_133.insets = new Insets(0, 0, 5, 0);
		gbc_button_133.gridx = 9;
		gbc_button_133.gridy = 3;
		rightPanel.add(button_133, gbc_button_133);
		
		JButton button_134 = new JButton("\n");
		button_134.setEnabled(false);
		button_134.setBackground(Color.RED);
		GridBagConstraints gbc_button_134 = new GridBagConstraints();
		gbc_button_134.insets = new Insets(0, 0, 5, 5);
		gbc_button_134.gridx = 0;
		gbc_button_134.gridy = 4;
		rightPanel.add(button_134, gbc_button_134);
		
		JButton button_135 = new JButton("\n");
		button_135.setEnabled(false);
		GridBagConstraints gbc_button_135 = new GridBagConstraints();
		gbc_button_135.insets = new Insets(0, 0, 5, 5);
		gbc_button_135.gridx = 1;
		gbc_button_135.gridy = 4;
		rightPanel.add(button_135, gbc_button_135);
		
		JButton button_136 = new JButton("\n");
		button_136.setEnabled(false);
		GridBagConstraints gbc_button_136 = new GridBagConstraints();
		gbc_button_136.insets = new Insets(0, 0, 5, 5);
		gbc_button_136.gridx = 2;
		gbc_button_136.gridy = 4;
		rightPanel.add(button_136, gbc_button_136);
		
		JButton button_137 = new JButton("\n");
		button_137.setEnabled(false);
		GridBagConstraints gbc_button_137 = new GridBagConstraints();
		gbc_button_137.insets = new Insets(0, 0, 5, 5);
		gbc_button_137.gridx = 3;
		gbc_button_137.gridy = 4;
		rightPanel.add(button_137, gbc_button_137);
		
		JButton button_138 = new JButton("\n");
		button_138.setEnabled(false);
		button_138.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_138 = new GridBagConstraints();
		gbc_button_138.insets = new Insets(0, 0, 5, 5);
		gbc_button_138.gridx = 4;
		gbc_button_138.gridy = 4;
		rightPanel.add(button_138, gbc_button_138);
		
		JButton button_139 = new JButton("\n");
		button_139.setEnabled(false);
		button_139.setBackground(Color.RED);
		GridBagConstraints gbc_button_139 = new GridBagConstraints();
		gbc_button_139.insets = new Insets(0, 0, 5, 5);
		gbc_button_139.gridx = 5;
		gbc_button_139.gridy = 4;
		rightPanel.add(button_139, gbc_button_139);
		
		JButton button_140 = new JButton("\n");
		button_140.setEnabled(false);
		button_140.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_140 = new GridBagConstraints();
		gbc_button_140.insets = new Insets(0, 0, 5, 5);
		gbc_button_140.gridx = 6;
		gbc_button_140.gridy = 4;
		rightPanel.add(button_140, gbc_button_140);
		
		JButton button_141 = new JButton("\n");
		button_141.setEnabled(false);
		GridBagConstraints gbc_button_141 = new GridBagConstraints();
		gbc_button_141.insets = new Insets(0, 0, 5, 5);
		gbc_button_141.gridx = 7;
		gbc_button_141.gridy = 4;
		rightPanel.add(button_141, gbc_button_141);
		
		JButton button_142 = new JButton("\n");
		button_142.setEnabled(false);
		button_142.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_142 = new GridBagConstraints();
		gbc_button_142.insets = new Insets(0, 0, 5, 5);
		gbc_button_142.gridx = 8;
		gbc_button_142.gridy = 4;
		rightPanel.add(button_142, gbc_button_142);
		
		JButton button_143 = new JButton("\n");
		button_143.setEnabled(false);
		GridBagConstraints gbc_button_143 = new GridBagConstraints();
		gbc_button_143.insets = new Insets(0, 0, 5, 0);
		gbc_button_143.gridx = 9;
		gbc_button_143.gridy = 4;
		rightPanel.add(button_143, gbc_button_143);
		
		JButton button_144 = new JButton("\n");
		button_144.setEnabled(false);
		button_144.setBackground(Color.RED);
		GridBagConstraints gbc_button_144 = new GridBagConstraints();
		gbc_button_144.insets = new Insets(0, 0, 5, 5);
		gbc_button_144.gridx = 0;
		gbc_button_144.gridy = 5;
		rightPanel.add(button_144, gbc_button_144);
		
		JButton button_145 = new JButton("\n");
		button_145.setEnabled(false);
		GridBagConstraints gbc_button_145 = new GridBagConstraints();
		gbc_button_145.insets = new Insets(0, 0, 5, 5);
		gbc_button_145.gridx = 1;
		gbc_button_145.gridy = 5;
		rightPanel.add(button_145, gbc_button_145);
		
		JButton button_146 = new JButton("\n");
		button_146.setEnabled(false);
		GridBagConstraints gbc_button_146 = new GridBagConstraints();
		gbc_button_146.insets = new Insets(0, 0, 5, 5);
		gbc_button_146.gridx = 2;
		gbc_button_146.gridy = 5;
		rightPanel.add(button_146, gbc_button_146);
		
		JButton button_147 = new JButton("\n");
		button_147.setEnabled(false);
		GridBagConstraints gbc_button_147 = new GridBagConstraints();
		gbc_button_147.insets = new Insets(0, 0, 5, 5);
		gbc_button_147.gridx = 3;
		gbc_button_147.gridy = 5;
		rightPanel.add(button_147, gbc_button_147);
		
		JButton button_148 = new JButton("\n");
		button_148.setEnabled(false);
		button_148.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_148 = new GridBagConstraints();
		gbc_button_148.insets = new Insets(0, 0, 5, 5);
		gbc_button_148.gridx = 4;
		gbc_button_148.gridy = 5;
		rightPanel.add(button_148, gbc_button_148);
		
		JButton button_149 = new JButton("\n");
		button_149.setEnabled(false);
		GridBagConstraints gbc_button_149 = new GridBagConstraints();
		gbc_button_149.insets = new Insets(0, 0, 5, 5);
		gbc_button_149.gridx = 5;
		gbc_button_149.gridy = 5;
		rightPanel.add(button_149, gbc_button_149);
		
		JButton button_150 = new JButton("\n");
		button_150.setEnabled(false);
		button_150.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_150 = new GridBagConstraints();
		gbc_button_150.insets = new Insets(0, 0, 5, 5);
		gbc_button_150.gridx = 6;
		gbc_button_150.gridy = 5;
		rightPanel.add(button_150, gbc_button_150);
		
		JButton button_151 = new JButton("\n");
		button_151.setEnabled(false);
		GridBagConstraints gbc_button_151 = new GridBagConstraints();
		gbc_button_151.insets = new Insets(0, 0, 5, 5);
		gbc_button_151.gridx = 7;
		gbc_button_151.gridy = 5;
		rightPanel.add(button_151, gbc_button_151);
		
		JButton button_152 = new JButton("\n");
		button_152.setEnabled(false);
		button_152.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_152 = new GridBagConstraints();
		gbc_button_152.insets = new Insets(0, 0, 5, 5);
		gbc_button_152.gridx = 8;
		gbc_button_152.gridy = 5;
		rightPanel.add(button_152, gbc_button_152);
		
		JButton button_153 = new JButton("\n");
		button_153.setEnabled(false);
		GridBagConstraints gbc_button_153 = new GridBagConstraints();
		gbc_button_153.insets = new Insets(0, 0, 5, 0);
		gbc_button_153.gridx = 9;
		gbc_button_153.gridy = 5;
		rightPanel.add(button_153, gbc_button_153);
		
		JButton button_154 = new JButton("\n");
		button_154.setEnabled(false);
		button_154.setBackground(Color.RED);
		GridBagConstraints gbc_button_154 = new GridBagConstraints();
		gbc_button_154.insets = new Insets(0, 0, 5, 5);
		gbc_button_154.gridx = 0;
		gbc_button_154.gridy = 6;
		rightPanel.add(button_154, gbc_button_154);
		
		JButton button_155 = new JButton("\n");
		button_155.setEnabled(false);
		GridBagConstraints gbc_button_155 = new GridBagConstraints();
		gbc_button_155.insets = new Insets(0, 0, 5, 5);
		gbc_button_155.gridx = 1;
		gbc_button_155.gridy = 6;
		rightPanel.add(button_155, gbc_button_155);
		
		JButton button_156 = new JButton("\n");
		button_156.setEnabled(false);
		GridBagConstraints gbc_button_156 = new GridBagConstraints();
		gbc_button_156.insets = new Insets(0, 0, 5, 5);
		gbc_button_156.gridx = 2;
		gbc_button_156.gridy = 6;
		rightPanel.add(button_156, gbc_button_156);
		
		JButton button_157 = new JButton("\n");
		button_157.setEnabled(false);
		GridBagConstraints gbc_button_157 = new GridBagConstraints();
		gbc_button_157.insets = new Insets(0, 0, 5, 5);
		gbc_button_157.gridx = 3;
		gbc_button_157.gridy = 6;
		rightPanel.add(button_157, gbc_button_157);
		
		JButton button_158 = new JButton("\n");
		button_158.setEnabled(false);
		button_158.setBackground(Color.RED);
		GridBagConstraints gbc_button_158 = new GridBagConstraints();
		gbc_button_158.insets = new Insets(0, 0, 5, 5);
		gbc_button_158.gridx = 4;
		gbc_button_158.gridy = 6;
		rightPanel.add(button_158, gbc_button_158);
		
		JButton button_159 = new JButton("\n");
		button_159.setEnabled(false);
		GridBagConstraints gbc_button_159 = new GridBagConstraints();
		gbc_button_159.insets = new Insets(0, 0, 5, 5);
		gbc_button_159.gridx = 5;
		gbc_button_159.gridy = 6;
		rightPanel.add(button_159, gbc_button_159);
		
		JButton button_160 = new JButton("\n");
		button_160.setEnabled(false);
		GridBagConstraints gbc_button_160 = new GridBagConstraints();
		gbc_button_160.insets = new Insets(0, 0, 5, 5);
		gbc_button_160.gridx = 6;
		gbc_button_160.gridy = 6;
		rightPanel.add(button_160, gbc_button_160);
		
		JButton button_161 = new JButton("\n");
		button_161.setEnabled(false);
		GridBagConstraints gbc_button_161 = new GridBagConstraints();
		gbc_button_161.insets = new Insets(0, 0, 5, 5);
		gbc_button_161.gridx = 7;
		gbc_button_161.gridy = 6;
		rightPanel.add(button_161, gbc_button_161);
		
		JButton button_162 = new JButton("\n");
		button_162.setEnabled(false);
		GridBagConstraints gbc_button_162 = new GridBagConstraints();
		gbc_button_162.insets = new Insets(0, 0, 5, 5);
		gbc_button_162.gridx = 8;
		gbc_button_162.gridy = 6;
		rightPanel.add(button_162, gbc_button_162);
		
		JButton button_163 = new JButton("\n");
		button_163.setEnabled(false);
		GridBagConstraints gbc_button_163 = new GridBagConstraints();
		gbc_button_163.insets = new Insets(0, 0, 5, 0);
		gbc_button_163.gridx = 9;
		gbc_button_163.gridy = 6;
		rightPanel.add(button_163, gbc_button_163);
		
		JButton button_164 = new JButton("\n");
		button_164.setEnabled(false);
		button_164.setBackground(Color.RED);
		GridBagConstraints gbc_button_164 = new GridBagConstraints();
		gbc_button_164.insets = new Insets(0, 0, 5, 5);
		gbc_button_164.gridx = 0;
		gbc_button_164.gridy = 7;
		rightPanel.add(button_164, gbc_button_164);
		
		JButton button_165 = new JButton("\n");
		button_165.setEnabled(false);
		GridBagConstraints gbc_button_165 = new GridBagConstraints();
		gbc_button_165.insets = new Insets(0, 0, 5, 5);
		gbc_button_165.gridx = 1;
		gbc_button_165.gridy = 7;
		rightPanel.add(button_165, gbc_button_165);
		
		JButton button_166 = new JButton("\n");
		button_166.setEnabled(false);
		GridBagConstraints gbc_button_166 = new GridBagConstraints();
		gbc_button_166.insets = new Insets(0, 0, 5, 5);
		gbc_button_166.gridx = 2;
		gbc_button_166.gridy = 7;
		rightPanel.add(button_166, gbc_button_166);
		
		JButton button_167 = new JButton("\n");
		button_167.setEnabled(false);
		GridBagConstraints gbc_button_167 = new GridBagConstraints();
		gbc_button_167.insets = new Insets(0, 0, 5, 5);
		gbc_button_167.gridx = 3;
		gbc_button_167.gridy = 7;
		rightPanel.add(button_167, gbc_button_167);
		
		JButton button_168 = new JButton("\n");
		button_168.setEnabled(false);
		button_168.setBackground(Color.RED);
		GridBagConstraints gbc_button_168 = new GridBagConstraints();
		gbc_button_168.insets = new Insets(0, 0, 5, 5);
		gbc_button_168.gridx = 4;
		gbc_button_168.gridy = 7;
		rightPanel.add(button_168, gbc_button_168);
		
		JButton button_169 = new JButton("\n");
		button_169.setEnabled(false);
		GridBagConstraints gbc_button_169 = new GridBagConstraints();
		gbc_button_169.insets = new Insets(0, 0, 5, 5);
		gbc_button_169.gridx = 5;
		gbc_button_169.gridy = 7;
		rightPanel.add(button_169, gbc_button_169);
		
		JButton button_170 = new JButton("\n");
		button_170.setEnabled(false);
		GridBagConstraints gbc_button_170 = new GridBagConstraints();
		gbc_button_170.insets = new Insets(0, 0, 5, 5);
		gbc_button_170.gridx = 6;
		gbc_button_170.gridy = 7;
		rightPanel.add(button_170, gbc_button_170);
		
		JButton button_171 = new JButton("\n");
		button_171.setEnabled(false);
		GridBagConstraints gbc_button_171 = new GridBagConstraints();
		gbc_button_171.insets = new Insets(0, 0, 5, 5);
		gbc_button_171.gridx = 7;
		gbc_button_171.gridy = 7;
		rightPanel.add(button_171, gbc_button_171);
		
		JButton button_172 = new JButton("\n");
		button_172.setEnabled(false);
		GridBagConstraints gbc_button_172 = new GridBagConstraints();
		gbc_button_172.insets = new Insets(0, 0, 5, 5);
		gbc_button_172.gridx = 8;
		gbc_button_172.gridy = 7;
		rightPanel.add(button_172, gbc_button_172);
		
		JButton button_173 = new JButton("\n");
		button_173.setEnabled(false);
		GridBagConstraints gbc_button_173 = new GridBagConstraints();
		gbc_button_173.insets = new Insets(0, 0, 5, 0);
		gbc_button_173.gridx = 9;
		gbc_button_173.gridy = 7;
		rightPanel.add(button_173, gbc_button_173);
		
		JButton button_174 = new JButton("\n");
		button_174.setEnabled(false);
		button_174.setBackground(Color.RED);
		GridBagConstraints gbc_button_174 = new GridBagConstraints();
		gbc_button_174.insets = new Insets(0, 0, 5, 5);
		gbc_button_174.gridx = 0;
		gbc_button_174.gridy = 8;
		rightPanel.add(button_174, gbc_button_174);
		
		JButton button_175 = new JButton("\n");
		button_175.setEnabled(false);
		GridBagConstraints gbc_button_175 = new GridBagConstraints();
		gbc_button_175.insets = new Insets(0, 0, 5, 5);
		gbc_button_175.gridx = 1;
		gbc_button_175.gridy = 8;
		rightPanel.add(button_175, gbc_button_175);
		
		JButton button_176 = new JButton("\n");
		button_176.setEnabled(false);
		GridBagConstraints gbc_button_176 = new GridBagConstraints();
		gbc_button_176.insets = new Insets(0, 0, 5, 5);
		gbc_button_176.gridx = 2;
		gbc_button_176.gridy = 8;
		rightPanel.add(button_176, gbc_button_176);
		
		JButton button_177 = new JButton("\n");
		button_177.setEnabled(false);
		GridBagConstraints gbc_button_177 = new GridBagConstraints();
		gbc_button_177.insets = new Insets(0, 0, 5, 5);
		gbc_button_177.gridx = 3;
		gbc_button_177.gridy = 8;
		rightPanel.add(button_177, gbc_button_177);
		
		JButton button_178 = new JButton("\n");
		button_178.setEnabled(false);
		button_178.setBackground(Color.RED);
		GridBagConstraints gbc_button_178 = new GridBagConstraints();
		gbc_button_178.insets = new Insets(0, 0, 5, 5);
		gbc_button_178.gridx = 4;
		gbc_button_178.gridy = 8;
		rightPanel.add(button_178, gbc_button_178);
		
		JButton button_179 = new JButton("\n");
		button_179.setEnabled(false);
		GridBagConstraints gbc_button_179 = new GridBagConstraints();
		gbc_button_179.insets = new Insets(0, 0, 5, 5);
		gbc_button_179.gridx = 5;
		gbc_button_179.gridy = 8;
		rightPanel.add(button_179, gbc_button_179);
		
		JButton button_180 = new JButton("\n");
		button_180.setEnabled(false);
		button_180.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_180 = new GridBagConstraints();
		gbc_button_180.insets = new Insets(0, 0, 5, 5);
		gbc_button_180.gridx = 6;
		gbc_button_180.gridy = 8;
		rightPanel.add(button_180, gbc_button_180);
		
		JButton button_181 = new JButton("\n");
		button_181.setEnabled(false);
		button_181.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_181 = new GridBagConstraints();
		gbc_button_181.insets = new Insets(0, 0, 5, 5);
		gbc_button_181.gridx = 7;
		gbc_button_181.gridy = 8;
		rightPanel.add(button_181, gbc_button_181);
		
		JButton button_182 = new JButton("\n");
		button_182.setEnabled(false);
		button_182.setBackground(Color.GREEN);
		GridBagConstraints gbc_button_182 = new GridBagConstraints();
		gbc_button_182.insets = new Insets(0, 0, 5, 5);
		gbc_button_182.gridx = 8;
		gbc_button_182.gridy = 8;
		rightPanel.add(button_182, gbc_button_182);
		
		JButton button_183 = new JButton("\n");
		button_183.setEnabled(false);
		GridBagConstraints gbc_button_183 = new GridBagConstraints();
		gbc_button_183.insets = new Insets(0, 0, 5, 0);
		gbc_button_183.gridx = 9;
		gbc_button_183.gridy = 8;
		rightPanel.add(button_183, gbc_button_183);
		
		JButton button_184 = new JButton("\n");
		button_184.setEnabled(false);
		button_184.setBackground(Color.RED);
		GridBagConstraints gbc_button_184 = new GridBagConstraints();
		gbc_button_184.insets = new Insets(0, 0, 0, 5);
		gbc_button_184.gridx = 0;
		gbc_button_184.gridy = 9;
		rightPanel.add(button_184, gbc_button_184);
		
		JButton button_185 = new JButton("\n");
		button_185.setEnabled(false);
		GridBagConstraints gbc_button_185 = new GridBagConstraints();
		gbc_button_185.insets = new Insets(0, 0, 0, 5);
		gbc_button_185.gridx = 1;
		gbc_button_185.gridy = 9;
		rightPanel.add(button_185, gbc_button_185);
		
		JButton button_186 = new JButton("\n");
		button_186.setEnabled(false);
		GridBagConstraints gbc_button_186 = new GridBagConstraints();
		gbc_button_186.insets = new Insets(0, 0, 0, 5);
		gbc_button_186.gridx = 2;
		gbc_button_186.gridy = 9;
		rightPanel.add(button_186, gbc_button_186);
		
		JButton button_187 = new JButton("\n");
		button_187.setEnabled(false);
		GridBagConstraints gbc_button_187 = new GridBagConstraints();
		gbc_button_187.insets = new Insets(0, 0, 0, 5);
		gbc_button_187.gridx = 3;
		gbc_button_187.gridy = 9;
		rightPanel.add(button_187, gbc_button_187);
		
		JButton button_188 = new JButton("\n");
		button_188.setEnabled(false);
		GridBagConstraints gbc_button_188 = new GridBagConstraints();
		gbc_button_188.insets = new Insets(0, 0, 0, 5);
		gbc_button_188.gridx = 4;
		gbc_button_188.gridy = 9;
		rightPanel.add(button_188, gbc_button_188);
		
		JButton button_189 = new JButton("\n");
		button_189.setEnabled(false);
		GridBagConstraints gbc_button_189 = new GridBagConstraints();
		gbc_button_189.insets = new Insets(0, 0, 0, 5);
		gbc_button_189.gridx = 5;
		gbc_button_189.gridy = 9;
		rightPanel.add(button_189, gbc_button_189);
		
		JButton button_190 = new JButton("\n");
		button_190.setEnabled(false);
		GridBagConstraints gbc_button_190 = new GridBagConstraints();
		gbc_button_190.insets = new Insets(0, 0, 0, 5);
		gbc_button_190.gridx = 6;
		gbc_button_190.gridy = 9;
		rightPanel.add(button_190, gbc_button_190);
		
		JButton button_191 = new JButton("\n");
		button_191.setEnabled(false);
		GridBagConstraints gbc_button_191 = new GridBagConstraints();
		gbc_button_191.insets = new Insets(0, 0, 0, 5);
		gbc_button_191.gridx = 7;
		gbc_button_191.gridy = 9;
		rightPanel.add(button_191, gbc_button_191);
		
		JButton button_192 = new JButton("\n");
		button_192.setEnabled(false);
		GridBagConstraints gbc_button_192 = new GridBagConstraints();
		gbc_button_192.insets = new Insets(0, 0, 0, 5);
		gbc_button_192.gridx = 8;
		gbc_button_192.gridy = 9;
		rightPanel.add(button_192, gbc_button_192);
		
		JButton button_193 = new JButton("\n");
		button_193.setEnabled(false);
		button_193.setBackground(Color.RED);
		GridBagConstraints gbc_button_193 = new GridBagConstraints();
		gbc_button_193.gridx = 9;
		gbc_button_193.gridy = 9;
		rightPanel.add(button_193, gbc_button_193);
		
		textField = new JTextField();
		textField.setBounds(153, 346, 50, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCoordenadas = new JLabel("Coordenadas");
		lblCoordenadas.setBounds(22, 346, 117, 15);
		frame.getContentPane().add(lblCoordenadas);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 346, 50, 19);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Fogo!");
		btnNewButton_1.setBounds(153, 366, 117, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
