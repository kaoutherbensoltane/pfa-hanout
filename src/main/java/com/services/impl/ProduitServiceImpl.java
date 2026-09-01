package com.services.impl;

import java.util.List;

import com.dao.ProduitDao;
import com.dao.impl.ProduitDaoImpl;
import com.entities.Produit;
import com.entities.Stock;
import com.model.MessageResponse;
import com.services.ProduitService;

public class ProduitServiceImpl implements ProduitService {
private ProduitDao produitDao;
	@Override
	public MessageResponse save(Produit produit) throws Exception {	
		
		Produit pdt=produitDao.findById(produit.getArticle());
		if(pdt!=null) {
			return new MessageResponse(false,"Lib�ll�e existant");
		
}
		
		produitDao.save(produit);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public MessageResponse update(Produit produit) throws Exception {
		produitDao.upDate(produit);
		return new MessageResponse(true, "Op�ration effectu� avec succ�s");
	}

	@Override
	public MessageResponse delete(Produit produit) throws Exception {
		Produit pdt=produitDao.findById(produit.getArticle());
		if(pdt!=null)
		{
			
			return new MessageResponse(false,"Article existant");
		}
		produitDao.upDate(produit);
		return new MessageResponse(true,"Op�ration effectu� avec succ�s");	
	}

	@Override
	public List<Produit> findAll() throws Exception {
		// TODO Auto-generated method stub
		return produitDao.findAll();
	}

	public ProduitDao getProduitDao() {
		return produitDao;
	}

	public void setProduitDao(ProduitDao produitDao) {
		this.produitDao = produitDao;
	}
	

}
