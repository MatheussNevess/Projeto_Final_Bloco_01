package ecommerce;

public class Perfume extends Produto implements Itens {

	private String marca;

	public Perfume(String nome, double preco, String marca) {
		super(nome, preco);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public double calcularDesconto() {
		return getPreco() * 0.9; // 10% de desconto
	}

	@Override
	public void exibirDetalhes() {
		System.out.println("Perfume ");
		System.out.println("Nome: " + getNome());
		System.out.println("Marca: " + getMarca());
		System.out.println("Preco: R$" + getPreco());
	}

	@Override
	public double calcularPrecoFinal() {
		return calcularDesconto();
	}
}
