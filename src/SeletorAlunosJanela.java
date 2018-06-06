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
import java.awt.Dimension;

@SuppressWarnings("serial")
public class SeletorAlunosJanela extends JFrame {
	
	public JPanel titulo;
	public JLabel tituloTexto;
	public JList<Aluno> listagemAlunos;
	public JList<Aluno> listagemAlunosTurma;
	public List<Aluno> listaAlunos;
	public List<Aluno> listaAlunosTurma;
	public MyListModel<Aluno> listaAlunosModel;
	public MyListModel<Aluno> listaAlunosTurmaModel;
	
	public SeletorAlunosJanela(){
		super("Seletor de Alunos");
		
		listaAlunos = CRUDFaculdade.hi().getAlunos();
		listaAlunosModel = new MyListModel<>();
		
		for(int i = 0; i < listaAlunos.size(); i++){
			listaAlunosModel.add(listaAlunos.get(i));
		}
		
		
	}
}
