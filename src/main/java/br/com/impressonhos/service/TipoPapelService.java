package br.com.impressonhos.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.jboss.solder.exception.control.ExceptionToCatch;

import br.com.impressonhos.dao.PersistenceUtil;
import br.com.impressonhos.entity.TipoPapel;

public class TipoPapelService extends PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 2586000639319261161L;
	
	@Inject private Event<ExceptionToCatch> exception;
	
	public TipoPapel save(TipoPapel tipoPapel){
		try
		{
			tipoPapel = tipoPapel.getId() == null || tipoPapel.getId().equals(new Long(0)) ? super.persist(tipoPapel) : super.merge(tipoPapel);
		}
		catch (PersistenceException pe)
		{
			exception.fire(new ExceptionToCatch(pe));
			tipoPapel = null;
		}
		return tipoPapel;
	}
	
	public boolean remove(TipoPapel tipoPapel){
		boolean isRemoved = true;
		try {
			super.removeById(tipoPapel, tipoPapel.getId());				
		} catch (PersistenceException pe) {
			exception.fire(new ExceptionToCatch(pe));
			isRemoved = false;
		}
		
		return isRemoved;
	} 
	
	public TipoPapel getTipoPapelConviteById(Long id) {
		try
		{
			return super.findById(TipoPapel.class, id);
		}
		catch (NoResultException e)
		{
			exception.fire(new ExceptionToCatch(e));
			return null;
		}
	}
	
	public List<TipoPapel> findAll(){
		return super.findAll(TipoPapel.class);
	}
}
