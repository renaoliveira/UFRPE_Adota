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

public class TelaDoacao extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldNome;
	private JTextField textFieldTipo;
	private JTextField textFieldQuantidade;
	private JTextField textFieldPreco;
	private JTextField textFieldDescricao;
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 36, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 61, 66, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 86, 46, 14);
		contentPane.add(lblPreco);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 128, 66, 14);
		contentPane.add(lblDescrio);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(99, 8, 155, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(99, 33, 155, 20);
		contentPane.add(textFieldTipo);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(99, 58, 155, 20);
		contentPane.add(textFieldQuantidade);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(99, 83, 155, 20);
		contentPane.add(textFieldPreco);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(99, 125, 155, 53);
		contentPane.add(textFieldDescricao);
		
		JButton btnDoar = new JButton("Doar");
		btnDoar.setBounds(133, 189, 89, 23);
		contentPane.add(btnDoar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 5, 134, 250);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(258, 106, 46, 14);
		contentPane.add(lblInfo);
	}

}
