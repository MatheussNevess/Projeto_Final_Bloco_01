package ecommerce;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static Scanner leia = new Scanner(System.in);
	public static Loja loja = new Loja();

	public static void main(String[] args) {

		int opcao = 0;

		while (opcao != 3) {
			exibirMenu();
			opcao = leia.nextInt();
			leia.nextLine();

			switch (opcao) {
			case 1:
				listarProdutos();
				keyPress();
				break;
			case 2:
				venderProduto();
				keyPress();
				break;
			case 3:
				System.out.println("Saindo...");
				sobre();
				break;
			default:
				System.out.println("Opção inválida. Escolha novamente.");
				break;
			}
		}

		leia.close();
	}

	private static void exibirMenu() {
		System.out.println("=== Menu ===");
		System.out.println("1. Listas Perfumes");
		System.out.println("2. Comprar Perfume");
		System.out.println("3. Sair");
		System.out.print("Escolha uma opção: ");

	}

	private static void listarProdutos() {
		System.out.println("\n=== Perfumes Disponíveis ===");
		List<Produto> perfumes = loja.listarPerfumes();
		for (Produto perfume : perfumes) {
			System.out.println("Nome: " + perfume.getNome());
			System.out.println("Preço: R$" + perfume.getPreco());
			if (perfume instanceof Perfume) {
				System.out.println("Marca: " + ((Perfume) perfume).getMarca());
			}
			System.out.println("=====================");
		}
	}

	private static void venderProduto() {
		listarProdutos();

		System.out.print("\nDigite o nome do perfume que deseja comprar: ");
		String nomePerfume = leia.nextLine();

		Produto produtoParaVender = null;

		for (Produto produto : loja.listarPerfumes()) {
			if (produto.getNome().equalsIgnoreCase(nomePerfume)) {
				produtoParaVender = produto;
				break;
			}
		}

		if (produtoParaVender != null) {
			boolean perfumeVendido = loja.venderProduto(produtoParaVender);
			if (perfumeVendido) {
				System.out.println("Compra realizada com sucesso:");
				System.out.println("Nome do perfume: " + produtoParaVender.getNome());
				System.out.println("Preço: R$" + produtoParaVender.getPreco());
				if (produtoParaVender instanceof Perfume) {
					System.out.println("Marca: " + ((Perfume) produtoParaVender).getMarca());
				}
			} else {
				System.out.println("Produto não encontrado na loja.");
			}
		} else {
			System.out.println("Produto não encontrado na loja.");
		}
	}

	public static void sobre() {
		System.out.println("*******************************************************");
		System.out.println("Projeto desenvolvido por: Matheus Wendel Dumas Neves");
		System.out.println("Email: Matheuswdn@gmail.com");
		System.out.println("https://github.com/MatheussNevess");
		System.out.println("*******************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}

}
