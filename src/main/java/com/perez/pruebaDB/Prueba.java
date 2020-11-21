package com.perez.pruebaDB;

import java.util.List;

import com.perez.dao.ClienteDAO;
import com.perez.dao.ServicioDAO;
import com.perez.dao.TiendaDAO;
import com.perez.model.Cliente;
import com.perez.model.Servicio;
import com.perez.model.Tienda;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteDAO clienteDao = new ClienteDAO(); 
		TiendaDAO tiendaDao = new TiendaDAO();
		ServicioDAO servicioDao = new ServicioDAO();
		
		/*
		 * CREACION DE UN CLIENTE 
		 */ 
		Cliente c = new Cliente(); 
		c.setNombre("John Doe"); 
		c.setEmail("john@gmail.com");
		c.setClave("12345");
		clienteDao.guardar(c); 
		
		/*
		 * CREACION DE UNA TIENDA 
		 */ 
		Tienda t = new Tienda(); 
		t.setNombre("apple"); 
		t.setLema("Compra barato");
		t.setDescripcion("empresa venta tech");
		t.setEmail("apple@correo.com");
		t.setClave("apple123");
		t.setPropietario("Manuel");
		t.setFacebook("appleinc");
		t.setWeb("apple.com");
		t.setImagen("sdnvsd");
		tiendaDao.guardar(t);
		
		
		/*
		 * CREACION SERVICIO
		 */ 
		Servicio s = new Servicio(); 
		s.setNombre("prepago servicios"); 
		s.setDescripcion("Prepago de servicios publicos"); 
		s.setTienda(t);
		servicioDao.guardar(s); 
		

		/*
		 * SEGUIR TIENDA POR CLIENTE
		 */ 
		clienteDao.seguirTienda(c, t); 
		
		/*
		 * ACTUALIZAR TIENDA
		 */ 
		Tienda tienda = tiendaDao.buscar(7);
		tienda.setNombre("Samsung");
		tienda.setLema("empresa tech");
		tienda.setDescripcion("venta aparatos tech");
		tienda.setEmail("samsung@gmail.com");
		tienda.setClave("abcedf");
		tiendaDao.editar(tienda);
	}

}
