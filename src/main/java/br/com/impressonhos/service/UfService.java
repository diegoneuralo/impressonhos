package br.com.impressonhos.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.solder.exception.control.ExceptionToCatch;

import br.com.impressonhos.dao.PersistenceUtil;
import br.com.impressonhos.entity.Uf;

public class UfService extends PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 3450073143514395225L;
	
	@Inject private Event<ExceptionToCatch> exception;
	
	public List<Uf> findAll() 
	{
		return super.findAll(Uf.class);
	}

}
