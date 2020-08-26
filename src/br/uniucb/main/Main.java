package br.uniucb.main;

import java.util.ArrayList;
import java.util.Scanner;
import br.uniucb.entidadesUni.Diretor;
import br.uniucb.entidadesUni.Funcionario;
import br.uniucb.entidadesUni.Professor;
import br.ucb.leitorDados.ScannerDados;

public class Main {
	public static void main(String[] args) {
		ArrayList<Funcionario> listaFunci = new ArrayList<>(); // Cria uma ArrayList
		ScannerDados sc = new ScannerDados(); // Cria o objeto 'sc' da classe ScannerDados
		char continuacao; // delclara variavel de continuidade
// executa a inclus�o de funcionarios ate o usuario pressionar 'n' para sair e obter os outros resultados
		do {
// recebe do usuario os dados do funcionario 
			sc.mensagem("- Sistema de cadastramento de funcion�rios da UCB (UNIVERSIDADE CAT�LICA DE BRASILIA) -");

			String nome = sc.lerString("�nforme o nome:");
			String cpf = sc.lerString("�nforme o cpf:");
			double salario = sc.lerDouble("�nforme o salario:");
			int matricula = sc.lerInt("�nforme a matricula:");

			char cargo = sc.lerChar("�nforme o cargo: ('d' - diretor / 'p' - professor)");

			double tempoDeCasa = 0;
			int anoDeAdmissao = 0;

			if (cargo == 'd') {
				tempoDeCasa = sc.lerDouble("�nforme o tempo de casa em meses:");
			} else {
				anoDeAdmissao = sc.lerInt("�nforme o ano de admiss�o:");

			}

//valida o cargo, se o funcionario for repetido e insere no array quando as validac�es estiverem corretas

			boolean cadastroRepetido = false;

			if (cargo == 'd') {
				Diretor d1 = new Diretor(nome, matricula, cpf, salario, tempoDeCasa);

				for (int i = 0; i < listaFunci.size(); i++) {// verifica se existe funcion�rio repetido com equals
					if (d1.equals(listaFunci.get(i))) {
						cadastroRepetido = true;
					}
				}
				if (cadastroRepetido) {
					sc.mensagem("O funcionario j� est� cadastrado! o cadastro n�o foi realizado!");
				} else {
					listaFunci.add(d1); // inclui no array um Diretor
					sc.mensagem("Cadastro realizado!");
					sc.mensagem(d1.toString()); // exibe dados do funcionario cadastrado via toString
				}

			} else if (cargo == 'p') {
				Professor p1 = new Professor(nome, matricula, cpf, salario, anoDeAdmissao);
// verifica se existe funcionario repetido com o equals
				for (int i = 0; i < listaFunci.size(); i++) {
					if (p1.equals(listaFunci.get(i))) {
						cadastroRepetido = true;
					}
				}
				if (cadastroRepetido) {// Caso for verdadeiro a proposi��o o funcionario n�o � adicionado
					sc.mensagem("Funcionario j� cadastrado! o cadastro n�o foi realizado!");
				} else {
					listaFunci.add(p1); // inclui no array um professor
					sc.mensagem("Cadastro realizado!");
					sc.mensagem(p1.toString()); // exibe os dados do funcionario cadastrado pelo toString
				}
			} else {

				sc.mensagem("Cargo inexistente, o funcion�rio n�o foi cadastrado!"); // caso o cargo seja diferente dos valores
																						// 'd' ou 'p'
			}

			continuacao = sc.lerChar("Voc� deseja continuar?(Pressione 'n' para sair!)");
		} while (continuacao != 'n');
//Fim do loop
		double totalImpostoRenda = 0;
		double mediaImpostoRenda = 0;

//calcula total de imposto de renda de cada funcion�rio adicionado
		for (int i = 0; i < listaFunci.size(); i++) {
			totalImpostoRenda = totalImpostoRenda + listaFunci.get(i).getImpostoDeRenda();
		}
//calcula media de imposto de renda de cada funion�rio
		mediaImpostoRenda = totalImpostoRenda / listaFunci.size();
//exibe mensagem com os valores de imposto de renda
		sc.mensagem("O valor total do Imposto de Renda � R$: " + totalImpostoRenda);
		sc.mensagem("A m�dia de Imposto de Renda � R$: " + mediaImpostoRenda);
//Apresenta ao usu�rio os funcion�rios adicionados!
		sc.mensagem("Lista de funcion�rios j� adicionados:\n" + listaFunci.toString());

	}

}
