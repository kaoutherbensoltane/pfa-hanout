package com.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dao.ClientDao;
import com.dao.impl.ClientDaoImpl;
import com.entities.Client;
import com.model.MessageResponse;
import com.services.ClientService;

public class ClientServiceImpl implements ClientService {
private ClientDao cltDao;
	@Override
	public MessageResponse save(Client client) throws Exception {
		Client clt=cltDao.findById(client.getCinClt());
		if(clt!=null) {
			return new MessageResponse(false, "CIN existe d�ja");
	
			
		}
		Criterion crit1=Restrictions.eq("nomClt", client.getNomClt());
		Criterion crit2=Restrictions.eq("prenomClt", client.getPrenomClt());
		Criterion crit=Restrictions.and(crit1,crit2);
		List<Client> list=cltDao.findByCriteria(crit);
		
		if(!list.isEmpty()) {
			return new MessageResponse(false,"nom et prenom de  client existant");
		}
		
		
	
		cltDao.save(client);
				return new MessageResponse(true, "op�ration effectu� avec succ�s");
	}
	
		
		
		


	@Override
	public MessageResponse update(Client client) throws Exception {
		
		cltDao.upDate(client);
		return new MessageResponse(true, "op�ration effectu� avec succ�s");
}

	@Override
	public MessageResponse delete(Client client) throws Exception {
		cltDao.delete(client);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}
	

	@Override
	public List<Client> findAll() throws Exception {
		// TODO Auto-generated method stub
		return cltDao.findAll();
	}






	public ClientDao getCltDao() {
		return cltDao;
	}






	public void setCltDao(ClientDao cltDao) {
		this.cltDao = cltDao;
	}

}
