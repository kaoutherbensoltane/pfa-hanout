package com.services.impl;

import java.util.List;

import com.dao.FactureDao;
import com.dao.impl.FactureDaoImlp;
import com.entities.Facture;
import com.model.MessageResponse;
import com.services.FactureService;

public class FactureServiceImpl implements FactureService {
	private FactureDao factureDao;

	@Override
	public MessageResponse save(Facture facture) throws Exception {
		Facture ftr=factureDao.findById(facture.getCode());
		if(ftr!=null)
		{
			
			return new MessageResponse(false,"CODE existant");
		}
		
		factureDao.save(facture);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public MessageResponse update(Facture facture) throws Exception {
		
	
		factureDao.upDate(facture);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public MessageResponse delete(Facture facture) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facture> findAll() throws Exception {
		// TODO Auto-generated method stub
		return factureDao.findAll();
	}

	public FactureDao getFactureDao() {
		return factureDao;
	}

	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}
	
	

}
