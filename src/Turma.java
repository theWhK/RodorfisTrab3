import java.util.ArrayList;
import java.util.List;

public class Turma {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private Professor professor;
	private String dataInicio, dataTermino, descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
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
	
	@Override
	public String toString()
	{
		return getDescricao();
	}
}
