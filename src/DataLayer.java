import java.util.ArrayList;
import java.util.List;

public class DataLayer {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Turma> turmas = new ArrayList<Turma>();
	private static DataLayer instance;
	
	public static DataLayer hi(){
		if (instance == null) {
			instance = new DataLayer();
		}
		
		return instance;
	}
	
	public boolean addAluno(Aluno a) {
		if (alunos.add(a)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeAlunoAt(int i) {
		if (!alunos.isEmpty()) {
			if (alunos.remove(i) != null) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Aluno> getAlunos() {
		return this.alunos;
	}
	
	public Aluno getAluno(int i) {
		return alunos.get(i);
	}
	
	public boolean addProfessor(Professor p) {
		if(professores.add(p)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeProfessorAt(int i) {
		if(!professores.isEmpty()) {
			if(professores.remove(i) != null) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Professor> getProfessor(){
		return this.professores;
	}
	
	public Professor getProfessor(int i) {
		return professores.get(i);
	}
	
	public boolean addTurma(Turma t) {
		if(turmas.add(t)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeTurmaAt(int i) {
		if(!turmas.isEmpty()) {
			if(turmas.remove(i) != null) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Turma> getTurma(){
		return this.turmas;
	}
	
	public Turma getTurma(int i) {
		return turmas.get(i);
	}
}
