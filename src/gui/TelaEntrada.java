package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.PessoaInexistenteException;
import negocio.Fachada;
import negocio.Pessoa;
import repositorio.RepositorioPessoaLista;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaEntrada extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	public JTextField textFieldLogin;
	private Pessoa p = new Pessoa();
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static JFrame getInstance(){
		if(TelaEntrada.instance == null){
			TelaEntrada.instance = new TelaEntrada();
		}
		
		return TelaEntrada.instance;
	}
	
	public JTextField getLogin(){
		return textFieldLogin;
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
				try {
					p = Fachada.getInstance().procurarPessoa(textFieldLogin.getText());
					System.out.println("TE: "+p.getLogin());
				} catch (PessoaInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(Fachada.getInstance().existePessoa(p.getLogin()) && p.getSenha().equals(passwordField.getText())){
					TelaOpcaoPessoal.getInstance().setVisible(true);
					TelaEntrada.getInstance().dispose();
					instance = null;
				}else	JOptionPane.showMessageDialog(null,"Dados Incorretos!");					
				
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
