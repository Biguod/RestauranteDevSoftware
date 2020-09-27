package br.edu.up.crud;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;
import br.edu.up.sistema.Armazenamento;

public class Criar {

	public void incluirPrato(List<Prato> listaPratos){

		Prato prato = new Prato();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DO PRATO QUE DESEJA ADICIONAR NO CARDAPIO");
		prato.nome = leitor.nextLine();
		System.out.println("DIGITE O PRE�O DO PRATO INCLUIDO");
		prato.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaPratos.add(prato);
		Armazenamento.salvarPrato(prato);

		// leitor.close();

	}

	public void incluirBebida(List<Bebida> listaBebidas){

		Bebida bebida = new Bebida();

		Scanner leitor = new Scanner(System.in);

		System.out.println("DIGITE O NOME DA BEBIDA QUE DESEJA ADICIONAR NO CARDAPIO");
		bebida.nome = leitor.nextLine();
		System.out.println("DIGITE O PRE�O DA BEBIDA INCLUIDA");
		bebida.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));

		listaBebidas.add(bebida);
		Armazenamento.salvarBebida(bebida);

		// leitor.close();

	}

	public void incluirVinho(List<Vinho> listaVinhos){
		
		Vinho vinhos = new Vinho();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("DIGITE O NOME DO VINHO QUE DESEJA ADICIONAR NO CARDAPIO");
		vinhos.nome = leitor.nextLine();
		System.out.println("DIGITE O PRE�O DO VINHO INCLUIDO");
		vinhos.preco = Double.parseDouble(leitor.nextLine().replaceAll(",", "."));
		
		Vinho vinho = new Vinho(vinhos.preco, vinhos.nome);
		Vinho.Incluir(listaVinhos, vinho);
		
		
		Armazenamento.salvarVinho(vinho);

		
//		listaVinhos.add(vinhos);
		

		// leitor.close();

	}
	


}
