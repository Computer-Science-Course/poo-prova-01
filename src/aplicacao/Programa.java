package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Pagamento;
import model.entidades.PagamentoCartaoDeCredito;
import model.enums.EstadoPagamento;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Entre com o número de pagamentos: ");
		Integer numero_pagamentos = scanner.nextInt();
		scanner.nextLine();
		
		if(numero_pagamentos != 0) {
			List<Pagamento> pagamentos = new ArrayList<>();
			
			for(Integer i = 1; i <= numero_pagamentos; i++) {
				System.out.printf("Pagamento #%d.\n", i);
				System.out.print("É [C]artão ou [B]oleto (C/B)? ");
				String resposta = scanner.nextLine();
				
				System.out.print("Id: ");					
				Integer id = scanner.nextInt();
				
				System.out.print("Estado de pagamento (PENDENTE, QUITADO ou CANCELADO): ");
				scanner.nextLine();
				String estado = scanner.nextLine();
				
				System.out.print("Valor: ");
				Double valor = scanner.nextDouble();
				
				if(resposta.toUpperCase().equals("C")) {
					System.out.print("Número de parcelas: ");					
					Integer numeroParcelas = scanner.nextInt();
					
					System.out.print("Taxa de juros: ");					
					Double taxaJuros = scanner.nextDouble();
					
					pagamentos.add(new PagamentoCartaoDeCredito(
							id, EstadoPagamento.valueOf(estado), valor, numeroParcelas, taxaJuros
					));
					
				} else if(resposta.toUpperCase().equals("B")) {
					System.out.print("Escolheu boleto.");										
				} else {
					System.out.print("Escolheu opção inválida.");															
				}
				scanner.nextLine();
				
			}
			// Imprimindo os relatórios
			System.out.println("Pagamentos: ");
			for(Pagamento pagamento: pagamentos) {
				System.out.println(pagamento.relatorio());
			}
		}
		
		scanner.close();

	}

}
