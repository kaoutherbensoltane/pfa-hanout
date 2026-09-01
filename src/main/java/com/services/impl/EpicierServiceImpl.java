package com.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dao.EpicierDao;
import com.dao.impl.EpicierDaoImpl;
import com.entities.Epicier;
import com.model.MessageResponse;
import com.services.EpicierService;

public class EpicierServiceImpl implements EpicierService {
	private EpicierDao epicierDao;

	@Override
	public MessageResponse save(Epicier epicier) throws Exception {
		Epicier epr=epicierDao.findById(epicier.getCinEpicier());
		if (epr!=null)
		{
			
			return new MessageResponse(false,"CIN existant");
		}
		Criterion crit1=Restrictions.eq("nomEpicier", epicier.getNomEpicier());
		Criterion crit2=Restrictions.eq("prenomEpicier", epicier.getPrenomEpicier());
		Criterion crit=Restrictions.and(crit1,crit2);
		List<Epicier> list=epicierDao.findByCriteria(crit);
		
		if(!list.isEmpty()) {
			return new MessageResponse(false,"nom et prenom de l'�picier  existant");
		
		}
		epicierDao.save(epicier);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public MessageResponse update(Epicier epicier) throws Exception {
		
		epicierDao.upDate(epicier);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public MessageResponse delete(Epicier epicier) throws Exception {
		epicierDao.delete(epicier);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public List<Epicier> findAll() throws Exception {
		// TODO Auto-generated method stub
		return epicierDao.findAll();
	}

	public EpicierDao getEpicierDao() {
		return epicierDao;
	}

	public void setEpicierDao(EpicierDao epicierDao) {
		this.epicierDao = epicierDao;
	}
	
	

}
