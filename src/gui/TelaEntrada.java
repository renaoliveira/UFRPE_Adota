package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Pessoa;
import repositorio.RepositorioPessoaLista;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaEntrada extends JFrame {

	private JPanel contentPane;
	private static JFrame telaEntradaInstance;
	private JTextField textFieldLogin;
	private Pessoa principal = new Pessoa();
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static JFrame getInstance(){
		if(TelaEntrada.telaEntradaInstance == null){
			TelaEntrada.telaEntradaInstance = new TelaEntrada();
		}
		
		return TelaEntrada.telaEntradaInstance;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEntrada frame = new TelaEntrada();
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
	public TelaEntrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(79, 67, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(79, 108, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.setLogin(textFieldLogin.getText());
				principal.setSenha(passwordField.getText());
				if(RepositorioPessoaLista.getInstance().existe(principal.getLogin())){
					TelaOpcaoPessoal.getInstance().setVisible(true);
					TelaEntrada.getInstance().dispose();
				}
					
				
			}
		});
		btnEntrar.setBounds(180, 175, 89, 23);
		contentPane.add(btnEntrar);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(132, 64, 186, 23);
		contentPane.add(textFieldLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 105, 186, 23);
		contentPane.add(passwordField);
	}
}