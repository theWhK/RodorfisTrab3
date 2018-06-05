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

public class ListarProfessorJanela extends JFrame {
	public JPanel titulo;
	public JPanel botoes;
	public JLabel tituloTexto;
	public JList<Aluno> listagem;
	public JButton botaoNovo;
	public JButton botaoMaisNovo;
	public JButton botaoNovissimo;
	
	public List<Professor> listagemProfessores;
	public MyListModel<Professor> listagemModel;
	
	public ListarProfessorJanela(){
		super("Listagem de Professores");
		
		listagemProfessores = CRUDFaculdade.hi().getProfessor();
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
				String rg = JOptionPane.showInputDialog(this, "Descriçào: ");
				String descricao = JOptionPane.showInputDialog(this, "Ra:" );
				Professor p = new Professor();
				a.setNome(nome);
				a.setCpf(cpf);
				a.setRg(rg);
				a.setRa(ra);
				a.setCpf(cpf);
				a.setDataDeMatricula(dataDeMatricula);
				CRUDFaculdade.hi().addAluno(a);
				listagemModel.add(a);
			});
	}
}
