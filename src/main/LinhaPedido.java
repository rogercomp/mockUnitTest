package main;

public class LinhaPedido {
	
	public Produto produto;
	public int quantidade;

	public LinhaPedido(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public double calcularPreco() {
		return produto.obterPreco(quantidade);
	}
}
