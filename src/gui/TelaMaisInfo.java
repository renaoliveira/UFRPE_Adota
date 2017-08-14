package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import negocio.Pessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMaisInfo extends JFrame {

	private JPanel contentPane;
	private static JFrame instance; 
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private Pessoa p;
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(instance == null)
			instance = new TelaMaisInfo();
		return instance;
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMaisInfo frame = new TelaMaisInfo();
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
	public TelaMaisInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(88, 49, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(144, 49, 166, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(88, 89, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(144, 89, 166, 20);
		contentPane.add(textFieldEmail);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(88, 129, 46, 14);
		contentPane.add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(144, 129, 166, 20);
		contentPane.add(textFieldTel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMaisInfo.getInstance().dispose();
				instance = null;
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setBounds(188, 197, 89, 23);
		contentPane.add(btnVoltar);
		

		p = Fachada.getInstance().getPessoa();
		textFieldNome.setText(p.getNome());
		textFieldEmail.setText(p.getEmail());
		if(p.getTelefone()!=null)
			textFieldTel.setText(p.getTelefone());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setNome(textFieldNome.getText());
				p.setEmail(textFieldEmail.getText());
				p.setTelefone(textFieldTel.getText());
				Fachada.getInstance().atualizar(p);
				JOptionPane.showMessageDialog(null, "Informações Atualizadas!");
			}
		});
		btnAtualizar.setForeground(Color.BLUE);
		btnAtualizar.setBounds(165, 163, 131, 23);
		contentPane.add(btnAtualizar);
	}

}
