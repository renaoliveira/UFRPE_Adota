package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpcaoPessoal extends JFrame {

	private JPanel contentPane;
	private static JFrame telaOpcaoInstance;
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaOpcaoPessoal.telaOpcaoInstance == null)
			TelaOpcaoPessoal.telaOpcaoInstance = new TelaOpcaoPessoal();
		
		return TelaOpcaoPessoal.telaOpcaoInstance;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcaoPessoal frame = new TelaOpcaoPessoal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaOpcaoPessoal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdocao.getInstance().setVisible(true);
			}
		});
		btnAdotar.setBounds(30, 22, 89, 23);
		contentPane.add(btnAdotar);
		
		JButton btnDoar = new JButton("Doar");
		btnDoar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDoacao.getInstance().setVisible(true);
			}
		});
		btnDoar.setBounds(30, 55, 89, 23);
		contentPane.add(btnDoar);
		
		JButton btnLarTemporario = new JButton("Lar Temporario");
		btnLarTemporario.setBounds(10, 89, 127, 23);
		contentPane.add(btnLarTemporario);
	}
}
