import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class SeletorProfessorJanela extends JFrame {
	
	public JPanel titulo;
	public JPanel botoes;
	public JLabel tituloTexto;
	public JComboBox<Professor> listagem;
	public JButton botaoNovo;
	
	public List<Professor> listagemProfs;
	public Professor[] arrayProfs;

	public SeletorProfessorJanela(Turma galera){
		super("Seletor de Professor");
		
		listagemProfs = CRUDFaculdade.hi().getProfessor();
		arrayProfs = new Professor[listagemProfs.size()];
		
		for(int i=0; i<listagemProfs.size(); i++){
			arrayProfs[i] = listagemProfs.get(i);
		}
		
		// Inicia os elementos
		titulo = new JPanel();
		tituloTexto = new JLabel("Seletor de Professor");
		listagem = new JComboBox(arrayProfs);
		botaoNovo = new JButton("Ok");
		botoes = new JPanel();	
		
		// Adiciona os elementos na interface
		titulo.add(tituloTexto);
		add(titulo, BorderLayout.NORTH);
		add(listagem);
		botoes.add(botaoNovo);
		add(botoes, BorderLayout.SOUTH);
		
		// Listeners
			// Criar
			botaoNovo.addActionListener((e)->{
				galera.setProfessor((Professor)listagem.getSelectedItem());
				setVisible(false);
			});
			/*// Atualizar
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
			// Remover
			botaoNovissimo.addActionListener((e)->{
				try {
					int index = listagem.getSelectedIndex();
					CRUDFaculdade.hi().removeAlunoAt(index);
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
			});*/
		
		// Mostra a interface
		setSize(500,200);
		setVisible(true);
	}
}
