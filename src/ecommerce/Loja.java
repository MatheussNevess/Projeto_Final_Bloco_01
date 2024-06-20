package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Loja {

	List<Produto> produtos;

	public Loja() {
		this.produtos = new ArrayList<>();
		inicializarPerfumes();
	}

	private void inicializarPerfumes() {
		produtos.add(new Perfume("Chanel No. 5", 500.0, "Chanel"));
		produtos.add(new Perfume("Dior Sauvage", 400.0, "Dior"));
		produtos.add(new Perfume("Acqua di Gio", 350.0, "Giorgio Armani"));
		produtos.add(new Perfume("CK One", 200.0, "Calvin Klein"));
		produtos.add(new Perfume("La Vie Est Belle", 450.0, "Lancôme"));
	}

	public List<Produto> listarPerfumes() {
		List<Produto> perfumes = new ArrayList<>();
		for (Produto produto : produtos) {
			if (produto instanceof Perfume) {
				perfumes.add(produto);
			}
		}
		return perfumes;
	}

	public boolean venderProduto(Produto produto) {
		return produtos.remove(produto);

	}
}
