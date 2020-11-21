package com.perez.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.perez.model.Cliente;
import com.perez.model.JPAUtil;
import com.perez.model.Tienda;

public class ClienteDAO {

	private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager(); 
	
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente); 
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Cliente buscar(long id) {
		Cliente c = new Cliente(); 
		c = entity.find(Cliente.class, id); 
		//JPAUtil.shutdown();
		return c;
	} 
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>(); 
		Query q = entity.createQuery("SELECT c FROM Cliente c"); 
		clientes = q.getResultList(); 
		return clientes;
	} 
	
	public void eliminar(long id) {
		Cliente c = entity.find(Cliente.class, id); 
		entity.getTransaction().begin(); 
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
	public void seguirTienda(Cliente c, Tienda t) {
		entity.getTransaction().begin(); 
		c.getTiendas().add(t); 
		entity.merge(c); 
		entity.getTransaction().commit();
	}
	
	
	
}
