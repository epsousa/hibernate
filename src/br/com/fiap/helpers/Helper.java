package br.com.fiap.helpers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.fiap.core.HibernateUtil;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class Helper {
	Session session = null;
	Transaction transaction = null;

	public String salvar(Pedido pedido) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(pedido);
			transaction.commit();
			return "Pedido salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String salvar(Cliente cliente) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
			return "Cliente salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String adicionarCliente(int idCliente, int idPedidos) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			Cliente c = (Cliente) session.load(Cliente.class, idCliente);
			Pedido p = (Pedido) session.load(Pedido.class, idPedidos);
			c.setPedido(p);
			session.save(c);
			transaction.commit();
			return "Associação realizada";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Cliente> getClientes() {
		List<Cliente> clientes = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			Query listaClientes = session.createQuery("from Cliente");
			clientes = listaClientes.list();
			transaction.commit();
			return clientes;
		} catch (Exception e) {
			e.getMessage();
		}
		return clientes;
	}

	public List<Pedido> getPedidos() {
		List<Pedido> pedidos = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			Query listaPedido = session.createQuery("from Pedido");
			pedidos = listaPedido.list();
			transaction.commit();
			return pedidos;
		} catch (Exception e) {
			e.getMessage();
		}
		return pedidos;
	}
	
	public Cliente getClienteById(int id) {
		Cliente cliente = new Cliente();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.load(cliente, id);
			transaction.commit();
			return cliente;
		} catch (Exception e) {
			e.getMessage();
		}
		return cliente;
	}

	public Pedido getPedidoById(int id) {
		Pedido pedido = new Pedido();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.load(pedido, id);
			transaction.commit();
			return pedido;
		} catch (Exception e) {
			e.getMessage();
		}
		return pedido;
	}
}
