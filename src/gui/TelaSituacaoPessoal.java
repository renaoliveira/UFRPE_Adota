package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.LarNaoCadastradoException;
import negocio.Fachada;
import negocio.Pessoa;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaSituacaoPessoal extends JFrame {

	private JPanel contentPane;
	private static JFrame instance; 
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(instance == null)
			instance = new TelaSituacaoPessoal();
		return instance;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSituacaoPessoal frame = new TelaSituacaoPessoal();
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
	public TelaSituacaoPessoal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 89, 352, 133);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(10, 95, 46, 14);
		contentPane.add(lblInfo);
		
		JButton btnEndereco = new JButton("Endere\u00E7o");
		btnEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Pessoa tmp = Fachada.getInstance().getPessoa();
				try {
					textArea.append("Lar Temporário\nCidade: "+tmp.getEndereco().getCidade()+"\nBairro: "+tmp.getEndereco().getBairro()+
									"\nRua: "+tmp.getEndereco().getRua()+"\nNum: "+tmp.getEndereco().getNumero()+
									"\nComplemento:"+tmp.getEndereco().getComplemento());
				} catch (LarNaoCadastradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					TelaCadastroLarTemporario.getInstance().setVisible(true);
				}

			}
		});
		btnEndereco.setBounds(41, 11, 89, 23);
		contentPane.add(btnEndereco);
		
		JButton btnPets = new JButton("Pets");
		btnPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Pessoa tmp = Fachada.getInstance().getPessoa();
				for (int i = 0; i < tmp.getNumPets(); i++) {
					textArea.append("Pet "+(i+1)+": "+tmp.getAdocao(i).getNome()+"\n");
				}
				
			}
		});
		btnPets.setBounds(169, 11, 89, 23);
		contentPane.add(btnPets);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSituacaoPessoal.getInstance().dispose();
				instance = null;
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setBounds(169, 233, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnPessoal = new JButton("Pessoal");
		btnPessoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Pessoa tmp = Fachada.getInstance().getPessoa();
				textArea.append("Nome: "+tmp.getNome()+"\nLogin: "+tmp.getLogin()+"\nEmail: "+tmp.getEmail()+
								"\nTelefone: "+tmp.getTelefone()+"\nQuantidade de Pets: "+tmp.getNumPets());
			}
		});
		btnPessoal.setBounds(297, 11, 89, 23);
		contentPane.add(btnPessoal);
		
		JButton btnInserirMaisInformacoes = new JButton("Inserir Mais Informacoes");
		btnInserirMaisInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				TelaMaisInfo.getInstance().setVisible(true);
			}
		});
		btnInserirMaisInformacoes.setForeground(Color.BLUE);
		btnInserirMaisInformacoes.setBounds(118, 55, 191, 23);
		contentPane.add(btnInserirMaisInformacoes);
	}
}
