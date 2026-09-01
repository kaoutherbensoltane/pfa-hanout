package com.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dao.FournisseurDao;
import com.dao.impl.FournisseurDaoImpl;
import com.entities.Fournisseur;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.FournisseurService;

public class FournisseurServiceImpl implements FournisseurService {
	private FournisseurDao fournisseurDao;

	@Override
	public MessageResponse save(Fournisseur fournisseur) throws Exception {

		Fournisseur fsr = fournisseurDao.findById(fournisseur.getCinFsr());
		if (fsr != null) {
			return new MessageResponse(false, "Cin fsr existant");

		}

		fournisseurDao.save(fournisseur);
		return new MessageResponse(true, "Opération effectué avec succés");
	}

	@Override
	public MessageResponse update(Fournisseur fournisseur) throws Exception {

		fournisseurDao.upDate(fournisseur);
		return new MessageResponse(true, "Opération effectué avec succés");
	}

	@Override
	public MessageResponse delete(Fournisseur fournisseur) throws Exception {
		fournisseurDao.delete(fournisseur);
		return new MessageResponse(true, "Opération effectué avec succés");
	}

	@Override
	public List<Fournisseur> findAll() throws Exception {

		return fournisseurDao.findAll();
	}

	public FournisseurDao getFournisseurDao() {
		return fournisseurDao;
	}

	public void setFournisseurDao(FournisseurDao fournisseurDao) {
		this.fournisseurDao = fournisseurDao;
	}

}
