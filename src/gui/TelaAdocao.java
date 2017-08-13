package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdocao extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldProcurar;

	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaAdocao.instance == null)
			TelaAdocao.instance = new TelaAdocao();
		
		return TelaAdocao.instance;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdocao frame = new TelaAdocao();
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
	public TelaAdocao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProcurar = new JLabel("Procurar:");
		lblProcurar.setBounds(99, 74, 46, 14);
		contentPane.add(lblProcurar);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setBounds(155, 71, 86, 20);
		contentPane.add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
		
		JButton btnProcurar = new JButton("New button");
		btnProcurar.setBounds(251, 70, 23, 23);
		contentPane.add(btnProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 129, 266, 121);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(24, 135, 46, 14);
		contentPane.add(lblInfo);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdotar.setBounds(340, 182, 86, 32);
		contentPane.add(btnAdotar);
		
		JButton btnLarTemporario = new JButton("Ser Lar");
		btnLarTemporario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroLarTemporario.getInstance().setVisible(true);
			}
		});
		btnLarTemporario.setBounds(340, 225, 86, 23);
		contentPane.add(btnLarTemporario);
	}

}
