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
public class CadastroProfessorJanela extends JFrame {

	public JPanel tituloPanel;
	public JPanel nomePanel;
	public JPanel cpfPanel;
	public JPanel rgPanel;
	public JPanel especialidadePanel;
	public JPanel botoesPanel;
	public JLabel tituloTexto;
	public JLabel nomeLabel;
	public JLabel cpfLabel;
	public JLabel rgLabel;
	public JLabel especialidadeLabel;
	public JTextField nomeField;
	public JTextField cpfField;
	public JTextField rgField;
	public JTextField especialidadeField;
	public JButton adicionarButton;
	public JButton cancelarButton;
	
	
	public CadastroProfessorJanela(MyListModel<Professor> listagemModel){
		super("Cadastro Professor");
	
		tituloPanel = new JPanel();
		tituloTexto = new JLabel("Cadastro Professor");
		nomePanel = new JPanel();
		nomeLabel = new JLabel("Nome: ");
		nomeField = new JTextField(15);
		cpfPanel = new JPanel();
		cpfLabel = new JLabel("CPF: ");
		cpfField = new JTextField(15);
		rgPanel = new JPanel();
		rgLabel = new JLabel("RG: ");
		rgField = new JTextField(15);
		especialidadePanel = new JPanel();
		especialidadeLabel = new JLabel("Especialidade: ");
		especialidadeField = new JTextField(10);
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
		especialidadePanel.add(especialidadeLabel);
		especialidadePanel.add(especialidadeField);
		add(especialidadePanel);
		botoesPanel.add(adicionarButton);
		botoesPanel.add(cancelarButton);
		add(botoesPanel);
		
		adicionarButton.addActionListener((e)->{
				Professor p = new Professor();
				p.setNome(nomeField.getText());
				p.setCpf(cpfField.getText());
				p.setRg(rgField.getText());
				p.setEspecialidade(especialidadeField.getText());
				DataLayer.hi().addProfessor(p);
				listagemModel.add(p);
				nomeField.setText("");
				cpfField.setText("");
				rgField.setText("");
				especialidadeField.setText("");
			});
		cancelarButton.addActionListener((e)->{
				setVisible(false);
				dispose();
			});
		
		setSize(300,300);
		setVisible(true);
	}
}

