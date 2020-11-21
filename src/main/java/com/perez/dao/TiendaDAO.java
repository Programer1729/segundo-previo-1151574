package com.perez.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.perez.model.Cliente;
import com.perez.model.JPAUtil;
import com.perez.model.Tienda;

public class TiendaDAO {
	
private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager(); 
	
	public void guardar(Tienda tienda) {
		entity.getTransaction().begin();
		entity.persist(tienda);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar(Tienda tienda) {
		entity.getTransaction().begin();
		entity.merge(tienda); 
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Tienda buscar(long id) {
		Tienda t = new Tienda();
		t = entity.find(Tienda.class, id); 
		//JPAUtil.shutdown();
		return t;
	} 
	
	public List<Tienda> obtenerClientes(){
		List<Tienda> tiendas = new ArrayList<Tienda>(); 
		Query q = entity.createQuery("SELECT t FROM Tienda t"); 
		tiendas = q.getResultList(); 
		return tiendas;
	} 
	
	public void eliminar(long id) {
		Cliente c = entity.find(Cliente.class, id); 
		entity.getTransaction().begin(); 
		entity.remove(c);
		entity.getTransaction().commit();
	}
}
