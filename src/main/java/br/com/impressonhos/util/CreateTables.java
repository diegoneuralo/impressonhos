package br.com.impressonhos.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.impressonhos.enums.Const;

public class CreateTables {	

	private static EntityManager em;
	
	public static void main(String[] args) {
		em = Persistence.createEntityManagerFactory(Const.SCHEMA).createEntityManager();
		em.close();				
	}
			
}
