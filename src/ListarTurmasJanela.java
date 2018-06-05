import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class ListarTurmasJanela extends JFrame {
	
	public JPanel titulo;
	public JPanel botoes;
	public JLabel tituloTexto;
	public JList<Turma> listagem;
	public JButton botaoNovo;
	public JButton botaoMaisNovo;
	public JButton botaoNovissimo;
	
	public List<Turma> listagemTurmas;
	public MyListModel<Turma> listagemModel;
	
	public ListarTurmasJanela() {
		super("Listagem de Alunos");
		
		listagemTurmas = CRUDFaculdade.hi().getTurma();
		listagemModel = new MyListModel<>();
		
		for(int i=0; i < listagemTurmas.size(); i++){
			listagemModel.add(listagemTurmas.get(i));
		}
		
		// Inicia os elementos
		titulo = new JPanel();
		tituloTexto = new JLabel("Listagem de Turmas");
		listagem = new JList<>(listagemModel);
		botaoNovo = new JButton("Novo");
		botaoMaisNovo = new JButton("Editar");
		botaoNovissimo = new JButton("Excluir");
		botoes = new JPanel();
		
		// Adiciona os elementos na interface
		titulo.add(tituloTexto);
		add(titulo, BorderLayout.NORTH);
		add(listagem);
		botoes.add(botaoNovo);
		botoes.add(botaoMaisNovo);
		botoes.add(botaoNovissimo);
		add(botoes, BorderLayout.SOUTH);
		
		// Mostra a interface
		setSize(500,500);
		setVisible(true);
	}
}
