package br.com.fiap.start;

import java.util.Date;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helpers.Helper;

public class TestaHibernate {

	private static Helper helper = new Helper();
	public static void main(String[] args) {
		incluirCliente();
		incluirPedido();
		relacionarUsuarioComPedido();
		retornarUsuario();
		retornarPedido();
		System.exit(0);
	}

	private static void retornarPedido() {
		//iterando sobre lista de pedidos
		for (Pedido pedido : helper.getPedidos()) {
			System.out.println(pedido);
		}
		
		//retorna um unico pedido
		System.out.println(helper.getPedidoById(1));
	}

	private static void retornarUsuario() {
		//iterando sobre lista de clientes
		for (Cliente cliente : helper.getClientes()) {
			System.out.println(cliente);
		}

		//retornando um unico cliente
		System.out.println(helper.getClienteById(2));
	}

	private static void relacionarUsuarioComPedido() {
		//relacionando pedido e cliente
		System.out.println(helper.adicionarCliente(1, 1));
		System.out.println(helper.adicionarCliente(2, 2));
	}

	private static void incluirPedido() {
		//incluindo pedidos
		Pedido pedido = new Pedido();
		pedido.setDescricao("Pedido 1");
		pedido.setData(new Date());
		pedido.setValor(1500D);
		System.out.println(helper.salvar(pedido));

		Pedido pedido2 = new Pedido();
		pedido.setDescricao("Pedido 2");
		pedido.setData(new Date());
		pedido.setValor(1500D);
		System.out.println(helper.salvar(pedido));

	}

	private static void incluirCliente() {
		//incluindo clientes
		Cliente cliente = new Cliente();
		cliente.setEmail("evairpereirasousa@hotmail.com");
		cliente.setNome("Evair Pereira Sousa");
		System.out.println(helper.salvar(cliente));

		Cliente cliente2 = new Cliente();
		cliente.setEmail("teste@hotmail.com");
		cliente.setNome("Teste Pereira Sousa");
		System.out.println(helper.salvar(cliente));
	}

}
