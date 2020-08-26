package br.uniucb.entidadesUni;
 
public class Professor extends Funcionario {
 
	private int anoDeAdmissao;

// construtor que inicializa os dados do professor
	public Professor(String nome, int matricula, String cpf, double salario, int anoDeAdmissao) {
		super(nome, matricula, cpf, salario);
		this.anoDeAdmissao = anoDeAdmissao;
	}

// Uso da subscrita toString
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + "\tMatrícula: " + super.getMatricula() + "\tCpf: " + super.getCpf()
				+ "\tSalário: " + super.getSalario() + "\tAno de admissão: " + this.anoDeAdmissao;
	}

	public int getAnoDeAdmisao() {
		return anoDeAdmissao;
	}

	public void setAnoDeAdmisao(int anoDeAdmisao) {
		this.anoDeAdmissao = anoDeAdmisao;
	}

//Herança do método getImporstoDeRenda da classe funcionário
	public double getImpostoDeRenda() {

		return getSalario() * 0.2;
	}

}