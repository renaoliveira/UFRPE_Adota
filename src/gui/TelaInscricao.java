package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.PessoaCadastradaException;
import negocio.Fachada;
import negocio.Pessoa;
import repositorio.RepositorioPessoaLista;
import teste.Instancias;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaInscricao extends JFrame {

	private JPanel contentPane;
	private static JFrame telaInscricaoInstance;
	private JTextField textFieldLogin;
	private JTextField textFieldEmail;
	private Pessoa p = new Pessoa();
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaInscricao.telaInscricaoInstance == null)
			TelaInscricao.telaInscricaoInstance = new TelaInscricao();
		
		return TelaInscricao.telaInscricaoInstance;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInscricao frame = new TelaInscricao();
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
	public TelaInscricao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(102, 65, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(102, 143, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(102, 102, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(158, 62, 171, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(158, 99, 171, 20);
		contentPane.add(textFieldEmail);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setLogin(textFieldLogin.getText());
				p.setEmail(textFieldEmail.getText());
				p.setSenha(passwordField.getText());
				//p = Instancias.getInstancePessoa();
				try {
					Fachada.getInstance().inserir(p);
					TelaInscricao.getInstance().setVisible(false);
				} catch (PessoaCadastradaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(203, 186, 89, 23);
		contentPane.add(btnCadastrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 140, 171, 20);
		contentPane.add(passwordField);
	}

}
