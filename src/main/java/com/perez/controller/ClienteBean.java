package com.perez.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.perez.dao.ClienteDAO;
import com.perez.model.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	ClienteDAO clienteDao = new ClienteDAO();
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> clientes = clienteDao.obtenerClientes();
		return clientes;
	} 
	
	public String editar(long id) {
		Cliente c = clienteDao.buscar(id);
		System.out.println(c);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/editar.xhtml";
	} 
	
	public String actualizar(Cliente cliente) {
		clienteDao.editar(cliente);
		return "/faces/index.xhtml";
	} 
	
	public String eliminar(long id) {
		clienteDao.eliminar(id);
		return "/faces/index.xhtml";
	} 
	
	public String nuevo() {
		Cliente c = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/nuevo.xhtml";
	} 
	
	public String guardar(Cliente cliente) {
		clienteDao.guardar(cliente);
		return "/faces/index.xhtml";
	}

}
