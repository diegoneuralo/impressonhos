package br.com.impressonhos.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.solder.exception.control.ExceptionToCatch;

import br.com.impressonhos.dao.PersistenceUtil;
import br.com.impressonhos.entity.TipoLogradouro;

public class TipoLogradouroService extends PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = -2412477883138143805L;
	
	@Inject private Event<ExceptionToCatch> exception;
	
	public List<TipoLogradouro> findAll() 
	{
		return super.findAll(TipoLogradouro.class);
	}

}
