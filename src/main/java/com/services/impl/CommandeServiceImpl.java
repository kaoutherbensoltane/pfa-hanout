package com.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dao.CommandeDao;
import com.dao.impl.CommandeDaoImpl;
import com.entities.Commande;
import com.model.MessageResponse;
import com.services.CommandeService;

public class CommandeServiceImpl implements CommandeService {
	private CommandeDao commandeDao;

	@Override
	public MessageResponse save(Commande commande) throws Exception {
		Commande cmd=commandeDao.findById(commande.getCinCmd());
		if(cmd!=null) {
			return new MessageResponse(false, "CIN existe d�ja");
		}
		
	
	Criterion crit=Restrictions.eq("numCmd", commande.getNumCmd());
	List<Commande> list=commandeDao.findByCriteria(crit);
	
	if(!list.isEmpty()) {
		return new MessageResponse(false,"num de Commande existant");
		
		
		
	}
	commandeDao.save(commande);
	return new MessageResponse(true, "op�ration effectu� avec succ�s");
}


	@Override
	public MessageResponse update(Commande commande) throws Exception {
		
		commandeDao.upDate(commande);
		return new MessageResponse(true, "op�ration effectu� avec succ�s");
	}

	@Override
	public MessageResponse delete(Commande commande) throws Exception {
		commandeDao.delete(commande);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}
	

	@Override
	public List<Commande> findAll() throws Exception {
		// TODO Auto-generated method stub
		return commandeDao.findAll();
	}


	public CommandeDao getCommandeDao() {
		return commandeDao;
	}


	public void setCommandeDao(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

	
}
