package br.com.impressonhos.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.jboss.solder.exception.control.ExceptionToCatch;

import br.com.impressonhos.dao.PersistenceUtil;
import br.com.impressonhos.entity.Contratante;

public class ContratanteService extends PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 2825729711978939978L;
	
	@Inject private Event<ExceptionToCatch> exception;
	
	public Contratante save(Contratante contratante){
		try
		{
			contratante = contratante.getId() == null || contratante.getId().equals(new Long(0)) ? super.persist(contratante) : super.merge(contratante);
		}
		catch (PersistenceException pe)
		{
			exception.fire(new ExceptionToCatch(pe));
			contratante = null;
		}
		return contratante;
	}
	
	public boolean remove(Contratante contratante){
		boolean isRemoved = true;
		try {
			super.removeById(contratante, contratante.getId());				
		} catch (PersistenceException pe) {
			exception.fire(new ExceptionToCatch(pe));
			isRemoved = false;
		}
		
		return isRemoved;
	} 
	
	public Contratante getContratanteById(Long id) {
		try
		{
			return super.findById(Contratante.class, id);
		}
		catch (NoResultException e)
		{
			exception.fire(new ExceptionToCatch(e));
			return null;
		}
	}
	
	public List<Contratante> findAll(){
		return super.findAll(Contratante.class);
	}
}
