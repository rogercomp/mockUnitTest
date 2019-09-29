package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import main.Cliente;
import main.LinhaPedido;
import main.Pedido;

@RunWith(MockitoJUnitRunner.class)
public class TestePedido {

	@Mock
	private Cliente cliente;
	
	private Pedido pedido;	
	
	private List<LinhaPedido> linhaPedidos = new ArrayList<>();
	
	@Mock
	private LinhaPedido linhaPedido1;
	
	@Mock
	private LinhaPedido linhaPedido2;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		linhaPedidos.add(linhaPedido1);
		linhaPedidos.add(linhaPedido2);
	}
	
		
	@Test
	public void testarCenario1() {
		Mockito.when(linhaPedido1.calcularPreco()).thenReturn(80.00);
		Mockito.when(linhaPedido2.calcularPreco()).thenReturn(60.00);
		pedido = new Pedido(linhaPedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(10.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorSemDesconto,140.0);
	}
	
	@Test
	public void testarCenario2() {
		Mockito.when(linhaPedido1.calcularPreco()).thenReturn(60.00);
		Mockito.when(linhaPedido2.calcularPreco()).thenReturn(30.00);
		pedido = new Pedido(linhaPedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(10.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorComDesconto,10.0);
	}
	
	@Test
	public void testarCenario3() {
		Mockito.when(linhaPedido1.calcularPreco()).thenReturn(80.00);
		Mockito.when(linhaPedido2.calcularPreco()).thenReturn(20.00);
		pedido = new Pedido(linhaPedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(-10.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorComDesconto,0.0);
	}
	
	@Test
	public void testarCenario4() {
		Mockito.when(linhaPedido1.calcularPreco()).thenReturn(-40.00);
		Mockito.when(linhaPedido2.calcularPreco()).thenReturn(-60.00);
		pedido = new Pedido(linhaPedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(20.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorSemDesconto,0.0);
	}
}
