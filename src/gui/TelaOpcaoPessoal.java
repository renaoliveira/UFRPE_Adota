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
import java.awt.Color;

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
		btnAdotar.setBounds(168, 35, 89, 23);
		contentPane.add(btnAdotar);
		
		JButton btnCadastrarDoacao = new JButton("Cadastrar Produtos");
		btnCadastrarDoacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroDoacao.getInstance().setVisible(true);
			}
		});
		btnCadastrarDoacao.setBounds(108, 123, 218, 23);
		contentPane.add(btnCadastrarDoacao);
		
		JButton btnLarTemporario = new JButton("Cadastrar Lar Temporario");
		btnLarTemporario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroLarTemporario.getInstance().setVisible(true);
			}
		});
		btnLarTemporario.setBounds(83, 157, 262, 23);
		contentPane.add(btnLarTemporario);
		
		JButton btnDoar = new JButton("Doar");
		btnDoar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDoacao.getInstance().setVisible(true);
			}
		});
		btnDoar.setBounds(168, 79, 89, 23);
		contentPane.add(btnDoar);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcaoPessoal.getInstance().dispose();
			}
		});
		btnSair.setForeground(Color.RED);
		btnSair.setBounds(168, 227, 89, 23);
		contentPane.add(btnSair);
	}
}
