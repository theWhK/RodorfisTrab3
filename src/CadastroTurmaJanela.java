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
import javax.swing.JComboBox;

@SuppressWarnings("serial")	
public class CadastroTurmaJanela extends JFrame {

	public JPanel tituloPanel;
	public JPanel descricaoPanel;
	public JPanel dataInicioPanel;
	public JPanel dataTerminoPanel;
	public JPanel botoesPanel;
	public JPanel professorPanel;
	public JLabel tituloTexto;
	public JLabel descricaoLabel;
	public JLabel dataInicioLabel;
	public JLabel dataTerminoLabel;
	public JLabel professorLabel;
	public JComboBox<Professor> professorComboBox;
	public JTextField descricaoField;
	public JTextField dataInicioField;
	public JTextField dataTerminoField;
	public JButton adicionarButton;
	public JButton cancelarButton;
	public List<Professor> listagemProfs;
	public Professor[] arrayProfs;
	
	
	public CadastroTurmaJanela(MyListModel<Turma> listagemModel){
		super("Cadastro Turma");
	
		listagemProfs = DataLayer.hi().getProfessor();
		arrayProfs = new Professor[listagemProfs.size()];
		
		for(int i=0; i<listagemProfs.size(); i++){
			arrayProfs[i] = listagemProfs.get(i);
		}
		
		tituloPanel = new JPanel();
		tituloTexto = new JLabel("Cadastro Turma");
		descricaoPanel = new JPanel();
		descricaoLabel = new JLabel("Descrição: ");
		descricaoField = new JTextField(15);
		dataInicioPanel = new JPanel();
		dataInicioLabel = new JLabel("Data de Início: ");
		dataInicioField = new JTextField(15);
		dataTerminoPanel = new JPanel();
		dataTerminoLabel = new JLabel("Data de Termino: ");
		dataTerminoField = new JTextField(15);
		botoesPanel = new JPanel();
		adicionarButton = new JButton("Adicionar");
		cancelarButton = new JButton("Cancelar");
		professorPanel = new JPanel();
		professorLabel = new JLabel("Professor: ");
		professorComboBox = new JComboBox(arrayProfs);
		
		setLayout(new GridLayout(7, 1));
		
		tituloPanel.add(tituloTexto);
		add(tituloPanel);
		descricaoPanel.add(descricaoLabel);
		descricaoPanel.add(descricaoField);
		add(descricaoPanel);
		dataInicioPanel.add(dataInicioLabel);
		dataInicioPanel.add(dataInicioField);
		add(dataInicioPanel);
		dataTerminoPanel.add(dataTerminoLabel);
		dataTerminoPanel.add(dataTerminoField);
		add(dataTerminoPanel);
		professorPanel.add(professorLabel);
		professorPanel.add(professorComboBox);
		add(professorPanel);
		botoesPanel.add(adicionarButton);
		botoesPanel.add(cancelarButton);
		add(botoesPanel);
		
		adicionarButton.addActionListener((e)->{
				Turma t = new Turma();
				t.setDescricao(descricaoField.getText());
				t.setDataInicio(dataInicioField.getText());
				t.setDataTermino(dataTerminoField.getText());
				t.setProfessor((Professor)professorComboBox.getSelectedItem());
				DataLayer.hi().addTurma(t);
				listagemModel.add(t);
				descricaoField.setText("");
				dataInicioField.setText("");
				dataTerminoField.setText("");
			});
		cancelarButton.addActionListener((e)->{
				setVisible(false);
				dispose();
			});
		
		setSize(300,300);
		setVisible(true);
	}
}


