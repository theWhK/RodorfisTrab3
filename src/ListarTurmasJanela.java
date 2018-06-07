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
		
		listagemTurmas = DataLayer.hi().getTurma();
		listagemModel = new MyListModel<>();
		
		for(int i = 0; i < listagemTurmas.size(); i++){
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
		
		// Listeners
			// Criar
			botaoNovo.addActionListener((e)->{
				CadastroTurmaJanela euNaoSei = new CadastroTurmaJanela(listagemModel);
				/*String cpf = JOptionPane.showInputDialog(this, "CPF: ");
				String rg = JOptionPane.showInputDialog(this, "RG: ");
				String ra = JOptionPane.showInputDialog(this, "RA:" );
				String dataDeMatricula = JOptionPane.showInputDialog(this, "Data de matricula: ");
				Aluno a = new Aluno();
				a.setNome(nome);
				a.setCpf(cpf);
				a.setRg(rg);
				a.setRa(ra);
				a.setCpf(cpf);
				a.setDataDeMatricula(dataDeMatricula);
				CRUDFaculdade.hi().addAluno(a);
				listagemModel.add(a);*/
			});
			// Atualizar
			/*
			botaoMaisNovo.addActionListener((e)->{
				try {
					Aluno a = listagem.getSelectedValue();
					String nome = JOptionPane.showInputDialog(this, "Nome: ", a.getNome());
					String cpf = JOptionPane.showInputDialog(this, "CPF: ", a.getCpf());
					String rg = JOptionPane.showInputDialog(this, "RG: ", a.getRg());
					String ra = JOptionPane.showInputDialog(this, "Ra:" ,a.getRa());
					String dataDeMatricula = JOptionPane.showInputDialog(this, "Data de matricula: ", a.getDataDeMatricula());
					a.setNome(nome);
					a.setCpf(cpf);
					a.setRg(rg);
					a.setRa(ra);
					a.setCpf(cpf);
					a.setDataDeMatricula(dataDeMatricula);
					listagem.repaint();
				}
				catch (NullPointerException oCaraNaoSelecionouNadaMeuDeus) {
					JOptionPane.showMessageDialog(
							this, 
							"Selecione um elemento na lista.", 
							"Erro", 
							JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception vishNemSei) {
					JOptionPane.showMessageDialog(
							this, 
							"Erro não previsto.", 
							"Erro", 
							JOptionPane.ERROR_MESSAGE);
				}
	
			});
			*/
			// Remover
			botaoNovissimo.addActionListener((e)->{
				try {
					int index = listagem.getSelectedIndex();
					DataLayer.hi().removeTurmaAt(index);
					listagemModel.remove(index);
				}
				catch (NullPointerException oCaraNaoSelecionouNadaMeuDeus) {
					JOptionPane.showMessageDialog(
							this, 
							"Selecione um elemento na lista.", 
							"Erro", 
							JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception vishNemSei) {
					JOptionPane.showMessageDialog(
							this, 
							"Erro não previsto.", 
							"Erro", 
							JOptionPane.ERROR_MESSAGE);
				}
			});
		
		// Mostra a interface
		setSize(500,500);
		setVisible(true);
	}
}
