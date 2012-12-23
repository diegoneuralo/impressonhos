package br.com.impressonhos.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.jboss.solder.exception.control.ExceptionToCatch;

import br.com.impressonhos.dao.PersistenceUtil;
import br.com.impressonhos.entity.ModeloConvite;

public class ModeloConviteService extends PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 3450073143514395225L;
	
	@Inject private Event<ExceptionToCatch> exception;
	
	public ModeloConvite save(ModeloConvite modeloConvite){
		System.out.println("ModeloConviteService.save()");
		try
		{
			modeloConvite = modeloConvite.getId() == null || modeloConvite.getId().equals(new Long(0)) ? super.persist(modeloConvite) : super.merge(modeloConvite);
		}
		catch (PersistenceException pe)
		{
			exception.fire(new ExceptionToCatch(pe));
			modeloConvite = null;
		}
		return modeloConvite;
	}
	
	public void remove(ModeloConvite modeloConvite){
		try
		{
			super.removeById(modeloConvite, modeloConvite.getId());				
		}
		catch (PersistenceException pe)
		{
			exception.fire(new ExceptionToCatch(pe));	
		}
	} 
	
	public ModeloConvite getModeloConviteById(Long id) {
		try
		{
			return super.findById(ModeloConvite.class, id);
		}
		catch (NoResultException e)
		{
			exception.fire(new ExceptionToCatch(e));
			return null;
		}
	}
	
	public List<ModeloConvite> findAll(){
		return super.findAll(ModeloConvite.class);
	}
}
