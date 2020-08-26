package br.uniucb.entidadesUni;
 
public class Diretor extends Funcionario {
 
	private double tempoDeCasa;

// Construtor que inicializa os dados do Diretor
	public Diretor(String nome,int matricula, String cpf, double salario, double tempoDeCasa) {
		super(nome, matricula, cpf, salario);
		this.tempoDeCasa = tempoDeCasa;
	}

// Uso da subscrita toString
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + "\tMatr�cula: " + super.getMatricula() + "\tCpf: " + super.getCpf()
				+ "\tSal�rio: " + super.getSalario() + "\ttempoDeCasa: " + this.tempoDeCasa;
	}

	public double getTempoDeCasa() {
		return tempoDeCasa;
	}

	public void setTempoDeCasa(double tempoDeCasa) {
		this.tempoDeCasa = tempoDeCasa;
	}

//Heran�a do m�todo getImporstoDeRenda da classe funcion�rio
	public double getImpostoDeRenda() {

		return getSalario() * 0.23;
	}

}
