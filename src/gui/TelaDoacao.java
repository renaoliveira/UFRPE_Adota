package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.ProdutoInexistenteException;
import negocio.Fachada;
import negocio.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class TelaDoacao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldProcurar;
	private JTextField textFieldQuantidade;
	private static JFrame instance; 
	private Produto p;

	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaDoacao.instance == null)
			TelaDoacao.instance = new TelaDoacao();
		return TelaDoacao.instance;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoacao frame = new TelaDoacao();
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
	public TelaDoacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setBounds(197, 45, 136, 20);
		contentPane.add(textFieldProcurar);
		textFieldProcurar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 101, 233, 87);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(63, 107, 46, 14);
		contentPane.add(lblInfo);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(166, 199, 70, 20);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(100, 202, 87, 14);
		contentPane.add(lblQuantidade);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try {					
					p = Fachada.getInstance().procurarProduto(textFieldProcurar.getText());
					textArea.append("Doação de Produtos\nNome: "+String.valueOf(p.getIdProduto())+"\nTipo: "+p.getTipo()+
							"\nPreço/Unidade/Kg: "+p.getPreco()+"\nDescrição:"+p.getDescricao());
				} catch (ProdutoInexistenteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(100, 44, 101, 22);
		contentPane.add(btnProcurar);
		
		JButton btnDoar = new JButton("Doar");
		btnDoar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				p.setQuantidade(0);
				p.agregaQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				textArea.append("Doação de Produtos\nNome: "+String.valueOf(p.getIdProduto())+"\nTipo: "+p.getTipo()+
						"\nPreço/Unidade/Kg: "+p.getPreco()+"\nDescrição:"+p.getDescricao()+"\nQuantidade: "+p.getQuantidade()+
						"\nValor: "+p.valorDoacao(Integer.parseInt(textFieldQuantidade.getText()), p.getPreco()));
			}
		});
		btnDoar.setBounds(246, 198, 87, 23);
		contentPane.add(btnDoar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcaoPessoal.getInstance().setVisible(true);
				TelaDoacao.getInstance().setVisible(false);
			}
		});
		btnVoltar.setBounds(176, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}
