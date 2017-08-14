package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecao.AnimalNãoCadastradoException;
import excecao.LarNaoCadastradoException;
import negocio.Animal;
import repositorio.RepositorioAnimalLista;
import repositorio.RepositorioPessoaLista;
import teste.Instancias;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaAdocao extends JFrame {

	private JPanel contentPane;
	private static JFrame instance;
	private JTextField textFieldProcurar;
	private Animal a = new Animal();
	private RepositorioAnimalLista rep;
	
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaAdocao.instance == null)
			TelaAdocao.instance = new TelaAdocao();
		
		return TelaAdocao.instance;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdocao frame = new TelaAdocao();
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
	public TelaAdocao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProcurar = new JLabel("Procurar:");
		lblProcurar.setBounds(99, 74, 46, 14);
		contentPane.add(lblProcurar);
		
		textFieldProcurar = new JTextField();
		textFieldProcurar.setBounds(155, 71, 86, 20);
		contentPane.add(textFieldProcurar);
		textFieldProcurar.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 129, 266, 121);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rep = RepositorioAnimalLista.getInstance();
				textArea.setText("");				
				try {
					a = rep.procurar(textFieldProcurar.getText());
					textArea.append("Nome: "+a.getNome()+"\nId: "+a.getId()+"\nEspécie: "+a.getEspecie()+ "\nCor: "+a.getCor());
					
				} catch (AnimalNãoCadastradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					textArea.append("Animal de Id: " + textFieldProcurar.getText()+" Não está cadastrado!");
				}				
					
			}
		});
		btnProcurar.setBounds(251, 70, 23, 23);
		contentPane.add(btnProcurar);
		
		JLabel lblInfo = new JLabel("Info:");
		lblInfo.setBounds(24, 135, 46, 14);
		contentPane.add(lblInfo);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				if(RepositorioAnimalLista.getInstance().existe(textFieldProcurar.getText()))
					RepositorioPessoaLista.getInstance().getPessoa().setAdocao(a);
				else textArea.append("Animal de Id: " + textFieldProcurar.getText()+" Não está cadastrado!");				
			}
		});
		btnAdotar.setBounds(340, 129, 86, 32);
		contentPane.add(btnAdotar);
		
		JButton btnLarTemporario = new JButton("Ser Lar");
		btnLarTemporario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				try {				
					a.setLarTemporario(RepositorioPessoaLista.getInstance().getPessoa().getEndereco());
					textArea.append("\t Lar Temporário\nCidade: "+a.getLarTemporario().getCidade()+"\nBairro: "+a.getLarTemporario().getBairro()+
									"\nRua: "+a.getLarTemporario().getRua()+"\nNum: "+a.getLarTemporario().getNumero()+
									"\nComplemento:"+a.getLarTemporario().getComplemento());
				} catch (LarNaoCadastradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					TelaCadastroLarTemporario.getInstance().setVisible(true);
				}
			}
		});
		btnLarTemporario.setBounds(340, 184, 86, 23);
		contentPane.add(btnLarTemporario);
		//Teste
		JButton btnInstancia = new JButton("Instancia");
		btnInstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Instancias.getInstanceAnimal();
				rep = RepositorioAnimalLista.getInstance();
			
				rep.inserir(a);
				System.out.println(RepositorioAnimalLista.tam);

			}
		});
		btnInstancia.setBounds(155, 22, 89, 23);
		contentPane.add(btnInstancia);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcaoPessoal.getInstance().setVisible(true);
				TelaAdocao.getInstance().setVisible(false);
			}
		});
		btnVoltar.setBounds(340, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
