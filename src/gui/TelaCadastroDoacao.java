package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.ProdutoCadastradoException;
import negocio.Fachada;
import negocio.Produto;
import repositorio.RepositorioProdutoLista;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastroDoacao extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldNome;
	private JTextField textFieldTipo;
	private JTextField textFieldPreco;
	private JTextField textFieldDescricao;
	private Produto produtos = new Produto();	
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaCadastroDoacao.instance == null)
			TelaCadastroDoacao.instance = new TelaCadastroDoacao();
		
		return TelaCadastroDoacao.instance;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDoacao frame = new TelaCadastroDoacao();
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
	public TelaCadastroDoacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 12, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 49, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 86, 46, 14);
		contentPane.add(lblPreco);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 128, 66, 14);
		contentPane.add(lblDescrio);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(99, 10, 155, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(99, 46, 155, 20);
		contentPane.add(textFieldTipo);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(99, 83, 155, 20);
		contentPane.add(textFieldPreco);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(99, 125, 155, 53);
		contentPane.add(textFieldDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 5, 134, 211);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(258, 106, 46, 14);
		contentPane.add(lblInfo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {
					Fachada.getInstance().inserir(produtos);
				} catch (ProdutoCadastradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textArea.append("Produto "+e1.getIdProduto()+" \nJá foi cadastrado!");
					
				}
			}
		});
		btnCadastrar.setBounds(312, 227, 96, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				textArea.setText("");
				produtos.setIdProduto(textFieldNome.getText());
				produtos.setTipo(textFieldTipo.getText());
				produtos.setPreco(Double.parseDouble(textFieldPreco.getText()));
				produtos.setDescricao(textFieldDescricao.getText());
				textArea.append("Cadastro de Produtos\nNome: "+String.valueOf(produtos.getIdProduto())+"\nTipo: "+produtos.getTipo()+
								"\nPreço/Unidade/Kg: "+produtos.getPreco()+"\nDescrição:"+produtos.getDescricao());
	
			}
		});
		btnAdicionar.setBounds(134, 193, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TelaOpcaoPessoal.getInstance().setVisible(true);
				TelaCadastroDoacao.getInstance().dispose();
				instance = null;
			}
		});
		btnVoltar.setBounds(134, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}
