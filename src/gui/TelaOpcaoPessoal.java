package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaOpcaoPessoal extends JFrame {

	private JPanel contentPane;
	private static JFrame telaOpcaoInstance;
	/**
	 * Launch the application.
	 */
	
	public static JFrame getInstance(){
		if(TelaOpcaoPessoal.telaOpcaoInstance == null)
			TelaOpcaoPessoal.telaOpcaoInstance = new TelaOpcaoPessoal();
		
		return TelaOpcaoPessoal.telaOpcaoInstance;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcaoPessoal frame = new TelaOpcaoPessoal();
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
	public TelaOpcaoPessoal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
