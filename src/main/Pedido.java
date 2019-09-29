package main;

import java.util.List;

public class Pedido {

	public List<LinhaPedido> linhapedidos;
	public Cliente cliente;
	public double valorSemDesconto;
	public double valorComDesconto;

	public Pedido(List<LinhaPedido> linhapedidos, Cliente cliente) {
		this.linhapedidos = linhapedidos;
		this.cliente = cliente;
	}

	public void calcularPreco() {
		for (LinhaPedido linhaPedido : linhapedidos) {
			this.valorSemDesconto += linhaPedido.calcularPreco();
		}

		if (this.valorSemDesconto <= 0.0) {
			this.valorSemDesconto = 0.0;
		}

		this.valorComDesconto = cliente.obterValorComDesconto(this);
		if (this.valorComDesconto <= 0.0) {
			this.valorComDesconto = 0.0;
		}

		System.out.println("-----Resumo-----: ");
		System.out.println("Valor sem Desconto: " + valorSemDesconto);
		System.out.println("Valor com Desconto: " + valorComDesconto);
	}

	public double obterValorBase() {
		return this.valorSemDesconto;
	}
}
