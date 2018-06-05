
public class Aluno extends Pessoa {
	private String dataDeMatricula, ra;
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getDataDeMatricula() {
		return dataDeMatricula;
	}
	public void setDataDeMatricula(String dataDeMatricula) {
		this.dataDeMatricula = dataDeMatricula;
	}
	@Override
	public String toString()
	{
		return getNome() + "(" + getRa() + ")";
	}
}
