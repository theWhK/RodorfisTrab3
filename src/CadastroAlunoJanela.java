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
import javax.swing.JTextField;

@SuppressWarnings("serial")	
public class CadastroAlunoJanela extends JFrame {

	public JPanel tituloPanel;
	public JPanel nomePanel;
	public JPanel cpfPanel;
	public JPanel rgPanel;
	public JPanel raPanel;
	public JPanel dataMatriculaPanel;
	public JPanel botoesPanel;
	public JLabel tituloTexto;
	public JLabel nomeLabel;
	public JLabel cpfLabel;
	public JLabel rgLabel;
	public JLabel raLabel;
	public JLabel dataMatriculaLabel;
	public JTextField nomeField;
	public JTextField cpfField;
	public JTextField rgField;
	public JTextField raField;
	public JTextField dataMatriculaField;
	public JButton adicionarButton;
	public JButton cancelarButton;
	
	
	public CadastroAlunoJanela(MyListModel<Aluno> listagemModel){
		super("Cadastro Aluno");
	
		tituloPanel = new JPanel();
		tituloTexto = new JLabel("Cadastro Aluno");
		nomePanel = new JPanel();
		nomeLabel = new JLabel("Nome: ");
		nomeField = new JTextField(15);
		cpfPanel = new JPanel();
		cpfLabel = new JLabel("CPF: ");
		cpfField = new JTextField(15);
		rgPanel = new JPanel();
		rgLabel = new JLabel("RG: ");
		rgField = new JTextField(15);
		raPanel = new JPanel();
		raLabel = new JLabel("RA: ");
		raField = new JTextField(10);
		dataMatriculaPanel = new JPanel();
		dataMatriculaLabel = new JLabel("Data de Matricula: ");
		dataMatriculaField = new JTextField(10);
		botoesPanel = new JPanel();
		adicionarButton = new JButton("Adicionar");
		cancelarButton = new JButton("Cancelar");
		
		setLayout(new GridLayout(7, 1));
		
		tituloPanel.add(tituloTexto);
		add(tituloPanel);
		nomePanel.add(nomeLabel);
		nomePanel.add(nomeField);
		add(nomePanel);
		cpfPanel.add(cpfLabel);
		cpfPanel.add(cpfField);
		add(cpfPanel);
		rgPanel.add(rgLabel);
		rgPanel.add(rgField);
		add(rgPanel);
		raPanel.add(raLabel);
		raPanel.add(raField);
		add(raPanel);
		dataMatriculaPanel.add(dataMatriculaLabel);
		dataMatriculaPanel.add(dataMatriculaField);
		add(dataMatriculaPanel);
		botoesPanel.add(adicionarButton);
		botoesPanel.add(cancelarButton);
		add(botoesPanel);
		
		adicionarButton.addActionListener((e)->{
				Aluno a = new Aluno();
				a.setNome(nomeField.getText());
				a.setCpf(cpfField.getText());
				a.setRg(rgField.getText());
				a.setRa(raField.getText());
				a.setDataDeMatricula(dataMatriculaField.getText());
				DataLayer.hi().addAluno(a);
				listagemModel.add(a);
				nomeField.setText("");
				cpfField.setText("");
				rgField.setText("");
				raField.setText("");
				dataMatriculaField.setText("");
			});
		cancelarButton.addActionListener((e)->{
				setVisible(false);
				dispose();
			});
		
		setSize(300,300);
		setVisible(true);
	}
}
