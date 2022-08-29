package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import model.entidades.Pagamento;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Entre com o número de pagamentos: ");
		Integer numero_pagamentos = scanner.nextInt();
		scanner.nextLine();
		
		if(numero_pagamentos != null) {
			for(Integer i = 1; i <= numero_pagamentos; i++) {
				System.out.printf("Pagamento #%d.\n", i);
				System.out.print("É [C]artão ou [B]oleto (C/B)? ");
				String resposta = scanner.nextLine();
				if(resposta.toUpperCase().equals("C")) {
					System.out.print("Escolheu cartão.");					
				} else if(resposta.toUpperCase().equals("B")) {
					System.out.print("Escolheu boleto.");										
				} else {
					System.out.print("Escolheu opção inválida.");															
				}
				
			}
		}
		
		Pagamento pagamento = new Pagamento();

	}

}
