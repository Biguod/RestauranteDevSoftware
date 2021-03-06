package br.edu.up.dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.sistema.Impressora;

public class Cardapio {
	static Impressora impressora = new Impressora();
	
	public List<Prato> listaPratos = new ArrayList<Prato>();
	public List<Bebida> listaBebidas = new ArrayList<Bebida>();
	public List<Vinho> listaVinhos = new ArrayList<Vinho>();

	public void inicializarPratos(){

		File arquivo = new File("..\\Restaurante\\src\\arquivos\\pratos.csv");

		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "UTF-8"));
			String linha = null;
			leitor.readLine();
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split(";");
				
				Prato prato = new Prato();
				prato.setNome(partes[0]);
				prato.setPreco(Double.parseDouble(partes[1].replaceAll(",", ".")));
				
				listaPratos.add(prato);
				
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Erro na conversão de string para double");
		}

		

		// leitor.close();

	}


	public void inicializarBebidas(){

		File arquivo = new File("..\\Restaurante\\src\\arquivos\\bebidas-tabuladas.txt");

		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "UTF-8"));
			String linha = null;
			leitor.readLine();
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split("\t");
				
				Bebida bebida = new Bebida();
				bebida.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
				bebida.setNome(partes[1]);
				
				listaBebidas.add(bebida);
				
			}
		} catch ( NumberFormatException | IOException e) {
			System.out.println("Erro na conversão de string para double");
		}


		// leitor.close();

	}


	public void inicializarVinhos(){

		File arquivo = new File("..\\Restaurante\\src\\arquivos\\vinhos-tabulados.txt");

		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo.getAbsolutePath()), "UTF-8"));
			String linha = null;
			leitor.readLine();
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split("\t");
				
				Vinho vinho = new Vinho();
				vinho.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
				vinho.setNome(partes[1]);
				
				listaVinhos.add(vinho);
				
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Erro na conversão de string para double");
		}


//		leitor.close();

	}


	public void inicializarCardapio(){
			inicializarPratos();
			inicializarBebidas();
			inicializarVinhos();
	}

	public static Pedido selecionarPrato(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido)
			throws IOException {

//		Impressora impressora = new Impressora();
		
		impressora.imprimirPratos(cardapio.listaPratos);
		
		Scanner leitor = new Scanner(System.in);
		int opcao;
		String observacao;
		Prato prato = null;
		while (prato == null) {
			System.out.println("ESCOLHA O PRATO DESEJADO OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao <= cardapio.listaPratos.size() && opcao >= 1) {

				prato = cardapio.listaPratos.get(opcao - 1);

				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();

				if ((int) observacao.charAt(0) == (int) 's') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					prato.setObservacao(observacao);
				} else {
					prato.setObservacao("Nenhuma");
				}

				pedido.listaPratos.add(prato);

			}
			if (opcao == 0) {
				return pedido;
			}
		}
		return pedido;
		// leitor.close();
	}

	public static Pedido selecionarBebida(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido)
			throws IOException {
		
//		Impressora impressora = new Impressora();
		impressora.imprimirBebidas(cardapio.listaBebidas);

		Scanner leitor = new Scanner(System.in);
		int opcao;
		String observacao = "";
		Bebida bebida = null;
		while (bebida == null) {
			System.out.println("ESCOLHA A BEBIDA DESEJADA OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao <= cardapio.listaBebidas.size() && opcao >= 1) {

				bebida = cardapio.listaBebidas.get(opcao - 1);

				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();

				if ((int) observacao.charAt(0) == (int) 's') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					bebida.setObservacao(observacao);
				} else {
					bebida.setObservacao("Nenhuma");
				}

				pedido.listaBebidas.add(bebida);
			}
			if (opcao == 0) {
				return pedido;
			}
		}
		return pedido;

		// leitor.close();
	}

	public static Pedido selecionarVinho(Cardapio cardapio, List<Pedido> listaPedidos, Pedido pedido)
			throws IOException {

//		Impressora impressora = new Impressora();
		impressora.imprimirVinhos(cardapio.listaVinhos);

		Scanner leitor = new Scanner(System.in);
		int opcao;
		String observacao;
		Vinho vinho = null;
		while (vinho == null) {
			System.out.println("ESCOLHA O VINHO DESEJADO OU DIGITE 0 PARA VOLTAR AO MENU INICIAL");
			opcao = leitor.nextInt();
			leitor.nextLine();

			if (opcao <= cardapio.listaVinhos.size() && opcao >= 1) {

				vinho = cardapio.listaVinhos.get(opcao - 1);

				System.out.println("DIGITE 'S' SE DESEJA ADICIONAR OBSERVAÇÃO OU 'N' PARA CONTINUAR");
				observacao = leitor.nextLine();

				if ((int) observacao.charAt(0) == (int) 's') {
					System.out.println("DIGITE A SUA OBSERVAÇÃO: ");
					observacao = leitor.nextLine();
					vinho.setObservacao(observacao);
				} else {
					vinho.setObservacao("Nenhuma");
				}

				pedido.listaVinhos.add(vinho);

			}
			if (opcao == 0) {
				return pedido;
			}
		}
		return pedido;

		// leitor.close();
	}

}
