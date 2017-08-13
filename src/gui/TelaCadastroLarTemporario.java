package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaCadastroLarTemporario extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNum;
	private JTextField textFieldComplemento;
	private JTextField textField_5;

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
		lblComplemento.setBounds(10, 159, 93, 14);
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
		
		textField_5 = new JTextField();
		scrollPane.setViewportView(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Info:");
		lblNewLabel.setBounds(269, 19, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(297, 210, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(130, 187, 77, 23);
		contentPane.add(btnAdicionar);
	}

}
