import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public final class GestorFaculdadeJanela extends JFrame {
	public GestorFaculdadeJanela() {
		super("Gestor de Faculdade");
		
		// Inicializa a grid
		GridLayout grid = new GridLayout(4,1);
		setLayout(grid);
		
		// Inicia os elementos
		JPanel titulo = new JPanel();
		JLabel tituloTexto = new JLabel("OURIÇOS FACULDAIDS");
		JButton b1 = new JButton("Gerenciar Alunos");
		JButton b2 = new JButton("Gerenciar Professores");
		JButton b3 = new JButton("Gerenciar Turmas");
		titulo.add(tituloTexto);
		
		// Listeners
			// Gerenciar alunos
			b1.addActionListener((e)->{
				@SuppressWarnings("unused")
				ListarAlunosJanela eita = new ListarAlunosJanela();
			});
			
			//Gerenciar professores
			b2.addActionListener((e)->{
				@SuppressWarnings("unused")
				ListarProfessorJanela eita = new ListarProfessorJanela();
			});
			
			// Gerenciar turmas
			b3.addActionListener((e)->{
				@SuppressWarnings("unused")
				ListarTurmasJanela eita = new ListarTurmasJanela();
			});
		
		// Insere os elementos na interface
		add(titulo);
		add(b1);
		add(b2);
		add(b3);
		setSize(500,500);
		
		// Exibe a interface
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		new GestorFaculdadeJanela();
	}
}
