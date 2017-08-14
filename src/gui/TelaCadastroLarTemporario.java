package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Endereco;
import negocio.Fachada;
import repositorio.RepositorioPessoaLista;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class TelaCadastroLarTemporario extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNum;
	private JTextField textFieldComplemento;
	private Endereco casa;

	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaCadastroLarTemporario.instance == null)
			TelaCadastroLarTemporario.instance = new TelaCadastroLarTemporario();
		
		return TelaCadastroLarTemporario.instance;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroLarTemporario frame = new TelaCadastroLarTemporario();
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
	public TelaCadastroLarTemporario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 19, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 53, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 91, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblN = new JLabel("Num:");
		lblN.setBounds(10, 127, 46, 14);
		contentPane.add(lblN);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 159, 125, 14);
		contentPane.add(lblComplemento);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(106, 16, 125, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(106, 50, 125, 20);
		contentPane.add(textFieldBairro);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(106, 88, 125, 20);
		contentPane.add(textFieldRua);
		
		textFieldNum = new JTextField();
		textFieldNum.setColumns(10);
		textFieldNum.setBounds(106, 124, 125, 20);
		contentPane.add(textFieldNum);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(106, 156, 125, 20);
		contentPane.add(textFieldComplemento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 39, 140, 160);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Info:");
		lblNewLabel.setBounds(269, 19, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().getPessoa().setEndereco(casa);
				TelaCadastroLarTemporario.getInstance().dispose();
				instance = null;
			}
		});
		btnCadastrar.setBounds(279, 210, 107, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				casa = new Endereco();
				casa.setCidade(textFieldCidade.getText());
				casa.setBairro(textFieldBairro.getText());
				casa.setRua(textFieldRua.getText());
				casa.setNumero(Integer.parseInt(textFieldNum.getText()));
				casa.setComplemento(textFieldComplemento.getText());
				textArea.append("Lar Temporário\nCidade: "+casa.getCidade()+"\nBairro: "+casa.getBairro()+
								"\nRua: "+casa.getRua()+"\nNum: "+casa.getNumero()+"\nComplemento:"+casa.getComplemento());
			}
		});
		btnAdicionar.setBounds(116, 187, 101, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroLarTemporario.getInstance().dispose();
				instance = null;
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setBounds(116, 227, 101, 23);
		contentPane.add(btnVoltar);
	}
}
