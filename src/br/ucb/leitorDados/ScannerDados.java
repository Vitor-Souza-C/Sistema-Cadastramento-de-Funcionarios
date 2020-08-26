package br.ucb.leitorDados;

import java.util.Scanner;

public class ScannerDados{ // Classe para leitura de dados, apenas métodos
	
	public static String lerString(String mensagem) {
		System.out.println(mensagem);
		return new Scanner(System.in).next();
	}

	public static char lerChar(String mensagem) {
		System.out.println(mensagem);
		return new Scanner(System.in).next().charAt(0);
	}

	public static double lerDouble(String mensagem) {
		System.out.println(mensagem);
		return new Scanner(System.in).nextDouble();
	}

	public static int lerInt(String mensagem) {
		System.out.println(mensagem);
		return new Scanner(System.in).nextInt();
	}

	public static void mensagem(String mensagem) {
		 System.out.println(mensagem);
		System.out.println();
	}
}