   package com.services.impl;

import java.util.List;

import com.dao.CaisseDao;
import com.dao.impl.CaisseDaoImpl;
import com.entities.Caisse;
import com.model.MessageResponse;
import com.services.CaisseService;

public class CaisseServiceImpl implements CaisseService{
private CaisseDao caisseDao;
	@Override
	public MessageResponse save(Caisse caisse) throws Exception {
		Caisse cais=caisseDao.findById(caisse.getCinCaisse());
		if(cais!=null) {
			return new MessageResponse(false, "CIN existe d�ja");
		}
		
		caisseDao.save(caisse);
				return new MessageResponse(true, "op�ration effectu� avec succ�s");
	}

	
	
	
	@Override
	public MessageResponse update(Caisse caisse) throws Exception {
		
		caisseDao.upDate(caisse);
		return new MessageResponse(true, "op�ration effectu� avec succ�s");
	
	
	
	
	
	}
	@Override
	public MessageResponse delete(Caisse caisse) throws Exception {
		caisseDao.delete(caisse);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public List<Caisse> findAll() throws Exception {
		// TODO Auto-generated method stub
		return caisseDao.findAll();
	}




	public CaisseDao getCaisseDao() {
		return caisseDao;
	}




	public void setCaisseDao(CaisseDao caisseDao) {
		this.caisseDao = caisseDao;
	}
	

}
