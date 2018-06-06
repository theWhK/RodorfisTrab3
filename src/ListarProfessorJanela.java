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

@SuppressWarnings("serial")	
public class ListarProfessorJanela extends JFrame {
	public JPanel titulo;
	public JPanel botoes;
	public JLabel tituloTexto;
	public JList<Professor> listagem;
	public JButton botaoNovo;
	public JButton botaoMaisNovo;
	public JButton botaoNovissimo;
	
	public List<Professor> listagemProfessores;
	public MyListModel<Professor> listagemModel;
	
	public ListarProfessorJanela(){
		super("Listagem de Professores");
		
		listagemProfessores = DataLayer.hi().getProfessor();
		listagemModel = new MyListModel<>();
		
		for(int i=0; i<listagemProfessores.size(); i++){
			listagemModel.add(listagemProfessores.get(i));
		}
		
		// Inicia os elementos
		titulo = new JPanel();
		tituloTexto = new JLabel("Listagem de Professores");
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
				String nome = JOptionPane.showInputDialog(this, "Nome: ");
				String cpf = JOptionPane.showInputDialog(this, "CPF: ");
				String rg = JOptionPane.showInputDialog(this, "RG: ");
				String especialidade = JOptionPane.showInputDialog(this, "Especialidade:" );
				Professor p = new Professor();
				p.setNome(nome);
				p.setCpf(cpf);
				p.setRg(rg);
				p.setEspecialidade(especialidade);
				DataLayer.hi().addProfessor(p);
				listagemModel.add(p);
			});
			// Atualizar
			botaoMaisNovo.addActionListener((e)->{
				try {
					Professor p = listagem.getSelectedValue();
					String nome = JOptionPane.showInputDialog(this, "Nome: ", p.getNome());
					String cpf = JOptionPane.showInputDialog(this, "CPF: ", p.getCpf());
					String rg = JOptionPane.showInputDialog(this, "RG: ", p.getRg());
					String especialidade = JOptionPane.showInputDialog(this, "Descricao:" ,p.getEspecialidade());
					p.setNome(nome);
					p.setCpf(cpf);
					p.setRg(rg);
					p.setEspecialidade(especialidade);
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
			// Remover
			botaoNovissimo.addActionListener((e)->{
				try {
					int index = listagem.getSelectedIndex();
					DataLayer.hi().removeProfessorAt(index);
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
