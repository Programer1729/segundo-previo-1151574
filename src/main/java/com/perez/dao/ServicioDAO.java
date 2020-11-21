package com.perez.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.perez.model.Cliente;
import com.perez.model.JPAUtil;
import com.perez.model.Servicio;
import com.perez.model.Tienda;

public class ServicioDAO {
private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager(); 
	
	public void guardar(Servicio servicio) {
		entity.getTransaction().begin();
		entity.persist(servicio);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void editar(Servicio servicio) {
		entity.getTransaction().begin();
		entity.merge(servicio); 
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Servicio buscar(long id) {
		Servicio s = new Servicio();
		s = entity.find(Servicio.class, id); 
		//JPAUtil.shutdown();
		return s;
	} 
	
	public List<Servicio> obtenerClientes(){
		List<Servicio> servicios = new ArrayList<Servicio>(); 
		Query q = entity.createQuery("SELECT s FROM Servicio s"); 
		servicios = q.getResultList(); 
		return servicios;
	} 
	
	public void eliminar(long id) {
		Servicio s = entity.find(Servicio.class, id); 
		entity.getTransaction().begin(); 
		entity.remove(s);
		entity.getTransaction().commit();
	}
}
