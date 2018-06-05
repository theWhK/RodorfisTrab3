
public class Professor extends Pessoa {
	private String especialidade;

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	@Override
	public String toString()
	{
		return getNome() + "(" + getEspecialidade() + ")";
	}
}
