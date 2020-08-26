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
		return "Nome: " + super.getNome() + "\tMatrícula: " + super.getMatricula() + "\tCpf: " + super.getCpf()
				+ "\tSalário: " + super.getSalario() + "\ttempoDeCasa: " + this.tempoDeCasa;
	}

	public double getTempoDeCasa() {
		return tempoDeCasa;
	}

	public void setTempoDeCasa(double tempoDeCasa) {
		this.tempoDeCasa = tempoDeCasa;
	}

//Herança do método getImporstoDeRenda da classe funcionário
	public double getImpostoDeRenda() {

		return getSalario() * 0.23;
	}

}
