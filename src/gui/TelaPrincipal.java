package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.PessoaCadastradaException;
import negocio.Pessoa;
import repositorio.RepositorioPessoaLista;
import teste.Instancias;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Pessoa p;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdotaUfrpe = new JLabel("Adota UFRPE");
		lblAdotaUfrpe.setBounds(176, 30, 64, 36);
		contentPane.add(lblAdotaUfrpe);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Teste de instancia
				p = Instancias.getInstancePessoa();
				try {
					RepositorioPessoaLista.getInstance().inserir(p);
				} catch (PessoaCadastradaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TelaEntrada.getInstance().setVisible(true);				
			}
		});
		btnEntrar.setBounds(166, 91, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnInscrever = new JButton("Inscreva-se");
		btnInscrever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInscricao.getInstance().setVisible(true);
			}
		});
		btnInscrever.setBounds(166, 143, 89, 23);
		contentPane.add(btnInscrever);
	}
}
