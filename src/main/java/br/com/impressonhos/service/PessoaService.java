package br.com.impressonhos.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.jboss.solder.exception.control.ExceptionToCatch;

import br.com.impressonhos.dao.PersistenceUtil;
import br.com.impressonhos.entity.Pessoa;

public class PessoaService extends PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = -3513686167695144647L;
	@Inject private Event<ExceptionToCatch> exception;
	
	public Pessoa save(Pessoa pessoa){
		try
		{
			pessoa = pessoa.getId() == null || pessoa.getId().equals(new Long(0)) ? super.persist(pessoa) : super.merge(pessoa);
		}
		catch (PersistenceException pe)
		{
			exception.fire(new ExceptionToCatch(pe));
			pessoa = null;
		}
		return pessoa;
	}
	
	public boolean remove(Pessoa pessoa){
		boolean isRemoved = true;
		try {
			super.removeById(pessoa, pessoa.getId());				
		} catch (PersistenceException pe) {
			exception.fire(new ExceptionToCatch(pe));
			isRemoved = false;
		}
		
		return isRemoved;
	} 
	
	public Pessoa getPessoaById(Long id) {
		try
		{
			return super.findById(Pessoa.class, id);
		}
		catch (NoResultException e)
		{
			exception.fire(new ExceptionToCatch(e));
			return null;
		}
	}
	
	public List<Pessoa> findAll(){
		return super.findAll(Pessoa.class);
	}
}
