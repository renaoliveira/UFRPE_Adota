package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Animal;
import negocio.Fachada;
import teste.Instancias;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAnimal extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldNome;
	private JTextField textFieldEspecie;
	private JTextField textFieldCor;
	private JTextField textFieldPeso;
	private Animal a = new Animal();
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(instance == null)
			instance = new TelaCadastroAnimal();
		
		return instance;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAnimal frame = new TelaCadastroAnimal();
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
	public TelaCadastroAnimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(121, 14, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(174, 11, 132, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Especie:");
		lblEspecie.setBounds(121, 52, 46, 14);
		contentPane.add(lblEspecie);
		
		textFieldEspecie = new JTextField();
		textFieldEspecie.setColumns(10);
		textFieldEspecie.setBounds(174, 49, 132, 20);
		contentPane.add(textFieldEspecie);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(121, 90, 46, 14);
		contentPane.add(lblCor);
		
		textFieldCor = new JTextField();
		textFieldCor.setColumns(10);
		textFieldCor.setBounds(174, 87, 132, 20);
		contentPane.add(textFieldCor);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(121, 133, 46, 14);
		contentPane.add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(174, 130, 132, 20);
		contentPane.add(textFieldPeso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a.setNome(textFieldNome.getText());
				a.setId(textFieldNome.getText());
				a.setEspecie(textFieldEspecie.getText());
				a.setCor(textFieldCor.getText());
				a.setPeso(Float.parseFloat(textFieldPeso.getText()));
				Fachada.getInstance().inserir(a);
				JOptionPane.showMessageDialog(null,"Animal Cadastrado!");
				TelaCadastroAnimal.getInstance().dispose();
				instance = null;
			}
		});
		btnCadastrar.setBounds(174, 177, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAnimal.getInstance().dispose();
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setBounds(187, 230, 61, 20);
		contentPane.add(btnVoltar);
	}
}
